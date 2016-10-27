package gov.nia.nrs.service;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.UserApply;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface UserApplyService {

	Map<String, Object> getUserApplyList(UserProfile userProfile,
			String userId, String aKinds, Integer pageIndex);

	Map<String, Object> getApplyCaseInfo(String userId) throws JsonProcessingException;

	boolean updateUserApply(UserProfile userProfile, UserApply userApply,
			String functionIds);

	String saveUserApply(UserProfile userProfile, UserApply userApply,
			String functionIds);

}
