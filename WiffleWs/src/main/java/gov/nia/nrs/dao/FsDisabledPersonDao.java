package gov.nia.nrs.dao;

import gov.nia.nrs.domain.FsDisabledPerson;

import java.util.List;

public interface FsDisabledPersonDao {

	List<FsDisabledPerson> getDisabledPersonList(String personId);

}
