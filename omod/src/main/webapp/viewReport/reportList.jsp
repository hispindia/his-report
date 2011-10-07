<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="View report" otherwise="/login.htm" redirect="/module/report/viewReportList.form" />

<spring:message var="pageTitle" code="report.report.view" scope="page"/>

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="../includes/js_css.jsp" %>
<h2><spring:message code="report.report.view"/></h2>	

<br />
<c:forEach items="${errors.allErrors}" var="error">
	<span class="error"><spring:message code="${error.defaultMessage}" text="${error.defaultMessage}"/></span><
</c:forEach>
<input type="button" value="<spring:message code='report.report.add'/>" onclick="ACT.go('report.form');"/>

<br /><br />
<input type="hidden" id="pageId" value="reportList"/>
<form method="get" >
<table cellpadding="5" cellspacing="0">
	<tr>
		<td><spring:message code="general.name"/></td>
		<td><input type="text" id="searchName" name="searchName" value="${searchName}" /></td>
		<td><spring:message code="report.fromDate"/></td>
		<td><input type="text" id="fromDate" class="date-pick left" readonly="readonly" name="fromDate" value="${fromDate}" title="Double Click to Clear" ondblclick="this.value='';"/></td>
		<td><spring:message code="report.toDate"/></td>
		<td><input type="text" id="toDate" class="date-pick left" readonly="readonly" name="toDate" value="${toDate}" title="Double Click to Clear" ondblclick="this.value='';"/></td>
		<td><input type="button" value="Search" onclick="REPORT.search(this);"/></td>
	</tr>
</table>

<span class="boxHeader"><spring:message code="report.report.list"/></span>
<div class="box">
<c:choose>
<c:when test="${not empty reports}">
<table cellpadding="5" cellspacing="0" width="100%">
<tr>
	<th>#</th>
	<th><spring:message code="report.report.name"/></th>
	<th><spring:message code="report.report.description"/></th>
	<th><spring:message code="report.report.createdOn"/></th>
	<th><spring:message code="report.report.createdBy"/></th>
	<th><spring:message code="report.reportType.list"/></th>
</tr>
<c:forEach items="${reports}" var="report" varStatus="varStatus">
	<tr class='${varStatus.index % 2 == 0 ? "oddRow" : "evenRow" } '>
		<td><c:out value="${(( pagingUtil.currentPage - 1  ) * pagingUtil.pageSize ) + varStatus.count }"/></td>	
		<td><a href="#" title="Edit" onclick="ACT.go('report.form?reportId=${ report.id}');">${report.name}</a> </td>
		<td>${report.description}</td>
		<td><openmrs:formatDate date="${report.createdOn}" type="textbox"/></td>
		<td>${report.createdBy}</td>
		<td>
			<c:if test="${not empty report.reportTypes }">
				<c:forEach items="${report.reportTypes}" var="reportType" >
					<a href="#" title="View report" onclick="ACT.go('viewReport.form?reportName=${reportType.path}&reportTypeTitle=${reportType.name}&reportTitle=${reportType.birtReport.name }')">${reportType.name }</a><br/>
				</c:forEach>
			</c:if>
		</td>
		
	</tr>
</c:forEach>

<tr class="paging-container">
	<td colspan="6"><%@ include file="../paging.jsp" %></td>
</tr>
</table>
</c:when>
<c:otherwise>
	No report found.
</c:otherwise>
</c:choose>
</div>
</form>






<%@ include file="/WEB-INF/template/footer.jsp" %>