package gov.nia.nrs.service;

import gov.nia.nrs.bean.UserProfile;

public interface LoginService {
	
	/**
	 * 前台帳號登入
	 * @param userId
	 * @param password
	 * @return
	 */
	public UserProfile login(String userId,String password);
	
}
