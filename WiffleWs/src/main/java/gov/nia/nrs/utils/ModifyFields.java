package gov.nia.nrs.utils;

import gov.nia.nrs.bean.UserProfile;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;

public class ModifyFields {

	/** 日誌紀錄器 */
    private static final Logger log = Logger.getLogger(ModifyFields.class);

	/** 建檔人員 */
	protected String createUserId;

	/** 建檔人員所屬單位代碼 */
	protected String createDeptId;

//	/** 建檔時間 */
//	protected Date createTime;

	protected String createDate;
	
	protected String createTime;
	
	/** 異動人員 */
	protected String mainUserId;

	/** 異動人員 */
	protected String maintainUserId;

	/** 異動人員所屬單位代碼 */
	protected String maintainDeptId;

	/**
	 * <h3>異動主機</h3>
	 * 多主機資料同步，故需註明主機來源<br/>
	 * 例如：<br/>
	 * CNHKMO: 0L<br/>
	 * NIAIMM: 0J<br/>
	 */
    @Value("${maintain-host}")
    protected String maintainHost;

	/** 異動程式 */
//	protected String maintainProgramId;
	protected String maintainFunctionId;
	

	/** 異動時間 */
	protected Date lastUpdateTime;
	
	
	
	/**
	 * <h3>更新 insert 時所需異動紀錄欄位資訊</h3>
	 * 
	 * @param target 欲更新之物件
	 * @param userInfo 更新時所需之使用者資訊
	 * @param programId 使用程式代號
	 * @param insertTime 新增時間，若傳遞 null，則使用當下時間
	 * @throws NiiCommonException
	 */
	public static void complementInsertInfo(Object target, UserProfile userInfo, Date insertTime) throws RuntimeException {
		if (null == target) {
			String msg = "更新 insert 時所需異動紀錄欄位資訊，目標物件不可為 null！";
			log.error(msg);
			throw new RuntimeException(msg);
		} else if (null == userInfo) {
			String msg = "更新 insert 時所需異動紀錄欄位資訊，使用者資訊不可為 null！";
			log.error(msg);
			throw new RuntimeException(msg);
		} else if (null == userInfo.getMaintainFunctionId() || userInfo.getMaintainFunctionId().trim().length() == 0) {
			String msg = "更新 insert 時所需異動紀錄欄位資訊，使用程式代號不可為 null！";
			log.error(msg);
			throw new RuntimeException(msg);
		}else if (null == insertTime) {
			insertTime = new Date();
		}

		ModifyFields modifyRecord = new ModifyFields();
		modifyRecord.createUserId = userInfo.getUserId();
		modifyRecord.createDeptId = userInfo.getDeptId();
//		modifyRecord.createTime = insertTime;
		modifyRecord.createDate = DateUtils.getSysDate();
		modifyRecord.createTime = DateUtils.getTimeStr(insertTime);
		modifyRecord.mainUserId = userInfo.getUserId();
		modifyRecord.maintainUserId = userInfo.getUserId();
		modifyRecord.maintainDeptId = userInfo.getDeptId();
		modifyRecord.maintainFunctionId = userInfo.getMaintainFunctionId();
		modifyRecord.lastUpdateTime = insertTime;

		try {
			BeanClone.clone(modifyRecord, target);
		} catch (Exception e) {
			String msg = "更新 insert 時所需異動紀錄欄位資訊，複製欄位資訊異常！";
			log.error(msg, e);
			throw new RuntimeException(msg, e);
		}
	}
	
	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the createTime
	 */
	public String getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	/**
	 * <h3>更新 update 時所需異動紀錄欄位資訊</h3>
	 * 
	 * @param target 欲更新之物件
	 * @param userInfo 更新時所需之使用者資訊
	 * @param programId 使用程式代號
	 * @param updateTime 異動時間，若傳遞 null，則使用當下時間
	 * @throws NiiCommonException
	 */
	public static void complementUpdateInfo(Object target, UserProfile userInfo, Date updateTime)
			throws RuntimeException {
		if (null == target) {
			String msg = "更新 update 時所需異動紀錄欄位資訊，目標物件不可為 null！";
			log.error(msg);
			throw new RuntimeException(msg);
		} else if (null == userInfo) {
			String msg = "更新 update 時所需異動紀錄欄位資訊，使用者資訊不可為 null！";
			log.error(msg);
			throw new RuntimeException(msg);
		} else if (null == userInfo.getMaintainFunctionId() || userInfo.getMaintainFunctionId().trim().length() == 0) {
			String msg = "更新 update 時所需異動紀錄欄位資訊，使用程式代號不可為 null！";
			log.error(msg);
			throw new RuntimeException(msg);
		} else if (null == updateTime) {
			updateTime = new Date();
		}

		ModifyFields modifyRecord = new ModifyFields();
		modifyRecord.mainUserId = userInfo.getUserId();
		modifyRecord.maintainUserId = userInfo.getUserId();
		modifyRecord.maintainDeptId = userInfo.getDeptId();
		modifyRecord.maintainFunctionId = userInfo.getMaintainFunctionId();
		modifyRecord.lastUpdateTime = updateTime;
		try {
			BeanClone.clone(modifyRecord, target);
		} catch (Exception e) {
			String msg = "更新 update 時所需異動紀錄欄位資訊，複製欄位資訊異常！";
			log.error(msg, e);
			throw new RuntimeException(msg, e);
		}
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateDeptId() {
		return createDeptId;
	}

	public void setCreateDeptId(String createDeptId) {
		this.createDeptId = createDeptId;
	}

//	public Date getCreateTime() {
//		return createTime;
//	}
//
//	public void setCreateTime(Date createTime) {
//		this.createTime = createTime;
//	}

	public String getMainUserId() {
		return mainUserId;
	}

	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
	}

	public String getMaintainUserId() {
		return maintainUserId;
	}

	public void setMaintainUserId(String maintainUserId) {
		this.maintainUserId = maintainUserId;
	}

	public String getMaintainDeptId() {
		return maintainDeptId;
	}

	public void setMaintainDeptId(String maintainDeptId) {
		this.maintainDeptId = maintainDeptId;
	}

//	public String getMaintainProgramId() {
//		return maintainProgramId;
//	}
//
//	public void setMaintainProgramId(String maintainProgramId) {
//		this.maintainProgramId = maintainProgramId;
//	}

	/**
	 * @return the maintainFunctionId
	 */
	public String getMaintainFunctionId() {
		return maintainFunctionId;
	}

	/**
	 * @param maintainFunctionId the maintainFunctionId to set
	 */
	public void setMaintainFunctionId(String maintainFunctionId) {
		this.maintainFunctionId = maintainFunctionId;
	}
	
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * @return the maintainHost
	 */
	public String getMaintainHost() {
		return maintainHost;
	}

	/**
	 * @param maintainHost the maintainHost to set
	 */
	public void setMaintainHost(String maintainHost) {
		this.maintainHost = maintainHost;
	}
	
	
}
