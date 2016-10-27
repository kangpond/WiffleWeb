package gov.nia.nrs.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AuditSummaryByFunctionId
 */
@Entity
@Table(name = "AuditSummaryByFunctionId")
public class AuditSummaryByFunctionId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "auditDate", column = @Column(name = "AuditDate", nullable = false, length = 8)),
			@AttributeOverride(name = "functionId", column = @Column(name = "FunctionId", nullable = false, length = 100)),
			@AttributeOverride(name = "type", column = @Column(name = "Type", nullable = false, length = 2)),
			@AttributeOverride(name = "userId", column = @Column(name = "UserId", nullable = false, length = 20)),
			@AttributeOverride(name = "deptId", column = @Column(name = "DeptId", nullable = false, length = 10)) })
	private AuditSummaryByFunctionIdId id;

	@Column(name = "FunctionName", nullable = false, length = 100)
	private String functionName;

	@Column(name = "DeptName", length = 80)
	private String deptName;

	@Column(name = "UserName", length = 80)
	private String userName;

	@Column(name = "Cnt", length = 8)
	private String cnt;

	@Column(name = "SubType", nullable = false, length = 1)
	private String subType;

	public AuditSummaryByFunctionId() {
	}

	public AuditSummaryByFunctionIdId getId() {
		return this.id;
	}

	public void setId(AuditSummaryByFunctionIdId id) {
		this.id = id;
	}

	public String getFunctionName() {
		return this.functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCnt() {
		return this.cnt;
	}

	public void setCnt(String cnt) {
		this.cnt = cnt;
	}

	public String getSubType() {
		return this.subType;
	}

	public void setSubType(String subType) {
		this.subType = subType;
	}

}
