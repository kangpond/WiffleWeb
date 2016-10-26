package gov.nia.nrs.domain;

import java.util.Date;

/**
 * News
 */
public class News implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Integer newsSeq;
	private String title;
	private String startDate;
	private String endDate;
	private String priority;
	private String content;
	private String deptId;
	private String userId;
	private String tel;
	private String createDate;
	private String deleteFlag;
	private String createUserId;
	private String createProgramId;
	private Date createTime;
	private String maintainHost;
	private String mainUserId;
	private String maintainProgramId;
	private Date lastUpdateTime;

	public News() {
	}

	public News(Integer newsSeq, String deleteFlag, String createUserId,
			String createProgramId, Date createTime, String maintainHost,
			String mainUserId, String maintainProgramId, Date lastUpdateTime) {
		this.newsSeq = newsSeq;
		this.deleteFlag = deleteFlag;
		this.createUserId = createUserId;
		this.createProgramId = createProgramId;
		this.createTime = createTime;
		this.maintainHost = maintainHost;
		this.mainUserId = mainUserId;
		this.maintainProgramId = maintainProgramId;
		this.lastUpdateTime = lastUpdateTime;
	}

	public News(Integer newsSeq, String title, String startDate,
			String endDate, String priority, String content, String deptId,
			String userId, String tel, String createDate, String deleteFlag,
			String createUserId, String createProgramId, Date createTime,
			String maintainHost, String mainUserId, String maintainProgramId,
			Date lastUpdateTime) {
		this.newsSeq = newsSeq;
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.priority = priority;
		this.content = content;
		this.deptId = deptId;
		this.userId = userId;
		this.tel = tel;
		this.createDate = createDate;
		this.deleteFlag = deleteFlag;
		this.createUserId = createUserId;
		this.createProgramId = createProgramId;
		this.createTime = createTime;
		this.maintainHost = maintainHost;
		this.mainUserId = mainUserId;
		this.maintainProgramId = maintainProgramId;
		this.lastUpdateTime = lastUpdateTime;
	}

	/**
	 * @return the newsSeq
	 */
	public Integer getNewsSeq() {
		return newsSeq;
	}

	/**
	 * @param newsSeq the newsSeq to set
	 */
	public void setNewsSeq(Integer newsSeq) {
		this.newsSeq = newsSeq;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the priority
	 */
	public String getPriority() {
		return priority;
	}

	/**
	 * @param priority the priority to set
	 */
	public void setPriority(String priority) {
		this.priority = priority;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the deptId
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
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
	 * @return the deleteFlag
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * @param deleteFlag the deleteFlag to set
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * @return the createUserId
	 */
	public String getCreateUserId() {
		return createUserId;
	}

	/**
	 * @param createUserId the createUserId to set
	 */
	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	/**
	 * @return the createProgramId
	 */
	public String getCreateProgramId() {
		return createProgramId;
	}

	/**
	 * @param createProgramId the createProgramId to set
	 */
	public void setCreateProgramId(String createProgramId) {
		this.createProgramId = createProgramId;
	}

	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	/**
	 * @return the mainUserId
	 */
	public String getMainUserId() {
		return mainUserId;
	}

	/**
	 * @param mainUserId the mainUserId to set
	 */
	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
	}

	/**
	 * @return the maintainProgramId
	 */
	public String getMaintainProgramId() {
		return maintainProgramId;
	}

	/**
	 * @param maintainProgramId the maintainProgramId to set
	 */
	public void setMaintainProgramId(String maintainProgramId) {
		this.maintainProgramId = maintainProgramId;
	}

	/**
	 * @return the lastUpdateTime
	 */
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}

	/**
	 * @param lastUpdateTime the lastUpdateTime to set
	 */
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
