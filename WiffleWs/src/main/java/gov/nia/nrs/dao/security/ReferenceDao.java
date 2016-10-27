package gov.nia.nrs.dao.security;

import gov.nia.nrs.domain.security.ReferenceItemNew;

import java.util.List;

public interface ReferenceDao {

	public List<ReferenceItemNew> getMissingReport(String firstReceiveNo,
			String residentIdNo, String englishName, String chineseName,
			String birthDate) throws Exception;
}
