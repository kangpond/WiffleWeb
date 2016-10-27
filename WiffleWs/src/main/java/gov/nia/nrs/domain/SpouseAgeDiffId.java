package gov.nia.nrs.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SpouseAgeDiffId
 */
@Embeddable
public class SpouseAgeDiffId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "Year", nullable = false, length = 4)
	private String year;

	@Column(name = "Month", nullable = false, length = 2)
	private String month;

	@Column(name = "Gender", nullable = false, length = 1)
	private String gender;

	@Column(name = "SpouseType", nullable = false, length = 1)
	private String spouseType;

	@Column(name = "MarryStatus", nullable = false, length = 1)
	private String marryStatus;

	@Column(name = "SpAgeDiffInterval", nullable = false, length = 3)
	private String spAgeDiffInterval;

	public SpouseAgeDiffId() {
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpouseType() {
		return this.spouseType;
	}

	public void setSpouseType(String spouseType) {
		this.spouseType = spouseType;
	}

	public String getMarryStatus() {
		return this.marryStatus;
	}

	public void setMarryStatus(String marryStatus) {
		this.marryStatus = marryStatus;
	}

	public String getSpAgeDiffInterval() {
		return this.spAgeDiffInterval;
	}

	public void setSpAgeDiffInterval(String spAgeDiffInterval) {
		this.spAgeDiffInterval = spAgeDiffInterval;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SpouseAgeDiffId))
			return false;
		SpouseAgeDiffId castOther = (SpouseAgeDiffId) other;

		return ((this.getYear() == castOther.getYear()) || (this.getYear() != null
				&& castOther.getYear() != null && this.getYear().equals(
				castOther.getYear())))
				&& ((this.getMonth() == castOther.getMonth()) || (this
						.getMonth() != null && castOther.getMonth() != null && this
						.getMonth().equals(castOther.getMonth())))
				&& ((this.getGender() == castOther.getGender()) || (this
						.getGender() != null && castOther.getGender() != null && this
						.getGender().equals(castOther.getGender())))
				&& ((this.getSpouseType() == castOther.getSpouseType()) || (this
						.getSpouseType() != null
						&& castOther.getSpouseType() != null && this
						.getSpouseType().equals(castOther.getSpouseType())))
				&& ((this.getMarryStatus() == castOther.getMarryStatus()) || (this
						.getMarryStatus() != null
						&& castOther.getMarryStatus() != null && this
						.getMarryStatus().equals(castOther.getMarryStatus())))
				&& ((this.getSpAgeDiffInterval() == castOther
						.getSpAgeDiffInterval()) || (this
						.getSpAgeDiffInterval() != null
						&& castOther.getSpAgeDiffInterval() != null && this
						.getSpAgeDiffInterval().equals(
								castOther.getSpAgeDiffInterval())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getYear() == null ? 0 : this.getYear().hashCode());
		result = 37 * result
				+ (getMonth() == null ? 0 : this.getMonth().hashCode());
		result = 37 * result
				+ (getGender() == null ? 0 : this.getGender().hashCode());
		result = 37
				* result
				+ (getSpouseType() == null ? 0 : this.getSpouseType()
						.hashCode());
		result = 37
				* result
				+ (getMarryStatus() == null ? 0 : this.getMarryStatus()
						.hashCode());
		result = 37
				* result
				+ (getSpAgeDiffInterval() == null ? 0 : this
						.getSpAgeDiffInterval().hashCode());
		return result;
	}

}
