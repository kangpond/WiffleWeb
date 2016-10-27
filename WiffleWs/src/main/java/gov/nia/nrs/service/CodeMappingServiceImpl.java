package gov.nia.nrs.service;

import gov.nia.nrs.dao.iis.CodeDataDao;
import gov.nia.nrs.domain.iis.CodeSetting;
import gov.nia.nrs.domain.iis.DataSetting;
import gov.nia.nrs.utils.BeanClone;
import gov.nia.nrs.utils.codeutils.CategoryVo;
import gov.nia.nrs.utils.codeutils.CodeDo;
import gov.nia.nrs.utils.codeutils.CodeVo;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("codeMappingService")
public class CodeMappingServiceImpl implements CodeMappingService {

    private Logger logger = LoggerFactory.getLogger(CodeMappingServiceImpl.class);

    @Autowired
    private CodeDataDao codeDataDao;

    /** 代碼類別列表 */
    private static Map<String, CategoryVo> categoryMap;

    /** 代碼總表 */
    private static Map<String, Map<String, CodeVo>> codeMap = new HashMap<String, Map<String, CodeVo>>();

    /** 代碼總表 */
    private static Map<String, List<CodeVo>> associatedMap = new HashMap<String, List<CodeVo>>();

    // 取得代碼類別清單
    @Override
    public List<CategoryVo> getCategoryList() throws Exception {
        if (null == categoryMap) {
            categoryMap = this.getCodeCategoryList();
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
    public CodeVo getCode(String category, String code) throws IllegalArgumentException {
        if (StringUtils.isBlank(category)) {
            logger.error("依代碼取得代碼資訊時，代碼類別不可為空值！");
            throw new IllegalArgumentException("依代碼取得代碼資訊時，代碼類別不可為空值！");
        } else if (StringUtils.isBlank(code)) {
            logger.error("依代碼取得代碼資訊時，代碼不可為空值！");
            throw new IllegalArgumentException("依代碼取得代碼資訊時，代碼不可為空值！");
        }

        // 轉換一下 -- allen 2014/12/01
        if (code != null && StringUtils.isNumeric(code)) {
            code = String.valueOf(Integer.valueOf(code));
        }

        // 利用已有 method 判斷該代碼類別是否存在
        try {
            this.getCategoryName(category);
        } catch (Exception e) {
            logger.error("依代碼取得代碼資訊時，代碼類別: {} 不存在！", category);
            // throw new Exception("依代碼取得代碼資訊時，代碼類別: " + category + " 不存在！");
        }

        if (null == codeMap.get(category))
            try {
                this.putCodeMap(category);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                logger.error("", e);
            }

        CodeVo result = codeMap.get(category).get(code);

        if (null == result) {
            logger.error("依代碼取得代碼資訊時，代碼: {} 不存在！", code);
            // throw new Exception("依代碼取得代碼資訊時，代碼: " + code + " 不存在！");
        }

        return result;
    }

    // 依代碼取得代碼資訊 (不將參數 code 轉為 integer，避免 612 地址抓取時因金門馬祖開頭為 0 導致抓不出資料)
    @Override
    public CodeVo getCode2(String category, String code) throws IllegalArgumentException {
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
            // throw new Exception("依代碼取得代碼資訊時，代碼類別: " + category + " 不存在！");
        }

        if (null == codeMap.get(category))
            try {
                this.putCodeMap(category);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                logger.error("", e);
            }

        CodeVo result = codeMap.get(category).get(code);

        if (null == result) {
            logger.error("依代碼取得代碼資訊時，代碼: {} 不存在！", code);
            // throw new Exception("依代碼取得代碼資訊時，代碼: " + code + " 不存在！");
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
        logger.debug("putCodeMap process. category={}", category);
        // 1.Find CodeSetting by category to get CodeId
        List<CodeSetting> codeSettingList = getCodeSettingList(category);

        String codeId = "";
        if (codeSettingList != null) {
            if (!codeSettingList.isEmpty()) {
                codeId = codeSettingList.get(0).getId();
            }
        }

        if (codeId.isEmpty()) {
            throw new RuntimeException("No Code Data found.");
        }

        // 2.Find DataSetting by CodeId
        List<DataSetting> dataSettingList = getDataSettingList(codeId);

        List<CodeDo> codeList = new LinkedList<CodeDo>();
        if (dataSettingList != null) {
            if (!dataSettingList.isEmpty()) {
                for (DataSetting data : dataSettingList) {
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
                        codeDo.setOrder(data.getOrderList() != null ? data.getOrderList().intValue() : 0);
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
    public Map<String, CategoryVo> getCodeCategoryList() throws Exception {
        List<CodeSetting> categoryData = codeDataDao.getAllCodeSettings();

        Map<String, CategoryVo> map = new HashMap<String, CategoryVo>();

        for (CodeSetting item : categoryData) {
            CategoryVo category = new CategoryVo();
            category.setCategory(item.getCodeName());
            category.setCategoryName(item.getCodeNameDesc());
            category.setId(item.getId());

            map.put(item.getCodeName(), category);
        }

        return map;
    }

    @Override
    public List<CodeSetting> getCodeSettingList(String category) throws Exception {
        return codeDataDao.getCodeSettingsByCodeName(category);
    }

    @Override
    public List<DataSetting> getDataSettingList(String codeId) throws Exception {
        return codeDataDao.getDataSettingByCodeId(codeId);
    }

    @Override
    public List<DataSetting> getDataSettingList656(String codeDataValueDesc) {

        return codeDataDao.getDataSettingList656(codeDataValueDesc);
    }

    @Override
    public String getCodeDataValueDescByCodeData(String codeDataValue) {
        return codeDataDao.getCodeDataValueDescByCodeData(codeDataValue);
    }

    @Override
    public Map<String, List<DataSetting>> getDataSettingListByCodeIdList(List<String> codeIdList) {
        Map<String, List<DataSetting>> dataSettingListMap = new HashMap<String, List<DataSetting>>();
        List<DataSetting> dataSettingList = codeDataDao.getDataSettingByCodeIdList(codeIdList);
        for (DataSetting dataSetting : dataSettingList) {
            String codeId = dataSetting.getCodeId();
            if (dataSettingListMap.get(codeId) == null) {
                List<DataSetting> settingList = new ArrayList<DataSetting>();
                dataSettingListMap.put(codeId, settingList);
            }
            dataSettingListMap.get(codeId).add(dataSetting);
        }
        return dataSettingListMap;
    }


}
