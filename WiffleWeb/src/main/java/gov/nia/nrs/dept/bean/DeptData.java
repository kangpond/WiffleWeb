package gov.nia.nrs.dept.bean;

import java.util.Date;

public class DeptData
{
	private String deptId;
	private String deptName;
	private String deptLevel;
	private String parentDeptId;
	private String revokeMark;
	private String effectiveDate;
	private String revokeDate;
	private String mainUserId;
	private String maintainFunctionId;
	private String maintainHost;
	private Date lastUpdateTime;
	private String deleteFlag;
	private String createDate;
	private String createTime;
	private String createUserId;
	private String address;

	public String getDeptId()
	{
		return deptId;
	}

	public void setDeptId(String deptId)
	{
		this.deptId = deptId;
	}

	public String getDeptName()
	{
		return deptName;
	}

	public void setDeptName(String deptName)
	{
		this.deptName = deptName;
	}

	public String getDeptLevel()
	{
		return deptLevel;
	}

	public void setDeptLevel(String deptLevel)
	{
		this.deptLevel = deptLevel;
	}

	public String getParentDeptId()
	{
		return parentDeptId;
	}

	public void setParentDeptId(String parentDeptId)
	{
		this.parentDeptId = parentDeptId;
	}

	public String getRevokeMark()
	{
		return revokeMark;
	}

	public void setRevokeMark(String revokeMark)
	{
		this.revokeMark = revokeMark;
	}

	public String getEffectiveDate()
	{
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate)
	{
		this.effectiveDate = effectiveDate;
	}

	public String getRevokeDate()
	{
		return revokeDate;
	}

	public void setRevokeDate(String revokeDate)
	{
		this.revokeDate = revokeDate;
	}

	public String getMainUserId()
	{
		return mainUserId;
	}

	public void setMainUserId(String mainUserId)
	{
		this.mainUserId = mainUserId;
	}

	public String getMaintainFunctionId()
	{
		return maintainFunctionId;
	}

	public void setMaintainFunctionId(String maintainFunctionId)
	{
		this.maintainFunctionId = maintainFunctionId;
	}

	public String getMaintainHost()
	{
		return maintainHost;
	}

	public void setMaintainHost(String maintainHost)
	{
		this.maintainHost = maintainHost;
	}

	public Date getLastUpdateTime()
	{
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime)
	{
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getDeleteFlag()
	{
		return deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag)
	{
		this.deleteFlag = deleteFlag;
	}

	public String getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}

	public String getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

	public String getCreateUserId()
	{
		return createUserId;
	}

	public void setCreateUserId(String createUserId)
	{
		this.createUserId = createUserId;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	@Override
	public String toString()
	{
		return "DeptData [deptId=" + deptId + ", deptName=" + deptName + ", deptLevel=" + deptLevel + ", parentDeptId="
				+ parentDeptId + ", revokeMark=" + revokeMark + ", effectiveDate=" + effectiveDate + ", revokeDate="
				+ revokeDate + ", mainUserId=" + mainUserId + ", maintainFunctionId=" + maintainFunctionId
				+ ", maintainHost=" + maintainHost + ", lastUpdateTime=" + lastUpdateTime + ", deleteFlag="
				+ deleteFlag + ", createDate=" + createDate + ", createTime=" + createTime + ", createUserId="
				+ createUserId + ", address=" + address + "]";
	}

}
