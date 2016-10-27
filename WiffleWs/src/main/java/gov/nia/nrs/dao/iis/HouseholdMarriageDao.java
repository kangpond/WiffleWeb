package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.HouseholdMarriage;

import java.util.List;

public interface HouseholdMarriageDao {


	HouseholdMarriage getHouseholdMarriage(String personId, String marryDate);

}
