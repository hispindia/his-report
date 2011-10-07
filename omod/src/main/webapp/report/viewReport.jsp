<%@ include file="/WEB-INF/template/include.jsp" %>
<openmrs:require privilege="View report" otherwise="/login.htm" redirect="index.htm" />
<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="../includes/js_css.jsp" %>
<%@taglib prefix="birt" uri="../resources/taglibs/birt.tld"%>

<br/>
<a href="${fullScreen}"   target="_blank" >View full screen</a>
	<birt:viewer scrolling="true"   id="birtViewer"   reportDesign="${urlReport}" 
	pattern="frameset"  title="${reportTitle } - ${reportTypeTitle }" 
	height="${height }" 
	width="${width }" 
	format="${format != null? format : 'html' }"  baseURL="${url_birt}"
 >  
 
 </birt:viewer>
<%@ include file="/WEB-INF/template/footer.jsp" %>