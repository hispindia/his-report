/**
 * <p> File: org.openmrs.module.report.db.ReportDAO.java </p>
 * <p> Project: report-api </p>
 * <p> Copyright (c) 2011 HISP Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Email: chuyennmth@gmail.com</p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 6:27:46 PM </p>
 * <p> Update date: Apr 25, 2011 6:27:46 PM </p>
 **/

package org.openmrs.module.report.db;

import java.util.List;

import org.openmrs.api.db.DAOException;
import org.openmrs.module.report.model.BirtReport;
import org.openmrs.module.report.model.BirtReportConfig;
import org.openmrs.module.report.model.BirtReportType;

/**
 * <p> Class: ReportDAO </p>
 * <p> Package: org.openmrs.module.report.db </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 6:27:46 PM </p>
 * <p> Update date: Apr 25, 2011 6:27:46 PM </p>
 **/
public interface ReportDAO {

	
	/**
	 * Birt Report 
	 */

    public List<BirtReport> listBirtReport(String name, String fromDate, String toDate, int min, int max) throws DAOException;
    public List<BirtReport> listBirtReportByRole(List<String> roleIds, Boolean retired) throws DAOException;
	
	public BirtReport saveReport(BirtReport report) throws DAOException;

	public int countBirtReport(String name, String fromDate, String toDate)  throws DAOException;
	
	public BirtReport getBirtReportById(Integer id) throws DAOException;
	
	public void deleteBirtReport(Integer id) throws DAOException;
	
	public BirtReport getBirtReportByName(String name) throws DAOException;
	
	
	/**
	 * Birt Report Config
	 */
	
	public BirtReportConfig saveReportConfig(BirtReportConfig report) throws DAOException;
	
	public BirtReportConfig getBirtReportConfig() throws DAOException;
	
	/**
	 * Birt Report tye
	 */

    public List<BirtReportType> listBirtReportTypeByReport(Integer id) throws DAOException;
	
	public BirtReportType saveBirtReportType(BirtReportType birtReportType) throws DAOException;

	public BirtReportType getBirtReportTypeById(Integer id) throws DAOException;
	
	public void deleteBirtReportType(Integer id) throws DAOException;
	
	public BirtReportType getBirtReportTypeByName(Integer reportId,String name) throws DAOException;
	
	
}
