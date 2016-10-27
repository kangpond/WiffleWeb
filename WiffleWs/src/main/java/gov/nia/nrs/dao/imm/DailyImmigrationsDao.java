/**
 *
 */
package gov.nia.nrs.dao.imm;

import gov.nia.nrs.domain.imm.DailyImmigrations;

import java.util.List;

/**
 * @author Jay Lin
 *
 */
public interface DailyImmigrationsDao {
    public List<DailyImmigrations> queryByPassengerIds(List<String> passengerIds);
}
