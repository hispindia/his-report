/**
 * <p> File: org.openmrs.module.report.model.BirtReportType.java </p>
 * <p> Project: birtReport-api </p>
 * <p> Copyright (c) 2011 HISP Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Email: chuyennmth@gmail.com</p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 6:13:44 PM </p>
 * <p> Update date: Apr 25, 2011 6:13:44 PM </p>
 **/

package org.openmrs.module.report.model;

import java.io.Serializable;
import java.util.Date;

import org.openmrs.api.context.Context;
import org.openmrs.module.report.BirtReportService;
import org.openmrs.module.report.util.ReportConstants;

/**
 * <p> Class: BirtReportType </p>
 * <p> Package: org.openmrs.module.report.model </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 6:13:44 PM </p>
 * <p> Update date: Apr 25, 2011 6:13:44 PM </p>
 **/
public class BirtReportType implements  Serializable {

	 private static final long serialVersionUID = 1L;
	 private Integer id;
	 private BirtReport birtReport;
	 private String name;
	 private Date createdOn;
	 private String createdBy;
	 private String path;
	 
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public BirtReport getBirtReport() {
		return birtReport;
	}
	public void setBirtReport(BirtReport birtReport) {
		this.birtReport = birtReport;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getFullPath() {
		BirtReportConfig config = ReportConstants.getConfig();
		String url_data = config.getUrlData();
		if(url_data.lastIndexOf("/") == -1){
			url_data = url_data +path;
		}else{
			url_data = url_data +"/"+path;
		}
		return url_data;
	}
	 
	 
	 

}
