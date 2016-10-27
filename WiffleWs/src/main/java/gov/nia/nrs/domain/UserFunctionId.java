package gov.nia.nrs.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserFunctionId
 */
@Embeddable
public class UserFunctionId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String functionId;
	private String userId;

	public UserFunctionId() {
	}

	public UserFunctionId(String functionId, String userId) {
		this.functionId = functionId;
		this.userId = userId;
	}

	@Column(name = "FunctionId", nullable = false, length = 100)
	public String getFunctionId() {
		return this.functionId;
	}

	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}

	@Column(name = "UserId", nullable = false, length = 10)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserFunctionId))
			return false;
		UserFunctionId castOther = (UserFunctionId) other;

		return ((this.getFunctionId() == castOther.getFunctionId()) || (this
				.getFunctionId() != null && castOther.getFunctionId() != null && this
				.getFunctionId().equals(castOther.getFunctionId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getFunctionId() == null ? 0 : this.getFunctionId()
						.hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		return result;
	}

}
