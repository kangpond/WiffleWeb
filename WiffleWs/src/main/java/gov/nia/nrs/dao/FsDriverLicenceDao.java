package gov.nia.nrs.dao;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.FsDriverLicence;

import java.util.List;

public interface FsDriverLicenceDao {

	List<FsDriverLicence> getDriverLicence(UserProfile userProfile,String firstReceiveNo);

}
