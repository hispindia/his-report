<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Manage report" otherwise="/login.htm" redirect="/module/report/reportType.form" />

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="../includes/js_css.jsp" %>
<h2><spring:message code="report.reportType.manage"/></h2>

<c:forEach items="${errors.allErrors}" var="error">
	<span class="error"><spring:message code="${error.defaultMessage}" text="${error.defaultMessage}"/></span>
</c:forEach>
<spring:bind path="reportType">
<c:if test="${not empty  status.errorMessages}">
<div class="error">
<ul>
<c:forEach items="${status.errorMessages}" var="error">
    <li>${error}</li>   
</c:forEach>
</ul>
</div>
</c:if>
</spring:bind>
<input type="hidden" id="pageId" value="reportTypePage"/>

<span class="boxHeader"><spring:message code="report.reportType.add"/></span>
<form method="post" class="box" id="reportTypeForm" enctype="multipart/form-data">
<table>
	<tr>
		<td ><spring:message code="report.report.name"/></td>
		<td><input type="text" disabled="disabled" value="${report.name }" size="255" style="width:300px" /></td>
	</tr>
	<tr>
		<spring:bind path="reportType.id">
			<input type="hidden" name="${status.expression}" id="${status.expression}" value="${status.value}" />
		</spring:bind>
		<spring:bind path="reportType.birtReport">
			<input type="hidden" name="${status.expression}" id="${status.expression}" value="${reportType.birtReport == null? reportId : status.value}" />
		</spring:bind>
		<td><spring:message code="report.reportType.name"/><em>*</em></td>
		<td>
			<spring:bind path="reportType.name">
				<input type="text" id="${status.expression}" name="${status.expression}" value="${status.value}" size="255" style="width:300px" />
				<c:if test="${status.errorMessage != ''}"><span class="error">${status.errorMessage}</span></c:if>
			</spring:bind>
		</td>
	</tr>
	<tr>
		<td valign="top"><spring:message code="report.reportType.file"/></td>
		<td>
				<input type="file" name="reportFile" id="reportFile"  />
		</td>
	</tr>
	
</table>
<br />
<input type="submit" value="<spring:message code="general.save"/>">
<input type="button" value="<spring:message code="general.cancel"/>" onclick="ACT.go('reportList.form');">
</form>
<br/>
<%@ include file="reportTypeList.jsp" %>
<%@ include file="/WEB-INF/template/footer.jsp" %>