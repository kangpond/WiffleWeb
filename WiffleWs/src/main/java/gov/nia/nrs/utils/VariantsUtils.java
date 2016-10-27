package gov.nia.nrs.utils;



import gov.nia.nrs.dao.iis.VariantsDao;
import gov.nia.nrs.domain.iis.Variants;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("variantsUtils")
public class VariantsUtils {

    private static Logger logger = LoggerFactory.getLogger(VariantsUtils.class);

    private String listSize = "60"; // 預設60個組合

    @Autowired
    private VariantsDao variantsDao;

    /**
     * 依輸入的中文姓名查詢異體字
     * 
     * @param chineseName
     * @return List<String>
     * @throws Exception
     */
    public List<String> getVariantsNames(String chineseName) throws Exception {
        if (StringUtils.isBlank(chineseName)) {
            logger.error("property chineseName is empty");
            throw new IllegalArgumentException("property is null");
        }

        List<String> nameWords = StringUtil.getChineseNameList(chineseName);
        List<List<String>> variantWords = getVariantWords(nameWords);
        logger.debug("chineseName = {}", chineseName);
        return mixVariantWords(variantWords, chineseName);
    }

    /**
     * 先傳入的名字切割成一個一個的字
     * 
     * @param chineseName
     * @return List<String>
     */
    @SuppressWarnings("unused")
    private List<String> splitName(String chineseName) {
        List<String> nameWords = new ArrayList<String>();
        int nameSize = chineseName.length();
        logger.debug("nameSize = {}", nameSize);
        logger.debug("chineseName = {}", chineseName);
        String excerptName = null;
        // 將名字分開
        for (int i = 0; i < nameSize; i++) {
            excerptName = String.valueOf(chineseName.charAt(i));
            if (StringUtils.isNotBlank(excerptName)) {
                logger.debug("splitName_excerptName = {}", excerptName);
                nameWords.add(excerptName);
            }
        }
        return nameWords;
    }

    /**
     * 將切割過的名字，分開查詢是否有異體字並分別包好
     * 
     * @param nameWords
     * @return List<List<String>>
     * @throws Exception
     */
    private List<List<String>> getVariantWords(List<String> nameWords) throws Exception {
        logger.debug("nameWords = {}", nameWords);
        // 為了拼裝姓名所準備的異體字
        List<List<String>> buildList = new ArrayList<List<String>>();
        // 資料庫到出來的異體字list
        List<String> variantList;
        // VariantsDo variantsDo;
        // 將拆開後姓名後一個一個的字當條件，查詢異體字
        for (int i = 0; i < nameWords.size(); i++) {
            variantList = new ArrayList<String>();
            // 用拆解過的名字查詢異體字table
            // 20121024 Jimmy指示，使用rank1當key值查詢
            List<String> queryCondiList = new ArrayList<String>();
            queryCondiList.add(nameWords.get(i));
            List<Variants> list = queryVariantsByRank1(queryCondiList);
            if (list != null && !list.isEmpty()) {
                for (Variants variantsDo : list) {
                    // 將各個異體字都塞進variantList
                    if (StringUtils.isNotBlank(variantsDo.getId().getRank1())) {
                        variantList.add(variantsDo.getId().getRank1());
                    }
                    if (StringUtils.isNotBlank(variantsDo.getRank2())) {
                        variantList.add(variantsDo.getRank2());
                    }
                    if (StringUtils.isNotBlank(variantsDo.getRank3())) {
                        variantList.add(variantsDo.getRank3());
                    }
                    if (StringUtils.isNotBlank(variantsDo.getRank4())) {
                        variantList.add(variantsDo.getRank4());
                    }
                    if (StringUtils.isNotBlank(variantsDo.getRank5())) {
                        variantList.add(variantsDo.getRank5());
                    }
                    if (StringUtils.isNotBlank(variantsDo.getRank6())) {
                        variantList.add(variantsDo.getRank6());
                    }
                    if (StringUtils.isNotBlank(variantsDo.getRank7())) {
                        variantList.add(variantsDo.getRank7());
                    }
                    if (StringUtils.isNotBlank(variantsDo.getRank8())) {
                        variantList.add(variantsDo.getRank8());
                    }
                    if (StringUtils.isNotBlank(variantsDo.getRank9())) {
                        variantList.add(variantsDo.getRank9());
                    }
                    if (StringUtils.isNotBlank(variantsDo.getRank10())) {
                        variantList.add(variantsDo.getRank10());
                    }
                }
            } else {
                // 若查不到，也就是查無異體字，則將原來的那個字塞進來
                logger.debug("沒有異體字也要把自己塞進去");
                variantList.add(nameWords.get(i));
            }
            buildList.add(i, variantList);
            logger.debug("buildList = {}", buildList.get(i));
        }
        return buildList;
    }

