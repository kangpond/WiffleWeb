/**
 *
 */
package gov.nia.nrs.dao.imm;

import gov.nia.nrs.domain.imm.Immigrations;
import gov.nia.nrs.domain.imm.ImmigrationsId;

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
@Repository("immigrationsDao")
public class ImmigrationsDaoImpl extends BaseIMMDaoImpl<Immigrations, ImmigrationsId> implements ImmigrationsDao {

    private static final Logger logger = LoggerFactory.getLogger(ImmigrationsDaoImpl.class);

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.dao.imm.ImmigrationsDao#queryByPassengerIds(java.util.List)
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Immigrations> queryByPassengerIds(List<String> passengerIds) {
        if (passengerIds == null || passengerIds.size() < 1) {
            return new ArrayList<Immigrations>();
        }
        return getSession()
                .createQuery(
                        "from Immigrations where id.passengerId in (:passengerIds) and (deleteFlag IS NULL OR deleteFlag NOT IN ('Y', 'y')) order by id.immigrateDate desc,immigrateTime desc")
                .setParameterList("passengerIds", passengerIds).list();
    }

}
