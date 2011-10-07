/**
 * <p> File: org.openmrs.module.ddureport.web.controller.report.ViewReportController.java </p>
 * <p> Project: birt-report </p>
 * <p> Copyright (c) 2011 HISP Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Email: chuyennmth@gmail.com</p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 6, 2011 5:40:57 PM </p>
 * <p> Update date: Apr 6, 2011 5:40:57 PM </p>
 **/

package org.openmrs.module.report.web.controller.report;

import org.apache.commons.lang.StringUtils;
import org.openmrs.module.report.model.BirtReportConfig;
import org.openmrs.module.report.util.ReportConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p> Class: ViewReportController </p>
 * <p> Package: org.openmrs.module.ddureport.web.controller.report </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 6, 2011 5:40:57 PM </p>
 * <p> Update date: Apr 6, 2011 5:40:57 PM </p>
 **/
@Controller("ReportViewReportController")
public class ViewReportController {
	@RequestMapping(value="/module/report/viewReport.form", method=RequestMethod.GET)
	public String viewReport(
			@RequestParam(value="reportName",required=false) String reportName,
			@RequestParam(value="reportTitle",required=false) String reportTitle,
			@RequestParam(value="reportTypeTitle",required=false) String reportTypeTitle,
			Model model) {
		//ConfigurationService config = ConfigurationService.getInstance();
		BirtReportConfig config = ReportConstants.getConfig();
		
		String url_data = config.getUrlData();
		String url_birt = config.getUrlBirt();
		String width = config.getWidth();
		String height = config.getHeight();
		String format = config.getFormat();

		model.addAttribute("url_birt", url_birt);

		model.addAttribute("width", width);
		model.addAttribute("height", height);
		if(url_data.lastIndexOf("/") == -1){
			url_data = url_data +reportName;
		}else{
			url_data = url_data +"/"+reportName;
		}
		//System.out.println("url_data: "+url_data);
		model.addAttribute("urlReport", url_data);
		String reportTile=  StringUtils.isNotBlank(reportTitle)?reportTitle : "Report title";
		reportTypeTitle = StringUtils.isNotBlank(reportTypeTitle)?reportTypeTitle : "Report type title";
		model.addAttribute("reportTitle",reportTile);
		model.addAttribute("format", format);
		model.addAttribute("reportTypeTitle", reportTypeTitle);
		String temp =url_birt+"/frameset?__id=birtViewer&__title="+reportTitle+"-"+reportTypeTitle+"&__report="+url_data+"&__masterpage=true&__format="+format;
		model.addAttribute("fullScreen", temp);
		model.addAttribute("reportName", reportName);
		
		return "module/report/report/viewReport";
	}
}
