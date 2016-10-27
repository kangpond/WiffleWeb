/**
 * 
 */
package gov.nia.nrs.dao;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.UserDef;

import java.util.Map;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

/**
 * @author Yang
 *
 */
public interface UserDefDao extends  GenericDAO<UserDef, String>{

//    public Map<String, Object> getUserDefList(UserProfile up, UserDef userDef, Integer offset, boolean needPager);

//    public void saveUserDef(UserDef ud);

//    public void updateUserDef(UserDef ud);

    public UserDef findById(String userId);

	public UserDef findByPersonIdAndSN(String userId, String snNum);

	public Map<String, Object> getUserDefList(UserProfile userProfile,
			String userId, String deptId, Integer pageIndex);
	
}
