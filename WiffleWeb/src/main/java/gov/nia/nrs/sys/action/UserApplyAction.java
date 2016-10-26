package gov.nia.nrs.sys.action;

import gov.nia.nrs.action.BaseAction;
import gov.nia.nrs.domain.City;
import gov.nia.nrs.domain.Functions;
import gov.nia.nrs.domain.UserApply;
import gov.nia.nrs.utils.BeanClone;
import gov.nia.nrs.utils.StringUtil;
import gov.nia.nrs.ws.UserApplyWebService;
import gov.nia.nrs.ws.UserDefWebService;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.validation.SkipValidation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.opensymphony.xwork2.ModelDriven;

public class UserApplyAction extends BaseAction implements ModelDriven<UserApply>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource UserApplyWebService userApplyWebService;
	@Resource UserDefWebService userDefWebService;
	
	protected UserApply userApply;
	private List<String> userFunctions; 
	private List<Functions> functions;
	
	//勾選的City
	private List<String> selectedCitys;
	//被勾選的所有City清單 
	private List<City> citys;
	
	private String functionTree;
	
	/**
	 * @return the userApply
	 */
	public UserApply getUserApply() {
		return userApply;
	}

	/**
	 * @param userApply the userApply to set
	 */
	public void setUserApply(UserApply userApply) {
		this.userApply = userApply;
	}
	
	public List<String> getUserFunctions() {
		return userFunctions;
	}

	public void setUserFunctions(List<String> userFunctions) {
		this.userFunctions = userFunctions;
	}

	public List<Functions> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Functions> functions) {
		this.functions = functions;
	}
	
	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
	
	/**
	 * @return the selectedCitys
	 */
	public List<String> getSelectedCitys() {
		return selectedCitys;
	}

	/**
	 * @param selectedCitys the selectedCitys to set
	 */
	public void setSelectedCitys(List<String> selectedCitys) {
		this.selectedCitys = selectedCitys;
	}
	
	public String getFunctionTree() {
		return functionTree;
	}

	public void setFunctionTree(String functionTree) {
		this.functionTree = functionTree;
	}
	
	@Override
	public UserApply getModel() {
		if(userApply == null)
			userApply = new	UserApply();
		return userApply;
	}

	
	@Action(value = "/userApplyList",results={
			@Result(name = "success", location = "userApply.list",type="tiles")
			})
	@SkipValidation
	public String userApplyList(){
		String[] applyKinds = getRequest().getParameterValues("applyKind");
		
		Map<String,Object> applyMap =  userApplyWebService.getUserApplyList(getUserProfile(), userApply.getUserId(),StringUtils.join(applyKinds, ","),getPageIndex());
		displayList = (List<? extends Object>) applyMap.get("userApplyList");
		totalSize = applyMap.get("totalCount") != null ? (int) applyMap.get("totalCount"):0;
		return SUCCESS;
	}
	
	
	@Action(value = "/applyCaseInfo",results={
			@Result(name = "success", location = "userApply.info",type="tiles")
			})
	@SkipValidation
	public String applyCaseInfo(){
		prepare(userApply.getUuid());
		return SUCCESS;
	}
	
	@Action(value = "/examApply",results={
			@Result(name = "success", location = "userApplyList",type="redirectAction"),
			@Result(name = "input", location = "userApply.info",type="tiles")
	})
	@SkipValidation
	public String examApply(){
		String functionIds = getRequest().getParameter("functionIds");
		
		String[] citys = getRequest().getParameterValues("cityCode");
		userApply.setReportCity(StringUtils.join(citys, ","));
		
        List<Attachment> attachments = new ArrayList<Attachment>();
        attachments.add(new Attachment("userProfile", "application/json", getUserProfile()));
        attachments.add(new Attachment("userApply", "application/json", userApply));
        attachments.add(new Attachment("functionIds", "application/json", functionIds));

        String direction = INPUT;
        
		boolean result = userApplyWebService.updateUserApply(attachments);
		if(result) 
			direction = SUCCESS;
		else{
			prepare(userApply.getUuid());
//			setUserFunctions(Arrays.asList(functionIds));
			setSelectedCitys(Arrays.asList(citys));
		}
		return direction;
	}
	
	
	@Action(value = "/authorityAlter",results={
			@Result(name = "success", location = "userApply.alter",type="tiles")
	})
	public String authorityAlter(){
		prepare2(getUserProfile().getUserId());
		return SUCCESS;
	}
	
	
	@Action(value = "/saveAuthority",results={
			@Result(name = "success", location = "authorityAlter",type="redirectAction",params={"message","${message}"}),
			@Result(name = "input", location = "userApply.alter",type="tiles")
	})
	public String saveAuthority(){
		String functionIds = getRequest().getParameter("functionIds");
		
		String[] citys = getRequest().getParameterValues("cityCode");
		userApply.setReportCity(StringUtils.join(citys, ","));
		
		List<Attachment> attachments = new ArrayList<Attachment>();
        attachments.add(new Attachment("userApply", "application/json", userApply));
        attachments.add(new Attachment("functionIds", "application/json", functionIds));
        attachments.add(new Attachment("userProfile", "application/json", getUserProfile()));

		String direction = INPUT;
		String uuid = userApplyWebService.saveUserApply(attachments);
        if(!StringUtil.isEmptyOrBlank(uuid)){
			direction = SUCCESS;
			message = "資料更新完成";
		}else{
			prepare(getUserProfile().getUuid());
//			setUserFunctions(Arrays.asList(functionIds));
			setSelectedCitys(Arrays.asList(citys));
		}
		return direction;
	}
	
	protected void prepare(String uuid) {
		try {
			Map<String,Object> applyMap = userApplyWebService.getApplyCaseInfo(uuid);
//			setUserFunctions((List<String>) applyMap.get("userFunction"));
			if(applyMap.get("userApply") != null)
				BeanClone.cloneSkipBlank(applyMap.get("userApply"), userApply);
//			setFunctions((List<Functions>) applyMap.get("functions"));
			functionTree = (String) applyMap.get("functionTree");
			setCitys((List<City>) applyMap.get("citys"));
			
			if(StringUtils.isNotEmpty(userApply.getReportCity())){
				String[] citys = userApply.getReportCity().split(",");
				setSelectedCitys(Arrays.asList(citys));
			}
		} catch (IllegalArgumentException | IllegalAccessException
				| InvocationTargetException | JsonProcessingException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void prepare2(String userId) {
		try {
			Map<String,Object> userMap = userDefWebService.getUserDefInfo(userId);
//			userFunctions = (List<String>) userMap.get("userFunction");
//			functions = (List<Functions>) userMap.get("functions");
			functionTree = (String) userMap.get("functionTree");
			BeanClone.cloneSkipBlank(userMap.get("userDef"), userApply);
			setCitys((List<City>) userMap.get("citys"));
			
			if(StringUtils.isNotEmpty(userApply.getReportCity())){
				String[] citys = userApply.getReportCity().split(",");
				setSelectedCitys(Arrays.asList(citys));
			}
		} catch (IllegalArgumentException | IllegalAccessException
				| InvocationTargetException | JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
