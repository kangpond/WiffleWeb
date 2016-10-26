package gov.nia.nrs.ws;

import gov.nia.nrs.bean.UserProfile;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Produces("application/json")
@Consumes("application/json")
public interface ReportWebService {

	@POST
	@Path("/exportSummaryByDay")
	String exportSummaryByDay(UserProfile userProfile,@QueryParam("startDate") String startDate, 
			@QueryParam("endDate") String endDate, @QueryParam("userId") String userId) throws Exception;

	@GET
	@Path("/downloadApplyFrom")
	public String downloadApplyFrom(@QueryParam("uuid") String uuid) throws Exception;

}
