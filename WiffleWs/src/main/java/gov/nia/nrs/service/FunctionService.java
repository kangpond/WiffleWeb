package gov.nia.nrs.service;

import gov.nia.nrs.domain.Functions;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;


public interface FunctionService {
	
	
	public List<Functions> getUserFunction(String userId);

	public List<Functions> getUpperFunctionList();

	public List<Functions> getFunctionList(Functions function);

	public Functions getFunction(String functionId);

	public boolean saveFunction(Functions function, String userId);

	public boolean deleteFunction(String functionId);

	Set<String> getUpperFunctionSet(List<String> list);


	String makeFunctionTree(List<String> userFunctions) throws JsonProcessingException;

	public String getFunctionName(String upperFunctionId);
}
