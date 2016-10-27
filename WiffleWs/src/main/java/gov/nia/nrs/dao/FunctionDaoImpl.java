package gov.nia.nrs.dao;

import gov.nia.nrs.domain.Functions;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.ExampleOptions;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.ISearch;
import com.googlecode.genericdao.search.SearchResult;

@Repository("functionDao")
public class FunctionDaoImpl extends BaseDaoImpl<Functions, String> implements FunctionDao {

    @SuppressWarnings("unchecked")
    @Override
    public List<Functions> getUserFunction(String userId) {
        StringBuffer hql = new StringBuffer("select distinct f.* ");
        hql.append(" from  UserFunction uf ");
        hql.append(" join Functions f on uf.FunctionId = f.FunctionId ");
        hql.append(" where uf.UserId = :userId and f.State = :state ");
//        if(StringUtils.isNotEmpty(visible))
//        	hql.append(" and f.Visible = :visible ");
//        else
//        	hql.append(" and f.Visible is null or f.Visible = '' ");
        
        hql.append(" group by f.FunctionId,f.FunctionName,f.FunctionDesc,f.Sequence, ");
        hql.append(" f.UpperFunctionId,f.ActionType,f.State,f.ClassName,f.IsLeaf,f.Visible,f.FunctionType, ");
        hql.append(" f.MainUserId,f.MaintainFunctionId,f.MaintainHost,f.LastUpdateTime,f.LinkURL, ");
        hql.append(" f.DeleteFlag,f.CreateDate,f.CreateTime,f.CreateUserId ");
        hql.append(" order by f.Sequence asc ");

        SQLQuery query = getSession().createSQLQuery(hql.toString());
        query.addEntity(Functions.class);
        query.setParameter("userId", userId);
        query.setParameter("state", "1"); // 目前條件先帶 state
//        if(StringUtils.isNotEmpty(visible))
//        	query.setParameter("visible", visible);
        	
        List<Functions> fList = query.list();
        return fList;
    }
  
    /**
     * Get RootFunction
     * 0 --> Root
     * 2 --> 動態查詢
     */
    @Override
    public List<Functions> getUpperFunctionList() {
        return getSession().createQuery(" from Functions where isLeaf in ('0','2') ").list();
    }
    
    public List<Functions> getFunctionList(Functions function){
    	StringBuffer sb = new StringBuffer();
        Map<String, String> cons = new HashMap<String, String>();
        sb.append(" from Functions  ");
        if (StringUtils.isNotEmpty(function.getState())) {
            sb.append(" and state =:state ");
            cons.put("state", function.getState());
        }
        if (StringUtils.isNotEmpty(function.getIsLeaf())) {
            sb.append(" and isLeaf =:isLeaf ");
            cons.put("isLeaf", function.getIsLeaf());
        }

        if (StringUtils.isNotEmpty(function.getUpperFunctionId())) {
            sb.append(" and upperFunctionId =:parentId");
            cons.put("parentId", function.getUpperFunctionId());
        }

        if (StringUtils.isNotEmpty(function.getFunctionId())) {
            sb.append(" and functionId =:functionId");
            cons.put("functionId", function.getFunctionId());
        }
        sb.append(" order by sequence ");

        String _hql = sb.toString();
        if (_hql.contains("and")) {
            _hql = _hql.replaceFirst("and", "where");
        }

        Query query = getSession().createQuery(_hql);
        for (String key : cons.keySet()) {
            query.setParameter(key, cons.get(key));
        }
        return query.list();
    }
    
    @Override
    public Long getMaxSequence() {
        List fcList = getSession().createQuery("select max(sequence) from Functions ").list();
        long sequence = 0;
        if (fcList.size() > 0 && fcList.get(0) != null) {
            sequence = (Long) fcList.get(0);
        }
        return sequence + 1;
    }
    
    @Override
	public Set<String> getUpperFunctionSet(List<String> subFunId){
    	 Set<String> set= new HashSet<String>();
    	 List<String> _f = getUpperFunctionId(subFunId);
    	 if(_f != null && _f .size() > 0){
    		 set.addAll(_f);
        	 set.addAll(getUpperFunctionSet(_f));
    	 }
    	 return set;
	}

    private  List<String> getUpperFunctionId(List<String> subFunId){
    	if(subFunId.size() > 0){
    		return getSession().createQuery("select upperFunctionId from Functions where isLeaf in ('1','2') and functionId in (:functionIds) ")
			 		.setParameterList("functionIds", subFunId).list();
    	}
    	return null;
    }
}
