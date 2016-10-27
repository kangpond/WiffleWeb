/**
 *
 */
package gov.nia.nrs.dao.imm;

import gov.nia.nrs.dataquery.bean.MultiCitizenshipQueryReq;
import gov.nia.nrs.domain.imm.MultiCitizenship;

import java.util.List;

/**
 * @author Jay Lin
 *
 */
public interface MultiCitizenshipDao {
    public List<MultiCitizenship> query(MultiCitizenshipQueryReq req);
}
