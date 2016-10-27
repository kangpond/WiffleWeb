package gov.nia.nrs.dao;

import gov.nia.nrs.bean.AuditQueryBean;
import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.ReportMgmt;

import java.util.Map;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

public interface ReportMgmtDao extends GenericDAO<ReportMgmt, String>{
	
	
	public String createReportMgmt(AuditQueryBean queryBean,UserProfile up);
	
	public void updateReportMgmt(String reportId, String fileName ,String state);

	public Map<String, Object> getReportMgmtList(ReportMgmt mgmt,
			UserProfile up, int offset);
}
