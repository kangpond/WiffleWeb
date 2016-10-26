package gov.nia.nrs.utils.codeutils;


import gov.nia.nrs.utils.BeanClone;
import gov.nia.nrs.ws.CommonWebService;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Repository("codeMappingService")
public class CodeMappingServiceImpl implements CodeMappingService {
    private static final Logger logger = LoggerFactory.getLogger(CodeMappingServiceImpl.class);

    /** 代碼類別列表 */
    private static Map<String, CategoryVo> categoryMap;

    /** 代碼總表 */
    private static Map<String, Map<String, CodeVo>> codeMap = new HashMap<String, Map<String, CodeVo>>();

    /** 代碼總表 */
    private static Map<String, List<CodeVo>> associatedMap = new HashMap<String, List<CodeVo>>();

    // 取得所有代碼類別清單
    @Override
    public List<CategoryVo> getCategoryList() throws Exception {
        if (null == categoryMap) {
            logger.debug("start getCategoryList 取得所有代碼類別清單");
            WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
            CommonWebService commonWs = (CommonWebService) context.getBean("commonWebService");
            CategoryMapVo mapVo = commonWs.getCodeCategoryMapping();
            if (mapVo != null) {
                categoryMap = mapVo.getMap();
            } else {
                logger.warn("未取得所有代碼類別清單");
            }
        }

        List<CategoryVo> result = new ArrayList<CategoryVo>(categoryMap.values());
        Collections.sort(result);

        return result;
    }

    // 依代碼類別取得代碼類別名稱
    @Override
    public String getCategoryName(String category) throws IllegalArgumentException, Exception {
        if (StringUtils.isBlank(category)) {
            logger.error("依代碼類別取得代碼類別名稱時，代碼類別不可為空值！");
            throw new IllegalArgumentException("依代碼類別取得代碼類別名稱時，代碼類別不可為空值！");
        }

        if (null == categoryMap)
            this.getCategoryList();

        CategoryVo result = categoryMap.get(category);

        if (null == result) {
            logger.error("依代碼類別取得代碼類別名稱時，代碼類別: {} 不存在！", category);
            throw new Exception("依代碼類別取得代碼類別名稱時，代碼類別: " + category + " 不存在！");
        }

        return result.getCategoryName();
    }


    // 依代碼類別取得代碼清單，代碼類別不存在時，回傳空 List
    @Override
    public List<CodeVo> queryCode(String category) {
        if (StringUtils.isBlank(category)) {
            logger.error("依代碼類別取得代碼清單時，代碼類別不可為空值！");
            throw new IllegalArgumentException("依代碼類別取得代碼清單時，代碼類別不可為空值！");
        }

        if (null == codeMap.get(category)) {
            try {
                this.putCodeMap(category);
            } catch (Exception e) {
                logger.error("取得代碼錯誤！", e);
                throw new IllegalArgumentException("取得代碼錯誤！");
            }
        }

        List<CodeVo> result = new ArrayList<CodeVo>(codeMap.get(category).values());
        Collections.sort(result);

        return result;
    }

    @Override
    public List<CodeVo> queryCode(CodeQueryVo condition) {
        if (StringUtils.isBlank(condition.getCategory())) {
            logger.error("依代碼類別取得代碼清單時，代碼類別不可為空值！");
            throw new IllegalArgumentException("依代碼類別取得代碼清單時，代碼類別不可為空值！");
        }

        if (null == codeMap.get(condition.getCategory())) {
            try {
                this.putCodeMap(condition.getCategory());
            } catch (Exception e) {
                logger.error("取得代碼錯誤！", e);
                throw new IllegalArgumentException("取得代碼錯誤！");
            }
        }

        List<CodeVo> result = new ArrayList<CodeVo>(codeMap.get(condition.getCategory()).values());

        boolean queryKeyWord = StringUtils.isNotBlank(condition.getKeyWord());

        if (queryKeyWord) {
            List<CodeVo> resultOut = new ArrayList<CodeVo>();
            for (CodeVo codeVo : result) {

                if (queryKeyWord && codeVo.getCodeName().indexOf(condition.getKeyWord()) < 0)
                    continue;
                resultOut.add(codeVo);
            }
            Collections.sort(resultOut);
            return resultOut;
        } else {
            Collections.sort(result);
            return result;
        }
    }

