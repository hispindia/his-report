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

