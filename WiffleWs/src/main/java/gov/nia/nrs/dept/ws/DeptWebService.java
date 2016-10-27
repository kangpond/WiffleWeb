package gov.nia.nrs.dept.ws;

import gov.nia.nrs.dept.bean.DeptData;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * 機關 Web Service
 * @author Tim
 */
@Path("/dept")
@Produces("application/json")
@Consumes("application/json")
public interface DeptWebService
{
	@GET
	@Path("/queryList100")
	public List<DeptData> queryList100() throws Exception;

	@GET
	@Path("/queryById")
	public DeptData queryById(@QueryParam("deptId") String deptId) throws Exception;

	@GET
	@Path("/queryByName")
	public List<DeptData> queryByName(@QueryParam("deptName") String deptName) throws Exception;

	@GET
	@Path("/delete")
	public void delete(@QueryParam("deptId") String deptId) throws Exception;

	@POST
	@Path("/update")
	public void update(DeptData deptData) throws Exception;
}
