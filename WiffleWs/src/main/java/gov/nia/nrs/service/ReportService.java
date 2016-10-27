package gov.nia.nrs.service;

import gov.nia.nrs.bean.AuditQueryBean;
import gov.nia.nrs.bean.UserProfile;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.sf.jasperreports.engine.JRException;

public interface ReportService {
	public String exportReport(List<? extends Object> inputList,AuditQueryBean queryBean,UserProfile up,String folder,boolean isZip) throws Exception;
	
	public String exportSummaryByDay(UserProfile userProfile, String startDate,
			String endDate, String userId) throws Exception ;

	public String downloadApplyFrom(String uuid) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException, JRException;
}
