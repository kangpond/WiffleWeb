package gov.nia.nrs.dao;

import gov.nia.nrs.bean.UserProfile;

import java.util.List;
import java.util.Map;

public interface IsuranceDao {


	public Map<String, Object> getIsuranceInfo(UserProfile userProfile,
			String firstReceiveNo, String residentIdNo, String isuranceType,
			Integer offset);
}
