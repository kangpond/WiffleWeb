/**
 * 
 */
package gov.nia.nrs.sys.action;

import gov.nia.nrs.action.BaseAction;
import gov.nia.nrs.domain.City;
import gov.nia.nrs.domain.Functions;
import gov.nia.nrs.domain.UserDef;
import gov.nia.nrs.utils.BeanClone;
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

/**
 * @author Yang
 *
 */
public class UserDefAction extends BaseAction implements ModelDriven<UserDef>{
	
	private static final long serialVersionUID = 1L;

	@Resource UserDefWebService userDefWebService;

	private UserDef userDef;
	//勾選的Function
	private List<String> userFunctions; 
	private List<Functions> functions;
	private List<City> citys;
	//勾選的City
	private List<String> selectedCitys;
	
	private String functionTree;
	
	
	/**
	 * @return the functions
	 */
	public List<Functions> getFunctions() {
		return functions;
	}

	/**
	 * @param functions the functions to set
	 */
	public void setFunctions(List<Functions> functions) {
		this.functions = functions;
	}

	/**
	 * @return the userFunctions
	 */
	public List<String> getUserFunctions() {
		return userFunctions;
	}

	/**
	 * @param userFunctions the userFunctions to set
	 */
	public void setUserFunctions(List<String> userFunctions) {
		this.userFunctions = userFunctions;
	}

	/**
	 * @return the userDef
	 */
	public UserDef getUserDef() {
		return userDef;
	}

	/**
	 * @param userDef the userDef to set
	 */
	public void setUserDef(UserDef userDef) {
		this.userDef = userDef;
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
	public UserDef getModel() {
		if(userDef == null)
			userDef = new UserDef();
		return userDef;
	}
	
	@Action(value = "/userDefList",results={
			@Result(name = "success", location = "user.list",type="tiles")
			})
	@SkipValidation
	public String userDefList(){
		Map<String, Object> userMap = userDefWebService.getUserDefList(getUserProfile(),userDef.getUserId(),userDef.getDeptId(),getPageIndex());
		displayList =(List<? extends Object>) userMap.get("userDefList");
		totalSize = (int) userMap.get("totalCount");
		return SUCCESS;
	}
	
	@Action(value = "/userInfo",results={
			@Result(name = "success", location = "user.info",type="tiles")
			})
	@SkipValidation
	public String userInfo() {
		prepare(userDef.getUserId());
		return SUCCESS;
	}
	
	
	@Action(value = "/usereEditInfo",results={
			@Result(name = "success", location = "user.edit",type="tiles")
			})
	@SkipValidation
	public String usereEditInfo(){
		prepare(userDef.getUserId());
		return SUCCESS;
	}
	
	@Action(value = "/updateUserDef",results={
			@Result(name = "input", location = "user.edit",type="tiles"),
			@Result(name = "success", location = "userDefList",type="redirectAction")
			})
	public String updateUserDef(){
		String direction = INPUT;
		String functionIds = getRequest().getParameter("functionIds");
		
		String[] citys = getRequest().getParameterValues("cityCode");
		userDef.setReportCity(StringUtils.join(citys, ","));
		
        List<Attachment> attachments = new ArrayList<Attachment>();
        attachments.add(new Attachment("userProfile", "application/json", getUserProfile()));
        attachments.add(new Attachment("userDef", "application/json", userDef));
		if(userDefWebService.saveUserDef(attachments,functionIds))
			direction = SUCCESS;
		else{
			prepare(userDef.getUserId());
//			setUserFunctions(Arrays.asList(functionIds));
			setSelectedCitys(Arrays.asList(citys));
		}
		return direction;
	}
	
	@Action(value = "/userDeleteInfo",results={
			@Result(name = "success", location = "user.delete",type="tiles")
	})
	@SkipValidation
	public String userDeleteInfo(){
		prepare(userDef.getUserId());
		return SUCCESS;
	}
	
	
	@Action(value = "/deleteUser",results={
			@Result(name = "success", location = "userDefList",type="redirectAction")
	})
	@SkipValidation
	public String deleteUser(){
		userDefWebService.deleteUserDef(userDef.getUserId(),getUserProfile());
		return SUCCESS;
	}
	
	
	@Action(value = "/singleUserInfo",results={
			@Result(name = "success", location = "user.selfie",type="tiles")
	})
	@SkipValidation
	public String singleUserInfo(){
		prepare(getUserProfile().getUserId());
		return SUCCESS;
	}
	
	@Action(value = "/updateUserInfo",results={
			@Result(name = "success", location = "singleUserInfo",type="redirectAction",params={"message","${message}"}),
			@Result(name = "input", location = "user.selfie",type="tiles")
	})
	@SkipValidation
	public String updateUserInfo(){
		String direction = INPUT;
		
		List<Attachment> attachments = new ArrayList<Attachment>();
        attachments.add(new Attachment("userProfile", "application/json", getUserProfile()));
        attachments.add(new Attachment("userDef", "application/json", userDef));
        
		if(userDefWebService.saveUserDef(attachments,StringUtils.EMPTY)){
			direction = SUCCESS;
			message = "資料更新完成";
		}else{
			prepare(getUserProfile().getUserId());
		}
		return direction;
	}

	
	private void prepare(String userId) {
		try {
			Map<String,Object> userMap = userDefWebService.getUserDefInfo(userId);
			functionTree = (String) userMap.get("functionTree");
			BeanClone.cloneSkipBlank(userMap.get("userDef"), userDef);
			setCitys((List<City>) userMap.get("citys"));
			if(StringUtils.isNotEmpty(userDef.getReportCity())){
				String[] citys = userDef.getReportCity().split(",");
				setSelectedCitys(Arrays.asList(citys));
			}
		} catch (IllegalArgumentException | IllegalAccessException
				| InvocationTargetException | JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
