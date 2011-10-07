/**
 * <p> File: org.openmrs.module.report.web.controller.global.AjaxController.java </p>
 * <p> Project: standard-omod </p>
 * <p> Copyright (c) 2011 HISP Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Email: chuyennmth@gmail.com</p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Mar 22, 2011 12:39:41 PM </p>
 * <p> Update date: Mar 22, 2011 12:39:41 PM </p>
 **/

package org.openmrs.module.report.web.controller.ajax;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.openmrs.api.context.Context;
import org.openmrs.module.report.BirtReportService;
import org.openmrs.module.report.model.BirtReportConfig;
import org.openmrs.module.report.model.BirtReportType;
import org.openmrs.module.report.util.ReportConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * <p> Class: AjaxController </p>
 * <p> Package: org.openmrs.module.report.web.controller.global </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Mar 22, 2011 12:39:41 PM </p>
 * <p> Update date: Mar 22, 2011 12:39:41 PM </p>
 **/
@Controller("ReportAjaxController")
public class AjaxController {
	@RequestMapping("/module/report/deleteReportType.form")
	public String deleteReportType(
			 @RequestParam(value="id")  Integer id,
			 @RequestParam(value="reportId")  Integer reportId,
			Model model) {
		BirtReportService birtReportService =  Context.getService(BirtReportService.class);
		BirtReportType  reportType = birtReportService.getBirtReportTypeById(id);
		BirtReportConfig config = ReportConstants.getConfig();
		if(reportType != null)
		{
			String real_path = config.getRealPath();
			if(real_path.lastIndexOf("/") == -1){
				real_path = real_path +reportType.getPath();
			}else{
				real_path = real_path +"/"+reportType.getPath();
			}
			File file = new File(real_path);
			if(file != null && file.exists()){
				file.delete();
			}
			birtReportService.deleteBirtReportType(id);
		}
		
		
		
		return "redirect:/module/report/reportType.form?reportId="+reportId;
	}
	@RequestMapping("/module/report/downloadReportType.form")
	public String downloadReportType(
			 @RequestParam(value="id")  Integer id,
			 HttpServletResponse response, 
			Model model) {
		BirtReportService birtReportService =  Context.getService(BirtReportService.class);
		BirtReportType  reportType = birtReportService.getBirtReportTypeById(id);
		BirtReportConfig config = ReportConstants.getConfig();
		if(reportType != null)
		{
			String real_path = config.getRealPath();
			
			if(real_path.lastIndexOf("/") == -1){
				real_path = real_path +reportType.getPath();
			}else{
				real_path = real_path +"/"+reportType.getPath();
			}
			
			
			response.setContentType("text/xml; charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename=" + reportType.getPath());
			try {
				InputStream fileInputStream = new FileInputStream(real_path);
				try {
					FileCopyUtils.copy(fileInputStream, response.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return null;
	}
	
}
