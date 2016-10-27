package gov.nia.nrs.dao.iis;

import gov.nia.nrs.domain.iis.CodeSetting;
import gov.nia.nrs.domain.iis.DataSetting;

import java.util.List;

public interface CodeDataDao {

	public List<DataSetting> getDataSettingList(String codeId);

    public String getDataValue(String codeId,String codeDataValue);

    /**
     *
     * @param codeId
     * @param codeDataValue
     * @return
     */
    public List<DataSetting> getDataSettingList(String codeId,String codeDataValue);

	DataSetting getDataSetting(String codeId, String codeDataValue);

    List<CodeSetting> getAllCodeSettings();

    List<CodeSetting> getCodeSettingsByCodeName(String codeName);

    List<DataSetting> getDataSettingByCodeId(String codeId);

    List<DataSetting> getDataSettingList656(String codeDataValueDesc);

    String getCodeDataValueDescByCodeData(String codeDataValue);

    List<DataSetting> getDataSettingByCodeIdList(List<String> codeIdList);


}
