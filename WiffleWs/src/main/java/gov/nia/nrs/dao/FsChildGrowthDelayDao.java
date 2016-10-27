package gov.nia.nrs.dao;

import gov.nia.nrs.bean.UserProfile;

public interface FsChildGrowthDelayDao {

	boolean checkingGrowthDelay(UserProfile userProfile, String personId);

}
