package gov.nia.nrs.domain.iis;

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Variants
 */
@Entity
@Table(name = "Variants")
public class Variants implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "rank1", column = @Column(name = "Rank1", nullable = false, length = 4)),
			@AttributeOverride(name = "serialNo", column = @Column(name = "SerialNo", nullable = false, precision = 7, scale = 0)) })
	private VariantsId id;

	@Column(name = "Rank2", length = 4)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String rank2;

	@Column(name = "Rank3", length = 4)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String rank3;

	@Column(name = "Rank4", length = 4)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String rank4;

	@Column(name = "Rank5", length = 4)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String rank5;

	@Column(name = "Rank6", length = 4)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String rank6;

	@Column(name = "Rank7", length = 4)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String rank7;

	@Column(name = "Rank8", length = 4)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String rank8;

	@Column(name = "Rank9", length = 4)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String rank9;

	@Column(name = "Rank10", length = 4)
	@org.hibernate.annotations.Type(type = "gov.nia.nrs.system.dialect.NStringUserType")
	private String rank10;

	@Column(name = "EstablishTime", length = 23)
	private Date establishTime;

	@Column(name = "ImportTime", length = 23)
	private Date importTime;

	@Column(name = "DeleteFlag", nullable = false, length = 1)
	private String deleteFlag;

	@Column(name = "MainUserId", nullable = false, length = 10)
	private String mainUserId;

	@Column(name = "MaintainProgramId", nullable = false, length = 10)
	private String maintainProgramId;

	@Column(name = "MaintainHost", nullable = false, length = 2)
	private String maintainHost;

	@Column(name = "LastUpdateTime", nullable = false, length = 23)
	private Date lastUpdateTime;

	public Variants() {
	}

	public VariantsId getId() {
		return this.id;
	}

	public void setId(VariantsId id) {
		this.id = id;
	}

	public String getRank2() {
		return this.rank2;
	}

	public void setRank2(String rank2) {
		this.rank2 = rank2;
	}

	public String getRank3() {
		return this.rank3;
	}

	public void setRank3(String rank3) {
		this.rank3 = rank3;
	}

	public String getRank4() {
		return this.rank4;
	}

	public void setRank4(String rank4) {
		this.rank4 = rank4;
	}

	public String getRank5() {
		return this.rank5;
	}

	public void setRank5(String rank5) {
		this.rank5 = rank5;
	}

	public String getRank6() {
		return this.rank6;
	}

	public void setRank6(String rank6) {
		this.rank6 = rank6;
	}

	public String getRank7() {
		return this.rank7;
	}

	public void setRank7(String rank7) {
		this.rank7 = rank7;
	}

	public String getRank8() {
		return this.rank8;
	}

	public void setRank8(String rank8) {
		this.rank8 = rank8;
	}

	public String getRank9() {
		return this.rank9;
	}

	public void setRank9(String rank9) {
		this.rank9 = rank9;
	}

	public String getRank10() {
		return this.rank10;
	}

	public void setRank10(String rank10) {
		this.rank10 = rank10;
	}

	public Date getEstablishTime() {
		return this.establishTime;
	}

	public void setEstablishTime(Date establishTime) {
		this.establishTime = establishTime;
	}

	public Date getImportTime() {
		return this.importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	public String getDeleteFlag() {
		return this.deleteFlag;
	}

	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public String getMainUserId() {
		return this.mainUserId;
	}

	public void setMainUserId(String mainUserId) {
		this.mainUserId = mainUserId;
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
