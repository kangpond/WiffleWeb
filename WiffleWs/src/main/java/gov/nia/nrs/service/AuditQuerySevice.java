package gov.nia.nrs.service;

import gov.nia.nrs.bean.AuditQueryBean;
import gov.nia.nrs.bean.UserProfile;

public interface AuditQuerySevice {

	public String searchAuditQuery(AuditQueryBean queryBean,UserProfile up,String reportId) throws Exception;
	
}
