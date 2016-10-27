package gov.nia.nrs.dao;

import java.util.List;

import gov.nia.nrs.domain.Government;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

public interface GovernmentDao extends  GenericDAO<Government, String>{

	public String getGovDesc(String deptId);

	public Government getGov(String deptId);

	public List<Government> getGovList();

	public List<Government> queryGovLikeName(String deptName);

	public List<Government> queryList100();

	public int deleteById(String deptId);

	public void update(Government government);
}
