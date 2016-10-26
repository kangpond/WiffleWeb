package gov.nia.nrs.domain;

import java.util.Date;

/**
 * UserApplyFunction
 */
public class UserApplyFunction implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private UserApplyFunctionId id;

    private String createDate;

    private String createTime;

    private String createUserId;

    private String deleteFlag;

    private Date lastUpdateTime;

    private String mainUserId;

    private String maintainFunctionId;

    private String maintainHost;

    public UserApplyFunction() {}

    public UserApplyFunctionId getId() {
        return this.id;
    }

    public void setId(UserApplyFunctionId id) {
        this.id = id;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public String getDeleteFlag() {
        return this.deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getMainUserId() {
        return this.mainUserId;
    }

    public void setMainUserId(String mainUserId) {
        this.mainUserId = mainUserId;
    }

    public String getMaintainFunctionId() {
        return this.maintainFunctionId;
    }

    public void setMaintainFunctionId(String maintainFunctionId) {
        this.maintainFunctionId = maintainFunctionId;
    }

    public String getMaintainHost() {
        return this.maintainHost;
    }

    public void setMaintainHost(String maintainHost) {
        this.maintainHost = maintainHost;
    }



}
