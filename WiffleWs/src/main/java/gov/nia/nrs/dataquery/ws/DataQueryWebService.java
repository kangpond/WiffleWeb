/**
 *
 */
package gov.nia.nrs.dataquery.ws;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.dataquery.bean.ApplyCaseListResp;
import gov.nia.nrs.dataquery.bean.DataDetailResp;
import gov.nia.nrs.dataquery.bean.DataListResp;
import gov.nia.nrs.dataquery.bean.DataQueryReq;
import gov.nia.nrs.dataquery.bean.ImmiListResp;
import gov.nia.nrs.dataquery.bean.InterviewDetailResp;
import gov.nia.nrs.dataquery.bean.InterviewListResp;
import gov.nia.nrs.dataquery.bean.PassportVo;
import gov.nia.nrs.domain.FsDriverLicence;
import gov.nia.nrs.domain.FsForeignHealthCare;
import gov.nia.nrs.domain.iis.HouseholdMarriage;
import gov.nia.nrs.domain.iis.SefCertify;
import gov.nia.nrs.domain.security.ReferenceItemNew;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.cxf.jaxrs.ext.multipart.Multipart;

/**
 * @author Jay Lin
 *
 */
@Path("/dataQuery")
@Produces("application/json")
@Consumes("application/json")
public interface DataQueryWebService {

    @POST
    @Path("/queryForList")
    public List<DataListResp> queryForList(DataQueryReq req) throws Exception;

    @GET
    @Path("/queryForDetail")
    public DataDetailResp queryForDetail(@QueryParam("param1") String firstReceiveNo, @QueryParam("param2") String residentIdNo) throws Exception;

    @GET
    @Path("/queryApplyCaseList")
    public List<ApplyCaseListResp> queryApplyCaseList(@QueryParam("param") String firstReceiveNo) throws Exception;

    @POST
    @Path("/queryPassportList")
    public List<PassportVo> queryPassportList(DataDetailResp resp) throws Exception;

    @POST
    @Path("/queryImmiList")
    @Consumes("multipart/mixed")
    public List<ImmiListResp> queryImmiList(@Multipart(value = "detailResp", type = "application/json") DataDetailResp resp, @Multipart(
            value = "passportVoList", type = "application/json") PassportVo[] passportVoList) throws Exception;

    @GET
    @Path("/queryInterviewList")
    public List<InterviewListResp> queryInterviewList(@QueryParam("param") String firstReceiveNo) throws Exception;

    @GET
    @Path("/queryInterview")
    public InterviewDetailResp queryInterview(@QueryParam("param") String seq) throws Exception;
    
    @POST
    @Path("/getMarriageCondition")
    public List<Map<String, String>> getMarriageCondition(UserProfile userProfile,@QueryParam("firstReceiveNo") String firstReceiveNo);
    
    @POST
    @Path("/getMarriageInfo")
	public HouseholdMarriage getMarriageInfo(UserProfile userProfile,
			@QueryParam("personId") String personId, @QueryParam("marrageDate") String marrageDate);
    
    @GET
    @Path("/getMissingReport")
	public List<ReferenceItemNew> getMissingReport(@QueryParam("firstReceiveNo") String firstReceiveNo,
			@QueryParam("residentIdNo") String residentIdNo, @QueryParam("englishName") String englishName, 
			@QueryParam("chineseName") String chineseName, @QueryParam("birthDate") String birthDate) throws Exception;
    
    @GET
    @Path("/getDriverLicence")
	public List<FsDriverLicence> getDriverLicence(UserProfile userProfile,@QueryParam("firstReceiveNo") String firstReceiveNo);
    
    
    @GET
    @Path("/getIsuranceInfo")
	public Map<String,Object> getIsuranceInfo(UserProfile userProfile,@QueryParam("firstReceiveNo") String firstReceiveNo,
			 @QueryParam("residentIdNo") String residentIdNo, @QueryParam("isuranceType") String isuranceType,@QueryParam("offset") Integer offset);
    
    @GET
    @Path("/getHealCareInfo")
	public List<FsForeignHealthCare> getHealCareInfo(UserProfile userProfile,
			@QueryParam("firstReceiveNo") String firstReceiveNo, @QueryParam("residentIdNo") String residentIdNo);
    
    @GET
    @Path("/getChildHealCareInfo")
	public List<Map<String,Object>> getChildHealCareInfo(UserProfile userProfile,
			@QueryParam("firstReceiveNo") String firstReceiveNo, @QueryParam("residentIdNo") String residentIdNo);
    
    @GET
    @Path("/getSefCertifyList")
	public List<SefCertify> getSefCertifyList(UserProfile userProfile,
			@QueryParam("firstReceiveNo") String firstReceiveNo, @QueryParam("residentIdNo") String residentIdNo);
    
    @GET
    @Path("/getSefCertifyInfo")
	public SefCertify getSefCertifyInfo(UserProfile userProfile, @QueryParam("documentNo") String documentNo);
    
    @GET
    @Path("/getAllowanceInfo")
	public Map<String, Object> getAllowanceInfo(UserProfile userProfile,
			@QueryParam("firstReceiveNo")  String firstReceiveNo, @QueryParam("residentIdNo") String residentIdNo);
    
    @GET
    @Path("/getForiegnInfo")
	public Map<String, Object> getForiegnInfo(UserProfile userProfile, @QueryParam("firstReceiveNo") String firstReceiveNo);
}
