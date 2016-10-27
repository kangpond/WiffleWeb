package gov.nia.nrs.service;

import gov.nia.nrs.domain.UserApplyFunction;

import java.util.List;

public interface UserApplyFunctionService {

	List<String> getApplyFunctionList(String uuid);

	void deleteUserApplyFunctions(String uuid);

	public boolean saveUserApplyFunctions(UserApplyFunction uaf);
}
