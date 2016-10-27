package gov.nia.nrs.dao;

import gov.nia.nrs.domain.FsLowIncome;

import java.util.List;

public interface FsLowIncomeDao {

	List<FsLowIncome> getLowIncomeList(String personId);

}
