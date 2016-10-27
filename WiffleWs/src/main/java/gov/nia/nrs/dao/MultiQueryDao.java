package gov.nia.nrs.dao;

import gov.nia.nrs.domain.iis.DataSetting;
import gov.nia.nrs.multiquery.bean.QueryAttrInfo;

import java.util.List;
import java.util.Map;

public interface MultiQueryDao
{
	public List<DataSetting> queryDataSetting(String codeId) throws Exception;

	public List<DataSetting> queryDataSettingByList(List<String> codeIdList) throws Exception;

	public List<DataSetting> queryTownDs(String cityCodeValue) throws Exception;

	/**
	 * 取出客製化資料表，並將欄位與值放入Map
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> getRowMapList(String sql) throws Exception;

	public Map<String, Integer> getRowCntDataMap(String sql, Map<Integer, QueryAttrInfo> rowAttrMap
			, Map<Integer, QueryAttrInfo> colAttrMap) throws Exception;
}
