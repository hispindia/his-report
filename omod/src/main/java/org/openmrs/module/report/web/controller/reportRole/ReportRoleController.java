 /*
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
*/ 
/**
 * <p> File: org.openmrs.module.report.web.controller.reportRole.ReportRoleController.java </p>
 * <p> Project: report-omod </p>
 * <p> Copyright (c) 2011 HISP Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Email: chuyennmth@gmail.com</p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 29, 2011 11:58:53 AM </p>
 * <p> Update date: Apr 29, 2011 11:58:53 AM </p>
 **/

package org.openmrs.module.report.web.controller.reportRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.openmrs.Role;
import org.openmrs.api.context.Context;
import org.openmrs.module.report.BirtReportService;
import org.openmrs.module.report.model.BirtReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p> Class: ReportRoleController </p>
 * <p> Package: org.openmrs.module.report.web.controller.reportRole </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 29, 2011 11:58:53 AM </p>
 * <p> Update date: Apr 29, 2011 11:58:53 AM </p>
 **/
@Controller("ReportRoleController")
public class ReportRoleController {
	@RequestMapping("/module/report/reportRole.form")
	public String viewReportRole(
			 @RequestParam(value="roleId", required=false)  String roleId,
			Model model) {
		List<Role> roles = Context.getUserService().getAllRoles();
		BirtReportService birtReportService =  Context.getService(BirtReportService.class);
		List<BirtReport> reports = birtReportService.listBirtReport("", "", "", 0, 0);
		List<String> idRoles= new ArrayList<String>();
		if(StringUtils.isNotBlank(roleId)){
			idRoles.add(roleId);
			List<BirtReport> reportRoles = birtReportService.listBirtReportByRole(idRoles, null);
			model.addAttribute("reportRoles", reportRoles);
			model.addAttribute("roleId", roleId);
		}
		model.addAttribute("roles", roles);
		model.addAttribute("reports", reports);
		return "/module/report/reportRole/reportRole";
	}
	
	@RequestMapping(value="/module/report/addRemoveReportToRole.form", method=RequestMethod.POST)
	public String addRemoveReportToRole(
			 @RequestParam("roleId")  String roleId,
			 @RequestParam("reportId")  Integer reportId,
			 @RequestParam(value="action")  Integer action,
			Model model) {
		BirtReportService birtReportService =  Context.getService(BirtReportService.class);
		BirtReport report = birtReportService.getBirtReportById(reportId);
		if(report != null){
			Role role = Context.getUserService().getRole(roleId);
			Set<Role> roles = report.getReportRoles();
			if(action == 1){
				if(!roles.contains(role)){
					roles.add(role);
					report.setReportRoles(roles);
					birtReportService.saveReport(report);
				}
			}else{
				if(roles.contains(role)){
					roles.remove(role);
					report.setReportRoles(roles);
					birtReportService.saveReport(report);
				}
			}
			
		}
		return "/module/report/blank/blank";
	}
	
public static void main(String[] args) {
	//PlatformConfig pf = new PlatformConfig();
	//pf.
}
}
