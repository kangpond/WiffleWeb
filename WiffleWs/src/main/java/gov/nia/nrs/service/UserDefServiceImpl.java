package gov.nia.nrs.service;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.dao.CityDao;
import gov.nia.nrs.dao.GovernmentDao;
import gov.nia.nrs.dao.UserDefDao;
import gov.nia.nrs.domain.Functions;
import gov.nia.nrs.domain.UserDef;
import gov.nia.nrs.domain.UserFunction;
import gov.nia.nrs.domain.UserFunctionId;
import gov.nia.nrs.eums.DeleteMark;
import gov.nia.nrs.utils.BeanClone;
import gov.nia.nrs.utils.ModifyFields;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service("userDefService")
@Transactional
public class UserDefServiceImpl implements UserDefService{
	
    private static final Logger log = Logger.getLogger(UserDefServiceImpl.class);

	@Resource UserDefDao userDefDao;
	@Resource GovernmentDao governmentDao;
	@Resource UserFunctionService userFunctionService;
	@Resource FunctionService functionService;
	@Resource CityDao cityDao;
	
	public UserProfile authenUser(String userId,String snNum){
		UserProfile up  =new UserProfile();
		try{
			log.debug("登入帳號 :"+userId+", 卡片序號:"+snNum);
			UserDef ud = null;
			if(StringUtils.isNotBlank(snNum))
				ud = userDefDao.findByPersonIdAndSN(userId,snNum);
			else
				ud = userDefDao.findById(userId);
			
			if(ud  != null && ud.getUserName() != null){
				BeanUtils.copyProperties(ud, up);
				up.setLastLoginDate(new Date());
				up.setErrMsg(StringUtils.EMPTY);
				up.setDeptName(governmentDao.getGovDesc(up.getDeptId()));
			}else{
				log.debug("登入失敗, 無此帳號");
				up.setErrMsg("登入失敗, 無此帳號");
			}
		}catch(Exception e){
			e.printStackTrace();
			up.setErrMsg(e.getMessage());
		}
		return up;
	}
	
	@Override
	public UserDef getUserDefById(String userId) {
		return userDefDao.findById(userId);
	}

	@Override
	public Map<String, Object> getUserDefList(UserProfile userProfile,
			String userId, String deptId, Integer pageIndex) {
		// TODO Auto-generated method stub
		return userDefDao.getUserDefList(userProfile,userId,deptId,pageIndex) ;
	}

	@Override
	public Map<String, Object> getUserDefInfo(String userId) throws JsonProcessingException {
		Map<String, Object>  userMap = new HashMap<String,Object>();
		UserDef ud = getUserDefById(userId);
		userMap.put("userDef", ud);
		userMap.put("citys", cityDao.getCitys());
		
		List<String> userFunctions = userFunctionService.getUserFunctionList(userId);
		
		userMap.put("functionTree", functionService.makeFunctionTree(userFunctions));
//		userMap.put("userFunction", userFunctionService.getUserFunctionList(userId));
		return userMap;
	}

	
	@Override
	public boolean deleteUserDef(String userId, UserProfile userProfile) {
		UserDef ud = getUserDefById(userId);
		boolean result = false;
		try {
			if(ud != null){
				ud.setDeleteFlag(DeleteMark.YES.getCode());
				ModifyFields.complementUpdateInfo(ud, userProfile, new Date());
				userDefDao.save(ud);
				result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public void saveUserDef(UserDef userDef){
		userDefDao.save(userDef);
	}
	
	@Override
	public boolean saveUserDef(UserProfile userProfile, UserDef userDef,String functionIds) {
		boolean result = false;
		try {
			UserDef ud = getUserDefById(userDef.getUserId());
			if(ud != null){
				BeanClone.copyBeanProperties(userDef, ud);
				ModifyFields.complementUpdateInfo(ud, userProfile, new Date());
				userDefDao.save(ud);
				
				if(StringUtils.isNotBlank(functionIds)){
					String[] funcs =  functionIds.split(",");
					userFunctionService.deleteUserFunctions(ud.getUserId());
					Set<String> roots = functionService.getUpperFunctionSet(Arrays.asList(funcs));
					
					for(String _h: roots){
						UserFunctionId ufId = new UserFunctionId(_h,ud.getUserId());
						UserFunction uf = new UserFunction();
						uf.setId(ufId);
						uf.setDeleteFlag(DeleteMark.NO.getCode());
						ModifyFields.complementInsertInfo(uf, userProfile, new Date());
						userFunctionService.saveUserFunctions(uf);
					}
					
					for(String f: funcs){
						UserFunctionId ufId = new UserFunctionId(f,ud.getUserId());
						UserFunction uf = new UserFunction();
						uf.setId(ufId);
						uf.setDeleteFlag(DeleteMark.NO.getCode());
						ModifyFields.complementInsertInfo(uf, userProfile, new Date());
						userFunctionService.saveUserFunctions(uf);
					}
					result = true;
				}else
					result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			log.error("更新UserDef發生錯誤: "+e);
		}
		return result;
	}

}
