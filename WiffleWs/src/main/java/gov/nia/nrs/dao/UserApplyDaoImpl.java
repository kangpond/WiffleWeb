/**
 * 
 */
package gov.nia.nrs.dao;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.UserApply;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Yang
 *
 */
@Repository("userApplyDao")
public class UserApplyDaoImpl extends BaseDaoImpl<UserApply, String> implements UserApplyDao {

	/* (non-Javadoc)
	 * @see gov.nia.nrs.dao.UserApplyDao#getUserApplyList(gov.nia.nrs.bean.UserProfile, java.lang.String, java.lang.String, java.lang.Integer)
	 */
	@Override
	public Map<String, Object> getUserApplyList(UserProfile userProfile,String userId, 
					String aKinds, Integer pageIndex) {
		int max = 10;
        Map<String, Object> condition = new HashMap<String, Object>();
        Map<String, Object> applyMap = new HashMap<String, Object>();

        StringBuffer hql = new StringBuffer(" from UserApply where caseStatus = '0' ");

        if(StringUtils.isNotEmpty(userId)){
        	hql.append("and userId =:userId");
        	condition.put("userId", userId);
        }
        if(StringUtils.isNotEmpty(aKinds)){
        	hql.append("and applyKind in (:applyKind)");
        	condition.put("applyKind", Arrays.asList(aKinds));
        }
        
        String _hql = hql.toString();
//        if (_hql.contains("and")) {
//            _hql = _hql.replaceFirst("and", "where");
//        }else{
//        	return applyMap;
//        }
        
        
        String statement = "select count(uuid) ";
        StringBuffer countHql = new StringBuffer(_hql);
        countHql.insert(0, statement);
        
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
            totalCount = safeLongToInt(_clist.get(0));
        }
        applyMap.put("totalCount", totalCount);
        
        
        StringBuffer caseHql = new StringBuffer(_hql);
        caseHql.append(" order by applyDate , applyTime ");
        
        Query q = getSession().createQuery(caseHql.toString());
        for (String key : condition.keySet()) {
            if (condition.get(key) instanceof Collection) {
                q.setParameterList(key, (Collection) condition.get(key));
            } else
                q.setParameter(key, condition.get(key));
        }
        q.setMaxResults(max);
        q.setFirstResult(pageIndex * max);
        List<UserApply> aList = q.list();
        
        applyMap.put("userApplyList", aList);
		return applyMap;
	}

	public static int safeLongToInt(long l){
    	if( l < Integer.MIN_VALUE ||  l > Integer.MAX_VALUE){
    		throw new IllegalArgumentException(l + "cannot be cast to int without changing its value. ");
    	}
    	return Integer.parseInt(String.valueOf(l));
    }
}
