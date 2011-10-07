/**
 * <p> File: org.openmrs.module.report.web.controller.report.BirtReportValidator.java </p>
 * <p> Project: report-omod </p>
 * <p> Copyright (c) 2011 HISP Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Email: chuyennmth@gmail.com</p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 7:08:27 PM </p>
 * <p> Update date: Apr 25, 2011 7:08:27 PM </p>
 **/

package org.openmrs.module.report.web.controller.report;

import org.apache.commons.lang.StringUtils;
import org.openmrs.api.context.Context;
import org.openmrs.module.report.BirtReportService;
import org.openmrs.module.report.model.BirtReport;
import org.springframework.validation.Errors;

/**
 * <p> Class: BirtReportValidator </p>
 * <p> Package: org.openmrs.module.report.web.controller.report </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 7:08:27 PM </p>
 * <p> Update date: Apr 25, 2011 7:08:27 PM </p>
 **/
public class BirtReportValidator {
	/**
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    public boolean supports(Class clazz) {
    	return BirtReport.class.equals(clazz);
    }

	/**
     * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
     */
    public void validate(Object command, Errors error) {
    	BirtReport report = (BirtReport) command;
    	
    	if( StringUtils.isBlank(report.getName())){
    		error.reject("report.report.name.required");
    	}
    	BirtReportService inventoryService = Context.getService(BirtReportService.class);
    	BirtReport reportE = inventoryService.getBirtReportByName(report.getName());
    	if(report.getId() != null){
    		if(reportE != null && reportE.getId().intValue() != report.getId().intValue()){
    			error.reject("report.report.name.existed");
    		}
    	}else{
    		if(reportE != null){
    	    		error.reject("report.report.name.existed");
    		}
    	}
    	
    	
    }
}
