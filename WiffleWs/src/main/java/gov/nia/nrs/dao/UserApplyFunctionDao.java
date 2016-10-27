package gov.nia.nrs.dao;

import gov.nia.nrs.domain.UserApplyFunction;

import java.util.List;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

public interface UserApplyFunctionDao extends GenericDAO<UserApplyFunction, String>{

	List<String> getApplyFunctionList(String uuid);

	void deleteUserApplyFunctions(String uuid);

	void saveUserApplyFunctions(UserApplyFunction uaf);

	
}
