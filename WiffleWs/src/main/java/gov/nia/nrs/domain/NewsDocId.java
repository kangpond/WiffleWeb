package gov.nia.nrs.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * NewsDocId
 */
@Embeddable
public class NewsDocId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "NewsSeq", nullable = false, precision = 6, scale = 0)
	private Integer newsSeq;

	@Column(name = "Uuid", nullable = false, length = 32)
	private String uuid;

	public NewsDocId() {
	}

	public Integer getNewsSeq() {
		return this.newsSeq;
	}

	public void setNewsSeq(Integer newsSeq) {
		this.newsSeq = newsSeq;
	}

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
		if (!(other instanceof NewsDocId))
			return false;
		NewsDocId castOther = (NewsDocId) other;

		return ((this.getNewsSeq() == castOther.getNewsSeq()) || (this
				.getNewsSeq() != null && castOther.getNewsSeq() != null && this
				.getNewsSeq().equals(castOther.getNewsSeq())))
				&& ((this.getUuid() == castOther.getUuid()) || (this.getUuid() != null
						&& castOther.getUuid() != null && this.getUuid()
						.equals(castOther.getUuid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getNewsSeq() == null ? 0 : this.getNewsSeq().hashCode());
		result = 37 * result
				+ (getUuid() == null ? 0 : this.getUuid().hashCode());
		return result;
	}

}
