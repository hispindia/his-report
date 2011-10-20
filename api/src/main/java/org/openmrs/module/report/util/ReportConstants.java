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
