/**
 *
 */
package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.ApplyCase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jay Lin
 *
 */
@Repository("applyCaseDao")
public class ApplyCaseDaoImpl extends BaseIISDaoImpl<ApplyCase, String> implements ApplyCaseDao {

    private static final Logger logger = LoggerFactory.getLogger(ApplyCaseDaoImpl.class);

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.dao.iis.ApplyCaseDao#getApplyCaseByFirstReceiveNo(java.lang.String)
     */
    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ApplyCase> getApplyCaseByFirstReceiveNo(String firstReceiveNo) {
        return getSession()
                .createQuery("from ApplyCase where firstReceiveNo = :firstReceiveNo and (deleteFlag is null or deleteFlag != 'Y') order by applyDate desc")
                .setParameter("firstReceiveNo", firstReceiveNo).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ApplyCase> getApplyCaseFL(String firstReceiveNo) {
        return getSession()
                .createQuery("from ApplyCase where firstReceiveNo = :firstReceiveNo and applicantType in ('F','L') and decideMark = 1 and (deleteFlag is null or deleteFlag != 'Y') order by applyDate desc")
                .setParameter("firstReceiveNo", firstReceiveNo).list();
    }
    
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<Map<String,String>> getPassportInfoList(String firstReceiveNo,String residentIdNo) {
    	List<ApplyCase>	aList = getApplyCaseFL(firstReceiveNo);
    	List<Map<String,String>> infoList = new ArrayList<Map<String,String>>();
    	if(aList.size() > 0){
    		for(ApplyCase a :aList){
    			Map<String,String> aMap = new HashMap<String, String>();
    			aMap.put("foreignPassportNo", a.getForeignPassportNo());
    			aMap.put("issueExpireDate", a.getIssueExpireDate());
    			aMap.put("residentIdNo", residentIdNo);
    			aMap.put("rcStartDate", a.getRcStartDate());
    			aMap.put("rcEndDate", a.getRcEndDate());
    			infoList.add(aMap);
    		}
    	}
    	return infoList;
    }
}
