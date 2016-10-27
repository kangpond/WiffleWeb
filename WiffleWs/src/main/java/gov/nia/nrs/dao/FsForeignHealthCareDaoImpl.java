/**
 * 
 */
package gov.nia.nrs.dao;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.FsForeignHealthCare;
import gov.nia.nrs.domain.FsForeignHealthCareId;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yang
 *
 */

@Repository("foreignHealthCareDao")
@Transactional
public class FsForeignHealthCareDaoImpl extends BaseDaoImpl<FsForeignHealthCare, FsForeignHealthCareId> implements FsForeignHealthCareDao {

    private static final Logger logger = LoggerFactory.getLogger(FsForeignHealthCareDaoImpl.class);

    @Override
    public List<FsForeignHealthCare> getHealCareInfo(UserProfile userProfile,String firstReceiveNo, String residentIdNo){
    	List<FsForeignHealthCare> fhcList = getHealthCare(firstReceiveNo, null);
    	if(fhcList == null || fhcList.size() == 0){
    		fhcList = getHealthCare(null, residentIdNo);
    	}
    	return fhcList;
    }
    
    private List<FsForeignHealthCare> getHealthCare(String firstReceiveNo, String residentIdNo){
    	StringBuffer hql = new StringBuffer(" from FsForeignHealthCare ");
    	Map<String, Object> condition = new HashMap<String, Object>();

    	if(StringUtils.isNotEmpty(firstReceiveNo)){
    		hql.append(" and id.firstReceiveNo =:firstReceiveNo ");
    		condition.put("firstReceiveNo", firstReceiveNo);
    	}
    	
    	if(StringUtils.isNotEmpty(residentIdNo)){
    		hql.append(" and (id.residentIdNo =:residentIdNo ");
    		hql.append(" or  residentIdNo1 =:residentIdNo1) ");
    		condition.put("residentIdNo", residentIdNo);
    		condition.put("residentIdNo1", residentIdNo);
    	}
    	
    	hql.append(" order by profileCreateDate desc ");
    	
    	String _hql = hql.toString();
        if (_hql.contains("and")) {
          _hql = _hql.replaceFirst("and", "where");
        }
        
    	Query query = getSession().createQuery(_hql);
    	for (String key : condition.keySet()) {
            if (condition.get(key) instanceof Collection) {
            	query.setParameterList(key, (Collection) condition.get(key));
            } else
            	query.setParameter(key, condition.get(key));
        }
    	
    	List<FsForeignHealthCare> q = query.list();
    	return q;
    }
    
    
}
