package gov.nia.nrs.dao;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.UserApply;

import java.util.Map;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

public interface UserApplyDao extends GenericDAO<UserApply, String>{

	Map<String, Object> getUserApplyList(UserProfile userProfile,
			String userId, String aKinds, Integer pageIndex);

}
