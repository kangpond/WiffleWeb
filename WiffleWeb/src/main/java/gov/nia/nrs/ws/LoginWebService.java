/**
 * 
 */
package gov.nia.nrs.ws;

import gov.nia.nrs.bean.UserProfile;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Yang
 *
 */
@Produces("application/json")
public interface LoginWebService {

    /**
     * @param userId
     * @param password
     * @return
     */
    @POST
    @Path("/auth")
    public UserProfile auth(@FormParam("userId") String userId, @FormParam("password") String password);


}
