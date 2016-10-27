/**
 *
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.Applicant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jay Lin
 *
 */
@Repository("applicantDao")
public class ApplicantDaoImpl extends BaseIISDaoImpl<Applicant, String> implements ApplicantDao {

    private static final Logger logger = LoggerFactory.getLogger(ApplicantDaoImpl.class);

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.dao.iis.ApplicantDao#getApplicantBy1stRecvNo(java.lang.String)
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public Applicant getApplicantBy1stRecvNo(String firstReceiveNo) {
        return find(firstReceiveNo);
    }

}
