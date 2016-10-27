package gov.nia.nrs.dao;

import java.util.List;

import gov.nia.nrs.domain.UserFunction;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

public interface UserFunctionDao extends GenericDAO<UserFunction, String>{

	List<String> getUserFunctionList(String userId);

	void deleteUserFunctions(String userId);

}
