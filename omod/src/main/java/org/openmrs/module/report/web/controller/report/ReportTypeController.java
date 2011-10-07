/**
 * <p> File: org.openmrs.module.report.web.controller.report.ReportTypeController.java </p>
 * <p> Project: report-omod </p>
 * <p> Copyright (c) 2011 HISP Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Email: chuyennmth@gmail.com</p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 26, 2011 10:42:13 AM </p>
 * <p> Update date: Apr 26, 2011 10:42:13 AM </p>
 **/

package org.openmrs.module.report.web.controller.report;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.report.BirtReportService;
import org.openmrs.module.report.model.BirtReport;
import org.openmrs.module.report.model.BirtReportConfig;
import org.openmrs.module.report.model.BirtReportType;
import org.openmrs.module.report.util.ReportConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * <p> Class: ReportTypeController </p>
 * <p> Package: org.openmrs.module.report.web.controller.report </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 26, 2011 10:42:13 AM </p>
 * <p> Update date: Apr 26, 2011 10:42:13 AM </p>
 **/

@Controller("ReportReportTypeController")
@RequestMapping("/module/report/reportType.form")
public class ReportTypeController {
Log log = LogFactory.getLog(this.getClass());
	@RequestMapping(method = RequestMethod.GET)
	public String firstView(@ModelAttribute("reportType") BirtReportType reportType, @RequestParam(value="reportTypeId",required=false) Integer id,@RequestParam(value="reportId",required=false) Integer reportId, Model model) {
		BirtReportService birtReportService =  Context.getService(BirtReportService.class);
		if( id != null ){
			reportType = birtReportService.getBirtReportTypeById(id);
			model.addAttribute("reportType",reportType);
			reportId = reportType.getBirtReport().getId();
		}
		if( reportId != null ){
			List<BirtReportType> list= birtReportService.listBirtReportTypeByReport(reportId);
			model.addAttribute("listReportType",list);
			
		}
		if(reportId != null && reportId > 0){
			model.addAttribute("report",birtReportService.getBirtReportById(reportId));
		}
		model.addAttribute("reportId",reportId);
		return "/module/report/report/reportType";
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(BirtReport.class, new ReportPropertyEditor());
	}
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(@ModelAttribute("reportType") BirtReportType reportType, BindingResult bindingResult, HttpServletRequest request, SessionStatus status) {
		new BirtReportTypeValidator().validate(reportType, bindingResult);
		if (bindingResult.hasErrors()) {
			return "/module/report/report/reportType";
		}else{
			BirtReportService birtReportService = Context.getService(BirtReportService.class);
	    	BirtReportConfig config = ReportConstants.getConfig();
			String tempPath = config.getRealPath();
			if(StringUtils.isBlank(tempPath)){
				new Throwable("Not exist realpath for save file report!");
			}
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
	        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("reportFile");
	        if(file != null && file.getBytes() != null  && file.isEmpty()==false){
		        long temp = new Date().getTime();
		        //String nameReport = org.openmrs.module.report.util.StringUtils.replaceSpecialWithUnderLineCharacter(reportType.getBirtReport().getName());
		        //String nameReportType = org.openmrs.module.report.util.StringUtils.replaceSpecialWithUnderLineCharacter(reportType.getName());
		        String fileName = reportType.getBirtReport().getId()+"_"+temp+".rptdesign";
		        String reportFilename = tempPath +"/" + fileName;
		        reportFilename = reportFilename.replaceAll("//", "/");
		        
		        try {
					FileCopyUtils.copy(file.getInputStream(), new FileOutputStream(reportFilename));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				reportType.setPath(fileName);
	        }else if(reportType.getId() != null && reportType.getId().intValue() > 0){
	        	reportType.setPath(birtReportService.getBirtReportTypeById(reportType.getId()).getPath());
	        }
			
			reportType.setCreatedBy(Context.getAuthenticatedUser().getGivenName());
			reportType.setCreatedOn(new Date());
			birtReportService.saveBirtReportType(reportType);
			status.setComplete();
			return "redirect:/module/report/reportType.form?reportId="+reportType.getBirtReport().getId();
		}
	}
}
