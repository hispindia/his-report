package org.openmrs.module.report.web.controller.report;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.report.BirtReportService;
import org.openmrs.module.report.model.BirtReport;

public class ReportPropertyEditor extends PropertyEditorSupport{
	private Log log = LogFactory.getLog(this.getClass());
	public ReportPropertyEditor() {
	}
	public void setAsText(String text) throws IllegalArgumentException {
		BirtReportService reportService = Context.getService(BirtReportService.class);
		if (text != null && text.trim().length() > 0 ) {
			try {
				setValue(reportService.getBirtReportById(NumberUtils.toInt(text)));
			}
			catch (Exception ex) {
				log.error("Error setting text: " + text, ex);
				throw new IllegalArgumentException("report not found: " + ex.getMessage());
			}
		} else {
			setValue(null);
		}
	}
	
	public String getAsText() {
		BirtReport s = (BirtReport) getValue();
		if (s == null ) {
			return null; 
		} else {
			return s.getId()+"";
		}
	}
}
