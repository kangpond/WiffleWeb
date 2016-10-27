/**
 *
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.Applicant;

/**
 * @author Jay
 *
 */
public interface ApplicantDao {

    public Applicant getApplicantBy1stRecvNo(String firstReceiveNo);

}
