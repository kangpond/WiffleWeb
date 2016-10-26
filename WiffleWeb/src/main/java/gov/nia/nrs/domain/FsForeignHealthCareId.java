package gov.nia.nrs.domain;


/**
 * FsForeignHealthCareId
 */
public class FsForeignHealthCareId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String firstReceiveNo;
	private String residentIdNo;

	public FsForeignHealthCareId() {
	}

	public FsForeignHealthCareId(String firstReceiveNo, String residentIdNo) {
		this.firstReceiveNo = firstReceiveNo;
		this.residentIdNo = residentIdNo;
	}

	public String getFirstReceiveNo() {
		return this.firstReceiveNo;
	}

	public void setFirstReceiveNo(String firstReceiveNo) {
		this.firstReceiveNo = firstReceiveNo;
	}

	public String getResidentIdNo() {
		return this.residentIdNo;
	}

	public void setResidentIdNo(String residentIdNo) {
		this.residentIdNo = residentIdNo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof FsForeignHealthCareId))
			return false;
		FsForeignHealthCareId castOther = (FsForeignHealthCareId) other;

		return ((this.getFirstReceiveNo() == castOther.getFirstReceiveNo()) || (this
				.getFirstReceiveNo() != null
				&& castOther.getFirstReceiveNo() != null && this
				.getFirstReceiveNo().equals(castOther.getFirstReceiveNo())))
				&& ((this.getResidentIdNo() == castOther.getResidentIdNo()) || (this
						.getResidentIdNo() != null
						&& castOther.getResidentIdNo() != null && this
						.getResidentIdNo().equals(castOther.getResidentIdNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getFirstReceiveNo() == null ? 0 : this.getFirstReceiveNo()
						.hashCode());
		result = 37
				* result
				+ (getResidentIdNo() == null ? 0 : this.getResidentIdNo()
						.hashCode());
		return result;
	}

}
