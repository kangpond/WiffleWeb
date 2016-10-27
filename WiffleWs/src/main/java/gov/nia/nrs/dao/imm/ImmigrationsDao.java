/**
 *
 */
package gov.nia.nrs.dao.imm;

import gov.nia.nrs.domain.imm.Immigrations;

import java.util.List;

/**
 * @author Jay Lin
 *
 */
public interface ImmigrationsDao {
    public List<Immigrations> queryByPassengerIds(List<String> passengerIds);
}
