/**
 *
 */
package gov.nia.nrs.dao.imm;

import gov.nia.nrs.domain.imm.Permit;

import java.util.List;

/**
 * @author Jay Lin
 *
 */
public interface PermitDao {
    public List<Permit> queryByFirstReceiveNo(String firstReceiveNo);
}
