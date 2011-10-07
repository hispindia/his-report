/**
 * <p> File: org.openmrs.module.report.util.ReportConstants.java </p>
 * <p> Project: report-api </p>
 * <p> Copyright (c) 2011 HISP Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Email: chuyennmth@gmail.com</p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 29, 2011 4:07:39 PM </p>
 * <p> Update date: Apr 29, 2011 4:07:39 PM </p>
 **/

package org.openmrs.module.report.util;

import org.openmrs.api.context.Context;
import org.openmrs.module.report.BirtReportService;
import org.openmrs.module.report.model.BirtReportConfig;

/**
 * <p> Class: ReportConstants </p>
 * <p> Package: org.openmrs.module.report.util </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 29, 2011 4:07:39 PM </p>
 * <p> Update date: Apr 29, 2011 4:07:39 PM </p>
 **/
public class ReportConstants {
	
	  private static BirtReportConfig config;
	   public static BirtReportConfig getConfig() {
		if(config == null){
			BirtReportService birtReportService =  Context.getService(BirtReportService.class);
			BirtReportConfig configE = birtReportService.getBirtReportConfig();
			config = configE;
			return config;
		}
		return config;
	}
	public static void setConfig(BirtReportConfig configE) {
		config = configE;
	}
}
