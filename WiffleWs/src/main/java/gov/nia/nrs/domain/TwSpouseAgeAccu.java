package gov.nia.nrs.domain;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TwSpouseAgeAccu
 */
@Entity
@Table(name = "TwSpouseAgeAccu")
public class TwSpouseAgeAccu implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "year", column = @Column(name = "Year", nullable = false, length = 4)),
			@AttributeOverride(name = "month", column = @Column(name = "Month", nullable = false, length = 2)),
			@AttributeOverride(name = "gender", column = @Column(name = "Gender", nullable = false, length = 1)),
			@AttributeOverride(name = "spouseType", column = @Column(name = "SpouseType", nullable = false, length = 1)),
			@AttributeOverride(name = "marryStatus", column = @Column(name = "MarryStatus", nullable = false, length = 1)),
			@AttributeOverride(name = "twSpAgeInterval", column = @Column(name = "TwSpAgeInterval", nullable = false, length = 3)) })
	private TwSpouseAgeAccuId id;

	@Column(name = "TwSpCount", nullable = false, precision = 8, scale = 0)
	private Integer twSpCount;

	@Column(name = "MaintainProgramId", length = 10)
	private String maintainProgramId;

	@Column(name = "MaintainHost", length = 2)
	private String maintainHost;

	@Column(name = "LastUpdateTime", length = 23)
	private Date lastUpdateTime;

	public TwSpouseAgeAccu() {
	}

	public TwSpouseAgeAccuId getId() {
		return this.id;
	}

	public void setId(TwSpouseAgeAccuId id) {
		this.id = id;
	}

	public Integer getTwSpCount() {
		return this.twSpCount;
	}

	public void setTwSpCount(Integer twSpCount) {
		this.twSpCount = twSpCount;
	}

	public String getMaintainProgramId() {
		return this.maintainProgramId;
	}

	public void setMaintainProgramId(String maintainProgramId) {
		this.maintainProgramId = maintainProgramId;
	}

	public String getMaintainHost() {
		return this.maintainHost;
	}

	public void setMaintainHost(String maintainHost) {
		this.maintainHost = maintainHost;
	}

	public Date getLastUpdateTime() {
		return this.lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

}
