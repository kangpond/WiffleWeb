package gov.nia.nrs.dataquery.action;

import gov.nia.nrs.domain.FsForeignHealthCare;
import gov.nia.nrs.domain.iis.HouseholdMarriage;
import gov.nia.nrs.domain.iis.SefCertify;

import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

@Namespace("/otherQuery")
public class OtherQueryAction extends DataQueryAction {

	private static final long serialVersionUID = 1L;

	
	private HouseholdMarriage householdMarriage;
	private FsForeignHealthCare fsForeignHealthCare;
	private SefCertify sefCertify; 
	private Map<String,Object> resultMap;
	
	public HouseholdMarriage getHouseholdMarriage() {
		return householdMarriage;
	}

	public void setHouseholdMarriage(HouseholdMarriage householdMarriage) {
		this.householdMarriage = householdMarriage;
	}
	
	public FsForeignHealthCare getFsForeignHealthCare() {
		return fsForeignHealthCare;
	}

	public void setFsForeignHealthCare(FsForeignHealthCare fsForeignHealthCare) {
		this.fsForeignHealthCare = fsForeignHealthCare;
	}
	
	public Map<String,Object> getResultMap() {
		return resultMap;
	}

	public void setResultMap(Map<String,Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	public SefCertify getSefCertify() {
		return sefCertify;
	}

	public void setSefCertify(SefCertify sefCertify) {
		this.sefCertify = sefCertify;
	}
	
	//-------------------外僑口卡 ------------------------//
	@Action(value = "foriegnInfo", results = {
			@Result(name = "success", location = "query.foriegn", type = "tiles")})
	public String foriegnInfo(){
		resultMap = dataQueryWebService.getForiegnInfo(getUserProfile(),firstReceiveNo);
		return SUCCESS;
	}
	
	//-------------------行方不明記錄 ------------------------//
	@Action(value = "missingReport", results = {
			@Result(name = "success", location = "query.missing", type = "tiles")})
	public String missingReport(){
		String englishName = getRequest().getParameter("englishName");
		String chineseName = getRequest().getParameter("chineseName");
		String birthDate = getRequest().getParameter("birthDate");
		
		try {
			displayList = (List<? extends Object>) dataQueryWebService.getMissingReport(firstReceiveNo,residentIdNo,englishName,chineseName,birthDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	
	//-------------------婚姻狀況 ------------------------//
    @Action(value = "marriage", results = {
    			@Result(name = "success", location = "query.marriage", type = "tiles")})
	public String marriage(){
		displayList = (List<? extends Object>) dataQueryWebService.getMarriageCondition(getUserProfile(),firstReceiveNo);
		return SUCCESS;
	}
    
    @Action(value = "marrageInfo", results = {
			@Result(name = "success", location = "query.marriage.info", type = "tiles")})
    public String marrageInfo(){
    	householdMarriage = dataQueryWebService.getMarriageInfo(getUserProfile(),getRequest().getParameter("personId"),getRequest().getParameter("marrageDate"));
    	return SUCCESS;
    }

    //-------------------勞保 ------------------------//
    @Action(value = "laborIsurance", results = {
			@Result(name = "success", location = "query.labor", type = "tiles")})
    public String laborIsurance(){
    	Map<String,Object> laborMap = dataQueryWebService.getIsuranceInfo(getUserProfile(),firstReceiveNo,residentIdNo,"1",getPageIndex());
    	displayList = (List<? extends Object>) laborMap.get("isuranceList");
    	totalSize = (int) laborMap.get("totalCount");
    	return SUCCESS;
    }
    
    //-------------------健保 ------------------------//
    @Action(value = "healthIsurance", results = {
			@Result(name = "success", location = "query.health", type = "tiles")})
    public String healthIsurance(){
    	Map<String,Object> healthMap = dataQueryWebService.getIsuranceInfo(getUserProfile(),firstReceiveNo,residentIdNo,"2",getPageIndex());
    	displayList = (List<? extends Object>) healthMap.get("isuranceList");
    	totalSize = (int) healthMap.get("totalCount");
    	return SUCCESS;
    }
    
    //-------------------配偶健康管理 ------------------------//
    @Action(value = "healthCare", results = {
			@Result(name = "success", location = "query.care", type = "tiles")})
    public String healthCare(){
    	displayList = dataQueryWebService.getHealCareInfo(getUserProfile(),firstReceiveNo,residentIdNo);
    	return SUCCESS;
    }
    
    //-------------------子女健康管理 ------------------------//
    @Action(value = "childCare", results = {
			@Result(name = "success", location = "query.child.care", type = "tiles")})
    public String childCare(){
    	List<Map<String, Object>> fList =  dataQueryWebService.getChildHealCareInfo(getUserProfile(),firstReceiveNo,residentIdNo);
    	if(fList.size() > 0){
    		resultMap = fList.get(0);
    	}
    	return SUCCESS;
    }
    
    //-------------------家庭經濟狀況------------------------//
    @Action(value = "allowanceInfo", results = {
			@Result(name = "success", location = "query.income", type = "tiles")})
    public String allowanceInfo(){
    	resultMap = dataQueryWebService.getAllowanceInfo(getUserProfile(),firstReceiveNo,residentIdNo);
    	return SUCCESS;
    }
    
    //-------------------海基會認證資料------------------------//
    @Action(value = "sefCertify", results = {
			@Result(name = "success", location = "query.sef", type = "tiles")})
    public String sefCertify(){
    	displayList = dataQueryWebService.getSefCertifyList(getUserProfile(),firstReceiveNo,residentIdNo);
    	return SUCCESS;
    }
    
    @Action(value = "getSefCertifyInfo", results = {
			@Result(name = "success", location = "query.sef.info", type = "tiles")})
    public String getSefCertifyInfo(){
    	sefCertify = dataQueryWebService.getSefCertifyInfo(getUserProfile(),getRequest().getParameter("documentNo"));
    	return SUCCESS;
    }
    
	//-------------------汽機車駕照 ------------------------//
    @Action(value = "driverLicence", results = {
			@Result(name = "success", location = "query.licence", type = "tiles")})
    public String driverLicence(){
    	displayList = dataQueryWebService.getDriverLicence(getUserProfile(),firstReceiveNo);
    	return SUCCESS;
    }


}
