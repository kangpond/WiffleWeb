/**
 * 
 */
package gov.nia.nrs.ws;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.Functions;
import gov.nia.nrs.service.FunctionService;

import java.util.List;

import javax.annotation.Resource;

/**
 * @author Yang
 *
 */
public class FunctionWebServiceImpl implements FunctionWebService {
	
	@Resource FunctionService functionService;
	
	@Override
	public List<Functions> getFunctionList(Functions function) {
		return functionService.getFunctionList(function);
	}

	@Override
	public List<Functions> getUpperFunctionList() {
		return functionService.getUpperFunctionList();
	}

	@Override
	public Functions getFunction(String functionId) {
		// TODO Auto-generated method stub
		return functionService.getFunction(functionId);
	}
	
	@Override
	public boolean saveFunction(Functions function, String userId){
		return functionService.saveFunction(function,userId);
	}

	@Override
	public void deleteFunction(String functionId) {
		// TODO Auto-generated method stub
		functionService.deleteFunction(functionId);
	}

}
