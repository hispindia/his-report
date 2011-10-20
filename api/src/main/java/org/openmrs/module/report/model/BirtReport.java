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
import java.util.Date;
import java.util.Set;

import org.openmrs.Role;

/**
 * <p> Class: BirtReport </p>
 * <p> Package: org.openmrs.module.report.model </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 6:04:29 PM </p>
 * <p> Update date: Apr 25, 2011 6:04:29 PM </p>
 **/
public class BirtReport implements  Serializable {

	 private static final long serialVersionUID = 1L;
	 private Integer id;
	 private String name;
	 private String description;
	 private Date createdOn;
	 private String createdBy;
	 private Set<BirtReportType> reportTypes;
	 private Set<Role> reportRoles;
	 private Boolean retired =false;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Set<BirtReportType> getReportTypes() {
		return reportTypes;
	}
	public void setReportTypes(Set<BirtReportType> reportTypes) {
		this.reportTypes = reportTypes;
	}
	public Set<Role> getReportRoles() {
		return reportRoles;
	}
	public void setReportRoles(Set<Role> reportRoles) {
		this.reportRoles = reportRoles;
	}
	public Boolean getRetired() {
		return retired;
	}
	public void setRetired(Boolean retired) {
		this.retired = retired;
	}
	 
	 
}
