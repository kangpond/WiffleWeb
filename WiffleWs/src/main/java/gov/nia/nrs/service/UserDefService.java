package gov.nia.nrs.service;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.UserDef;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserDefService {

	UserProfile authenUser(String userId, String password);

	UserDef getUserDefById(String userId);

	Map<String, Object> getUserDefList(UserProfile userProfile, String userId,
			String deptId, Integer pageIndex);

	Map<String, Object> getUserDefInfo(String userId) throws JsonProcessingException;

	boolean deleteUserDef(String userId, UserProfile userProfile);

	boolean saveUserDef(UserProfile userProfile, UserDef userDef, String functionIds);

	void saveUserDef(UserDef userDef);
	
}
