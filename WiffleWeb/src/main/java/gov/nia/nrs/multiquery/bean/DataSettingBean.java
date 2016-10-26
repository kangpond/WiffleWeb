package gov.nia.nrs.multiquery.bean;

import java.util.Date;

public class DataSettingBean
{
	private String id;
	private Long version;
	private String codeId;
	private String codeDataValue;
	private String codeDataValueDesc;
	private String activeStatus;
	private String parentDataId;
	private String comments;
	private String createUserId;
	private Date createDate;
	private String mainUserId;
	private String maintainProgramId;
	private String maintainHost;
	private Date lastUpdateTime;
	private String codeDataValueDesc2;
	private String flag;
	private Long orderList;
	private String filter1;
	private String filter2;
	private String filter3;
	private String dataFlag;
	private Long txnMark;
	private Date syncTime;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public Long getVersion()
	{
		return version;
	}

	public void setVersion(Long version)
	{
		this.version = version;
	}

	public String getCodeId()
	{
		return codeId;
	}

	public void setCodeId(String codeId)
	{
		this.codeId = codeId;
	}

	public String getCodeDataValue()
	{
		return codeDataValue;
	}

	public void setCodeDataValue(String codeDataValue)
	{
		this.codeDataValue = codeDataValue;
	}

	public String getCodeDataValueDesc()
	{
		return codeDataValueDesc;
	}

	public void setCodeDataValueDesc(String codeDataValueDesc)
	{
		this.codeDataValueDesc = codeDataValueDesc;
	}

	public String getActiveStatus()
	{
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus)
	{
		this.activeStatus = activeStatus;
	}

	public String getParentDataId()
	{
		return parentDataId;
	}

	public void setParentDataId(String parentDataId)
	{
		this.parentDataId = parentDataId;
	}

	public String getComments()
	{
		return comments;
	}

	public void setComments(String comments)
	{
		this.comments = comments;
	}

	public String getCreateUserId()
	{
		return createUserId;
	}

	public void setCreateUserId(String createUserId)
	{
		this.createUserId = createUserId;
	}

	public Date getCreateDate()
	{
		return createDate;
	}

	public void setCreateDate(Date createDate)
	{
		this.createDate = createDate;
	}

	public String getMainUserId()
	{
		return mainUserId;
	}

	public void setMainUserId(String mainUserId)
	{
		this.mainUserId = mainUserId;
	}

	public String getMaintainProgramId()
	{
		return maintainProgramId;
	}

	public void setMaintainProgramId(String maintainProgramId)
	{
		this.maintainProgramId = maintainProgramId;
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

	public String getCodeDataValueDesc2()
	{
		return codeDataValueDesc2;
	}

	public void setCodeDataValueDesc2(String codeDataValueDesc2)
	{
		this.codeDataValueDesc2 = codeDataValueDesc2;
	}

	public String getFlag()
	{
		return flag;
	}

	public void setFlag(String flag)
	{
		this.flag = flag;
	}

	public Long getOrderList()
	{
		return orderList;
	}

	public void setOrderList(Long orderList)
	{
		this.orderList = orderList;
	}

	public String getFilter1()
	{
		return filter1;
	}

	public void setFilter1(String filter1)
	{
		this.filter1 = filter1;
	}

	public String getFilter2()
	{
		return filter2;
	}

	public void setFilter2(String filter2)
	{
		this.filter2 = filter2;
	}

	public String getFilter3()
	{
		return filter3;
	}

	public void setFilter3(String filter3)
	{
		this.filter3 = filter3;
	}

	public String getDataFlag()
	{
		return dataFlag;
	}

	public void setDataFlag(String dataFlag)
	{
		this.dataFlag = dataFlag;
	}

	public Long getTxnMark()
	{
		return txnMark;
	}

	public void setTxnMark(Long txnMark)
	{
		this.txnMark = txnMark;
	}

	public Date getSyncTime()
	{
		return syncTime;
	}

	public void setSyncTime(Date syncTime)
	{
		this.syncTime = syncTime;
	}

	@Override
	public String toString()
	{
		return "DataSettingBean [id=" + id + ", version=" + version + ", codeId=" + codeId + ", codeDataValue="
				+ codeDataValue + ", codeDataValueDesc=" + codeDataValueDesc + ", activeStatus=" + activeStatus
				+ ", parentDataId=" + parentDataId + ", comments=" + comments + ", createUserId=" + createUserId
				+ ", createDate=" + createDate + ", mainUserId=" + mainUserId + ", maintainProgramId="
				+ maintainProgramId + ", maintainHost=" + maintainHost + ", lastUpdateTime=" + lastUpdateTime
				+ ", codeDataValueDesc2=" + codeDataValueDesc2 + ", flag=" + flag + ", orderList=" + orderList
				+ ", filter1=" + filter1 + ", filter2=" + filter2 + ", filter3=" + filter3 + ", dataFlag=" + dataFlag
				+ ", txnMark=" + txnMark + ", syncTime=" + syncTime + "]";
	}

}
