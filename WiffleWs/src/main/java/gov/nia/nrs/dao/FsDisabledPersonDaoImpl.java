/**
 * 
 */
package gov.nia.nrs.dao;

import gov.nia.nrs.domain.FsDisabledPerson;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Search;

/**
 * @author Yang
 *
 */

@Repository("fsDisabledPersonDao")
@Transactional
public class FsDisabledPersonDaoImpl extends BaseDaoImpl<FsDisabledPerson, String> implements FsDisabledPersonDao {
    
	private static final Logger logger = LoggerFactory.getLogger(FsDisabledPersonDaoImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<FsDisabledPerson> getDisabledPersonList(String personId){
		Search search = new Search(FsDisabledPerson.class);
		search.setResultMode(Search.RESULT_LIST);
		search.addField("personId");
		return search(search);
	}
	
}
