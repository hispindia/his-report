/**
 * <p> File: org.openmrs.module.report.db.hibernate.HibernateReportDAO.java </p>
 * <p> Project: report-api </p>
 * <p> Copyright (c) 2011 HISP Technologies. </p>
 * <p> All rights reserved. </p>
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Email: chuyennmth@gmail.com</p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 6:28:09 PM </p>
 * <p> Update date: Apr 25, 2011 6:28:09 PM </p>
 **/

package org.openmrs.module.report.db.hibernate;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.openmrs.api.db.DAOException;
import org.openmrs.module.report.db.ReportDAO;
import org.openmrs.module.report.model.BirtReport;
import org.openmrs.module.report.model.BirtReportConfig;
import org.openmrs.module.report.model.BirtReportType;

/**
 * <p> Class: HibernateReportDAO </p>
 * <p> Package: org.openmrs.module.report.db.hibernate </p> 
 * <p> Author: Nguyen manh chuyen </p>
 * <p> Update by: Nguyen manh chuyen </p>
 * <p> Version: $1.0 </p>
 * <p> Create date: Apr 25, 2011 6:28:09 PM </p>
 * <p> Update date: Apr 25, 2011 6:28:09 PM </p>
 **/
public class HibernateReportDAO implements ReportDAO{
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	SimpleDateFormat formatterExt = new SimpleDateFormat("dd/MM/yyyy");
	protected final Log log = LogFactory.getLog(getClass());
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<BirtReport> listBirtReport(String name, String fromDate,
			String toDate, int min, int max) throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BirtReport.class , "report");
		if(StringUtils.isNotBlank(name)){
			criteria.add(Restrictions.like("report.name", "%"+name+"%"));
		}
		if (!StringUtils.isBlank(fromDate) && StringUtils.isBlank(toDate)) {
			String startFromDate = fromDate + " 00:00:00";
			String endFromDate = fromDate + " 23:59:59";
			try {
				criteria.add(Restrictions.and(Restrictions.ge(
						"report.createdOn", formatter.parse(startFromDate)), Restrictions.le(
						"report.createdOn", formatter.parse(endFromDate))));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("listBirtReport>>Error convert date: "+ e.toString());
				e.printStackTrace();
			}
		} 
		else if (StringUtils.isBlank(fromDate) && !StringUtils.isBlank(toDate)) {
			String startToDate = toDate + " 00:00:00";
			String endToDate = toDate + " 23:59:59";
			try {
				criteria.add(Restrictions.and(Restrictions.ge(
						"report.createdOn", formatter.parse(startToDate)), Restrictions.le(
						"report.createdOn", formatter.parse(endToDate))));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("listBirtReport>>Error convert date: "+ e.toString());
				e.printStackTrace();
			}
		} 
		else if (!StringUtils.isBlank(fromDate) && !StringUtils.isBlank(toDate)) {
			String startToDate = fromDate + " 00:00:00";
			String endToDate = toDate + " 23:59:59";
			try {
				criteria.add(Restrictions.and(Restrictions.ge(
						"report.createdOn", formatter.parse(startToDate)), Restrictions.le(
						"report.createdOn", formatter.parse(endToDate))));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("listBirtReport>>Error convert date: "+ e.toString());
				e.printStackTrace();
			}
		}
		if(max > 0){
			criteria.setFirstResult(min).setMaxResults(max);
		}
		List<BirtReport> l = criteria.list();
		return l;
	}

	@Override
	public List<BirtReport> listBirtReportByRole(List<String> roleIds, Boolean retired)
			throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BirtReport.class , "report")
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
		.createCriteria("report.reportRoles", Criteria.INNER_JOIN)
		.add(Restrictions.in("id",roleIds));
		if(retired != null){
			criteria.add(Restrictions.eq("report.retired", retired));
		}
		List<BirtReport> l = criteria.list();
		return l;
		
	}

	@Override
	public BirtReport saveReport(BirtReport report) throws DAOException {
		// TODO Auto-generated method stub
		BirtReport birtReport = (BirtReport)sessionFactory.getCurrentSession().merge(report);
		return birtReport;
	}

	@Override
	public int countBirtReport(String name, String fromDate, String toDate)
			throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BirtReport.class , "report");
		if(StringUtils.isNotBlank(name)){
			criteria.add(Restrictions.like("report.name", "%"+name+"%"));
		}
		if (!StringUtils.isBlank(fromDate) && StringUtils.isBlank(toDate)) {
			String startFromDate = fromDate + " 00:00:00";
			String endFromDate = fromDate + " 23:59:59";
			try {
				criteria.add(Restrictions.and(Restrictions.ge(
						"report.createdOn", formatter.parse(startFromDate)), Restrictions.le(
						"report.createdOn", formatter.parse(endFromDate))));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("countBirtReport>>Error convert date: "+ e.toString());
				e.printStackTrace();
			}
		} 
		else if (StringUtils.isBlank(fromDate) && !StringUtils.isBlank(toDate)) {
			String startToDate = toDate + " 00:00:00";
			String endToDate = toDate + " 23:59:59";
			try {
				criteria.add(Restrictions.and(Restrictions.ge(
						"report.createdOn", formatter.parse(startToDate)), Restrictions.le(
						"report.createdOn", formatter.parse(endToDate))));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("countBirtReport>>Error convert date: "+ e.toString());
				e.printStackTrace();
			}
		} 
		else if (!StringUtils.isBlank(fromDate) && !StringUtils.isBlank(toDate)) {
			String startToDate = fromDate + " 00:00:00";
			String endToDate = toDate + " 23:59:59";
			try {
				criteria.add(Restrictions.and(Restrictions.ge(
						"report.createdOn", formatter.parse(startToDate)), Restrictions.le(
						"report.createdOn", formatter.parse(endToDate))));
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("countBirtReport>>Error convert date: "+ e.toString());
				e.printStackTrace();
			}
		}
		
		Number rs =  (Number) criteria.setProjection( Projections.rowCount() ).uniqueResult();
		return rs != null ? rs.intValue() : 0;
	}

	@Override
	public BirtReport getBirtReportById(Integer id) throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BirtReport.class , "report")
		.add(Restrictions.eq("report.id", id));
		
		return (BirtReport) criteria.uniqueResult();
	}

	@Override
	public void deleteBirtReport(Integer id) throws DAOException {
		BirtReport birtReport = getBirtReportById(id);
		if(birtReport != null && CollectionUtils.isEmpty(birtReport.getReportTypes())){
			sessionFactory.getCurrentSession().delete(birtReport);
		}
		
	}

	@Override
	public BirtReport getBirtReportByName(String name) throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BirtReport.class , "report")
		.add(Restrictions.eq("report.name", name));
		criteria.setFirstResult(0).setMaxResults(1);
		List<BirtReport> l = criteria.list();
		return CollectionUtils.isNotEmpty(l)? l.get(0) : null;
	}

	//REPORT TYPE
	
	@Override
	public List<BirtReportType> listBirtReportTypeByReport(Integer id)
			throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BirtReportType.class , "reportType")
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
		.createAlias("reportType.birtReport", "report")
		.add(Restrictions.eq("report.id", id));
		List<BirtReportType> l = criteria.list();
		return l;
	}

	@Override
	public BirtReportType saveBirtReportType(BirtReportType birtReportType)
			throws DAOException {
		BirtReportType o = (BirtReportType)sessionFactory.getCurrentSession().merge(birtReportType);
		return o;
	}

	@Override
	public BirtReportType getBirtReportTypeById(Integer id) throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BirtReportType.class , "reportType")
		.add(Restrictions.eq("reportType.id", id));
		
		return (BirtReportType) criteria.uniqueResult();
	}

	@Override
	public void deleteBirtReportType(Integer id) throws DAOException {
		BirtReportType birtReportType = getBirtReportTypeById(id);
		if(birtReportType != null){
			sessionFactory.getCurrentSession().delete(birtReportType);
		}
	}

	@Override
	public BirtReportType getBirtReportTypeByName(Integer reportId, String name) throws DAOException {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BirtReportType.class , "reportType")
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
		.createAlias("reportType.birtReport", "report")
		.add(Restrictions.eq("report.id", reportId))
		.add(Restrictions.eq("reportType.name", name));
		criteria.setFirstResult(0).setMaxResults(1);
		List<BirtReportType> l = criteria.list();
		return CollectionUtils.isNotEmpty(l)? l.get(0) : null;
	}
	
	/**
	 * Birt Report Config
	 */
	
	public BirtReportConfig saveReportConfig(BirtReportConfig report) throws DAOException{
		BirtReportConfig o = (BirtReportConfig)sessionFactory.getCurrentSession().merge(report);
		return o;
	}
	
	public BirtReportConfig getBirtReportConfig() throws DAOException{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(BirtReportConfig.class );
		criteria.setFirstResult(0).setMaxResults(1);
		List<BirtReportConfig> l = criteria.list();
		return CollectionUtils.isNotEmpty(l)? l.get(0) : null;
	}
	
}
