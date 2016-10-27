/**
 * 
 */
package gov.nia.nrs.dao;

import gov.nia.nrs.domain.FsOldAllowance;

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

@Repository("fsOldAllowanceDao")
@Transactional
public class FsOldAllowanceDaoImpl extends BaseDaoImpl<FsOldAllowance, String> implements FsOldAllowanceDao {

	private static final Logger logger = LoggerFactory.getLogger(FsOldAllowanceDaoImpl.class);

	
	@Override
	public List<FsOldAllowance> getAllowanceList(String personId){
		Search search = new Search(FsOldAllowance.class);
		search.setResultMode(Search.RESULT_LIST);
		search.addField("personId");
		return search(search);
	}

	
}
