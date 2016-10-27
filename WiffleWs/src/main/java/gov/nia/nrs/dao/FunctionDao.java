package gov.nia.nrs.dao;

import gov.nia.nrs.domain.Functions;

import java.util.List;
import java.util.Set;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

public interface FunctionDao extends GenericDAO<Functions, String>{

    public List<Functions> getUserFunction(String userId);

    public List<Functions> getUpperFunctionList();

	public List<Functions> getFunctionList(Functions function);

	Long getMaxSequence();

	public Set<String> getUpperFunctionSet(List<String> subFunId);

}
