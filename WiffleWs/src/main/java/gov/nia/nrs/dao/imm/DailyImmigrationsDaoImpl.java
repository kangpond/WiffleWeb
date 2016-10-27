/**
 *
 */
package gov.nia.nrs.dao.imm;

import gov.nia.nrs.domain.imm.DailyImmigrations;
import gov.nia.nrs.domain.imm.DailyImmigrationsId;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jay Lin
 *
 */
@Repository("dailyImmigrationsDao")
public class DailyImmigrationsDaoImpl extends BaseIMMDaoImpl<DailyImmigrations, DailyImmigrationsId> implements DailyImmigrationsDao {

    private static final Logger logger = LoggerFactory.getLogger(DailyImmigrationsDaoImpl.class);

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.dao.imm.DailyImmigrationsDao#queryByPassengerIds(java.util.List)
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<DailyImmigrations> queryByPassengerIds(List<String> passengerIds) {
        if (passengerIds == null || passengerIds.size() < 1) {
            return new ArrayList<DailyImmigrations>();
        }
        return getSession()
                .createQuery(
                        "from DailyImmigrations where passengerId in (:passengerIds) and (deleteFlag IS NULL OR deleteFlag NOT IN ('Y', 'y')) order by id.immigrateDate desc, inspectTime desc")
                .setParameterList("passengerIds", passengerIds).list();
    }

}
