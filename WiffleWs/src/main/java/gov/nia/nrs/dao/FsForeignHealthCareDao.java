package gov.nia.nrs.dao;

import java.util.List;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.FsForeignHealthCare;

public interface FsForeignHealthCareDao {

	public List<FsForeignHealthCare> getHealCareInfo(UserProfile userProfile,String firstReceiveNo, String residentIdNo);
}
