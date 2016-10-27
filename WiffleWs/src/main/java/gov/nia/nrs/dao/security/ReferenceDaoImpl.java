package gov.nia.nrs.dao.security;

import gov.nia.nrs.domain.security.ReferenceItemNew;
import gov.nia.nrs.domain.security.ReferencePersonMainNew;
import gov.nia.nrs.utils.StringUtil;
import gov.nia.nrs.utils.VariantsUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("referenceDao")
public class ReferenceDaoImpl extends BaseSecDaoImpl<ReferencePersonMainNew, String> implements ReferenceDao {

    private static final Logger log = LoggerFactory.getLogger(ReferenceDaoImpl.class);

    @Resource VariantsUtils variantsUtils;

    
    @SuppressWarnings("unchecked")
	@Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ReferenceItemNew> getMissingReport(String firstReceiveNo,
			String residentIdNo, String englishName, String chineseName,
			String birthDate) throws Exception{
    	List<String> _list = getReferencePersonIds(firstReceiveNo,null,null,null,null);
    	if(_list.size() == 0){
    		_list = getReferencePersonIds(null,residentIdNo,null,null,null);
    	}
    	
    	List<ReferenceItemNew> items = null;
    	if(_list.size() > 0){
        	StringBuffer hql2 = new StringBuffer("from ReferenceItemNew where referencePersonId in (:referencePersonId) ");
        	hql2.append(" and and kind in (:kind) and (deleteFlag !='Y' or deleteFlag is null) ");
        	Query itemQuery = getSession().createQuery(hql2.toString());
        	itemQuery.setParameterList("referencePersonId", _list);
        	itemQuery.setParameterList("kind", Arrays.asList(new String[]{"666","136"}));
        	items = itemQuery.list();
        }
        return items;
    }
    
    private List<String> getReferencePersonIds (String firstReceiveNo,
			String residentIdNo, String englishName, String chineseName,
			String birthDate) throws Exception{
    	
		Map<String,Object> cons = new HashMap<String, Object>();
		
    	StringBuffer hql = new StringBuffer("select referencePersonId from ReferencePersonMainNew ");
    	if(StringUtils.isNotEmpty(firstReceiveNo)){
    		hql.append(" and firstReceiveNo = :firstReceiveNo ");
    		cons.put("firstReceiveNo", firstReceiveNo);
    	} 
    	if(StringUtils.isNotEmpty(residentIdNo)){
    		hql.append(" and residentIdNo = :residentIdNo ");
    		cons.put("residentIdNo", residentIdNo);
    	}
    	if(StringUtils.isNotEmpty(birthDate)){
    		if(StringUtils.isNotEmpty(chineseName)){
    			hql.append(" and  chineseName in (:chineseName) ");
    			cons.put("chineseName", variantsUtils.getVariantsNames(chineseName));
    		}else if(StringUtils.isNotEmpty(englishName)){
    			hql.append("and (englishName =:englishName ");
    			hql.append(" or sortEnglishName =:sortEnglishName) ");
    			cons.put("englishName", englishName);
    			cons.put("sortEnglishName", StringUtil.sortEnglishWords(englishName));
    		}
    		hql.append(" and birthDate =:birthDate ");
    		cons.put("birthDate", birthDate);
    	}
    	
    	String _hql = hql.toString();
        if (_hql.contains("and")) {
            _hql = _hql.replaceFirst("and", "where");
        }
        
        Query query = getSession().createQuery(_hql);
        for (String key : cons.keySet()) {
            if (cons.get(key) instanceof Collection) {
            	query.setParameterList(key, (Collection) cons.get(key));
            } else
            	query.setParameter(key, cons.get(key));
        }
    	
        return query.list();
    }
    
    
}
