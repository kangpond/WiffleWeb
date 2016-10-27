/**
 *
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.InterviewRecords;

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
@Repository("interviewRecordsDao")
public class InterviewRecordsDaoImpl extends BaseIISDaoImpl<InterviewRecords, Long> implements InterviewRecordsDao {

    private static final Logger logger = LoggerFactory.getLogger(InterviewRecordsDaoImpl.class);

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.dao.iis.InterviewRecordsDao#queryByFirstReceiveNo(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<InterviewRecords> queryByFirstReceiveNo(String firstReceiveNo) {
        return getSession()
                .createQuery(
                        "from InterviewRecords where firstReceiveNo = :firstReceiveNo and (deleteFlag IS NULL OR deleteFlag NOT IN ('Y', 'y')) order by startF2fTalkDate desc, startF2fTalkTime desc ")
                .setParameter("firstReceiveNo", firstReceiveNo).list();
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public InterviewRecords queryByKey(Long seq) {
        return find(seq);
    }

}
