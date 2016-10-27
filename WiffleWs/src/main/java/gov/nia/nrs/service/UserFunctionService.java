package gov.nia.nrs.service;

import gov.nia.nrs.domain.UserFunction;

import java.util.List;

public interface UserFunctionService {

	List<String> getUserFunctionList(String userId);

	void deleteUserFunctions(String userId);

	boolean saveUserFunctions(UserFunction uf);

}
