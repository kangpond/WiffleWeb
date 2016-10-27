/**
 * 
 */
package gov.nia.nrs.ws;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.UserDef;
import gov.nia.nrs.service.UserDefService;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * @author A0017
 *
 */
public class UserDefWebServiceImpl implements UserDefWebService {

	
	@Resource UserDefService userDefService;
	
	@Override
	public Map<String, Object> getUserDefList(UserProfile userProfile,
			String userId, String deptId, Integer pageIndex) {
		return userDefService.getUserDefList(userProfile,userId,deptId,pageIndex) ;
	}

	@Override
	public Map<String, Object> getUserDefInfo(String userId) throws JsonProcessingException {
		return userDefService.getUserDefInfo(userId);
	}

	@Override
	public boolean deleteUserDef(String userId, UserProfile userProfile) {
		// TODO Auto-generated method stub
		return userDefService.deleteUserDef(userId, userProfile);
	}

	@Override
	public boolean saveUserDef(List<Attachment> attachments, String functionIds) {
		UserProfile userProfile = attachments.get(0).getObject(UserProfile.class);
		UserDef userDef = attachments.get(1).getObject(UserDef.class);
		return userDefService.saveUserDef(userProfile, userDef,functionIds);
	}

	
	

}
