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
<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="View report" otherwise="/login.htm" redirect="/module/report/reportRoleList.form" />

<spring:message var="pageTitle" code="report.report.view" scope="page"/>

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="../includes/js_css.jsp" %>
<br />
<h2><spring:message code="report.report.view"/></h2>	
<br />
<input type="hidden" id="pageId" value="reportRoleList"/>
<form method="get" >
<span class="boxHeader"><spring:message code="report.report.list"/></span>
<div class="box">
<c:choose>
<c:when test="${not empty reports}">
<table cellpadding="5" cellspacing="0" width="100%">
<tr align="center">
	<th>#</th>
	<th><spring:message code="report.report.name"/></th>
	<th><spring:message code="report.report.description"/></th>
	<th><spring:message code="report.reportType.list"/></th>
	<th><spring:message code="report.report.createdOn"/></th>
	<th><spring:message code="report.report.createdBy"/></th>
	
</tr>
<c:forEach items="${reports}" var="report" varStatus="varStatus">
	<tr align="center" class='${varStatus.index % 2 == 0 ? "oddRow" : "evenRow" } '>
		<td><c:out value="${varStatus.count }"/></td>	
		<td>${report.name}</td>
		<td>${report.description}</td>
		<td>
			<c:if test="${not empty report.reportTypes }">
				<c:forEach items="${report.reportTypes}" var="reportType" >
					<a href="#" title="View report" onclick="ACT.go('viewReport.form?reportName=${reportType.path}&reportTypeTitle=${reportType.name}&reportTitle=${reportType.birtReport.name }')">${reportType.name }</a><br/>
				</c:forEach>
			</c:if>
		</td>
		<td><openmrs:formatDate date="${report.createdOn}" type="textbox"/></td>
		<td>${report.createdBy}</td>
		
	</tr>
</c:forEach>
</table>
</c:when>
<c:otherwise>
	No reports found.
</c:otherwise>
</c:choose>
</div>
</form>

<%@ include file="/WEB-INF/template/footer.jsp" %>