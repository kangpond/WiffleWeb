package gov.nia.nrs.dao;

import gov.nia.nrs.bean.AuditQueryBean;
import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.Audit;
import gov.nia.nrs.utils.ActionType;
import gov.nia.nrs.utils.DateUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("auditQueryDao")
public class AuditQueryDaoImpl extends BaseDaoImpl<Audit, String> implements AuditQueryDao {

    private static final Logger log = Logger.getLogger(AuditQueryDaoImpl.class);

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=true)
	public List<? extends Object> search(AuditQueryBean queryBean,UserProfile up, Class objectClass,boolean needPager,int offset,int max) throws Exception {
		Criteria dc = getSession().createCriteria(objectClass);
		
		if(StringUtils.isNotBlank(queryBean.getStartDate()) && 
				StringUtils.isNotBlank(queryBean.getEndDate())){
			dc.add(Restrictions.between("auditTime", 
						DateUtils.getDateFromString(queryBean.getStartDate(),"0","0","0"), 
							DateUtils.getDateFromString(queryBean.getEndDate(),"23","59","59")));
		}
		
		//被查詢者條件查詢
		if(StringUtils.isNotBlank(queryBean.getPersonId())){
			dc.add(Restrictions.eq("personId",queryBean.getPersonId()));
		}
		if(StringUtils.isNotBlank(queryBean.getPassportNo())){
			dc.add(Restrictions.eq("passportNo",queryBean.getPassportNo()));
		}
		if(StringUtils.isNotBlank(queryBean.getPermitNo())){
			dc.add(Restrictions.eq("permitNo",queryBean.getPermitNo()));
		}
		if(StringUtils.isNotBlank(queryBean.getResidentIdNo())){
			dc.add(Restrictions.eq("residentIdNo",queryBean.getResidentIdNo()));
		}
		if(StringUtils.isNotBlank(queryBean.getFirstReceiveNo())){
			dc.add(Restrictions.eq("firstReceiveNo",queryBean.getFirstReceiveNo()));
		}
		if(StringUtils.isNotBlank(queryBean.getNation())){
			dc.add(Restrictions.eq("nation",queryBean.getNation()));
		}
		if(StringUtils.isNotBlank(queryBean.getChineseName())){
			dc.add(Restrictions.eq("chineseName",queryBean.getChineseName()));
		}
		if(StringUtils.isNotBlank(queryBean.getEnglishName())){
			dc.add(Restrictions.eq("englishName",queryBean.getEnglishName()));
		}
		if(StringUtils.isNotBlank(queryBean.getBirthDate())){
			dc.add(Restrictions.eq("birthDate",queryBean.getBirthDate()));
		}
		
		//操作者
		if(StringUtils.isNotBlank(queryBean.getUserId())){
			dc.add(Restrictions.eq("userId",queryBean.getUserId()));
		}
		if(StringUtils.isNotBlank(queryBean.getUserName())){
			dc.add(Restrictions.eq("userName",queryBean.getUserName()));
		}
		if(StringUtils.isNotBlank(queryBean.getDeptType())){
			dc.add(Restrictions.eq("deptType",queryBean.getDeptType()));
		}
		if(StringUtils.isNotBlank(queryBean.getDeptId())){
			dc.add(Restrictions.eq("deptId",queryBean.getDeptId()));
		}
		
		if(needPager){
			dc.setMaxResults(max);
			dc.setFirstResult(offset*max);
		}
		
		@SuppressWarnings("unchecked")
		List<? extends Object> list = dc.list();
		
		return list;
	}
	
	
    private List<String> getActionTypeList(AuditQueryBean queryBean){
    	List<String> actionTypeList = new ArrayList<String>();
		String[] actionTypes =	queryBean.getActionType().split(",");
		for(String actionType:actionTypes){
			//如果是查詢(4) 要包含 (6)
			if(StringUtils.equals(ActionType.Query.getType(), actionType.trim())){
				actionTypeList.add(ActionType.Print.getType());
			}
			actionTypeList.add(actionType.trim());
		}
		return actionTypeList;
    }
 
    @Override
    @Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=true)
    public int totalCount(AuditQueryBean queryBean,UserProfile up,String tableName){
    	Map<String,Object> condition = new HashMap<String,Object>();
    	
    	StringBuffer hql = new StringBuffer();
    	hql.append("select count(nosqlKey) from "+ tableName);
    	
    	if(StringUtils.isNotBlank(queryBean.getType())){
    		hql.append(" and type =:type");
    		condition.put("type", queryBean.getType());
		}
		
		if(StringUtils.isNotBlank(queryBean.getStartDate()) && 
							StringUtils.isNotBlank(queryBean.getEndDate())){
			hql.append(" and auditTime between :start and :end ");
			condition.put("start", DateUtils.getDateFromString(queryBean.getStartDate(),"0","0","0"));
			condition.put("end", DateUtils.getDateFromString(queryBean.getEndDate(),"23","59","59"));
		}
		
		if(StringUtils.isNotBlank(queryBean.getActionType())){
			hql.append(" and actionType in (:actionType) ");
    		condition.put("actionType", getActionTypeList(queryBean));
		}
		
		//被查詢者條件查詢
		if(StringUtils.isNotBlank(queryBean.getPersonId())){
			hql.append(" and personId = :personId ");
    		condition.put("personId", queryBean.getPersonId());
		}
		if(StringUtils.isNotBlank(queryBean.getPassportNo())){
			hql.append(" and passportNo = :passportNo ");
    		condition.put("passportNo", queryBean.getPassportNo());
		}
		if(StringUtils.isNotBlank(queryBean.getPermitNo())){
			hql.append(" and permitNo = :permitNo ");
    		condition.put("permitNo", queryBean.getPermitNo());
		}
		if(StringUtils.isNotBlank(queryBean.getResidentIdNo())){
			hql.append(" and residentIdNo = :residentIdNo ");
    		condition.put("residentIdNo", queryBean.getResidentIdNo());
		}
		if(StringUtils.isNotBlank(queryBean.getFirstReceiveNo())){
			hql.append(" and firstReceiveNo = :firstReceiveNo ");
    		condition.put("firstReceiveNo", queryBean.getFirstReceiveNo());
		}
		if(StringUtils.isNotBlank(queryBean.getNation())){
			hql.append(" and nation = :nation ");
    		condition.put("nation", queryBean.getNation());
		}
		if(StringUtils.isNotBlank(queryBean.getChineseName())){
			hql.append(" and chineseName = :chineseName ");
    		condition.put("chineseName", queryBean.getChineseName());
		}
		if(StringUtils.isNotBlank(queryBean.getEnglishName())){
			hql.append(" and englishName = :englishName ");
    		condition.put("englishName", queryBean.getEnglishName());
		}
		if(StringUtils.isNotBlank(queryBean.getBirthDate())){
			hql.append(" and birthDate = :birthDate ");
    		condition.put("birthDate", queryBean.getBirthDate());
		}
		
		//操作者
		if(StringUtils.isNotBlank(queryBean.getUserId())){
			hql.append(" and userId = :userId ");
    		condition.put("userId", queryBean.getUserId());
		}
		if(StringUtils.isNotBlank(queryBean.getUserName())){
			hql.append(" and userName = :userName ");
    		condition.put("userName", queryBean.getUserName());
		}
		if(StringUtils.isNotBlank(queryBean.getDeptType())){
			hql.append(" and deptType = :deptType ");
    		condition.put("deptType", queryBean.getDeptType());
		}
		if(StringUtils.isNotBlank(queryBean.getDeptId())){
			hql.append(" and deptId = :deptId ");
    		condition.put("deptId", queryBean.getDeptId());
		}
    	
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
		
		List<Long> _clist = q.list();
		int totalCount = 0;
        if (_clist != null && _clist.size() > 0) {
            totalCount = _clist.get(0).intValue();
        }
        return totalCount;
    }
}
