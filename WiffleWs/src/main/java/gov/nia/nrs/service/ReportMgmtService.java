package gov.nia.nrs.service;

import gov.nia.nrs.bean.AuditQueryBean;
import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.ReportMgmt;

import java.util.Map;

public interface ReportMgmtService {

	public Map<String,Object> getReportMgmtList(ReportMgmt mgnt,UserProfile up, int offset);

	public ReportMgmt getQueryConditions(String reportId,UserProfile up);

	public String createReportMgmt(AuditQueryBean aqb, UserProfile up);

	public void updateReportMgmt(String reportId, String filePath, String state);
}
