/**
 * <p> File: org.openmrs.module.report.model.BirtReport.java </p>
 * <p> Project: report-api </p>
 * <p> Copyright (c) 2011 HISP Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Email: chuyennmth@gmail.com</p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 6:04:29 PM </p>
 * <p> Update date: Apr 25, 2011 6:04:29 PM </p>
 **/

package org.openmrs.module.report.model;

import java.io.Serializable;

/**
 * <p> Class: BirtReport </p>
 * <p> Package: org.openmrs.module.report.model </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 6:04:29 PM </p>
 * <p> Update date: Apr 25, 2011 6:04:29 PM </p>
 **/
public class BirtReportConfig implements  Serializable {

	 private static final long serialVersionUID = 1L;
	 private Integer id;
	 private String urlData="http://localhost:8080/data";
	 private String	 tempFile="birt_report_temp.rptdesign";
	 private String	 realPath="D:/HISP/report";
	 private String	 urlBirt="http://localhost:8080/birt";
	 private String	 width="1100";
	 private String	 format="html";
	 private String	 height="450";
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUrlData() {
		return urlData;
	}
	public void setUrlData(String urlData) {
		this.urlData = urlData;
	}
	public String getTempFile() {
		return tempFile;
	}
	public void setTempFile(String tempFile) {
		this.tempFile = tempFile;
	}
	public String getRealPath() {
		return realPath;
	}
	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}
	public String getUrlBirt() {
		return urlBirt;
	}
	public void setUrlBirt(String urlBirt) {
		this.urlBirt = urlBirt;
	}
	
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	
	 
	 
	 
}
