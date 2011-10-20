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