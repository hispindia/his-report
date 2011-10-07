<span class="boxHeader"><spring:message code="report.reportType.list"/></span>
<div class="box">
<c:choose>
<c:when test="${not empty listReportType}">

<table cellpadding="5" cellspacing="0" width="100%">
<tr align="center">
	<th>#</th>
	<th><spring:message code="report.reportType.name"/></th>
	<th><spring:message code="report.report.createdOn"/></th>
	<th><spring:message code="report.report.createdBy"/></th>
	<th></th>
</tr>
<c:forEach items="${listReportType}" var="reportType" varStatus="varStatus">
	<tr align="center" class='${varStatus.index % 2 == 0 ? "oddRow" : "evenRow" } '>
		<td><c:out value="${ varStatus.count }"/></td>	
		<td><a href="#" title="Edit" onclick="ACT.go('reportType.form?reportTypeId=${ reportType.id}');">${reportType.name}</a> </td>
		<td><openmrs:formatDate date="${reportType.createdOn}" type="textbox"/></td>
		<td>${reportType.createdBy}</td>
		<td>
			<a href="#" onclick="ACT.go('viewReport.form?reportName=${reportType.path}&reportTypeTitle=${reportType.name}&reportTitle=${reportType.birtReport.name }');">View report</a>
			<a href="#" onclick="REPORT.downloadReportType('${reportType.id}');" >Download report</a>
			<a href="#" onclick="REPORT.deleteReportType('${reportType.id}','${reportType.birtReport.id }');">Delete report type</a>
			<a href="#" onclick="ACT.go('sourceFileReport.form?reportTypeId=${reportType.id}');">View source file</a>
		</td>
	</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
	No report found.
</c:otherwise>
</c:choose>
</div>