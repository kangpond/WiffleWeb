package gov.nia.nrs.domain;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SpouseAgeDiff
 */
@Entity
@Table(name = "SpouseAgeDiff")
public class SpouseAgeDiff implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "year", column = @Column(name = "Year", nullable = false, length = 4)),
			@AttributeOverride(name = "month", column = @Column(name = "Month", nullable = false, length = 2)),
			@AttributeOverride(name = "gender", column = @Column(name = "Gender", nullable = false, length = 1)),
			@AttributeOverride(name = "spouseType", column = @Column(name = "SpouseType", nullable = false, length = 1)),
			@AttributeOverride(name = "marryStatus", column = @Column(name = "MarryStatus", nullable = false, length = 1)),
			@AttributeOverride(name = "spAgeDiffInterval", column = @Column(name = "SpAgeDiffInterval", nullable = false, length = 3)) })
	private SpouseAgeDiffId id;

	@Column(name = "SpAgeDiffCount", nullable = false, precision = 8, scale = 0)
	private Integer spAgeDiffCount;

	@Column(name = "MaintainProgramId", length = 10)
	private String maintainProgramId;

	@Column(name = "MaintainHost", length = 2)
	private String maintainHost;

	@Column(name = "LastUpdateTime", length = 23)
	private Date lastUpdateTime;

	public SpouseAgeDiff() {
	}

	public SpouseAgeDiffId getId() {
		return this.id;
	}

	public void setId(SpouseAgeDiffId id) {
		this.id = id;
	}

	public Integer getSpAgeDiffCount() {
		return this.spAgeDiffCount;
	}

	public void setSpAgeDiffCount(Integer spAgeDiffCount) {
		this.spAgeDiffCount = spAgeDiffCount;
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
