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
import org.openmrs.module.report.model.BirtReportType;
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
public class BirtReportTypeValidator {
	/**
     * @see org.springframework.validation.Validator#supports(java.lang.Class)
     */
    public boolean supports(Class clazz) {
    	return BirtReportType.class.equals(clazz);
    }

	/**
     * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
     */
    public void validate(Object command, Errors error) {
    	BirtReportType reportType = (BirtReportType) command;
    	
    	if( reportType.getId() == null && StringUtils.isBlank(reportType.getName())){
    		error.reject("report.reportType.name.required");
    	}
    	BirtReportService inventoryService = Context.getService(BirtReportService.class);
    	BirtReportType reportE = inventoryService.getBirtReportTypeByName(reportType.getBirtReport().getId() , reportType.getName());
    	if(reportType.getId() != null){
    		if(reportE != null && reportE.getId().intValue() != reportType.getId().intValue()){
    			error.reject("report.reportType.name.existed");
    		}
    	}else{
    		if(reportE != null){
    	    		error.reject("report.reportType.name.existed");
    		}
    	}
    	
    	
    }
}
