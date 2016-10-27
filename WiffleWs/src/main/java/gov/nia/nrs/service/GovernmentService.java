package gov.nia.nrs.service;

import gov.nia.nrs.domain.Government;

import java.util.List;
import java.util.Map;


public interface GovernmentService {

	public String getGovDesc(String deptId);

	public List<Government> getGovList();

	public Map<String, Government> getGovernmentMap();
}
