package gov.nia.nrs.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AuditSummaryByFunctionIdId
 */
@Embeddable
public class AuditSummaryByFunctionIdId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "AuditDate", nullable = false, length = 8)
	private String auditDate;

	@Column(name = "FunctionId", nullable = false, length = 100)
	private String functionId;

	@Column(name = "Type", nullable = false, length = 2)
	private String type;

	@Column(name = "UserId", nullable = false, length = 20)
	private String userId;

	@Column(name = "DeptId", nullable = false, length = 10)
	private String deptId;

	public AuditSummaryByFunctionIdId() {
	}

	public String getAuditDate() {
		return this.auditDate;
	}

	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}

	public String getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDeptId() {
		return this.deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AuditSummaryByFunctionIdId))
			return false;
		AuditSummaryByFunctionIdId castOther = (AuditSummaryByFunctionIdId) other;

		return ((this.getAuditDate() == castOther.getAuditDate()) || (this
				.getAuditDate() != null && castOther.getAuditDate() != null && this
				.getAuditDate().equals(castOther.getAuditDate())))
				&& ((this.getFunctionId() == castOther.getFunctionId()) || (this
						.getFunctionId() != null
						&& castOther.getFunctionId() != null && this
						.getFunctionId().equals(castOther.getFunctionId())))
				&& ((this.getType() == castOther.getType()) || (this.getType() != null
						&& castOther.getType() != null && this.getType()
						.equals(castOther.getType())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())))
				&& ((this.getDeptId() == castOther.getDeptId()) || (this
						.getDeptId() != null && castOther.getDeptId() != null && this
						.getDeptId().equals(castOther.getDeptId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getAuditDate() == null ? 0 : this.getAuditDate().hashCode());
		result = 37
				* result
				+ (getFunctionId() == null ? 0 : this.getFunctionId()
						.hashCode());
		result = 37 * result
				+ (getType() == null ? 0 : this.getType().hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getDeptId() == null ? 0 : this.getDeptId().hashCode());
		return result;
	}

}
