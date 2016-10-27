package gov.nia.nrs.dao;

import gov.nia.nrs.domain.FsOldAllowance;

import java.util.List;

public interface FsOldAllowanceDao {

	List<FsOldAllowance> getAllowanceList(String personId);

}
