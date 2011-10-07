<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Manage report" otherwise="/login.htm" redirect="/module/report/reportList.form" />

<spring:message var="pageTitle" code="report.report.manage" scope="page"/>

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="../includes/js_css.jsp" %>

<%@ include file="../includes/nav.jsp" %>
<h2><spring:message code="report.report.manage"/></h2>	
<br />
<c:forEach items="${errors.allErrors}" var="error">
	<span class="error"><spring:message code="${error.defaultMessage}" text="${error.defaultMessage}"/></span><
</c:forEach>
<input type="button" value="<spring:message code='report.report.add'/>" onclick="ACT.go('report.form');"/>

<br /><br />
<input type="hidden" id="pageId" value="reportList"/>
<form method="post" onsubmit="return false" id="form">
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
<input type="button" onclick="REPORT.checkValue();" value="<spring:message code='report.deleteSelected'/>"/>
<table cellpadding="5" cellspacing="0" width="100%">
<tr align="center">
	<th>#</th>
	<th><spring:message code="report.report.name"/></th>
	<th><spring:message code="report.report.description"/></th>
	<th><spring:message code="report.report.retired"/></th>
	<th><spring:message code="report.report.createdOn"/></th>
	<th><spring:message code="report.report.createdBy"/></th>
	<th><spring:message code="report.reportType.list"/></th>
	<th><spring:message code="report.reportRole.list"/></th>
	<th></th>
</tr>
<c:forEach items="${reports}" var="report" varStatus="varStatus">
	<tr align="center" class='${varStatus.index % 2 == 0 ? "oddRow" : "evenRow" } '>
		<td><c:out value="${(( pagingUtil.currentPage - 1  ) * pagingUtil.pageSize ) + varStatus.count }"/></td>	
		<td><a href="#" title="Edit" onclick="ACT.go('report.form?reportId=${ report.id}');">${report.name}</a> </td>
		<td>${report.description}</td>
		<td>${report.retired}</td>
		<td><openmrs:formatDate date="${report.createdOn}" type="textbox"/></td>
		<td>${report.createdBy}</td>
		<td>
			<c:if test="${not empty report.reportTypes }">
				<c:forEach items="${report.reportTypes}" var="reportType" >
					<a href="#" title="View report" onclick="ACT.go('viewReport.form?reportName=${reportType.path}&reportTypeTitle=${reportType.name}&reportTitle=${reportType.birtReport.name }')">${reportType.name }</a><br/>
				</c:forEach>
			</c:if>
		</td>
		<td>
			<c:if test="${not empty report.reportRoles }">
				<c:forEach items="${report.reportRoles}" var="role" >
					<a href="#" title="View report of this role" onclick="ACT.go('reportRole.form?roleId=${role.role}')">${role.role }</a><br/>
				</c:forEach>
			</c:if>
		</td>
		<td>
		<a href="#" onclick="ACT.go('reportType.form?reportId=${report.id}');">Report type</a>
		<input type="checkbox" name="ids" value="${report.id}"/>
		</td>
	</tr>
</c:forEach>

<tr class="paging-container">
	<td colspan="9"><%@ include file="../paging.jsp" %></td>
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