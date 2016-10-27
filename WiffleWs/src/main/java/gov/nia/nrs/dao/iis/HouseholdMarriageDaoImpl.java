package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.HouseholdMarriage;
import gov.nia.nrs.domain.iis.HouseholdMarriageId;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yang
 *
 */
@Repository("householdMarriageDao")
public class HouseholdMarriageDaoImpl extends BaseIISDaoImpl<HouseholdMarriage, HouseholdMarriageId> implements HouseholdMarriageDao {

	
    private static final Logger logger = LoggerFactory.getLogger(HouseholdMarriageDaoImpl.class);

	
    @SuppressWarnings("unchecked")
	@Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public HouseholdMarriage getHouseholdMarriage(String personId,String marryDate){
    	List <HouseholdMarriage> _list = getSession().createQuery(" from HouseholdMarriage where id.personId =:personId and marrageDate =:marrageDate ")
    					.setParameter("personId", personId)
    					.setParameter("marrageDate", marryDate).list() ; 
    	return _list.size() > 0 ? _list.get(0):null;								
    }
	
}
