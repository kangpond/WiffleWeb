package gov.nia.nrs.ws;

import gov.nia.nrs.domain.Government;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Produces("application/json")
@Consumes("application/json")
public interface GovernmentWebService {

	@GET
	@Path("/getGovDesc")
	public String getGovDesc(@QueryParam("deptId") String deptId);

	
	@GET
	@Path("/getGovernmentMap")
	public Map<String, Government> getGovernmentMap();
}
