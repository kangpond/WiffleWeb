package gov.nia.nrs.domain.iis;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VariantsId
 */
@Embeddable
public class VariantsId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "Rank1", nullable = false, length = 4)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String rank1;

	@Column(name = "SerialNo", nullable = false, precision = 7, scale = 0)
	private Integer serialNo;

	public VariantsId() {
	}

	public String getRank1() {
		return this.rank1;
	}

	public void setRank1(String rank1) {
		this.rank1 = rank1;
	}

	public Integer getSerialNo() {
		return this.serialNo;
	}

	public void setSerialNo(Integer serialNo) {
		this.serialNo = serialNo;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VariantsId))
			return false;
		VariantsId castOther = (VariantsId) other;

		return ((this.getRank1() == castOther.getRank1()) || (this.getRank1() != null
				&& castOther.getRank1() != null && this.getRank1().equals(
				castOther.getRank1())))
				&& ((this.getSerialNo() == castOther.getSerialNo()) || (this
						.getSerialNo() != null
						&& castOther.getSerialNo() != null && this
						.getSerialNo().equals(castOther.getSerialNo())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getRank1() == null ? 0 : this.getRank1().hashCode());
		result = 37 * result
				+ (getSerialNo() == null ? 0 : this.getSerialNo().hashCode());
		return result;
	}

}
