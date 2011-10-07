<%@ include file="/WEB-INF/template/include.jsp" %>
<openmrs:require privilege="Manage report" otherwise="/login.htm" redirect="/report/config.form" />
<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="../includes/js_css.jsp" %>
<%@ include file="../includes/nav.jsp" %>

<b class="boxHeader">Config properties for report</b>
<input type="hidden" id="pageId" value="configPage"/>
<form method="post" class="box" id="configForm">

 <table>
 	<tr>
	 	<td><spring:message code="report.config.realPath"/><em>*</em>:</td>
	 	<td><input type="text" id="real_path_p" name="real_path_p" value="${real_path }" style="width:300px"/></td>
 	</tr>
 	<tr>
	 	<td><spring:message code="report.config.urlData"/><em>*</em>:</td>
	 	<td><input type="text" id="url_data_p" name="url_data_p" value="${url_data }" style="width:300px"/></td>
 	</tr>
 	<tr>
	 	<td><spring:message code="report.config.urlBirt"/><em>*</em>:</td>
	 	<td><input type="text" id="url_birt_p" name="url_birt_p" value="${url_birt }" style="width:300px"/></td>
 	</tr>
 	<tr>
	 	<td><spring:message code="report.config.width"/><em>*</em>:</td>
	 	<td><input type="text" id="width_p" name="width_p" value="${width}" /></td>
 	</tr>
 	<tr>
	 	<td><spring:message code="report.config.height"/><em>*</em>:</td>
	 	<td><input type="text" id="height_p" name="height_p" value="${height}" /></td>
 	</tr>
 	<tr>
	 	<td><spring:message code="report.config.format"/>[html|pdf]<em>*</em>:</td>
	 	<td><input type="text" id="format_p" name="format_p" value="${format}" /></td>
 	</tr>
 </table>
 <br />
<input type="submit" value="<spring:message code="general.save"/>" >
<input type="button" value="<spring:message code="general.cancel"/>" onclick="ACT.go('reportList.form');">
</form>





 <%@ include file="/WEB-INF/template/footer.jsp" %> 