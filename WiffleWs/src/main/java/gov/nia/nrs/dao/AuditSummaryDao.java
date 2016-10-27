package gov.nia.nrs.dao;

import gov.nia.nrs.bean.AuditQueryBean;
import gov.nia.nrs.bean.UserProfile;

import java.util.List;
import java.util.Map;

public interface AuditSummaryDao {

	public List<Map<String, ?>> searchSummaryByDay(UserProfile up,
			String startDate, String endDate, String userId);

}
