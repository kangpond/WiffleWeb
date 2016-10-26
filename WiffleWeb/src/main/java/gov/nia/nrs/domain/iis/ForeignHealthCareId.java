package gov.nia.nrs.domain.iis;


/**
 * ForeignHealthCareId
 */
public class ForeignHealthCareId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String firstReceiveNo;
	private String residentIdNo;
	private String residentIdNo1;

	public ForeignHealthCareId() {
	}

	public ForeignHealthCareId(String firstReceiveNo, String residentIdNo,
			String residentIdNo1) {
		this.firstReceiveNo = firstReceiveNo;
		this.residentIdNo = residentIdNo;
		this.residentIdNo1 = residentIdNo1;
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

	public String getResidentIdNo1() {
		return this.residentIdNo1;
	}

	public void setResidentIdNo1(String residentIdNo1) {
		this.residentIdNo1 = residentIdNo1;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ForeignHealthCareId))
			return false;
		ForeignHealthCareId castOther = (ForeignHealthCareId) other;

		return ((this.getFirstReceiveNo() == castOther.getFirstReceiveNo()) || (this
				.getFirstReceiveNo() != null
				&& castOther.getFirstReceiveNo() != null && this
				.getFirstReceiveNo().equals(castOther.getFirstReceiveNo())))
				&& ((this.getResidentIdNo() == castOther.getResidentIdNo()) || (this
						.getResidentIdNo() != null
						&& castOther.getResidentIdNo() != null && this
						.getResidentIdNo().equals(castOther.getResidentIdNo())))
				&& ((this.getResidentIdNo1() == castOther.getResidentIdNo1()) || (this
						.getResidentIdNo1() != null
						&& castOther.getResidentIdNo1() != null && this
						.getResidentIdNo1()
						.equals(castOther.getResidentIdNo1())));
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
		result = 37
				* result
				+ (getResidentIdNo1() == null ? 0 : this.getResidentIdNo1()
						.hashCode());
		return result;
	}

}
