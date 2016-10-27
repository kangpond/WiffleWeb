/**
 *
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.iis.TwSpouse;

import java.util.List;
import java.util.Map;

/**
 * @author Jay Lin
 *
 */
public interface TwSpouseDao {
    public List<TwSpouse> query(String personId, String chineseName, String birthDate);

    public List<Map<String, String>> getMarriageCondition(UserProfile userProfile,String firstReceiveNo);

	public TwSpouse getTwSpouse(String twSpousePersonId, String firstReceiveNo);
}
