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
 * <p> File: org.openmrs.module.report.web.controller.editReport.EditReportController.java </p>
 * <p> Project: report-omod </p>
 * <p> Copyright (c) 2011 HISP Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Email: chuyennmth@gmail.com</p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 26, 2011 2:13:19 PM </p>
 * <p> Update date: Apr 26, 2011 2:13:19 PM </p>
 **/

package org.openmrs.module.report.web.controller.editReport;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.openmrs.api.context.Context;
import org.openmrs.module.report.BirtReportService;
import org.openmrs.module.report.model.BirtReportConfig;
import org.openmrs.module.report.model.BirtReportType;
import org.openmrs.module.report.util.FileUtils;
import org.openmrs.module.report.util.ReportConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p> Class: EditReportController </p>
 * <p> Package: org.openmrs.module.report.web.controller.editReport </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 26, 2011 2:13:19 PM </p>
 * <p> Update date: Apr 26, 2011 2:13:19 PM </p>
 **/
@Controller("ReportEditReportController")
public class EditReportController {

	@RequestMapping(value="/module/report/sourceFileReport.form", method=RequestMethod.GET)
	public String viewSourceFileReportList(
			@RequestParam(value="reportTypeId",required=false) Integer reportTypeId,
		
			Model model
			
	){
		BirtReportService birtReportService = Context.getService(BirtReportService.class);
    	BirtReportType reportE = birtReportService.getBirtReportTypeById(reportTypeId);
    	BirtReportConfig config = ReportConstants.getConfig();
		String real_path = config.getRealPath();
		
		if(real_path.lastIndexOf("/") == -1){
			real_path = real_path +reportE.getPath();
		}else{
			real_path = real_path +"/"+reportE.getPath();
		}
		
		String xmlString=FileUtils.readInput(real_path);
		if(StringUtils.isNotBlank(xmlString)){
			xmlString = xmlString.trim();
		}
		xmlString = StringEscapeUtils.escapeXml(xmlString);
		model.addAttribute("xmlString", xmlString);
		model.addAttribute("reportTypeId", reportTypeId);
		model.addAttribute("reportType", reportE);
		//List<String > listFile = FileUtils.listFileByExtension(real_path, "rptdesign");
		//model.addAttribute("listFile", listFile);
		//Read file report
		//Out content file to Text area, 
		//View , Save , return list
		// View -> save to temp file -> view
		// Save -> action save return list
		//list  -> action list
		return "/module/report/editReport/sourceFileReport";
	}
	
	@RequestMapping(value="/module/report/sourceFileReport.form", method=RequestMethod.POST)
	public String submitSourceFileReport(
			HttpServletRequest request,
			Model model
			
	){
		Integer reportTypeId = NumberUtils.toInt(request.getParameter("reportTypeId"), 0);
		BirtReportService birtReportService = Context.getService(BirtReportService.class);
    	BirtReportType reportE = birtReportService.getBirtReportTypeById(reportTypeId);
    	BirtReportConfig config = ReportConstants.getConfig();
    	if(reportE != null){
			String real_path = config.getRealPath();
			if(real_path.lastIndexOf("/") == -1){
				real_path = real_path +reportE.getPath();
			}else{
				real_path = real_path +"/"+reportE.getPath();
			}
			String xmlFile = request.getParameter("xmlFile");
			if(StringUtils.isNotBlank(xmlFile)){
				xmlFile = xmlFile.trim();
			}
			FileUtils.WriteStringToFile(xmlFile, real_path);
			return "redirect:/module/report/reportType.form?reportId="+reportE.getBirtReport().getId();
    	}
    	System.out.println("report type is null please check");
    	return "redirect:/module/report/reportList.form";
	}
	
	@RequestMapping(value="/module/report/saveTempFileReport.form", method=RequestMethod.GET)
	public String saveTempFileReport(
			HttpServletRequest request,
			Model model
			
	){
    	BirtReportConfig config = ReportConstants.getConfig();
		String real_path = config.getRealPath();
		String temp_file = config.getTempFile();
		if(real_path.lastIndexOf("/") == -1){
			real_path = real_path +temp_file;
		}else{
			real_path = real_path +"/"+temp_file;
		}
		String xmlFile = request.getParameter("xmlFile");
		if(StringUtils.isNotBlank(xmlFile)){
			xmlFile = xmlFile.trim();
		}
		FileUtils.WriteStringToFile(xmlFile, real_path);

		//List<String > listFile = FileUtils.listFileByExtension(real_path, "rptdesign");
		//model.addAttribute("listFile", listFile);
		//Read file report
		//Out content file to Text area, 
		//View , Save , return list
		// View -> save to temp file -> view
		// Save -> action save return list
		//list  -> action list
		return "/module/report/blank/blank";
	}
	
	
	@RequestMapping(value="/module/report/saveTempFileReport.form", method=RequestMethod.POST)
	public String saveTempToFileReport(
			HttpServletRequest request,
			Model model
			
	){
    	BirtReportConfig config = ReportConstants.getConfig();
		String real_path = config.getRealPath();
		String temp_file = config.getTempFile();
		
		if(real_path.lastIndexOf("/") == -1){
			real_path = real_path +temp_file;
		}else{
			real_path = real_path +"/"+temp_file;
		}
		String xmlFile = request.getParameter("xmlFile");
		if(StringUtils.isNotBlank(xmlFile)){
			xmlFile = xmlFile.trim();
		}
		FileUtils.WriteStringToFile(xmlFile, real_path);

		//List<String > listFile = FileUtils.listFileByExtension(real_path, "rptdesign");
		//model.addAttribute("listFile", listFile);
		//Read file report
		//Out content file to Text area, 
		//View , Save , return list
		// View -> save to temp file -> view
		// Save -> action save return list
		//list  -> action list
		return "redirect:/module/report/viewReport.form?reportName="+temp_file;
	}
	@RequestMapping(value="/module/report/compilerReport.form", method=RequestMethod.GET)
	public String getCompilerReport(
			HttpServletRequest request,
			Model model
			
	){
		
		return "/module/report/editReport/compilerReport";
	}
	@RequestMapping(value="/module/report/compilerReport.form", method=RequestMethod.POST)
	public String compilerReport(
			HttpServletRequest request,
			Model model
			
	){
    	BirtReportConfig config = ReportConstants.getConfig();
		String real_path = config.getRealPath();
		String temp_file = config.getTempFile();
		if(real_path.lastIndexOf("/") == -1){
			real_path = real_path +temp_file;
		}else{
			real_path = real_path +"/"+temp_file;
		}
		String xmlFile = request.getParameter("xmlFile");
		if(StringUtils.isNotBlank(xmlFile)){
			xmlFile = xmlFile.trim();
		}
		FileUtils.WriteStringToFile(xmlFile, real_path);

		//List<String > listFile = FileUtils.listFileByExtension(real_path, "rptdesign");
		//model.addAttribute("listFile", listFile);
		//Read file report
		//Out content file to Text area, 
		//View , Save , return list
		// View -> save to temp file -> view
		// Save -> action save return list
		//list  -> action list
		return "redirect:/module/report/viewReport.form?reportName="+temp_file;
	}
	
}
