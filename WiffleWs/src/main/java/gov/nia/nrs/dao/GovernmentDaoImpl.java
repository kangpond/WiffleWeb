/**
 *
 */
package gov.nia.nrs.dao;

import gov.nia.nrs.domain.Government;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yang
 *
 */
@Repository("governmentDao")
public class GovernmentDaoImpl extends BaseDaoImpl<Government, String> implements GovernmentDao {

    private static final Logger log = Logger.getLogger(GovernmentDaoImpl.class);

    @Override
	public Government getGov(String deptId){
		return super.find(deptId);
	}

	@Override
    @Cacheable(value = "govMap")
    public String getGovDesc(String deptId){
    	Map<String, String> map = new HashMap<String, String>();
    	String govDesc = map.get(deptId);
		if(StringUtils.isNotEmpty(govDesc)){
			log.debug("We found cached govDesc in map : "+govDesc);
			return govDesc;
		}else{
			Government gov = getGov(deptId);
			if(gov != null){
				map.put(gov.getDeptId(), gov.getDeptName());
				log.debug("No cached! Need to get new Gov from DB: "+gov.getDeptName());
				return gov.getDeptName();
			}
		}
		return deptId;
    }
	
	@Override
	public List<Government> getGovList(){
		return getSession().createQuery(" from Government order by deptId asc ").list();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Government> queryGovLikeName(String deptName)
	{
		log.debug("queryGovLikeName, deptName=" + deptName);

		StringBuffer sql = new StringBuffer();
		sql.append("select * from Government");
		sql.append(" where DeptName like :deptName");
		sql.append(" and DeleteFlag <> 'Y'");
		Query query = getSession().createSQLQuery(sql.toString()).addEntity(Government.class);
		query.setParameter("deptName", "%" + deptName + "%");

		@SuppressWarnings("unchecked")
		List<Government> list = query.list();
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Government> queryList100()
	{
		log.debug("queryList100");
		StringBuffer sql = new StringBuffer();
		sql.append("select top 100 * from Government");
		sql.append(" where DeleteFlag <> 'Y'");
		Query query = getSession().createSQLQuery(sql.toString()).addEntity(Government.class);
//		query.setParameter("startDate", now);

		@SuppressWarnings("unchecked")
		List<Government> list = query.list();
		return list;
	}

	@Override
	@Transactional
	public int deleteById(String deptId)
	{
		log.debug("deleteById, deptId=" + deptId);

		StringBuffer sql = new StringBuffer();
		sql.append("update Government");
		sql.append(" set DeleteFlag='Y'");
		sql.append(" where DeptId=:deptId");
		Query query = getSession().createSQLQuery(sql.toString()).addEntity(Government.class);
		query.setParameter("deptId", deptId);
		return query.executeUpdate();
	}

	@Override
	@Transactional
	public void update(Government government)
	{
		log.debug("update, government=" + ReflectionToStringBuilder.toString(government));
		getSession().merge(government);
	}
}