    /**
     * 將查詢回來的異體字組裝成一個一個的名字
     * 
     * @param variantWords
     * @return List<String>
     */
    private List<String> mixVariantWords(List<List<String>> variantWords, String processName) {
        logger.debug("processName = {}", processName);
        logger.debug("variantWords = {}", variantWords);
        // 放所有異字陣列
        List<List<String>> list = variantWords;
        // 放所有組合的名字
        List<String> nameList = new ArrayList<String>();
        // 放所有陣列目前取的字元 index
        List<Integer> indexList = new ArrayList<Integer>();
        for (int i = 0; i < processName.length(); i++) {
            indexList.add(0);
        }
        // 算出總共幾種組合
        int maxCount = 1;
        for (int i = 0; i < list.size(); i++) {
            maxCount *= list.get(i).size();
        }

        // 目前第幾種組合
        int targetNum = 0;
        // 陣列 index - 目前變更到的是第幾陣列
        int arrayIndex = 0;
        // 是否為第一筆
        boolean isFirst = true;

        while (targetNum < maxCount) {
            if (arrayIndex < list.size()) {
                // 若不是第一筆,需變更字元 index
                if (!isFirst) {
                    // 是否已經變更
                    boolean hasChange = false;
                    for (int i = 0; i < list.size(); i++) {
                        if (!hasChange) {
                            // 該陣列目前 index
                            Integer targetIndex = indexList.get(i);
                            // 比對 若 index + 1 是否小於該陣列的 length
                            if ((targetIndex + 1) < list.get(i).size()) {
                                // 若小於,則該陣列的字元 index +1
                                targetIndex += 1;
                                indexList.set(i, targetIndex);
                                // 標記為已變更
                                hasChange = true;
                                // 將該陣列前面陣列裡的字元 index 歸 0
                                changeWord(indexList, i);
                                // 將陣列 index 歸 0
                                arrayIndex = 0;
                            } else {
                                arrayIndex++;
                            }
                        }
                    }
                } else {
                    isFirst = false;
                }
                String name = composeName(list, indexList);
                logger.debug("比對重複之前，組出的姓名 = {}", name);
                // 排除重複的名字
                if (!nameList.contains(name)) {
                    nameList.add(name);
                    targetNum++;
                }

                // 最多處理幾種組合
                if (targetNum >= Integer.valueOf(listSize)) {
                    logger.debug("排除重複後，目前所擁有的組數 = {}", targetNum);
                    break;
                }
            } else {
                break;
            }
        }
        for (String str : nameList) {
            logger.debug("姓名組合 : {}", str);
        }
        logger.debug("{}種組合", nameList.size());
        return nameList;
    }

    // 依各陣列目前字元 index 組字
    private String composeName(List<List<String>> list, List<Integer> indexList) {
        StringBuilder name = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            // 該 array 應該取的字元index
            Integer index = indexList.get(i);
            // 將字串起來
            name.append(list.get(i).get(index));
        }
        return name.toString();
    }

    // 字元的 index 變更時,變更字所在 Array 以前的所有 Array 的字元 index 都要歸 0
    private void changeWord(List<Integer> indexList, int arrayIndex) {
        for (int i = 0; i < arrayIndex; i++) {
            indexList.set(i, 0);
        }
    }

    /**
     * 依輸入的英文姓名，將其名與姓交換位置
     * 
     * @param englishName
     * @return
     * @throws Exception
     */
    public List<String> getEnglishNameChange(String englishName) {
        if (StringUtils.isBlank(englishName)) {
            logger.error("englishName is empty");
            throw new IllegalArgumentException("property is null");
        }
        // 全轉大寫
        englishName = englishName.toUpperCase();
        // 先處理名字中間有很多空白
        String[] ssTmp = englishName.split(" ");
        String tempName = "";
        for (String s : ssTmp) {
            if (StringUtils.isNotBlank(s)) {
                tempName = tempName + " " + s;
            }
        }
        logger.debug("tempName = {}", tempName);
        // 先去一下前後空白
        englishName = StringUtils.trim(tempName);
        logger.debug("englishName = {}", englishName);
        List<String> resultList = new ArrayList<String>();
        String[] ss = englishName.split(" ");
        logger.debug("ss size = {}", ss.length);
        permutation("", ss, ss.length, resultList);
        return resultList;
    }

    private void permutation(String s, String[] splits, int n, List<String> resultList) {
        if (n == 1) {
            for (int i = 0; i < splits.length; i++) {
                resultList.add(s + splits[i]);
            }
        }
        for (int i = 0; i < splits.length; i++) {
            String ss = "";
            ss = s + splits[i] + " ";
            // 建立没有第i个元素的子数组
            String[] ii = new String[splits.length - 1];
            int index = 0;
            for (int j = 0; j < splits.length; j++) {
                if (j != i) {
                    ii[index++] = splits[j];
                }
            }
            permutation(ss, ii, n - 1, resultList);
        }
    }

    public List<Variants> queryVariantsByRank1(List<String> wordList) throws Exception {
        if (CollectionUtils.isEmpty(wordList)) {
            return new ArrayList<Variants>();
        }

        return variantsDao.getVariantsByRank1(wordList);
    }
    // public List<Variants> queryVariantsByRank1(List<String> wordList) throws Exception {
    // if(wordList==null){
    // throw new RuntimeException("wordList is null....");
    // }
    //
    // DetachedCriteria criteria = DetachedCriteria.forClass(Variants.class);
    // Restrictions.in("id.rank1", wordList.toArray());
    //
    // return variantsDAO.findByCriteria(criteria);
    // }
}
