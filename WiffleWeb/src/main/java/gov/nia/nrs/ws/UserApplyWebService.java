package gov.nia.nrs.ws;

import gov.nia.nrs.bean.UserProfile;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

import com.fasterxml.jackson.core.JsonProcessingException;

@Produces("application/json")
@Consumes("application/json")
public interface UserApplyWebService {

	
	@GET
	@Path("/getUserApplyList")
	Map<String, Object> getUserApplyList(UserProfile userProfile,@QueryParam("userId") String userId,
					 @QueryParam("aKinds") String aKinds, @QueryParam("pageIndex") Integer pageIndex);

	@GET
	@Path("/getApplyCaseInfo")
	Map<String, Object> getApplyCaseInfo(@QueryParam("uuid") String uuid) throws JsonProcessingException;

	@POST
	@Path("/updateUserApply")
    @Consumes("multipart/mixed")
	boolean updateUserApply(List<Attachment> attachments);

	@POST
	@Path("/saveUserApply")
    @Consumes("multipart/mixed")
	String saveUserApply(List<Attachment> attachments);

}
