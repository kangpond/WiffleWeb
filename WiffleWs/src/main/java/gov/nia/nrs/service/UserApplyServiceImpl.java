package gov.nia.nrs.service;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.dao.CityDao;
import gov.nia.nrs.dao.UserApplyDao;
import gov.nia.nrs.domain.UserApply;
import gov.nia.nrs.domain.UserApplyFunction;
import gov.nia.nrs.domain.UserApplyFunctionId;
import gov.nia.nrs.domain.UserDef;
import gov.nia.nrs.domain.UserFunction;
import gov.nia.nrs.domain.UserFunctionId;
import gov.nia.nrs.eums.DeleteMark;
import gov.nia.nrs.utils.BeanClone;
import gov.nia.nrs.utils.DateUtils;
import gov.nia.nrs.utils.ModifyFields;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.id.UUIDHexGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

@Service("userApplyService")
@Transactional
public class UserApplyServiceImpl implements UserApplyService {

    private static final Logger log = Logger.getLogger(UserApplyServiceImpl.class);

    
	@Resource UserDefService userDefService;
	@Resource UserApplyDao userApplyDao;
	@Resource FunctionService functionService;
	@Resource UserFunctionService userFunctionService;
	@Resource UserApplyFunctionService userApplyFunctionService;
	@Resource CityDao cityDao;
	
	@Override
	public Map<String, Object> getUserApplyList(UserProfile userProfile,
			String userId, String aKinds, Integer pageIndex) {
		return userApplyDao.getUserApplyList(userProfile,userId,aKinds,pageIndex) ;
	}

	@Override
	public Map<String, Object> getApplyCaseInfo(String uuid) throws JsonProcessingException {
		Map<String, Object>  userMap = new HashMap<String,Object>();
		userMap.put("userApply", userApplyDao.find(uuid));
		userMap.put("citys", cityDao.getCitys());
		List<String> userFunctions = userApplyFunctionService.getApplyFunctionList(uuid);
		userMap.put("functionTree", functionService.makeFunctionTree(userFunctions));
		
		return userMap;
	}

	@Override
	public boolean updateUserApply(UserProfile userProfile, UserApply userApply, String functionIds){
		UserApply srcUa = userApplyDao.find(userApply.getUuid());
		UserDef ud = userDefService.getUserDefById(userApply.getUserId());
		boolean result = false;
		
		//核准
		if(StringUtils.equalsIgnoreCase(userApply.getCaseStatus(), "1")){
			if(ud == null){
				ud = new UserDef();
				BeanUtils.copyProperties(userApply, ud);
				ModifyFields.complementInsertInfo(ud, userProfile, new Date());
			}else{
				BeanClone.copyBeanProperties(userApply, ud);
				ModifyFields.complementUpdateInfo(ud, userProfile, new Date());
			}
			ud.setState(userApply.getCaseStatus());
			ud.setDeleteFlag(DeleteMark.NO.getCode());
			userDefService.saveUserDef(ud);
			
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
			}
			
		}else if(StringUtils.equalsIgnoreCase(userApply.getCaseStatus(), "2")){
			result = true;
		}
		srcUa.setCaseStatus(userApply.getCaseStatus());
		ModifyFields.complementUpdateInfo(srcUa, userProfile, new Date());
		userApplyDao.save(srcUa);
		
		return result;
	}

	@Override
	public String saveUserApply(UserProfile userProfile, UserApply userApply,String functionIds) {
		UserApply srcUa = userApplyDao.find(userApply.getUuid());
		boolean result = false;

		if(srcUa == null){
			srcUa = new UserApply();
			BeanUtils.copyProperties(userApply, srcUa);
			srcUa.setApplyDate(DateUtils.getDateToString(new Date(), "yyyyMMdd"));
			srcUa.setApplyTime(DateUtils.getDateToString(new Date(), "hhmmss"));
			srcUa.setUuid(getUUID());
			ModifyFields.complementInsertInfo(srcUa, userProfile, new Date());
		}else{
			BeanClone.copyBeanProperties(userApply, srcUa);
			ModifyFields.complementUpdateInfo(srcUa, userProfile, new Date());
		}
		srcUa.setDeleteFlag(DeleteMark.NO.getCode());
		srcUa.setCaseStatus("0");
		userApplyDao.save(srcUa);
		
		if(StringUtils.isNotBlank(functionIds)){
			String[] funcs =  functionIds.split(",");
			userApplyFunctionService.deleteUserApplyFunctions(srcUa.getUuid());
			
			
			for(String f: funcs){
				UserApplyFunctionId uafId = new UserApplyFunctionId();
				uafId.setFunctionId(f);
				uafId.setUuid(srcUa.getUuid());
				
				UserApplyFunction uaf = new UserApplyFunction();
				uaf.setId(uafId);
				uaf.setDeleteFlag(DeleteMark.NO.getCode());
				ModifyFields.complementInsertInfo(uaf, userProfile, new Date());
				userApplyFunctionService.saveUserApplyFunctions(uaf);
			}
			result = true;
		}
		
		return result ? srcUa.getUuid(): StringUtils.EMPTY;
	}

	public String getUUID(){
		return (String) new UUIDHexGenerator().generate(null, null);
	}
}
