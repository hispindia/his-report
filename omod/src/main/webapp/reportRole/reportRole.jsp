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

<openmrs:require privilege="Manage report" otherwise="/login.htm" redirect="/module/report/report.form" />

<%@ include file="/WEB-INF/template/header.jsp" %>
<%@ include file="../includes/js_css.jsp" %>
<%@ include file="../includes/nav.jsp" %>
<h2><spring:message code="report.reportRole.manage"/></h2>
<br/>
<input type="hidden" id="pageId" value="reportRolePage"/>
<span class="boxHeader"><spring:message code="report.reportRole.edit"/></span>
<form method="post" class="box" id="reportRoleForm">
<table width="100%">
	<tr>
		 <td align="left" width="100%">Role:<em>*</em>
		 	<select name="roleId" id="roleId" tabindex="20" onchange="REPORT.onChangeRole(this);">
				<option value=""><spring:message code="report.pleaseSelect"/></option>
                <c:forEach items="${roles}" var="rl">
                    <option value="${rl.role}"  <c:if test="${rl.role == roleId}"> selected</c:if> >${rl.role}</option>
                </c:forEach>
   			</select>
		 </td>
	</tr>
	<tr>
		<td  width="100%">
		    <br/>
			<span class="boxHeader"><spring:message code="report.report.list"/></span>
			<table class="box" width="100%">
					<tr>
						<th>#</th>
						<th><spring:message code="report.report.name"/></th>
						<th><spring:message code="report.report.description"/></th>
					</tr>
					<c:if test="${not empty reports }">
					<c:forEach items="${reports}" var="report" varStatus="varStatus">
						<tr class='${varStatus.index % 2 == 0 ? "oddRow" : "evenRow" } '>
							<td><c:out value="${varStatus.count }"/></td>	
							<td>
								<input  type="checkbox" id="${report.id }" 
								<c:forEach items="${reportRoles}" var="reportRole"  varStatus="varStatus">
									<c:if test="${report.id == reportRole.id }"> checked=checked</c:if>
								</c:forEach>
								onclick="REPORT.addRemoveReportToRole(this);" value="${report.id }">&nbsp;&nbsp;${report.name}
							</td>
							<td>${report.description}</td>
						</tr>
					</c:forEach>
					</c:if>
			</table>
		</td>
	
	
	</tr>
</table>
</form>
<%@ include file="/WEB-INF/template/footer.jsp" %>