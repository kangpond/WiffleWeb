package gov.nia.nrs.multiquery.ws;

import gov.nia.nrs.multiquery.bean.ChartData;
import gov.nia.nrs.multiquery.bean.CityChartData;
import gov.nia.nrs.multiquery.bean.DataSettingBean;
import gov.nia.nrs.multiquery.bean.MultiQueryForm;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * 多維度查詢 Web Service
 * @author Tim
 */
@Path("/multiquery")
@Produces("application/json")
@Consumes("application/json")
public interface MultiQueryWebService
{
	@GET
	@Path("/queryDataSetting")
	public List<DataSettingBean> queryDataSetting(@QueryParam("codeId") String codeId) throws Exception;

	@GET
	@Path("/queryDataSettingByList")
	public List<DataSettingBean> queryDataSettingByList(@QueryParam("codeIdList") List<String> codeIdList) throws Exception;

	@GET
	@Path("/queryTownDs")
	public List<DataSettingBean> queryTownDs(@QueryParam("cityCodeValue") String cityCodeValue) throws Exception;

	@POST
	@Path("/dlReport")
	public String dlReport(MultiQueryForm multiQueryForm) throws Exception;

	@POST
	@Path("/queryChartData")
	public ChartData queryChartData(MultiQueryForm multiQueryForm) throws Exception;

	@POST
	@Path("/queryCityChartData")
	public CityChartData queryCityChartData(MultiQueryForm multiQueryForm) throws Exception;

}
