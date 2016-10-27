package gov.nia.nrs.ws;


import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.UserDef;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import com.fasterxml.jackson.core.JsonProcessingException;

@Produces("application/json")
@Consumes("application/json")
public interface UserDefWebService {

	@GET
	@Path("/getUserDefList")
	Map<String, Object> getUserDefList(UserProfile userProfile,@QueryParam("userId") String userId,
			@QueryParam("deptId") String deptId, @QueryParam("pageIndex") Integer pageIndex);
	
	@GET
	@Path("/getUserDefInfo/{userId}")
	Map<String, Object> getUserDefInfo(@PathParam("userId") String userId) throws JsonProcessingException;
	
	@PUT
	@Path("/deleteUserDef/{userId}")
	public boolean deleteUserDef(@PathParam("userId") String userId, UserProfile userProfile);
	
	@POST
	@Path("/saveUserDef")
    @Consumes("multipart/mixed")
	public boolean saveUserDef(List<Attachment> attachments, @QueryParam("functionIds") String functionIds);

}
