<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Manage report" otherwise="/login.htm" redirect="/module/report/compilerReport.form" />

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="../includes/js_css.jsp" %>
<%@ include file="../includes/nav.jsp" %>
<input type="hidden" id="pageId" value="compilerReportPage"/>
<span class="boxHeader"><spring:message code="report.report.compiler"/></span>
<form method="post" class="box" id="compilerReportPage">
Put your content report here:
<br/>
<textarea rows="30" cols="172" name="xmlFile" id="xmlFile">
</textarea>
<br/>
<input type="submit" value="<spring:message code="general.view"/>">
</form>
<%@ include file="/WEB-INF/template/footer.jsp" %>

