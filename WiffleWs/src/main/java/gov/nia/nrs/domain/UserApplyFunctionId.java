package gov.nia.nrs.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserApplyFunctionId
 */
@Embeddable
public class UserApplyFunctionId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String functionId;
	private String uuid;

	public UserApplyFunctionId() {
	}

	public UserApplyFunctionId(String functionId, String uuid) {
		this.functionId = functionId;
		this.uuid = uuid;
	}

	@Column(name = "FunctionId", nullable = false, length = 100)
	public String getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	@Column(name = "Uuid", nullable = false, length = 32)
	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserApplyFunctionId))
			return false;
		UserApplyFunctionId castOther = (UserApplyFunctionId) other;

		return ((this.getFunctionId() == castOther.getFunctionId()) || (this
				.getFunctionId() != null && castOther.getFunctionId() != null && this
				.getFunctionId().equals(castOther.getFunctionId())))
				&& ((this.getUuid() == castOther.getUuid()) || (this.getUuid() != null
						&& castOther.getUuid() != null && this.getUuid()
						.equals(castOther.getUuid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getFunctionId() == null ? 0 : this.getFunctionId()
						.hashCode());
		result = 37 * result
				+ (getUuid() == null ? 0 : this.getUuid().hashCode());
		return result;
	}

}
