/**
 *
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.InterviewRecords;

import java.util.List;

/**
 * @author Jay Lin
 *
 */
public interface InterviewRecordsDao {

    public List<InterviewRecords> queryByFirstReceiveNo(String firstReceiveNo);

    public InterviewRecords queryByKey(Long seq);
}
