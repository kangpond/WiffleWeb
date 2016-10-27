package gov.nia.nrs.domain.imm;



import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Immigrations generated by hbm2java
 */
@Entity
@Table(name="Immigrations"
)
public class Immigrations  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private ImmigrationsId id;
    private String passengerType;
    private String immigWay;
    private String processDate;
    private Integer immigrateType;
    private Integer port;
    private String flightNo;
    private Integer fromTo;
    private String inspectorId;
    private Integer terminalNo;
    private String terminalLocation;
    private Date immigrateTime;
    private Integer nation;
    private String permitNo;
    private String passportNo;
    private String edCardNo;
    private String customMark;
    private String noVisaMark;
    private String utteringMark;
    private String stayDays;
    private String otherMark;
    private Long matchRatio;
    private String reserved;
    private Date establishTime;
    private Date importTime;
    private String deleteFlag;
    private String mainUserId;
    private String maintainProgramId;
    private String maintainHost;
    private Date lastUpdateTime;
    private String captureDate;
    private Integer captureSerialNo;
    private String secondDocType;
    private String secondDocCategory;
    private String secondDocId;
    private String apisMatchFlag;
    private Date inspectLoginDate;
    private Integer txnMark;
    private Date syncTime;
    private String flightFlag;
    private String chineseName;
    private String englishName;
    private String personId;
    private String bioCmpRcode;
    private String bioCaptureState;
    private String applicantType;
    private String positionType;
    private String reasonType;

    public Immigrations() {}

	
    public Immigrations(ImmigrationsId id, String passengerType, String immigWay, String processDate, Integer immigrateType, Integer port, String flightNo, Integer fromTo, String inspectorId, Integer terminalNo, String terminalLocation, Date immigrateTime, Integer nation, String permitNo, String passportNo, String edCardNo, String customMark, String noVisaMark, String utteringMark, String stayDays, String otherMark, String deleteFlag, String mainUserId, String maintainProgramId, String maintainHost, Date lastUpdateTime) {
        this.id = id;
        this.passengerType = passengerType;
        this.immigWay = immigWay;
        this.processDate = processDate;
        this.immigrateType = immigrateType;
        this.port = port;
        this.flightNo = flightNo;
        this.fromTo = fromTo;
        this.inspectorId = inspectorId;
        this.terminalNo = terminalNo;
        this.terminalLocation = terminalLocation;
        this.immigrateTime = immigrateTime;
        this.nation = nation;
        this.permitNo = permitNo;
        this.passportNo = passportNo;
        this.edCardNo = edCardNo;
        this.customMark = customMark;
        this.noVisaMark = noVisaMark;
        this.utteringMark = utteringMark;
        this.stayDays = stayDays;
        this.otherMark = otherMark;
        this.deleteFlag = deleteFlag;
        this.mainUserId = mainUserId;
        this.maintainProgramId = maintainProgramId;
        this.maintainHost = maintainHost;
        this.lastUpdateTime = lastUpdateTime;
    }
    public Immigrations(ImmigrationsId id, String passengerType, String immigWay, String processDate, Integer immigrateType, Integer port, String flightNo, Integer fromTo, String inspectorId, Integer terminalNo, String terminalLocation, Date immigrateTime, Integer nation, String permitNo, String passportNo, String edCardNo, String customMark, String noVisaMark, String utteringMark, String stayDays, String otherMark, Long matchRatio, String reserved, Date establishTime, Date importTime, String deleteFlag, String mainUserId, String maintainProgramId, String maintainHost, Date lastUpdateTime, String captureDate, Integer captureSerialNo, String secondDocType, String secondDocCategory, String secondDocId, String apisMatchFlag, Date inspectLoginDate, Integer txnMark, Date syncTime, String flightFlag, String chineseName, String englishName, String personId, String bioCmpRcode, String bioCaptureState, String applicantType, String positionType, String reasonType) {
        this.id = id;
        this.passengerType = passengerType;
        this.immigWay = immigWay;
        this.processDate = processDate;
        this.immigrateType = immigrateType;
        this.port = port;
        this.flightNo = flightNo;
        this.fromTo = fromTo;
        this.inspectorId = inspectorId;
        this.terminalNo = terminalNo;
        this.terminalLocation = terminalLocation;
        this.immigrateTime = immigrateTime;
        this.nation = nation;
        this.permitNo = permitNo;
        this.passportNo = passportNo;
        this.edCardNo = edCardNo;
        this.customMark = customMark;
        this.noVisaMark = noVisaMark;
        this.utteringMark = utteringMark;
        this.stayDays = stayDays;
        this.otherMark = otherMark;
        this.matchRatio = matchRatio;
        this.reserved = reserved;
        this.establishTime = establishTime;
        this.importTime = importTime;
        this.deleteFlag = deleteFlag;
        this.mainUserId = mainUserId;
        this.maintainProgramId = maintainProgramId;
        this.maintainHost = maintainHost;
        this.lastUpdateTime = lastUpdateTime;
        this.captureDate = captureDate;
        this.captureSerialNo = captureSerialNo;
        this.secondDocType = secondDocType;
        this.secondDocCategory = secondDocCategory;
        this.secondDocId = secondDocId;
        this.apisMatchFlag = apisMatchFlag;
        this.inspectLoginDate = inspectLoginDate;
        this.txnMark = txnMark;
        this.syncTime = syncTime;
        this.flightFlag = flightFlag;
        this.chineseName = chineseName;
        this.englishName = englishName;
        this.personId = personId;
        this.bioCmpRcode = bioCmpRcode;
        this.bioCaptureState = bioCaptureState;
        this.applicantType = applicantType;
        this.positionType = positionType;
        this.reasonType = reasonType;
    }
   
    @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="passengerId", column=@Column(name="PassengerId", nullable=false, length=10) ), 
        @AttributeOverride(name="immigrateDate", column=@Column(name="ImmigrateDate", nullable=false, length=8) ), 
        @AttributeOverride(name="immigrateSeq", column=@Column(name="ImmigrateSeq", nullable=false, precision=5, scale=0) ) } )
    public ImmigrationsId getId() {
        return this.id;
    }
    
    public void setId(ImmigrationsId id) {
        this.id = id;
    }

    
    @Column(name="PassengerType", nullable=false, length=1)
    public String getPassengerType() {
        return this.passengerType;
    }
    
    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    
    @Column(name="ImmigWay", nullable=false, length=1)
    public String getImmigWay() {
        return this.immigWay;
    }
    
    public void setImmigWay(String immigWay) {
        this.immigWay = immigWay;
    }

    
    @Column(name="ProcessDate", nullable=false, length=8)
    public String getProcessDate() {
        return this.processDate;
    }
    
    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    
    @Column(name="ImmigrateType", nullable=false, precision=1, scale=0)
    public Integer getImmigrateType() {
        return this.immigrateType;
    }
    
    public void setImmigrateType(Integer immigrateType) {
        this.immigrateType = immigrateType;
    }

    
    @Column(name="Port", nullable=false, precision=2, scale=0)
    public Integer getPort() {
        return this.port;
    }
    
    public void setPort(Integer port) {
        this.port = port;
    }

    
    @Column(name="FlightNo", nullable=false, length=20)
    public String getFlightNo() {
        return this.flightNo;
    }
    
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    
    @Column(name="FromTo", nullable=false, precision=3, scale=0)
    public Integer getFromTo() {
        return this.fromTo;
    }
    
    public void setFromTo(Integer fromTo) {
        this.fromTo = fromTo;
    }

    
    @Column(name="InspectorId", nullable=false, length=5)
    public String getInspectorId() {
        return this.inspectorId;
    }
    
    public void setInspectorId(String inspectorId) {
        this.inspectorId = inspectorId;
    }

    
    @Column(name="TerminalNo", nullable=false, precision=4, scale=0)
    public Integer getTerminalNo() {
        return this.terminalNo;
    }
    
    public void setTerminalNo(Integer terminalNo) {
        this.terminalNo = terminalNo;
    }

    
    @Column(name="TerminalLocation", nullable=false, length=2)
    public String getTerminalLocation() {
        return this.terminalLocation;
    }
    
    public void setTerminalLocation(String terminalLocation) {
        this.terminalLocation = terminalLocation;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ImmigrateTime", nullable=false, length=23)
    public Date getImmigrateTime() {
        return this.immigrateTime;
    }
    
    public void setImmigrateTime(Date immigrateTime) {
        this.immigrateTime = immigrateTime;
    }

    
    @Column(name="Nation", nullable=false, precision=3, scale=0)
    public Integer getNation() {
        return this.nation;
    }
    
    public void setNation(Integer nation) {
        this.nation = nation;
    }

    
    @Column(name="PermitNo", nullable=false, length=12)
    public String getPermitNo() {
        return this.permitNo;
    }
    
    public void setPermitNo(String permitNo) {
        this.permitNo = permitNo;
    }

    
    @Column(name="PassportNo", nullable=false, length=15)
    public String getPassportNo() {
        return this.passportNo;
    }
    
    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    
    @Column(name="EdCardNo", nullable=false, length=10)
    public String getEdCardNo() {
        return this.edCardNo;
    }
    
    public void setEdCardNo(String edCardNo) {
        this.edCardNo = edCardNo;
    }

    
    @Column(name="CustomMark", nullable=false, length=1)
    public String getCustomMark() {
        return this.customMark;
    }
    
    public void setCustomMark(String customMark) {
        this.customMark = customMark;
    }

    
    @Column(name="NoVisaMark", nullable=false, length=1)
    public String getNoVisaMark() {
        return this.noVisaMark;
    }
    
    public void setNoVisaMark(String noVisaMark) {
        this.noVisaMark = noVisaMark;
    }

    
    @Column(name="UtteringMark", nullable=false, length=1)
    public String getUtteringMark() {
        return this.utteringMark;
    }
    
    public void setUtteringMark(String utteringMark) {
        this.utteringMark = utteringMark;
    }

    
    @Column(name="StayDays", nullable=false, length=3)
    public String getStayDays() {
        return this.stayDays;
    }
    
    public void setStayDays(String stayDays) {
        this.stayDays = stayDays;
    }

    
    @Column(name="OtherMark", nullable=false, length=1)
    public String getOtherMark() {
        return this.otherMark;
    }
    
    public void setOtherMark(String otherMark) {
        this.otherMark = otherMark;
    }

    
    @Column(name="MatchRatio", precision=5)
    public Long getMatchRatio() {
        return this.matchRatio;
    }
    
    public void setMatchRatio(Long matchRatio) {
        this.matchRatio = matchRatio;
    }

    
    @Column(name="Reserved", length=30)
    public String getReserved() {
        return this.reserved;
    }
    
    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="EstablishTime", length=23)
    public Date getEstablishTime() {
        return this.establishTime;
    }
    
    public void setEstablishTime(Date establishTime) {
        this.establishTime = establishTime;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ImportTime", length=23)
    public Date getImportTime() {
        return this.importTime;
    }
    
    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }

    
    @Column(name="DeleteFlag", nullable=false, length=1)
    public String getDeleteFlag() {
        return this.deleteFlag;
    }
    
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    
    @Column(name="MainUserId", nullable=false, length=10)
    public String getMainUserId() {
        return this.mainUserId;
    }
    
    public void setMainUserId(String mainUserId) {
        this.mainUserId = mainUserId;
    }

    
    @Column(name="MaintainProgramId", nullable=false, length=10)
    public String getMaintainProgramId() {
        return this.maintainProgramId;
    }
    
    public void setMaintainProgramId(String maintainProgramId) {
        this.maintainProgramId = maintainProgramId;
    }

    
    @Column(name="MaintainHost", nullable=false, length=2)
    public String getMaintainHost() {
        return this.maintainHost;
    }
    
    public void setMaintainHost(String maintainHost) {
        this.maintainHost = maintainHost;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LastUpdateTime", nullable=false, length=23)
    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }
    
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    
    @Column(name="CaptureDate", length=8)
    public String getCaptureDate() {
        return this.captureDate;
    }
    
    public void setCaptureDate(String captureDate) {
        this.captureDate = captureDate;
    }

    
    @Column(name="CaptureSerialNo", precision=5, scale=0)
    public Integer getCaptureSerialNo() {
        return this.captureSerialNo;
    }
    
    public void setCaptureSerialNo(Integer captureSerialNo) {
        this.captureSerialNo = captureSerialNo;
    }

    
    @Column(name="SecondDocType", length=1)
    public String getSecondDocType() {
        return this.secondDocType;
    }
    
    public void setSecondDocType(String secondDocType) {
        this.secondDocType = secondDocType;
    }

    
    @Column(name="SecondDocCategory", length=3)
    public String getSecondDocCategory() {
        return this.secondDocCategory;
    }
    
    public void setSecondDocCategory(String secondDocCategory) {
        this.secondDocCategory = secondDocCategory;
    }

    
    @Column(name="SecondDocId", length=30)
    public String getSecondDocId() {
        return this.secondDocId;
    }
    
    public void setSecondDocId(String secondDocId) {
        this.secondDocId = secondDocId;
    }

    
    @Column(name="ApisMatchFlag", length=1)
    public String getApisMatchFlag() {
        return this.apisMatchFlag;
    }
    
    public void setApisMatchFlag(String apisMatchFlag) {
        this.apisMatchFlag = apisMatchFlag;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="InspectLoginDate", length=23)
    public Date getInspectLoginDate() {
        return this.inspectLoginDate;
    }
    
    public void setInspectLoginDate(Date inspectLoginDate) {
        this.inspectLoginDate = inspectLoginDate;
    }

    
    @Column(name="TxnMark", precision=1, scale=0)
    public Integer getTxnMark() {
        return this.txnMark;
    }
    
    public void setTxnMark(Integer txnMark) {
        this.txnMark = txnMark;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="SyncTime", length=23)
    public Date getSyncTime() {
        return this.syncTime;
    }
    
    public void setSyncTime(Date syncTime) {
        this.syncTime = syncTime;
    }

    
    @Column(name="FlightFlag", length=1)
    public String getFlightFlag() {
        return this.flightFlag;
    }
    
    public void setFlightFlag(String flightFlag) {
        this.flightFlag = flightFlag;
    }

    
    @Column(name="ChineseName", length=80)
    public String getChineseName() {
        return this.chineseName;
    }
    
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    
    @Column(name="EnglishName", length=50)
    public String getEnglishName() {
        return this.englishName;
    }
    
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    
    @Column(name="PersonId", length=20)
    public String getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    
    @Column(name="BioCmpRcode", length=4)
    public String getBioCmpRcode() {
        return this.bioCmpRcode;
    }
    
    public void setBioCmpRcode(String bioCmpRcode) {
        this.bioCmpRcode = bioCmpRcode;
    }

    
    @Column(name="BioCaptureState", length=3)
    public String getBioCaptureState() {
        return this.bioCaptureState;
    }
    
    public void setBioCaptureState(String bioCaptureState) {
        this.bioCaptureState = bioCaptureState;
    }

    
    @Column(name="ApplicantType", length=1)
    public String getApplicantType() {
        return this.applicantType;
    }
    
    public void setApplicantType(String applicantType) {
        this.applicantType = applicantType;
    }

    
    @Column(name="PositionType", length=2)
    public String getPositionType() {
        return this.positionType;
    }
    
    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    
    @Column(name="ReasonType", length=2)
    public String getReasonType() {
        return this.reasonType;
    }
    
    public void setReasonType(String reasonType) {
        this.reasonType = reasonType;
    }




}


