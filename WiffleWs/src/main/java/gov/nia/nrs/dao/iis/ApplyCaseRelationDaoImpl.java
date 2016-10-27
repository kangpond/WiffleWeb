package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.ApplyCaseRelation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * @author Yang
 *
 */
@Repository("applyCaseRelationDao")
@Transactional
public class ApplyCaseRelationDaoImpl extends BaseIISDaoImpl<ApplyCaseRelation, String> implements ApplyCaseRelationDao {

    private static final Logger logger = LoggerFactory.getLogger(ApplyCaseRelationDaoImpl.class);


    @Override
    public ApplyCaseRelation getApplyCaseRelation(String receiveNo){
    	return find(receiveNo);
    }
    
}
