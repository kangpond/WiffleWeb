/**
 * 
 */
package gov.nia.nrs.dao;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.UserDef;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * @author B00A0017
 *
 */
@Repository("userDefDao")
public class UserDefDaoImpl extends BaseDaoImpl<UserDef, String> implements UserDefDao {


	@Override
	public Map<String, Object> getUserDefList(UserProfile userProfile, String userId,
													 String deptId, Integer pageIndex) {
	  if (pageIndex == null) pageIndex = 0;
      int max = 10;
      Map<String, Object> userMap = new HashMap<String, Object>();
      Map<String, Object> condition = new HashMap<String, Object>();
      StringBuffer sb = new StringBuffer();
      sb.append("from UserDef  ");
      if (StringUtils.isNotBlank(deptId)) {
	        sb.append(" and deptId = :deptId ");
	        condition.put("deptId", deptId);
	  }
	
	  if (StringUtils.isNotBlank(userId)) {
	        sb.append(" and userId = :userId");
	        condition.put("userId", userId);
	  }
	  sb.append(" and deleteFlag != 'Y'");
	  
	  String _hql = sb.toString();
	  if (_hql.contains("and")) {
	        _hql = _hql.replaceFirst("and", "where");
	  }else
		  return userMap;
	  
	  StringBuffer countHql = new StringBuffer(_hql);
      countHql.insert(0, "select count(userId) ");
      Query count = getSession().createQuery(countHql.toString());
      for (String key : condition.keySet()) {
          count.setParameter(key, condition.get(key));
      }
      
      int totalCount = 0;
      List<Long> _clist = count.list();
      if (_clist != null && _clist.size() > 0) {
          totalCount = _clist.get(0).intValue();
      }

      _hql += " order by deptId";
      Query query = getSession().createQuery(_hql);
      query.setMaxResults(max);
      query.setFirstResult(pageIndex * max);

      for (String key : condition.keySet()) {
          query.setParameter(key, condition.get(key));
      }
      List<UserDef> uList = query.list();
      
      userMap.put("totalCount", totalCount);
      userMap.put("userDefList", uList);
      
      return userMap;
	}

    @Override
    public UserDef findById(String userId) {
        return (UserDef) getSession().get(UserDef.class, userId);
    }

    
    @SuppressWarnings("unchecked")
    @Override
    public UserDef findByPersonIdAndSN(String userId, String snNum){
    	StringBuffer hql = new StringBuffer();
        Map<String, String> condition = new HashMap<String, String>();

    	hql.append("from UserDef where userId =:userId ")
    		.append("and deleteFlag = 'N' ");
    	condition.put("userId", userId);
    	
    	if(StringUtils.isNotEmpty(snNum)){
    		hql.append("and certificateSn =:certificateSn ");
    		condition.put("certificateSn", snNum);
    	}
    	
    	Query q  = getSession().createQuery(hql.toString());
		for (String key : condition.keySet()) {
            q.setParameter(key, condition.get(key));
        }
		
		List<UserDef> _List = q.list();
		if(_List != null && _List.size() > 0)
			return _List.get(0);
		else
			return null;
    }
    
}
