/**
 *
 */
package gov.nia.nrs.dao.imm;

import gov.nia.nrs.domain.imm.Permit;

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
@Repository("permitDao")
public class PermitDaoImpl extends BaseIMMDaoImpl<Permit, String> implements PermitDao {

    private static final Logger logger = LoggerFactory.getLogger(PermitDaoImpl.class);

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.dao.imm.PermitDao#queryByFirstReceiveNo(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Permit> queryByFirstReceiveNo(String firstReceiveNo) {
        return getSession().createQuery("from Permit where firstRecvNo = :firstRecvNo and (deleteFlag IS NULL OR deleteFlag != 'Y')")
                .setParameter("firstRecvNo", firstReceiveNo).list();
    }

}
