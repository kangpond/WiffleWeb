package gov.nia.nrs.service;

import java.util.ArrayList;
import java.util.List;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.Functions;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Resource UserDefService userDefService;
	@Resource FunctionService functionService;
	

	/**
	 * 前台帳密驗證
	 */
	@Override
	public UserProfile login(String userId,String snNum) {
		//正式機設定
		UserProfile userProfile = userDefService.authenUser(userId, snNum);
	    if (StringUtils.isEmpty(userProfile.getErrMsg())) {
	       List<Functions> fList = functionService.getUserFunction(userProfile.getUserId());
	       if(fList.size() > 0){
	    	   List<Functions> _fList = new ArrayList<Functions>();
	    	   List<Functions> _fList1 = new ArrayList<Functions>();
	    	   for(Functions f: fList){
	    		   if(StringUtils.equals(f.getVisible(), "1")){
	    			   _fList1.add(f);
	    		   }else{
		    		   _fList.add(f);
		    	   }
	    	   }
	    	   userProfile.setFunctions(_fList);
	    	   //取動態查尋列表
		       userProfile.setOtherFunctions(_fList1);
	       }
	    }
		
	    return userProfile;
	}

}
