/**
 * 
 */
package gov.nia.nrs.dao;

import gov.nia.nrs.domain.FsDisabledPerson;
import gov.nia.nrs.domain.FsLowIncome;

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
@Repository("fsLowIncomeDao")
@Transactional
public class FsLowIncomeDaoImpl extends BaseDaoImpl<FsLowIncome, String> implements FsLowIncomeDao {

	private static final Logger logger = LoggerFactory.getLogger(FsLowIncomeDaoImpl.class);
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FsLowIncome> getLowIncomeList(String personId){
		Search search = new Search(FsDisabledPerson.class);
		search.setResultMode(Search.RESULT_LIST);
		search.addField("personId");
		return search(search);
	}

}
