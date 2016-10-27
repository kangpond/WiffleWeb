package gov.nia.nrs.dao;

import gov.nia.nrs.domain.City;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

@Repository("cityDao")
public class CityDaoImpl extends BaseDaoImpl<City, String> implements CityDao {

	
	@SuppressWarnings("unchecked")
	@Override
	public List<City> getCitys(){
		return getSession().createQuery("from City where cityCode != 'Z' order by cityCode ").list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String getCityDesc(String... cityCode){
		List<String> nameList = getSession().createQuery("select cityName from City where cityCode in (:cityCode) and  cityCode != 'Z' order by cityCode ")
					.setParameterList("cityCode", cityCode)
					.list();
		return StringUtils.join(nameList.toArray(), ",");
	}
	
}
