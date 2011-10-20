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
package org.openmrs.module.report;

import java.util.List;

import org.openmrs.api.APIException;
import org.openmrs.api.OpenmrsService;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.report.model.BirtReport;
import org.openmrs.module.report.model.BirtReportConfig;
import org.openmrs.module.report.model.BirtReportType;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BirtReportService extends OpenmrsService{
	
	/**
	 * Birt Report 
	 */

    public List<BirtReport> listBirtReport(String name, String fromDate, String toDate, int min, int max) throws APIException;
    
    public List<BirtReport> listBirtReportByRole(List<String> roleIds, Boolean retired) throws APIException;
	
	public BirtReport saveReport(BirtReport report) throws APIException;

	public int countBirtReport(String name, String fromDate, String toDate)  throws APIException;
	
	public BirtReport getBirtReportById(Integer id) throws APIException;
	
	public void deleteBirtReport(Integer id) throws APIException;
	
	public BirtReport getBirtReportByName(String name) throws APIException;
	
	/**
	 * Birt Report type
	 */

    public List<BirtReportType> listBirtReportTypeByReport(Integer id) throws APIException;
	
	public BirtReportType saveBirtReportType(BirtReportType birtReportType) throws APIException;

	public BirtReportType getBirtReportTypeById(Integer id) throws APIException;
	
	public void deleteBirtReportType(Integer id) throws APIException;
	
	public BirtReportType getBirtReportTypeByName(Integer reportId,String name) throws APIException;
	
	/**
	 * Birt Report Config
	 */
	
	public BirtReportConfig saveReportConfig(BirtReportConfig report) throws APIException;
	
	public BirtReportConfig getBirtReportConfig() throws APIException;

}
