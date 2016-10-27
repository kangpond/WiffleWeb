package gov.nia.nrs.dao;

import gov.nia.nrs.bean.UserProfile;

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
@Repository("isuranceDao")
@Transactional
public class IsuranceDaoImpl extends BaseDaoImpl<Object, String> implements IsuranceDao {

    private static final Logger logger = LoggerFactory.getLogger(IsuranceDaoImpl.class);

    @Override
    public Map<String, Object> getIsuranceInfo(UserProfile userProfile,
			String firstReceiveNo, String residentIdNo, String isuranceType, Integer offset){
    	
    	Map<String, Object> returnMap = new HashMap<String, Object>();

    	/**
    	 *  先計算用firstReceiveNo是否有資料
    	 *  如果沒有再取 residentIdNo的資料
     	 */
    	int count =	getTotalCount(firstReceiveNo, null, isuranceType);
    	if(count > 0){
    		returnMap.put("totalCount", count);
    		returnMap.put("isuranceList", getIsuranceDataList(firstReceiveNo, null, isuranceType, offset));
    	}else{
    		returnMap.put("totalCount", getTotalCount(null, residentIdNo, isuranceType));
    		returnMap.put("isuranceList", getIsuranceDataList(null, residentIdNo, isuranceType, offset));
    	}
		
		return returnMap;
	}
	
	
	private String getSql(Map<String,Object> condition, String firstReceiveNo, String residentIdNo,String isuranceType){
		StringBuffer hql = new StringBuffer(" from ");
		if(StringUtils.equals("1", isuranceType)){
			hql.append(" FsForeignLaborIsurance ");
		}else if(StringUtils.equals("2", isuranceType)){
			hql.append(" FsForeignHealthIsurance ");
		}
		
		if(StringUtils.isNotEmpty(firstReceiveNo)){
			hql.append(" and firstReceiveNo = :firstReceiveNo ");
			condition.put("firstReceiveNo", firstReceiveNo);
		}
		if(StringUtils.isNotEmpty(residentIdNo)){
			if(StringUtils.equals("1", isuranceType)){
				hql.append(" and id.residentIdNo = :residentIdNo ");
				condition.put("residentIdNo", residentIdNo);	
			}else if(StringUtils.equals("2", isuranceType)){
				hql.append(" and (id.residentIdNo = :residentIdNo ");
				hql.append(" or id.residentIdNo1 = :residentIdNo1) ");
				condition.put("residentIdNo", residentIdNo);
				condition.put("residentIdNo1", residentIdNo);
			}
		}
		
		String _hql = hql.toString();
        if (_hql.contains("and")) {
          _hql = _hql.replaceFirst("and", "where");
        }
        return _hql;
	}
	
	private int getTotalCount(String firstReceiveNo, String residentIdNo,String isuranceType){
		Map<String,Object> condition = new HashMap<String, Object>();
		
		String sql = getSql(condition,firstReceiveNo, residentIdNo, isuranceType);
		StringBuffer countHql = new StringBuffer(sql);
		countHql.insert(0, "select count(firstReceiveNo) ");
		 
		Query count = getSession().createQuery(countHql.toString());
        for (String key : condition.keySet()) {
            if (condition.get(key) instanceof Collection) {
                count.setParameterList(key, (Collection) condition.get(key));
            } else
                count.setParameter(key, condition.get(key));
        }
        
        List<Long> _clist = count.list();
        int totalCount = 0;
        if (_clist != null && _clist.size() > 0) {
            totalCount = Integer.parseInt(String.valueOf(_clist.get(0)));
        }
        
		return totalCount;
	}
	
	private List<? extends Object> getIsuranceDataList(String firstReceiveNo, String residentIdNo,String isuranceType, Integer offset){
		int max = 10;
		
		Map<String,Object> condition = new HashMap<String, Object>();
		String hql = getSql(condition, firstReceiveNo, residentIdNo, isuranceType);
		
		StringBuffer caseHql = new StringBuffer(hql);
		if(StringUtils.equals("1", isuranceType)){
			caseHql.append(" order by id.effectiveDate desc ");
		}else if(StringUtils.equals("2", isuranceType)){
			caseHql.append(" order by createTime desc ");
		}
        
        Query q = getSession().createQuery(caseHql.toString());
        for (String key : condition.keySet()) {
            if (condition.get(key) instanceof Collection) {
                q.setParameterList(key, (Collection) condition.get(key));
            } else
                q.setParameter(key, condition.get(key));
        }
        q.setMaxResults(max);
        q.setFirstResult(offset * max);
		return q.list();
	}
	
}
