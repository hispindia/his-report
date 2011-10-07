/**
 * <p> File: org.openmrs.module.report.web.controller.report.ReportListController.java </p>
 * <p> Project: report-omod </p>
 * <p> Copyright (c) 2011 HISP Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Email: chuyennmth@gmail.com</p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 7:19:46 PM </p>
 * <p> Update date: Apr 25, 2011 7:19:46 PM </p>
 **/

package org.openmrs.module.report.web.controller.report;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.openmrs.api.context.Context;
import org.openmrs.module.report.BirtReportService;
import org.openmrs.module.report.model.BirtReport;
import org.openmrs.module.report.util.PagingUtil;
import org.openmrs.module.report.util.RequestUtil;
import org.openmrs.web.WebConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p> Class: ReportListController </p>
 * <p> Package: org.openmrs.module.report.web.controller.report </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 7:19:46 PM </p>
 * <p> Update date: Apr 25, 2011 7:19:46 PM </p>
 **/

@Controller("ReportReportListController")
@RequestMapping("/module/report/reportList.form")
public class ReportListController {
	
	@RequestMapping(method=RequestMethod.POST)
    public String delete(@RequestParam("ids") String[] ids,HttpServletRequest request){
		String temp = "";
    	HttpSession httpSession = request.getSession();
    	
		try{
			BirtReportService birtReportService =Context.getService(BirtReportService.class);
			if( ids != null && ids.length > 0 ){
				for(String sId : ids )
				{
					BirtReport report = birtReportService.getBirtReportById(NumberUtils.toInt(sId, 0));
					if(report != null && CollectionUtils.isEmpty(report.getReportTypes())){
						birtReportService.deleteBirtReport(NumberUtils.toInt(sId, 0));
					}else{
						temp += "Can't delete report <br/> ";
					}
				}
			}
		}catch (Exception e) {
			httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR,"Can not delete report ");
		}
		httpSession.setAttribute(WebConstants.OPENMRS_MSG_ATTR,StringUtils.isBlank(temp) ?  "report.deleted" : temp);
    	
    	return "redirect:/module/report/reportList.form";
    }
	
	@RequestMapping(method=RequestMethod.GET)
	public String list( @RequestParam(value="searchName",required=false)  String searchName,
							@RequestParam(value="fromDate",required=false)  String fromDate, 
							@RequestParam(value="toDate",required=false)  String toDate, 
							@RequestParam(value="pageSize",required=false)  Integer pageSize, 
	                        @RequestParam(value="currentPage",required=false)  Integer currentPage,
	                        Map<String, Object> model, HttpServletRequest request){
		
		BirtReportService birtReportService = Context.getService(BirtReportService.class);
		
		int total = birtReportService.countBirtReport(searchName, fromDate, toDate);
		String temp = "";
		if(!StringUtils.isBlank(searchName)){	
				temp = "?searchName="+searchName;
		}
		if(fromDate != null){	
			if(StringUtils.isBlank(temp)){
				temp = "?fromDate="+fromDate;
			}else{
				temp +="&fromDate="+fromDate;
			}
		}
		if(toDate != null){	
			if(StringUtils.isBlank(temp)){
				temp = "?toDate="+toDate;
			}else{
				temp +="&toDate="+toDate;
			}
		}
		PagingUtil pagingUtil = new PagingUtil( RequestUtil.getCurrentLink(request)+temp , pageSize, currentPage, total );
		
		List<BirtReport> reports = birtReportService.listBirtReport(searchName, fromDate, toDate, pagingUtil.getStartPos(), pagingUtil.getPageSize());
		
		model.put("reports", reports );
		model.put("searchName", searchName);
		model.put("fromDate", fromDate);
		model.put("toDate", toDate);
		model.put("pagingUtil", pagingUtil);
		
		return "/module/report/report/reportList";
	}
}
