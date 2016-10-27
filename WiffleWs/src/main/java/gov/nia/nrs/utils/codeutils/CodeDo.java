package gov.nia.nrs.utils.codeutils;

import java.util.Date;

public class CodeDo {

    /** 代碼類別編號 */
    private String category;

    /** 代碼 */
    private String code;

    /** 代碼名稱 */
    private String codeName;

    /** 代碼說明 */
    private String comment;

    /** 代碼說明-2 */
    private String comment2;

    /** 關聯性上層代碼之 ID */
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

    /** 新增使用者 ID */
    private String createUserId;

    /** 新增日期 */
    private Date createTime;

    /** 修改使用者 ID */
    private String mainUserId;

    /** 修改程式名稱 */
    private String maintainProgramId;

    /** 修改登入 IP */
    private String maintainHost;

    /** 異動時間 */
    private Date lastUpdateTime;

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CodeDo [category=");
        builder.append(category);
        builder.append(", code=");
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
        builder.append(", createUserId=");
        builder.append(createUserId);
        builder.append(", createTime=");
        builder.append(createTime);
        builder.append(", mainUserId=");
        builder.append(mainUserId);
        builder.append(", maintainProgramId=");
        builder.append(maintainProgramId);
        builder.append(", maintainHost=");
        builder.append(maintainHost);
        builder.append(", lastUpdateTime=");
        builder.append(lastUpdateTime);
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
     * @return the createUserId
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * @return the createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @return the mainUserId
     */
    public String getMainUserId() {
        return mainUserId;
    }

    /**
     * @return the maintainProgramId
     */
    public String getMaintainProgramId() {
        return maintainProgramId;
    }

    /**
     * @return the maintainHost
     */
    public String getMaintainHost() {
        return maintainHost;
    }

    /**
     * @return the lastUpdateTime
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
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
     * @param createUserId the createUserId to set
     */
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * @param createTime the createTime to set
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @param mainUserId the mainUserId to set
     */
    public void setMainUserId(String mainUserId) {
        this.mainUserId = mainUserId;
    }

    /**
     * @param maintainProgramId the maintainProgramId to set
     */
    public void setMaintainProgramId(String maintainProgramId) {
        this.maintainProgramId = maintainProgramId;
    }

    /**
     * @param maintainHost the maintainHost to set
     */
    public void setMaintainHost(String maintainHost) {
        this.maintainHost = maintainHost;
    }

    /**
     * @param lastUpdateTime the lastUpdateTime to set
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }
}
