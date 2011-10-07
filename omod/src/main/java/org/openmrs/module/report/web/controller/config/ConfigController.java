/**
 * <p> File: org.openmrs.module.report.web.controller.config.ConfigController.java </p>
 * <p> Project: report-omod </p>
 * <p> Copyright (c) 2011 HISP Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Email: chuyennmth@gmail.com</p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 5:28:08 PM </p>
 * <p> Update date: Apr 25, 2011 5:28:08 PM </p>
 **/

package org.openmrs.module.report.web.controller.config;

import javax.servlet.http.HttpServletRequest;

import org.openmrs.api.context.Context;
import org.openmrs.module.report.BirtReportService;
import org.openmrs.module.report.model.BirtReportConfig;
import org.openmrs.module.report.util.ReportConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p> Class: ConfigController </p>
 * <p> Package: org.openmrs.module.report.web.controller.config </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 5:28:08 PM </p>
 * <p> Update date: Apr 25, 2011 5:28:08 PM </p>
 **/
@Controller("ReportConfigController")
public class ConfigController {

	@RequestMapping(value="/module/report/config.form", method=RequestMethod.GET)
	public String viewConfig( Model model) {
		//ConfigurationService config = ConfigurationService.getInstance();
		BirtReportConfig config = ReportConstants.getConfig();
		if(config == null){
			config = new BirtReportConfig();
		}
			String url_data = config.getUrlData();
			String url_birt = config.getUrlBirt();
			String real_path =config.getRealPath();
			String format = config.getFormat();
			String width =config.getWidth();
			String height = config.getHeight();
			
			model.addAttribute("url_data", url_data);
			model.addAttribute("url_birt", url_birt);
			model.addAttribute("real_path", real_path);
			model.addAttribute("width", width);
			model.addAttribute("height", height);
			model.addAttribute("format", format);
		
		return "/module/report/config/config";
	}
	
	@RequestMapping(value="/module/report/config.form", method=RequestMethod.POST)
	public String submitConfig(
			HttpServletRequest request,
			Model model) {
		
		
		String url_data_p = request.getParameter("url_data_p");
		String url_birt_p = request.getParameter("url_birt_p");
		String real_path_p = request.getParameter("real_path_p");
		
		String width_p = request.getParameter("width_p");
		String height_p = request.getParameter("height_p");
		String format_p = request.getParameter("format_p");
		BirtReportService birtReportService =  Context.getService(BirtReportService.class);
		BirtReportConfig config = birtReportService.getBirtReportConfig();
		if(config == null){
			config = new BirtReportConfig();
		}
		config.setFormat(format_p);
		config.setHeight(height_p);
		config.setWidth(width_p);
		config.setRealPath(real_path_p);
		config.setUrlBirt(url_birt_p);
		config.setUrlData(url_data_p);
		birtReportService.saveReportConfig(config);
		ReportConstants.setConfig(null);
		
		return "redirect:/module/report/config.form";
	}
	
	
}
