/**
 *
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.ForeignSpouse;

import java.util.List;

/**
 * @author Jay Lin
 *
 */
public interface ForeignSpouseDao {

    public List<ForeignSpouse> query(String residentIdNo, String personId, String passportNo, String latestReceiveNo, String chineseName, String englishName,
            String birthDate);

    public List<ForeignSpouse> queryByFirstReceiveNo(List<String> firstReceiveNoList);

    public ForeignSpouse query(String residentIdNo, String firstReceiveNo);
}