    // 依代碼類別取得關聯性代碼主代碼清單
    @Override
    public List<CodeVo> queryCodeMaster(String category) throws IllegalArgumentException, Exception {
        if (StringUtils.isBlank(category)) {
            logger.error("依代碼類別取得關聯性代碼主代碼清單時，代碼類別不可為空值！");
            throw new IllegalArgumentException("依代碼類別取得關聯性代碼主代碼清單時，代碼類別不可為空值！");
        }

        if (null == codeMap.get(category))
            this.putCodeMap(category);

        List<CodeVo> result = associatedMap.get(category);

        if (null == result) {
            logger.error("此代碼類別: {} ，非關聯性代碼！", category);
            throw new Exception("此代碼類別: " + category + " ，非關聯性代碼！");
        }

        Collections.sort(result);

        return result;
    }

    // 依代碼類別取得關聯性代碼子代碼清單
    @Override
    public List<CodeVo> querySubCode(String category, String code) throws IllegalArgumentException, Exception {
        if (StringUtils.isBlank(category)) {
            logger.error("依代碼類別取得關聯性代碼子代碼清單時，代碼類別不可為空值！");
            throw new IllegalArgumentException("依代碼類別取得關聯性代碼子代碼清單時，代碼類別不可為空值！");
        } else if (StringUtils.isBlank(code)) {
            logger.error("依代碼類別取得關聯性代碼子代碼清單時，代碼不可為空值！");
            throw new IllegalArgumentException("依代碼類別取得關聯性代碼子代碼清單時，代碼不可為空值！");
        }

        if (null == codeMap.get(category))
            this.putCodeMap(category);

        if (null == codeMap.get(category) || null == codeMap.get(category).get(code)) {
            logger.error("此代碼類別: {} ，代碼: {} ，不存在！", category, code);
            throw new Exception("此代碼類別: " + category + " ，代碼: " + code + " ，不存在！");
        }

        List<CodeVo> result = codeMap.get(category).get(code).getSubCode();

        if (null != result)
            Collections.sort(result);

        return result;
    }

    // 依代碼取得代碼資訊
    @Override
    public CodeVo getCode(String category, String code) throws IllegalArgumentException, Exception {
        if (StringUtils.isBlank(category)) {
            logger.error("依代碼取得代碼資訊時，代碼類別不可為空值！");
            throw new IllegalArgumentException("依代碼取得代碼資訊時，代碼類別不可為空值！");
        } else if (StringUtils.isBlank(code)) {
            logger.error("依代碼取得代碼資訊時，代碼不可為空值！");
            throw new IllegalArgumentException("依代碼取得代碼資訊時，代碼不可為空值！");
        }

        // 轉換一下 -- allen 2014/12/01
        // if (code != null && StringUtils.isNumeric(code)) {
        // code = String.valueOf(Integer.valueOf(code));
        // }

        // 利用已有 method 判斷該代碼類別是否存在
        try {
            this.getCategoryName(category);
        } catch (Exception e) {
            logger.error("依代碼取得代碼資訊時，代碼類別: {} 不存在！", category);
            throw new Exception("依代碼取得代碼資訊時，代碼類別: " + category + " 不存在！");
        }

        if (null == codeMap.get(category))
            this.putCodeMap(category);

        CodeVo result = codeMap.get(category).get(code);

        if (null == result) {
            logger.error("依代碼取得代碼資訊時，code: {} not exist! category={}", code, category);
            if (code.equals("0")) {
                // 找不到時，若code=0，帶空值出去
                CodeVo vo = new CodeVo();
                vo.setCode(code);
                vo.setCodeName("");
                vo.setComment("");
                vo.setComment2("");
                return vo;
            } else {
                // modify by Jay 20151126
                // code有可能是01對映不到code為1的時候, 輚成數字在找看看
                if (StringUtils.isNumeric(code)) {
                    result = codeMap.get(category).get(String.valueOf(Integer.valueOf(code)));
                }
                if (result == null) {
                    throw new Exception("code:" + code + " not exist! category=" + category);
                }
            }

        }

        return result;
    }

    // 依代碼取得代碼名稱
    @Override
    public String getCodeName(String category, String code) throws IllegalArgumentException, Exception {
        return this.getCode(category, code).getCodeName();
    }


    // 清除代碼內容
    @Override
    public void cleanCode() {
        logger.info("-- clean Code Map --");
        categoryMap = null;
        codeMap = new HashMap<String, Map<String, CodeVo>>();
    }

