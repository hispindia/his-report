<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Manage report" otherwise="/login.htm" redirect="/module/report/sourceFileReport.form" />

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="../includes/js_css.jsp" %>

<br/>
<input type="hidden" id="pageId" value="sourceFileReportPage"/>
<span class="boxHeader"><spring:message code="report.report.editReport"/></span>
<form method="post" class="box" id="sourceFileReportForm">
<textarea rows="30" cols="172" name="xmlFile" id="xmlFile">
${xmlString }
</textarea>
<input type="hidden" id="reportTypeId" value="${reportTypeId }"/>
<br/>
<input type="submit" value="<spring:message code="general.save"/>">
<input type="button" value="<spring:message code="general.view"/>" onclick="REPORT.viewReport(this);">
<input type="button" value="<spring:message code="general.cancel"/>" onclick="ACT.go('reportType.form?reportId=${reportType.birtReport.id}');">
 
</form>
<div id="viewReport"></div>

<%@ include file="/WEB-INF/template/footer.jsp" %>

