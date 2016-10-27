package gov.nia.nrs.service;

import gov.nia.nrs.domain.iis.DataSetting;

import java.util.List;

public interface CodeDataSerivce {
	
	public List<DataSetting> getDataSettingList(String codeId);
	
	List<DataSetting> getDataSettingList(String codeId,String codeDataValue);

	String getDataValueDescs(String codeId, String codeDataValue);

	String getBirthPlace(String birthPlaceCode, String birthPlace1,String birthPlace2);

	String getDisplayAddress(String zipCode, String city, String township,
			String village, String neighborhood, String road, String lane,
			String alley, String number);

}
