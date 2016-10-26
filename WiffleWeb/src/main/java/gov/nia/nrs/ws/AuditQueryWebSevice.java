package gov.nia.nrs.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

@Produces("application/json")
@Consumes("application/json")
public interface AuditQueryWebSevice {

	@POST
	@Path("/searchAuditQuery")
    @Consumes("multipart/mixed")
	void searchAuditQuery(List<Attachment> attachments);
}
