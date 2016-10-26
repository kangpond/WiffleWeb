/**
 *
 */
package gov.nia.nrs.ws;

import gov.nia.nrs.utils.codeutils.CategoryMapVo;
import gov.nia.nrs.utils.codeutils.DataSettingDo;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 * @author Jay Lin
 *
 */
@Produces("application/json")
@Consumes("application/json")
public interface CommonWebService {

    @GET
    @Path("/getCodeCategoryList")
    public CategoryMapVo getCodeCategoryMapping();

    @GET
    @Path("/getCodeIdOfCodeSetting")
    public String getCodeIdOfCodeSetting(@QueryParam("category") String category);

    @GET
    @Path("/getDataSettingList")
    public List<DataSettingDo> getDataSettingList(@QueryParam("codeId") String codeId);
}
