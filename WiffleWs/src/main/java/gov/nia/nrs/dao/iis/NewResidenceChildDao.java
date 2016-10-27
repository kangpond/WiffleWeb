/**
 *
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.NewResidenceChild;

import java.util.List;

/**
 * @author Jay Lin
 *
 */
public interface NewResidenceChildDao {
    public List<NewResidenceChild> query(String personId, String chineseName, String birthDate);
}
