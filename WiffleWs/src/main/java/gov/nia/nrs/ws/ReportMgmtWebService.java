package gov.nia.nrs.ws;

import java.util.List;
import java.util.Map;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.ReportMgmt;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

@Produces("application/json")
@Consumes("application/json")
public interface ReportMgmtWebService {

	
	
	@GET
	@Path("/getQueryConditions")
	ReportMgmt getQueryConditions(@QueryParam("reportId") String reportId, UserProfile userProfile);

	@POST
	@Path("/getReportMgmtList")
    @Consumes("multipart/mixed")
	Map<String, Object> getReportMgmtList(List<Attachment> attachments);

}
