 <%--
 *  Copyright 2009 Society for Health Information Systems Programmes, India (HISP India)
 *
 *  This file is part of Report module.
 *
 *  Report module is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  Report module is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Report module.  If not, see <http://www.gnu.org/licenses/>.
 *
--%> 
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