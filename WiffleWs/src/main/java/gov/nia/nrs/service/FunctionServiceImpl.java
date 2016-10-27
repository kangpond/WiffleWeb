package gov.nia.nrs.service;

import gov.nia.nrs.dao.FunctionDao;
import gov.nia.nrs.domain.Functions;
import gov.nia.nrs.utils.DomainUtils;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;


@Service("functionService")
@Transactional
public class FunctionServiceImpl implements FunctionService{
	
	private final static Log log = LogFactory.getLog(FunctionServiceImpl.class);
	
	@Autowired
	private FunctionDao functionDao;
	
	
	@Override
	public List<Functions> getUserFunction(String userId){
		return functionDao.getUserFunction(userId);
	}


	@Override
	public List<Functions> getUpperFunctionList() {
		return functionDao.getUpperFunctionList();
	}

	@Override
	public Set<String> getUpperFunctionSet(List<String> subFunId) {
		return functionDao.getUpperFunctionSet(subFunId);
	}


	@Override
	public List<Functions> getFunctionList(Functions function) {
		return functionDao.getFunctionList(function);
	}


	@Override
	public Functions getFunction(String functionId) {
		return functionDao.find(functionId);
	}


	@Override
	public boolean saveFunction(Functions function,String userId) {
		boolean result  = false;
		Functions srcFc = getFunction(function.getFunctionId());
		if(srcFc == null){
			srcFc = new Functions();
			BeanUtils.copyProperties(function, srcFc);
			srcFc.setSequence(Long.valueOf(functionDao.getMaxSequence()));
		}else{
			String[] ignore = new String[4];
			ignore[0] = "createDate";
			ignore[1] = "createTime";
			ignore[2] = "createUserId";
			ignore[3] = "sequence";
			BeanUtils.copyProperties(function, srcFc,ignore);
		}
		DomainUtils.createField(userId, srcFc);
		try {
			functionDao.save(srcFc);
			result  = true;
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e);
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public boolean deleteFunction(String functionId) {
		return functionDao.removeById(functionId);
	}
	
	@Override
	public String makeFunctionTree(List<String> userFunctions) throws JsonProcessingException{
//		Functions f = new Functions();
//		f.setState("1");
//		f.setIsLeaf("0");
		List<Functions> functions = getFunctionList(new Functions("0","1",null,null,null));
		return getJSONString(functions,userFunctions);
	}
	
	private String getJSONString(List<Functions> functions,List<String> userFunctions) throws JsonProcessingException{		
		StringBuffer str = new StringBuffer();
		str.append("[");
		//functions 父節點功能樹
		for(int i=0; i<functions.size(); i++){
			str.append("{");
			Functions fun = functions.get(i);
			str.append("\"id\":\"" + fun.getFunctionId() + "\",");
			for(String funId:userFunctions){
				if(StringUtils.equals(funId, fun.getFunctionId()) && 
							StringUtils.equalsIgnoreCase(fun.getIsLeaf(), "1")){
					str.append("\"checked\":true,");
					break;
				}
			}
			str.append("\"text\":\"" + fun.getFunctionName() + "\"");
			
			
			Functions f = new Functions();
    		f.setState("1");
    		f.setUpperFunctionId(fun.getFunctionId());
			if(StringUtils.equalsIgnoreCase(fun.getFunctionType(), "1")){
				f.setIsLeaf("2");
			}else{
				f.setIsLeaf("1");
			}
			List<Functions> subFunctionList = getFunctionList(f);
    		
			if(subFunctionList != null && subFunctionList.size()>0){
				str.append(",");
				String wrod = getJSONString(subFunctionList, userFunctions);
				str.append("\"children\":" + wrod);
			}
			str.append("}");
			if(i !=(functions.size()-1)){
				str.append(",");
			}
		}
		str.append("]");
		
		return str.toString();
	}
	
	@Override
	public String getFunctionName(String upperFunctionId){
		return functionDao.find(upperFunctionId).getFunctionName();
	}
}
