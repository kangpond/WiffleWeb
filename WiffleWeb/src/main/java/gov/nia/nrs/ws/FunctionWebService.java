package gov.nia.nrs.ws;

import gov.nia.nrs.domain.Functions;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Produces("application/json")
@Consumes("application/json")
public interface FunctionWebService {

	@POST
    @Path("/list")
	public List<Functions> getFunctionList(Functions function);
	
	@GET
	@Path("/upperFunctionList")
	public List<Functions> getUpperFunctionList();

	@GET
	@Path("/function")
	public Functions getFunction(@QueryParam("functionId") String functionId);

	@PUT
    @Path("/saveFunction/{userId}")
	public boolean saveFunction(Functions function, @PathParam("userId") String userId);

	@DELETE
    @Path("/deleteFunction/{functionId}")
	public void deleteFunction(@PathParam("functionId") String functionId);

}
