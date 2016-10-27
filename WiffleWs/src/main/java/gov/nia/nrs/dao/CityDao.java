package gov.nia.nrs.dao;

import gov.nia.nrs.domain.City;

import java.util.List;

public interface CityDao {

	List<City> getCitys();

	String getCityDesc(String[] cityCode);

}
