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
package org.openmrs.module.report.impl;

import java.util.List;

import org.openmrs.api.APIException;
import org.openmrs.api.impl.BaseOpenmrsService;
import org.openmrs.module.report.BirtReportService;
import org.openmrs.module.report.db.ReportDAO;
import org.openmrs.module.report.model.BirtReport;
import org.openmrs.module.report.model.BirtReportConfig;
import org.openmrs.module.report.model.BirtReportType;

public class BirtReportServiceImpl extends BaseOpenmrsService implements BirtReportService {

	  public BirtReportServiceImpl(){
	    }
	    
	    protected ReportDAO dao;

		public ReportDAO getDao() {
			return dao;
		}

		public void setDao(ReportDAO dao) {
			this.dao = dao;
		}

		@Override
		public List<BirtReport> listBirtReport(String name, String fromDate,
				String toDate, int min, int max) throws APIException {
			// TODO Auto-generated method stub
			return dao.listBirtReport(name, fromDate, toDate, min, max);
		}

		@Override
		public List<BirtReport> listBirtReportByRole(List<String> roleIds, Boolean retired)
				throws APIException {
			// TODO Auto-generated method stub
			return dao.listBirtReportByRole(roleIds, retired);
		}

		@Override
		public BirtReport saveReport(BirtReport report) throws APIException {
			// TODO Auto-generated method stub
			return dao.saveReport(report);
		}

		@Override
		public int countBirtReport(String name, String fromDate, String toDate)
				throws APIException {
			// TODO Auto-generated method stub
			return dao.countBirtReport(name, fromDate, toDate);
		}

		@Override
		public BirtReport getBirtReportById(Integer id) throws APIException {
			// TODO Auto-generated method stub
			return dao.getBirtReportById(id);
		}

		@Override
		public void deleteBirtReport(Integer id) throws APIException {
			// TODO Auto-generated method stub
			dao.deleteBirtReport(id);
		}

		@Override
		public BirtReport getBirtReportByName(String name) throws APIException {
			// TODO Auto-generated method stub
			return dao.getBirtReportByName(name);
		}

		@Override
		public List<BirtReportType> listBirtReportTypeByReport(Integer id)
				throws APIException {
			// TODO Auto-generated method stub
			return dao.listBirtReportTypeByReport(id);
		}

		@Override
		public BirtReportType saveBirtReportType(BirtReportType birtReportType)
				throws APIException {
			// TODO Auto-generated method stub
			return dao.saveBirtReportType(birtReportType);
		}

		@Override
		public BirtReportType getBirtReportTypeById(Integer id)
				throws APIException {
			// TODO Auto-generated method stub
			return dao.getBirtReportTypeById(id);
		}

		@Override
		public void deleteBirtReportType(Integer id) throws APIException {
			// TODO Auto-generated method stub
			dao.deleteBirtReportType(id);
		}

		@Override
		public BirtReportType getBirtReportTypeByName(Integer reportId,String name)
				throws APIException {
			// TODO Auto-generated method stub
			return dao.getBirtReportTypeByName(reportId ,name);
		}

		@Override
		public BirtReportConfig saveReportConfig(BirtReportConfig report)
				throws APIException {
			// TODO Auto-generated method stub
			return dao.saveReportConfig(report);
		}

		@Override
		public BirtReportConfig getBirtReportConfig() throws APIException {
			// TODO Auto-generated method stub
			return dao.getBirtReportConfig();
		}
	    

}
