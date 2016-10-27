package gov.nia.nrs.dao.iis;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.iis.SefCertify;

import java.util.List;

public interface SefCertifyDao {

	List<SefCertify> getSefCertifyList(String personId);

	SefCertify getSefCertifyInfo(UserProfile userProfile, String documentNo);

}
