package gov.nia.nrs.domain.iis;

/**
 * HouseholdMarriageId
 */
public class HouseholdMarriageId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private String personId;
	private String announceDate;
	private String announceTime;
	private String code;

	public HouseholdMarriageId() {
	}

	public HouseholdMarriageId(String personId, String announceDate,
			String announceTime, String code) {
		this.personId = personId;
		this.announceDate = announceDate;
		this.announceTime = announceTime;
		this.code = code;
	}

	public String getPersonId() {
		return this.personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getAnnounceDate() {
		return this.announceDate;
	}

	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}

	public String getAnnounceTime() {
		return this.announceTime;
	}

	public void setAnnounceTime(String announceTime) {
		this.announceTime = announceTime;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof HouseholdMarriageId))
			return false;
		HouseholdMarriageId castOther = (HouseholdMarriageId) other;

		return ((this.getPersonId() == castOther.getPersonId()) || (this
				.getPersonId() != null && castOther.getPersonId() != null && this
				.getPersonId().equals(castOther.getPersonId())))
				&& ((this.getAnnounceDate() == castOther.getAnnounceDate()) || (this
						.getAnnounceDate() != null
						&& castOther.getAnnounceDate() != null && this
						.getAnnounceDate().equals(castOther.getAnnounceDate())))
				&& ((this.getAnnounceTime() == castOther.getAnnounceTime()) || (this
						.getAnnounceTime() != null
						&& castOther.getAnnounceTime() != null && this
						.getAnnounceTime().equals(castOther.getAnnounceTime())))
				&& ((this.getCode() == castOther.getCode()) || (this.getCode() != null
						&& castOther.getCode() != null && this.getCode()
						.equals(castOther.getCode())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getPersonId() == null ? 0 : this.getPersonId().hashCode());
		result = 37
				* result
				+ (getAnnounceDate() == null ? 0 : this.getAnnounceDate()
						.hashCode());
		result = 37
				* result
				+ (getAnnounceTime() == null ? 0 : this.getAnnounceTime()
						.hashCode());
		result = 37 * result
				+ (getCode() == null ? 0 : this.getCode().hashCode());
		return result;
	}

}