    /**
     *
     * @param category
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    private void putCodeMap(String category) throws Exception {
        // 1.Find CodeSetting by category to get CodeId
        logger.debug("1.Find CodeSetting by category to get CodeId by WS");
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(ServletActionContext.getServletContext());
        CommonWebService commonWs = (CommonWebService) context.getBean("commonWebService");
        String codeId = commonWs.getCodeIdOfCodeSetting(category);

        if (StringUtils.isBlank(codeId)) {
            throw new RuntimeException("No Code Data found.");
        }

        // 2.Find DataSetting by CodeId
        logger.debug("2.Find DataSetting from CodeId by WS");
        List<DataSettingDo> dataSettingList = commonWs.getDataSettingList(codeId);

        List<CodeDo> codeList = new LinkedList<CodeDo>();
        if (dataSettingList != null) {
            if (!dataSettingList.isEmpty()) {
                for (DataSettingDo data : dataSettingList) {
                    if (StringUtils.isNotBlank(data.getCodeDataValue())) {
                        CodeDo codeDo = new CodeDo();
                        codeDo.setCategory(category);
                        codeDo.setCode(data.getCodeDataValue());
                        codeDo.setCodeName(data.getCodeDataValueDesc());
                        codeDo.setComment(data.getCodeDataValueDesc2());
                        codeDo.setComment2(data.getComments());
                        codeDo.setFilter1(data.getFilter1());
                        codeDo.setFilter2(data.getFilter2());
                        codeDo.setFilter3(data.getFilter3());
                        codeDo.setOrder(data.getOrderList());
                        codeDo.setParentId(data.getParentDataId());
                        codeList.add(codeDo);
                    }
                }
            }
        }

        CodeVo code, parentCode;
        Map<String, CodeVo> codeSubMap = new HashMap<String, CodeVo>();
        boolean associated = false;
        List<CodeVo> associatedList = null;

        for (CodeDo item : codeList) {
            code = new CodeVo();
            try {
                BeanClone.clone(item, code);
            } catch (Exception e) {
                logger.error("複製代碼資料時，複製錯誤！", e);
            }
            codeSubMap.put(item.getCode(), code);

            if (!associated && StringUtils.isNotBlank(code.getParentId()))
                associated = true;
        }

        codeMap.put(category, codeSubMap);

        if (associated) {
            associatedList = new ArrayList<CodeVo>();
            for (CodeVo item : codeSubMap.values()) {
                if (StringUtils.isBlank(item.getParentId())) {
                    associatedList.add(item);
                } else {
                    parentCode = codeSubMap.get(item.getParentId());
                    if (null == parentCode)
                        continue;
                    if (null == parentCode.getSubCode())
                        parentCode.setSubCode(new ArrayList<CodeVo>());
                    parentCode.getSubCode().add(item);
                }
            }
            associatedMap.put(category, associatedList);
        }
    }

    @Override
    public List<CodeVo> queryCodeByFilter(CodeQueryVo condition) throws IllegalArgumentException, Exception {
        // TODO Auto-generated method stub
        logger.debug("(before) Query Code By Filter! condition: {}", condition);
        if (null == condition) {
            String msg = "依篩選條件取得代碼清單時, 篩選條件不可為Null!";
            logger.error(msg);
            throw new IllegalArgumentException(msg);
        } else if (StringUtils.isBlank(condition.getCategory())) {
            String msg = "依篩選條件取得代碼清單時, 代碼類別不可為空值!";
            logger.error(msg);
            throw new IllegalArgumentException(msg);
        }

        List<CodeVo> result = new ArrayList<CodeVo>();
        List<CodeVo> codeList = this.queryCode(condition);

        // 逐筆取得代碼驗證
        for (CodeVo item : codeList)
            // 接著判斷是否符合篩選條件
            if (this.checkByFilter(item, condition))
                result.add(item);
        //
        // // 決定排序方式
        // if (condition.isSortByField())
        // new CommonSort().sort(result, "order");

        return result;
    }

    /**
     * <h3>依據條件驗證該代碼是否符合篩選規則</h3>
     *
     * @param code 待驗證物件
     * @param condition 驗證條件
     * @return 是否符合條件
     */
    private boolean checkByFilter(CodeVo code, CodeQueryVo condition) {
        if (StringUtils.isBlank(condition.getFilter1()) && StringUtils.isBlank(condition.getFilter2()) && StringUtils.isBlank(condition.getFilter3()))
            return true;

        int filter = 0, codeType = 0;

        if (StringUtils.isNotBlank(condition.getFilter1())) {
            filter += 4;
            if (condition.getFilter1().equals(code.getFilter1()))
                codeType += 4;
        }

        if (StringUtils.isNotBlank(condition.getFilter2())) {
            filter += 2;
            if (condition.getFilter2().equals(code.getFilter2()))
                codeType += 2;
        }

        if (StringUtils.isNotBlank(condition.getFilter3())) {
            filter += 1;
            if (condition.getFilter3().equals(code.getFilter3()))
                codeType += 1;
        }

        return 0 == filter || (condition.isUnion() ? codeType > 0 : filter == codeType);
    }

}
