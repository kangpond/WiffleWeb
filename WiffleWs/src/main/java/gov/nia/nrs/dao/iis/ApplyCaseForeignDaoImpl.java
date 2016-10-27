package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.ApplyCaseForeign;
import gov.nia.nrs.service.CodeDataSerivce;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.codec.binary.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Yang
 *
 */

@Repository("applyCaseForeignDao")
@Transactional
public class ApplyCaseForeignDaoImpl extends BaseIISDaoImpl<ApplyCaseForeign, String> implements ApplyCaseForeignDao {

    private static final Logger logger = LoggerFactory.getLogger(ApplyCaseForeignDaoImpl.class);
    
    @Resource CodeDataSerivce codeDataSerivce;
    
    @Override
    public List<Map<String,String>> getAddressList(String firstReceiveNo,String addressType){
    	String fieldString = "";
    	//居住地
    	if(StringUtils.equals("1", addressType)){
    		fieldString = ",acf.TelNo,acf.ZipCodeA,acf.CityA,acf.TownshipA,acf.VillageA,acf.NeighborhoodA,acf.RoadA,acf.LaneA,acf.AlleyA,acf.NumberA";
    	}else if(StringUtils.equals("2", addressType)){
    		//辦公地址
//    		fieldString = ",acf.telNoWk,acf.zipCodeWk,acf.cityWk,acf.townshipWk,acf.villageWk,acf.neighborhoodWk,acf.roadWk,acf.laneWk,acf.alleyWk,acf.numberWk";
    		fieldString = ",acf.TelNoWK,acf.ZipCodeWK,acf.CityWK,acf.TownshipWK,acf.VillageWK,acf.NeighborhoodWK,acf.RoadWK,acf.LaneWK,acf.AlleyWK,acf.NumberWK";
    	}
    	
    	List<Object[]> _list = getAddressRootList(firstReceiveNo, fieldString);
    	List<Map<String,String>> addressList  = new ArrayList<Map<String,String>>(); 
    	if(_list.size() > 0){
    		for(Object[] o: _list){
    			Map<String,String> oMap = new HashMap<String, String>();
    			oMap.put("receiveNo", (String) o[0]);
    			oMap.put("applyDate", (String) o[1]);
    			oMap.put("telNo", (String) o[2]);
    			String address = codeDataSerivce.getDisplayAddress((String) o[3], (String) o[4], 
    											  				   (String) o[5], (String) o[6], 
    											  				   (String) o[7], (String) o[8], 
    											  				   (String) o[9], (String) o[10], 
    											  				   (String) o[11]);
    			oMap.put("address", address);
    			addressList.add(oMap);
    		}
    	}
    	return addressList;
    }
    
    
    @SuppressWarnings("unchecked")
	private List<Object[]> getAddressRootList (String firstReceiveNo,String fieldString){
    	StringBuffer hql = new StringBuffer();
    	hql.append(" select ac.ReceiveNo,ac.ApplyDate ");
    	hql.append(fieldString);
    	hql.append(" from ( ");
    	hql.append("select ReceiveNo,ApplyDate from ApplyCase ")
    		.append("where FirstReceiveNo =:firstReceiveNo and ApplicantType in ('F','L') ");
    	hql.append("and DecideMark = 1 and ApplyType in ('G','H') and (DeleteFlag is null or DeleteFlag != 'Y') ");
    	hql.append(" group by ReceiveNo, ApplyDate) as ac, ApplyCaseForeign as acf ");
    	hql.append(" where ac.ReceiveNo = acf.ReceiveNo ");
    	hql.append(" order by ac.ApplyDate desc ");
//    	hql.append(" group by ac.receiveNo,ac.applyDate "); 
//    	hql.append(fieldString);
    	return getSession().createSQLQuery(hql.toString())
    						.setParameter("firstReceiveNo", firstReceiveNo).list();
    }
    
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String,String>> getWorkInfoList(String firstReceiveNo){
		StringBuffer hql = new StringBuffer();
    	hql.append(" select workAllowDept,workAllowDate,workAllowDocNo,workAllowStartDate,workAllowEndDate ");
    	hql.append(" from ApplyCaseForeign where firstReceiveNo =:firstReceiveNo ");
    	hql.append(" and (deleteFlag is null or deleteFlag != 'Y') ");
    	hql.append(" order by workAllowDate desc ");
//    	hql.append(" group by workAllowDept,workAllowDate,workAllowDocNo,workAllowStartDate,workAllowEndDate ");
    	
    	List<Object[]> _list = getSession().createQuery(hql.toString())
					.setParameter("firstReceiveNo", firstReceiveNo).list();
    	
    	List<Map<String,String>> workList  = new ArrayList<Map<String,String>>(); 
    	if(_list.size() > 0){
    		for(Object[] o: _list){
    			Map<String,String> oMap = new HashMap<String, String>();
    			oMap.put("workAllowDept", (String) o[0]);
    			oMap.put("workAllowDate", (String) o[1]);
    			oMap.put("workAllowDocNo", (String) o[2]);
    			oMap.put("workAllowStartDate", (String) o[3]);
    			oMap.put("workAllowEndDate", (String) o[4]);
    			workList.add(oMap);
    		}
    	}
    	return workList;
	}

}
