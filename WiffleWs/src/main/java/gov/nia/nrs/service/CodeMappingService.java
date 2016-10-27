package gov.nia.nrs.service;


import gov.nia.nrs.domain.iis.CodeSetting;
import gov.nia.nrs.domain.iis.DataSetting;
import gov.nia.nrs.utils.codeutils.CategoryVo;
import gov.nia.nrs.utils.codeutils.CodeVo;

import java.util.List;
import java.util.Map;

/**
 * 代碼服務介面
 * @author Allen
 * @since 2015年4月7日 下午1:53:11
 */
public interface CodeMappingService {
    /**
     * 機關名稱代碼對應
     */
    public final String CODEID_482 = "482";
    /**
     * Data Filter 2: "ALL"<br><br>
     * 註記是否有權限可以看到全部的違常登錄
     */
    public final String FILTER_2 = "ALL";
    /**
     * Data Filter 3: "NIA"<br><br>
     * 註記是否為署內使用者
     */
    public final String FILTER_3 = "NIA";

	/**
	 * 取得代碼類別清單
	 * @return 代碼類別列表
	 */
	public List<CategoryVo> getCategoryList() throws Exception;

	/**
	 * 依代碼類別取得代碼類別名稱
	 * @param category 代碼類別
	 * @return 代碼類別名稱
	 * @throws IllegalArgumentException
	 * @throws DataNotFoundException
	 */
	public String getCategoryName(String category)
			throws IllegalArgumentException, Exception;

	/**
	 * 依代碼類別取得代碼清單<br>
	 * 代碼類別不存在時，回傳空 List
	 * @param category 代碼類別
	 * @return 代碼列表
	 */
	public List<CodeVo> queryCode(String category);

	/**
	 * 依代碼類別取得關聯性代碼主代碼清單
	 * @param category
	 * @return
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	public List<CodeVo> queryCodeMaster(String category)
			throws IllegalArgumentException, Exception;

	/**
	 * 依代碼類別取得關聯性代碼子代碼清單
	 * @param category
	 * @param code
	 * @return
	 * @throws IllegalArgumentException
	 * @throws Exception
	 */
	public List<CodeVo> querySubCode(String category, String code)
			throws IllegalArgumentException, Exception;

	/**
	 * 依代碼取得代碼資訊
	 * @param category 代碼類別
	 * @param code 代碼
	 * @return 代碼資訊
	 * @throws IllegalArgumentException
	 * @throws DataNotFoundException
	 */
	public CodeVo getCode(String category, String code)
			throws IllegalArgumentException;

	/**
     * 依代碼取得代碼資訊 (不將參數 code 轉為 Integer)
     * @param category 代碼類別
     * @param code 代碼
     * @return 代碼資訊
     * @throws IllegalArgumentException
     * @throws DataNotFoundException
     */
    public CodeVo getCode2(String category, String code)
            throws IllegalArgumentException;

	/**
	 * 依代碼取得代碼名稱
	 * @param category 代碼類別
	 * @param code 代碼
	 * @return 代碼名稱
	 * @throws IllegalArgumentException
	 * @throws DataNotFoundException
	 * @throws Exception
	 */
	public String getCodeName(String category, String code)
			throws IllegalArgumentException, Exception;

	/**
	 * 清除代碼暫存總表
	 */
	public void cleanCode();

	/**
	 * 取得代碼分類列表集　
	 * @throws Exception
	 */
	public Map<String, CategoryVo> getCodeCategoryList() throws Exception;

	/**
	 * 取得代碼設定全部資料
	 */
	public List<CodeSetting> getCodeSettingList(String category) throws Exception;

	/**
	 * 取得代碼資料設定全部資料
	 */
	public List<DataSetting> getDataSettingList(String codeId) throws Exception;
/**
 * 取得CodeId =656 Filter =FIRM  codeDataValueDesc Like 'codeDataValueDesc' 資料
 * @param codeDataValueDesc
 * @return
 */
    public List<DataSetting> getDataSettingList656(String codeDataValueDesc);

    public String getCodeDataValueDescByCodeData(String codeDataValue);

    /**
     * 取得指定多個代碼清單
     */
    public Map<String,List<DataSetting>> getDataSettingListByCodeIdList(List<String> codeIdList);
}
