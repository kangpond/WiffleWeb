/**
 * Copyright 2012 (C) Hyweb Technology. All Rights Reserved.
 *
 * Date:2012/7/26 下午1:46:55 User: Carl Desc: 新加註解
 */

package gov.nia.nrs.utils.codeutils;

import java.util.List;

/**
 * @author <a href=”mailto:carl.lu@hyweb.com.tw”>Carl Lu</a>
 * @version Revision: 1 2012/7/26 下午1:46:55
 */
public class CodeVo implements Comparable<CodeVo> {

    /** 代碼 */
    private String code;

    /**
     * 代碼名稱 CodeDataValueDesc
     * */
    private String codeName;

    /**
     * 代碼說明 CodeDataValueDesc2
     * */
    private String comment;

    /**
     * 代碼說明-2 comments
     * */
    private String comment2;

    /**
     * 關聯性上層代碼之 ID parentDataId
     * */
    private String parentId;

    /** 第一篩選欄位 */
    private String filter1;

    /** 第二篩選欄位 */
    private String filter2;

    /** 第三篩選欄位 */
    private String filter3;

    /** 排序欄位 */
    private Integer order;

    /** 刪除註記 */
    private String deleteFlag;

    /** 關聯性子代碼列表 */
    private List<CodeVo> subCode;

    @Override
    public int compareTo(CodeVo item) {
        if (null == item)
            return -1;
        if (this.code.matches("\\d*") && item.code.matches("\\d*"))
            return Integer.parseInt(this.code) - Integer.parseInt(item.code);
        else
            return this.code.compareTo(item.code);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CodeVo [code=");
        builder.append(code);
        builder.append(", codeName=");
        builder.append(codeName);
        builder.append(", comment=");
        builder.append(comment);
        builder.append(", comment2=");
        builder.append(comment2);
        builder.append(", parentId=");
        builder.append(parentId);
        builder.append(", filter1=");
        builder.append(filter1);
        builder.append(", filter2=");
        builder.append(filter2);
        builder.append(", filter3=");
        builder.append(filter3);
        builder.append(", order=");
        builder.append(order);
        builder.append(", deleteFlag=");
        builder.append(deleteFlag);
        builder.append(", subCode=");
        builder.append(subCode);
        builder.append("]");
        return builder.toString();
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @return the codeName
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @return the comment2
     */
    public String getComment2() {
        return comment2;
    }

    /**
     * @return the parentId
     */
    public String getParentId() {
        return parentId;
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
     * @return the order
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * @return the deleteFlag
     */
    public String getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * @return the subCode
     */
    public List<CodeVo> getSubCode() {
        return subCode;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @param codeName the codeName to set
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @param comment2 the comment2 to set
     */
    public void setComment2(String comment2) {
        this.comment2 = comment2;
    }

    /**
     * @param parentId the parentId to set
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
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
     * @param order the order to set
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * @param deleteFlag the deleteFlag to set
     */
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * @param subCode the subCode to set
     */
    public void setSubCode(List<CodeVo> subCode) {
        this.subCode = subCode;
    }
}
