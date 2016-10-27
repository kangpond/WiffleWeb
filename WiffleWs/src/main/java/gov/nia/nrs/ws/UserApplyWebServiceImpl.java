package gov.nia.nrs.ws;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.UserApply;
import gov.nia.nrs.service.UserApplyService;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import com.fasterxml.jackson.core.JsonProcessingException;

public class UserApplyWebServiceImpl implements UserApplyWebService {

	
	@Resource UserApplyService userApplyService;
	
	
	@Override
	public Map<String, Object> getUserApplyList(UserProfile userProfile,
			String userId, String aKinds, Integer pageIndex) {
		return userApplyService.getUserApplyList(userProfile, userId,  aKinds,  pageIndex) ;
	}


	@Override
	public Map<String, Object> getApplyCaseInfo(String uuid) throws JsonProcessingException {
		return userApplyService.getApplyCaseInfo(uuid);
	}


	@Override
	public boolean updateUserApply(List<Attachment> attachments) {
		UserProfile userProfile = attachments.get(0).getObject(UserProfile.class);
		UserApply userApply = attachments.get(1).getObject(UserApply.class);
		String functionIds = attachments.get(2).getObject(String.class);
		
		return userApplyService.updateUserApply(userProfile,userApply,functionIds);
	}


	@Override
	public String saveUserApply(List<Attachment> attachments) {
		UserApply userApply = attachments.get(0).getObject(UserApply.class);
		String functionIds = attachments.get(1).getObject(String.class);
		UserProfile userProfile = attachments.get(2).getObject(UserProfile.class);
		return userApplyService.saveUserApply(userProfile,userApply,functionIds);
	}

}
