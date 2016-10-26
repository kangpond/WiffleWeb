package gov.nia.nrs.utils.codeutils;


import java.util.List;

/**
 * 代碼服務介面
 *
 * @author Allen
 * @since 2015年4月7日 下午1:53:11
 */
public interface CodeMappingService {
    /**
     * 機關名稱代碼對應
     */
    public final String CODEID_482 = "482";

    /**
     * 取得代碼類別清單
     *
     * @return 代碼類別列表
     */
    public List<CategoryVo> getCategoryList() throws Exception;

    /**
     * 依代碼類別取得代碼類別名稱
     *
     * @param category 代碼類別
     * @return 代碼類別名稱
     * @throws IllegalArgumentException
     * @throws DataNotFoundException
     */
    public String getCategoryName(String category) throws IllegalArgumentException, Exception;

    /**
     * 依代碼類別取得代碼清單<br>
     * 代碼類別不存在時，回傳空 List
     *
     * @param category 代碼類別
     * @return 代碼列表
     */
    public List<CodeVo> queryCode(String category);

    /**
     * 依代碼類別取得關聯性代碼主代碼清單
     *
     * @param category
     * @return
     * @throws IllegalArgumentException
     * @throws Exception
     */
    public List<CodeVo> queryCodeMaster(String category) throws IllegalArgumentException, Exception;

    /**
     * 依代碼類別取得關聯性代碼子代碼清單
     *
     * @param category
     * @param code
     * @return
     * @throws IllegalArgumentException
     * @throws Exception
     */
    public List<CodeVo> querySubCode(String category, String code) throws IllegalArgumentException, Exception;

    /**
     * 依代碼取得代碼資訊
     *
     * @param category 代碼類別
     * @param code 代碼
     * @return 代碼資訊
     * @throws IllegalArgumentException
     * @throws Exception
     * @throws DataNotFoundException
     */
    public CodeVo getCode(String category, String code) throws IllegalArgumentException, Exception;

    /**
     * 依代碼取得代碼名稱
     *
     * @param category 代碼類別
     * @param code 代碼
     * @return 代碼名稱
     * @throws IllegalArgumentException
     * @throws DataNotFoundException
     * @throws Exception
     */
    public String getCodeName(String category, String code) throws IllegalArgumentException, Exception;

    /**
     * 清除代碼暫存總表
     */
    public void cleanCode();

    /**
     * 查代碼專用.
     *
     * @param condition
     * @return
     */
    public List<CodeVo> queryCode(CodeQueryVo condition) throws IllegalArgumentException, Exception;

    /**
     * <h3>依篩選條件取得代碼清單</h3>
     * 可使用代碼名稱關鍵字查詢<br/>
     * <h4>必填資訊：</h4>
     * condition.category: 代碼類別<br/>
     * <br/>
     * <h5>為提升效能，使用 Cache Memory 內容</h5>
     * @param condition 篩選條件
     * @return 代碼清單
     * @throws NiiCommonException
     */
    public List<CodeVo> queryCodeByFilter(CodeQueryVo condition) throws IllegalArgumentException, Exception;
}
