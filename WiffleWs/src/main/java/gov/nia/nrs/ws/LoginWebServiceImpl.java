/**
 * 
 */
package gov.nia.nrs.ws;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.service.LoginService;

import javax.annotation.Resource;

/**
 * @author Yang
 *
 */
public class LoginWebServiceImpl implements LoginWebService {

    @Resource
    LoginService loginService;


    @Override
    public UserProfile auth(String userId, String password) {
        return loginService.login(userId, password);
    }

}
