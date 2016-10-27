/**
 * 
 */
package gov.nia.nrs.dao;

import gov.nia.nrs.bean.AuditQueryBean;
import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.AuditSummaryByFunctionId;
import gov.nia.nrs.domain.AuditSummaryByFunctionIdId;
import gov.nia.nrs.domain.iis.Dept;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * @author Yang
 *
 */
@Repository("auditSummaryDao")
public class AuditSummaryDaoImpl extends BaseDaoImpl<AuditSummaryByFunctionId, 
													AuditSummaryByFunctionIdId>implements AuditSummaryDao {

    private static final Logger log = Logger.getLogger(AuditSummaryDaoImpl.class);

	@Override
	public List<Map<String, ?>> searchSummaryByDay(UserProfile up, String startDate, 
																String endDate, String userId) {
		
		Map<String,Object> condition = new HashMap<String,Object>();
		
		StringBuffer hql = new StringBuffer();
		hql.append(" select id.type,functionName,userName,id.userId,sum (cast(cnt as int))as Cnt ");
		hql.append(" from AuditSummaryByFunctionId ");
		
		if(StringUtils.isNotBlank(startDate) && 
				StringUtils.isNotBlank(endDate)){
			hql.append(" and id.auditDate between :startDate and :endDate ");
			condition.put("startDate", startDate);
			condition.put("endDate", endDate);
		}
		
		
		if(StringUtils.isNotBlank(userId)){
			hql.append(" and id.userId =:userId ");
			condition.put("userId", userId);
		}
		hql.append(" group by id.type,functionName,userName,id.userId ");
		hql.append(" order by id.type,id.userId ");
		
		String _hql = hql.toString();
		if(_hql.contains("and")) {
			_hql = _hql.replaceFirst("and", "where");
		}
		
		Query q= getSession().createQuery(_hql);
		for(String key : condition.keySet()){
			if(condition.get(key) instanceof Collection){
				q.setParameterList(key, (Collection) condition.get(key));
			}else
				q.setParameter(key, condition.get(key));
		}
		
		List<Object[]> _list = q.list();
		List<Map<String,?>> summary = new ArrayList<Map<String,?>>();
		for(Object[] o : _list){
		    Map<String,Object> countMap= new HashMap<String,Object>();
	    	countMap.put("type", (String) o[0]);
	 	    countMap.put("functionName", (String) o[1]);
	 	    countMap.put("userName", (String) o[2]);
	 	    countMap.put("cnt", new BigDecimal(o[4].toString()));
		 	summary.add(countMap);
		}
		return summary;
	}

}
