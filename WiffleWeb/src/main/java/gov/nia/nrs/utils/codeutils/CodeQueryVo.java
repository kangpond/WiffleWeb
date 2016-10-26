/**
 * Copyright 2012 (C) Hyweb Technology. All Rights Reserved.
 *
 * Date:2012/9/28 下午12:19:05 User: Carl Desc: 新加註解
 */

package gov.nia.nrs.utils.codeutils;

/**
 * @author <a href=”mailto:carl.lu@hyweb.com.tw”>Carl Lu</a>
 * @version Revision: 1 2012/9/28 下午12:19:05
 */
public class CodeQueryVo {

    /** 代碼類別編號 */
    private String category;

    /** 代碼值 */
    private String code;

    /** 關鍵字 */
    private String keyWord;

    /** 第一篩選欄位 */
    private String filter1;

    /** 第二篩選欄位 */
    private String filter2;

    /** 第三篩選欄位 */
    private String filter3;

    /** 是否使用排序欄位排序 */
    private boolean sortByField;

    /** 是否為聯集篩選方式，預設為 true */
    private boolean union = true;

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CodeQueryVo [category=");
        builder.append(category);
        builder.append(", code=");
        builder.append(code);
        builder.append(", keyWord=");
        builder.append(keyWord);
        builder.append(", filter1=");
        builder.append(filter1);
        builder.append(", filter2=");
        builder.append(filter2);
        builder.append(", filter3=");
        builder.append(filter3);
        builder.append(", sortByField=");
        builder.append(sortByField);
        builder.append(", union=");
        builder.append(union);
        builder.append("]");
        return builder.toString();
    }

    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @return the filter1
     */
    public String getFilter1() {
        return filter1;
    }

    /**
     * @return the filter2
     */
    public String getFilter2() {
        return filter2;
    }

    /**
     * @return the filter3
     */
    public String getFilter3() {
        return filter3;
    }

    /**
     * @return the sortByField
     */
    public boolean isSortByField() {
        return sortByField;
    }

    /**
     * @return the union
     */
    public boolean isUnion() {
        return union;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @param filter1 the filter1 to set
     */
    public void setFilter1(String filter1) {
        this.filter1 = filter1;
    }

    /**
     * @param filter2 the filter2 to set
     */
    public void setFilter2(String filter2) {
        this.filter2 = filter2;
    }

    /**
     * @param filter3 the filter3 to set
     */
    public void setFilter3(String filter3) {
        this.filter3 = filter3;
    }

    /**
     * @param sortByField the sortByField to set
     */
    public void setSortByField(boolean sortByField) {
        this.sortByField = sortByField;
    }

    /**
     * @param union the union to set
     */
    public void setUnion(boolean union) {
        this.union = union;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the keyWord
     */
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * @param keyWord the keyWord to set
     */
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
