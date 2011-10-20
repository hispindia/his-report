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
 * <p> File: org.openmrs.module.report.web.controller.report.ReportController.java </p>
 * <p> Project: report-omod </p>
 * <p> Copyright (c) 2011 HISP Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Email: chuyennmth@gmail.com</p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 7:06:14 PM </p>
 * <p> Update date: Apr 25, 2011 7:06:14 PM </p>
 **/

package org.openmrs.module.report.web.controller.report;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.report.BirtReportService;
import org.openmrs.module.report.model.BirtReport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

/**
 * <p> Class: ReportController </p>
 * <p> Package: org.openmrs.module.report.web.controller.report </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 7:06:14 PM </p>
 * <p> Update date: Apr 25, 2011 7:06:14 PM </p>
 **/

@Controller("ReportReportController")
@RequestMapping("/module/report/report.form")
public class ReportController {
Log log = LogFactory.getLog(this.getClass());
	
	@RequestMapping(method = RequestMethod.GET)
	public String firstView(@ModelAttribute("report") BirtReport report, @RequestParam(value="reportId",required=false) Integer id, Model model) {
		if( id != null ){
			report = Context.getService(BirtReportService.class).getBirtReportById(id);
			model.addAttribute("report",report);
		}
		return "/module/report/report/report";
	}
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("report") BirtReport report, BindingResult bindingResult, HttpServletRequest request, SessionStatus status) {
		new BirtReportValidator().validate(report, bindingResult);
		if (bindingResult.hasErrors()) {
			return "/module/report/report/report";
		}else{
			BirtReportService birtReportService = Context.getService(BirtReportService.class);
			if(report.getId() != null && report.getId().intValue() > 0){
				BirtReport  reportCurrent = birtReportService.getBirtReportById(report.getId());
				if(reportCurrent != null && CollectionUtils.isNotEmpty(reportCurrent.getReportTypes())){
					report.setReportTypes(reportCurrent.getReportTypes());
					report.setReportRoles(reportCurrent.getReportRoles());
				}
			}
			report.setCreatedBy(Context.getAuthenticatedUser().getGivenName());
			report.setCreatedOn(new Date());
			birtReportService.saveReport(report);
			status.setComplete();
			return "redirect:/module/report/reportList.form";
		}
	}
}
