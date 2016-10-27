package gov.nia.nrs.dao;

import gov.nia.nrs.domain.UserFunction;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository("userFunctionDao")
public class UserFunctionDaoImpl extends BaseDaoImpl<UserFunction, String> implements UserFunctionDao {

    private final static Log log = LogFactory.getLog(UserFunctionDaoImpl.class);


	@SuppressWarnings("unchecked")
	@Override
	public List<String> getUserFunctionList(String userId) {
		return getSession().createQuery("select id.functionId from UserFunction where id.userId =:userId order by createDate, createTime ")
						   .setParameter("userId", userId).list();
	}

	@Override
	public void deleteUserFunctions(String userId){
	    Query query = getSession().createQuery("delete from UserFunction where id.userId =:userId ")
				.setParameter("userId", userId);
        int i =query.executeUpdate();
	}
}
