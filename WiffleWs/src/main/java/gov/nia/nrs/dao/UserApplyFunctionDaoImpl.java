package gov.nia.nrs.dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import gov.nia.nrs.domain.UserApplyFunction;

@Repository("userApplyFunctionDao")
public class UserApplyFunctionDaoImpl extends BaseDaoImpl<UserApplyFunction, String> implements UserApplyFunctionDao {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<String> getApplyFunctionList(String uuid){
		return getSession().createQuery("select id.functionId from UserApplyFunction where id.uuid =:uuid order by createDate ,createTime ")
				   .setParameter("uuid", uuid).list();
	}
	
	
	
	@Override
	public void deleteUserApplyFunctions(String uuid) {
		Query query = getSession().createQuery("delete from UserApplyFunction where id.uuid =:uuid ")
				.setParameter("uuid", uuid);		
		int i =query.executeUpdate();
	}
	
	@Override
	public void saveUserApplyFunctions(UserApplyFunction uaf){
		getSession().save(uaf);
	}
}
