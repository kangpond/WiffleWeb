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
 * DailyImmigrations generated by hbm2java
 */
@Entity
@Table(name="DailyImmigrations"
)
public class DailyImmigrations  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private DailyImmigrationsId id;
    private String passengerId;
    private String origPassengerId;
    private String passengerType;
    private String immigWay;
    private String processDate;
    private String immigRcode;
    private Integer immigrateType;
    private String flightNo;
    private Integer flightTime;
    private Integer fromTo;
    private String englishName;
    private String chineseName;
    private String gender;
    private String birthDate;
    private String personId;
    private Integer birthPlaceCode;
    private Integer birthPlace1;
    private String birthPlace2;
    private Integer nation;
    private String permitNo;
    private String passportNo;
    private String inspectorId;
    private Date inspectTime;
    private Integer inspectTermNo;
    private String inspectTermLoc;
    private String modifyMark;
    private String multiCitizenMark;
    private String readPermitMark;
    private String edCardMark;
    private String customId;
    private Integer customNo;
    private Integer customTermNo;
    private String customTermLoc;
    private Date customTime;
    private String customAlarmMark;
    private String customMultiMark;
    private String customInspMark;
    private String customRedLineMark;
    private Integer grpPersonCnt;
    private String grpLeaderEdNo;
    private Integer grpCnt;
    private String noImmigrateMark;
    private String useForeignMark;
    private String readPersonIdMark;
    private String portBuMark;
    private String createDept;
    private String alienWorkerMark;
    private String mrpMark;
    private String noVisaMark;
    private String specialPersonMark;
    private String approvalDocMark;
    private String noticeSusp;
    private String securitySusp;
    private String security4susp;
    private String aviaPoliceSusp;
    private String otherMark;
    private String dataMsg;
    private String reEntryNo;
    private String faceRecogMark;
    private String stayDays;
    private String visaKind;
    private String reserved;
    private Long matchRatio;
    private String writeBackFlag;
    private String writeBackRcode;
    private Date writeBackTime;
    private String cutFlag;
    private String cutRcode;
    private Date cutTime;
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
    private String permitDocType;
    private String applyType;
    private Integer taxCount;
    private Integer keepCount;
    private Integer saveCount;
    private Integer customCount;
    private Integer passCount;
    private String customDesc;
    private String flightFlag;
    private String bioCmpRcode;
    private String bioCaptureState;

    public DailyImmigrations() {}

	
    public DailyImmigrations(DailyImmigrationsId id, String immigRcode, Integer immigrateType, String flightNo, Integer flightTime, Integer fromTo, String englishName, String gender, String birthDate, String personId, Integer birthPlaceCode, Integer birthPlace1, String birthPlace2, Integer nation, String permitNo, String passportNo, String inspectorId, Date inspectTime, Integer inspectTermNo, String inspectTermLoc, String modifyMark, String multiCitizenMark, String readPermitMark, String edCardMark, String customId, Integer customNo, Integer customTermNo, String customTermLoc, String customAlarmMark, String customMultiMark, String customInspMark, String customRedLineMark, Integer grpPersonCnt, String grpLeaderEdNo, Integer grpCnt, String noImmigrateMark, String useForeignMark, String readPersonIdMark, String portBuMark, String createDept, String alienWorkerMark, String mrpMark, String noVisaMark, String specialPersonMark, String approvalDocMark, String noticeSusp, String securitySusp, String security4susp, String aviaPoliceSusp, String otherMark, String dataMsg, String reEntryNo, String stayDays, String visaKind, String writeBackFlag, String writeBackRcode, String cutFlag, String cutRcode, String deleteFlag, String mainUserId, String maintainProgramId, String maintainHost, Date lastUpdateTime) {
        this.id = id;
        this.immigRcode = immigRcode;
        this.immigrateType = immigrateType;
        this.flightNo = flightNo;
        this.flightTime = flightTime;
        this.fromTo = fromTo;
        this.englishName = englishName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.personId = personId;
        this.birthPlaceCode = birthPlaceCode;
        this.birthPlace1 = birthPlace1;
        this.birthPlace2 = birthPlace2;
        this.nation = nation;
        this.permitNo = permitNo;
        this.passportNo = passportNo;
        this.inspectorId = inspectorId;
        this.inspectTime = inspectTime;
        this.inspectTermNo = inspectTermNo;
        this.inspectTermLoc = inspectTermLoc;
        this.modifyMark = modifyMark;
        this.multiCitizenMark = multiCitizenMark;
        this.readPermitMark = readPermitMark;
        this.edCardMark = edCardMark;
        this.customId = customId;
        this.customNo = customNo;
        this.customTermNo = customTermNo;
        this.customTermLoc = customTermLoc;
        this.customAlarmMark = customAlarmMark;
        this.customMultiMark = customMultiMark;
        this.customInspMark = customInspMark;
        this.customRedLineMark = customRedLineMark;
        this.grpPersonCnt = grpPersonCnt;
        this.grpLeaderEdNo = grpLeaderEdNo;
        this.grpCnt = grpCnt;
        this.noImmigrateMark = noImmigrateMark;
        this.useForeignMark = useForeignMark;
        this.readPersonIdMark = readPersonIdMark;
        this.portBuMark = portBuMark;
        this.createDept = createDept;
        this.alienWorkerMark = alienWorkerMark;
        this.mrpMark = mrpMark;
        this.noVisaMark = noVisaMark;
        this.specialPersonMark = specialPersonMark;
        this.approvalDocMark = approvalDocMark;
        this.noticeSusp = noticeSusp;
        this.securitySusp = securitySusp;
        this.security4susp = security4susp;
        this.aviaPoliceSusp = aviaPoliceSusp;
        this.otherMark = otherMark;
        this.dataMsg = dataMsg;
        this.reEntryNo = reEntryNo;
        this.stayDays = stayDays;
        this.visaKind = visaKind;
        this.writeBackFlag = writeBackFlag;
        this.writeBackRcode = writeBackRcode;
        this.cutFlag = cutFlag;
        this.cutRcode = cutRcode;
        this.deleteFlag = deleteFlag;
        this.mainUserId = mainUserId;
        this.maintainProgramId = maintainProgramId;
        this.maintainHost = maintainHost;
        this.lastUpdateTime = lastUpdateTime;
    }
    public DailyImmigrations(DailyImmigrationsId id, String passengerId, String origPassengerId, String passengerType, String immigWay, String processDate, String immigRcode, Integer immigrateType, String flightNo, Integer flightTime, Integer fromTo, String englishName, String chineseName, String gender, String birthDate, String personId, Integer birthPlaceCode, Integer birthPlace1, String birthPlace2, Integer nation, String permitNo, String passportNo, String inspectorId, Date inspectTime, Integer inspectTermNo, String inspectTermLoc, String modifyMark, String multiCitizenMark, String readPermitMark, String edCardMark, String customId, Integer customNo, Integer customTermNo, String customTermLoc, Date customTime, String customAlarmMark, String customMultiMark, String customInspMark, String customRedLineMark, Integer grpPersonCnt, String grpLeaderEdNo, Integer grpCnt, String noImmigrateMark, String useForeignMark, String readPersonIdMark, String portBuMark, String createDept, String alienWorkerMark, String mrpMark, String noVisaMark, String specialPersonMark, String approvalDocMark, String noticeSusp, String securitySusp, String security4susp, String aviaPoliceSusp, String otherMark, String dataMsg, String reEntryNo, String faceRecogMark, String stayDays, String visaKind, String reserved, Long matchRatio, String writeBackFlag, String writeBackRcode, Date writeBackTime, String cutFlag, String cutRcode, Date cutTime, Date establishTime, Date importTime, String deleteFlag, String mainUserId, String maintainProgramId, String maintainHost, Date lastUpdateTime, String captureDate, Integer captureSerialNo, String secondDocType, String secondDocCategory, String secondDocId, String apisMatchFlag, Date inspectLoginDate, Integer txnMark, Date syncTime, String permitDocType, String applyType, Integer taxCount, Integer keepCount, Integer saveCount, Integer customCount, Integer passCount, String customDesc, String flightFlag, String bioCmpRcode, String bioCaptureState) {
        this.id = id;
        this.passengerId = passengerId;
        this.origPassengerId = origPassengerId;
        this.passengerType = passengerType;
        this.immigWay = immigWay;
        this.processDate = processDate;
        this.immigRcode = immigRcode;
        this.immigrateType = immigrateType;
        this.flightNo = flightNo;
        this.flightTime = flightTime;
        this.fromTo = fromTo;
        this.englishName = englishName;
        this.chineseName = chineseName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.personId = personId;
        this.birthPlaceCode = birthPlaceCode;
        this.birthPlace1 = birthPlace1;
        this.birthPlace2 = birthPlace2;
        this.nation = nation;
        this.permitNo = permitNo;
        this.passportNo = passportNo;
        this.inspectorId = inspectorId;
        this.inspectTime = inspectTime;
        this.inspectTermNo = inspectTermNo;
        this.inspectTermLoc = inspectTermLoc;
        this.modifyMark = modifyMark;
        this.multiCitizenMark = multiCitizenMark;
        this.readPermitMark = readPermitMark;
        this.edCardMark = edCardMark;
        this.customId = customId;
        this.customNo = customNo;
        this.customTermNo = customTermNo;
        this.customTermLoc = customTermLoc;
        this.customTime = customTime;
        this.customAlarmMark = customAlarmMark;
        this.customMultiMark = customMultiMark;
        this.customInspMark = customInspMark;
        this.customRedLineMark = customRedLineMark;
        this.grpPersonCnt = grpPersonCnt;
        this.grpLeaderEdNo = grpLeaderEdNo;
        this.grpCnt = grpCnt;
        this.noImmigrateMark = noImmigrateMark;
        this.useForeignMark = useForeignMark;
        this.readPersonIdMark = readPersonIdMark;
        this.portBuMark = portBuMark;
        this.createDept = createDept;
        this.alienWorkerMark = alienWorkerMark;
        this.mrpMark = mrpMark;
        this.noVisaMark = noVisaMark;
        this.specialPersonMark = specialPersonMark;
        this.approvalDocMark = approvalDocMark;
        this.noticeSusp = noticeSusp;
        this.securitySusp = securitySusp;
        this.security4susp = security4susp;
        this.aviaPoliceSusp = aviaPoliceSusp;
        this.otherMark = otherMark;
        this.dataMsg = dataMsg;
        this.reEntryNo = reEntryNo;
        this.faceRecogMark = faceRecogMark;
        this.stayDays = stayDays;
        this.visaKind = visaKind;
        this.reserved = reserved;
        this.matchRatio = matchRatio;
        this.writeBackFlag = writeBackFlag;
        this.writeBackRcode = writeBackRcode;
        this.writeBackTime = writeBackTime;
        this.cutFlag = cutFlag;
        this.cutRcode = cutRcode;
        this.cutTime = cutTime;
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
        this.permitDocType = permitDocType;
        this.applyType = applyType;
        this.taxCount = taxCount;
        this.keepCount = keepCount;
        this.saveCount = saveCount;
        this.customCount = customCount;
        this.passCount = passCount;
        this.customDesc = customDesc;
        this.flightFlag = flightFlag;
        this.bioCmpRcode = bioCmpRcode;
        this.bioCaptureState = bioCaptureState;
    }
   
    @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="edCardNo", column=@Column(name="EdCardNo", nullable=false, length=20) ), 
        @AttributeOverride(name="port", column=@Column(name="Port", nullable=false, precision=2, scale=0) ), 
        @AttributeOverride(name="immigrateDate", column=@Column(name="ImmigrateDate", nullable=false, length=8) ), 
        @AttributeOverride(name="immigrateSeq", column=@Column(name="ImmigrateSeq", nullable=false, precision=5, scale=0) ) } )
    public DailyImmigrationsId getId() {
        return this.id;
    }
    
    public void setId(DailyImmigrationsId id) {
        this.id = id;
    }

    
    @Column(name="PassengerId", length=10)
    public String getPassengerId() {
        return this.passengerId;
    }
    
    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    
    @Column(name="OrigPassengerId", length=10)
    public String getOrigPassengerId() {
        return this.origPassengerId;
    }
    
    public void setOrigPassengerId(String origPassengerId) {
        this.origPassengerId = origPassengerId;
    }

    
    @Column(name="PassengerType", length=1)
    public String getPassengerType() {
        return this.passengerType;
    }
    
    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    
    @Column(name="ImmigWay", length=1)
    public String getImmigWay() {
        return this.immigWay;
    }
    
    public void setImmigWay(String immigWay) {
        this.immigWay = immigWay;
    }

    
    @Column(name="ProcessDate", length=8)
    public String getProcessDate() {
        return this.processDate;
    }
    
    public void setProcessDate(String processDate) {
        this.processDate = processDate;
    }

    
    @Column(name="ImmigRcode", nullable=false, length=4)
    public String getImmigRcode() {
        return this.immigRcode;
    }
    
    public void setImmigRcode(String immigRcode) {
        this.immigRcode = immigRcode;
    }

    
    @Column(name="ImmigrateType", nullable=false, precision=1, scale=0)
    public Integer getImmigrateType() {
        return this.immigrateType;
    }
    
    public void setImmigrateType(Integer immigrateType) {
        this.immigrateType = immigrateType;
    }

    
    @Column(name="FlightNo", nullable=false, length=20)
    public String getFlightNo() {
        return this.flightNo;
    }
    
    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

    
    @Column(name="FlightTime", nullable=false, precision=5, scale=0)
    public Integer getFlightTime() {
        return this.flightTime;
    }
    
    public void setFlightTime(Integer flightTime) {
        this.flightTime = flightTime;
    }

    
    @Column(name="FromTo", nullable=false, precision=3, scale=0)
    public Integer getFromTo() {
        return this.fromTo;
    }
    
    public void setFromTo(Integer fromTo) {
        this.fromTo = fromTo;
    }

    
    @Column(name="EnglishName", nullable=false, length=50)
    public String getEnglishName() {
        return this.englishName;
    }
    
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    
    @Column(name="ChineseName", length=80)
    public String getChineseName() {
        return this.chineseName;
    }
    
    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    
    @Column(name="Gender", nullable=false, length=1)
    public String getGender() {
        return this.gender;
    }
    
    public void setGender(String gender) {
        this.gender = gender;
    }

    
    @Column(name="BirthDate", nullable=false, length=8)
    public String getBirthDate() {
        return this.birthDate;
    }
    
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    
    @Column(name="PersonId", nullable=false, length=20)
    public String getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    
    @Column(name="BirthPlaceCode", nullable=false, precision=1, scale=0)
    public Integer getBirthPlaceCode() {
        return this.birthPlaceCode;
    }
    
    public void setBirthPlaceCode(Integer birthPlaceCode) {
        this.birthPlaceCode = birthPlaceCode;
    }

    
    @Column(name="BirthPlace1", nullable=false, precision=3, scale=0)
    public Integer getBirthPlace1() {
        return this.birthPlace1;
    }
    
    public void setBirthPlace1(Integer birthPlace1) {
        this.birthPlace1 = birthPlace1;
    }

    
    @Column(name="BirthPlace2", nullable=false, length=16)
    public String getBirthPlace2() {
        return this.birthPlace2;
    }
    
    public void setBirthPlace2(String birthPlace2) {
        this.birthPlace2 = birthPlace2;
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

    
    @Column(name="InspectorId", nullable=false, length=5)
    public String getInspectorId() {
        return this.inspectorId;
    }
    
    public void setInspectorId(String inspectorId) {
        this.inspectorId = inspectorId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="InspectTime", nullable=false, length=23)
    public Date getInspectTime() {
        return this.inspectTime;
    }
    
    public void setInspectTime(Date inspectTime) {
        this.inspectTime = inspectTime;
    }

    
    @Column(name="InspectTermNo", nullable=false, precision=4, scale=0)
    public Integer getInspectTermNo() {
        return this.inspectTermNo;
    }
    
    public void setInspectTermNo(Integer inspectTermNo) {
        this.inspectTermNo = inspectTermNo;
    }

    
    @Column(name="InspectTermLoc", nullable=false, length=2)
    public String getInspectTermLoc() {
        return this.inspectTermLoc;
    }
    
    public void setInspectTermLoc(String inspectTermLoc) {
        this.inspectTermLoc = inspectTermLoc;
    }

    
    @Column(name="ModifyMark", nullable=false, length=1)
    public String getModifyMark() {
        return this.modifyMark;
    }
    
    public void setModifyMark(String modifyMark) {
        this.modifyMark = modifyMark;
    }

    
    @Column(name="MultiCitizenMark", nullable=false, length=1)
    public String getMultiCitizenMark() {
        return this.multiCitizenMark;
    }
    
    public void setMultiCitizenMark(String multiCitizenMark) {
        this.multiCitizenMark = multiCitizenMark;
    }

    
    @Column(name="ReadPermitMark", nullable=false, length=1)
    public String getReadPermitMark() {
        return this.readPermitMark;
    }
    
    public void setReadPermitMark(String readPermitMark) {
        this.readPermitMark = readPermitMark;
    }

    
    @Column(name="EdCardMark", nullable=false, length=1)
    public String getEdCardMark() {
        return this.edCardMark;
    }
    
    public void setEdCardMark(String edCardMark) {
        this.edCardMark = edCardMark;
    }

    
    @Column(name="CustomId", nullable=false, length=5)
    public String getCustomId() {
        return this.customId;
    }
    
    public void setCustomId(String customId) {
        this.customId = customId;
    }

    
    @Column(name="CustomNo", nullable=false, precision=2, scale=0)
    public Integer getCustomNo() {
        return this.customNo;
    }
    
    public void setCustomNo(Integer customNo) {
        this.customNo = customNo;
    }

    
    @Column(name="CustomTermNo", nullable=false, precision=4, scale=0)
    public Integer getCustomTermNo() {
        return this.customTermNo;
    }
    
    public void setCustomTermNo(Integer customTermNo) {
        this.customTermNo = customTermNo;
    }

    
    @Column(name="CustomTermLoc", nullable=false, length=2)
    public String getCustomTermLoc() {
        return this.customTermLoc;
    }
    
    public void setCustomTermLoc(String customTermLoc) {
        this.customTermLoc = customTermLoc;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CustomTime", length=23)
    public Date getCustomTime() {
        return this.customTime;
    }
    
    public void setCustomTime(Date customTime) {
        this.customTime = customTime;
    }

    
    @Column(name="CustomAlarmMark", nullable=false, length=1)
    public String getCustomAlarmMark() {
        return this.customAlarmMark;
    }
    
    public void setCustomAlarmMark(String customAlarmMark) {
        this.customAlarmMark = customAlarmMark;
    }

    
    @Column(name="CustomMultiMark", nullable=false, length=1)
    public String getCustomMultiMark() {
        return this.customMultiMark;
    }
    
    public void setCustomMultiMark(String customMultiMark) {
        this.customMultiMark = customMultiMark;
    }

    
    @Column(name="CustomInspMark", nullable=false, length=1)
    public String getCustomInspMark() {
        return this.customInspMark;
    }
    
    public void setCustomInspMark(String customInspMark) {
        this.customInspMark = customInspMark;
    }

    
    @Column(name="CustomRedLineMark", nullable=false, length=1)
    public String getCustomRedLineMark() {
        return this.customRedLineMark;
    }
    
    public void setCustomRedLineMark(String customRedLineMark) {
        this.customRedLineMark = customRedLineMark;
    }

    
    @Column(name="GrpPersonCnt", nullable=false, precision=3, scale=0)
    public Integer getGrpPersonCnt() {
        return this.grpPersonCnt;
    }
    
    public void setGrpPersonCnt(Integer grpPersonCnt) {
        this.grpPersonCnt = grpPersonCnt;
    }

    
    @Column(name="GrpLeaderEdNo", nullable=false, length=10)
    public String getGrpLeaderEdNo() {
        return this.grpLeaderEdNo;
    }
    
    public void setGrpLeaderEdNo(String grpLeaderEdNo) {
        this.grpLeaderEdNo = grpLeaderEdNo;
    }

    
    @Column(name="GrpCnt", nullable=false, precision=3, scale=0)
    public Integer getGrpCnt() {
        return this.grpCnt;
    }
    
    public void setGrpCnt(Integer grpCnt) {
        this.grpCnt = grpCnt;
    }

    
    @Column(name="NoImmigrateMark", nullable=false, length=1)
    public String getNoImmigrateMark() {
        return this.noImmigrateMark;
    }
    
    public void setNoImmigrateMark(String noImmigrateMark) {
        this.noImmigrateMark = noImmigrateMark;
    }

    
    @Column(name="UseForeignMark", nullable=false, length=1)
    public String getUseForeignMark() {
        return this.useForeignMark;
    }
    
    public void setUseForeignMark(String useForeignMark) {
        this.useForeignMark = useForeignMark;
    }

    
    @Column(name="ReadPersonIdMark", nullable=false, length=1)
    public String getReadPersonIdMark() {
        return this.readPersonIdMark;
    }
    
    public void setReadPersonIdMark(String readPersonIdMark) {
        this.readPersonIdMark = readPersonIdMark;
    }

    
    @Column(name="PortBuMark", nullable=false, length=1)
    public String getPortBuMark() {
        return this.portBuMark;
    }
    
    public void setPortBuMark(String portBuMark) {
        this.portBuMark = portBuMark;
    }

    
    @Column(name="CreateDept", nullable=false, length=2)
    public String getCreateDept() {
        return this.createDept;
    }
    
    public void setCreateDept(String createDept) {
        this.createDept = createDept;
    }

    
    @Column(name="AlienWorkerMark", nullable=false, length=1)
    public String getAlienWorkerMark() {
        return this.alienWorkerMark;
    }
    
    public void setAlienWorkerMark(String alienWorkerMark) {
        this.alienWorkerMark = alienWorkerMark;
    }

    
    @Column(name="MrpMark", nullable=false, length=1)
    public String getMrpMark() {
        return this.mrpMark;
    }
    
    public void setMrpMark(String mrpMark) {
        this.mrpMark = mrpMark;
    }

    
    @Column(name="NoVisaMark", nullable=false, length=1)
    public String getNoVisaMark() {
        return this.noVisaMark;
    }
    
    public void setNoVisaMark(String noVisaMark) {
        this.noVisaMark = noVisaMark;
    }

    
    @Column(name="SpecialPersonMark", nullable=false, length=2)
    public String getSpecialPersonMark() {
        return this.specialPersonMark;
    }
    
    public void setSpecialPersonMark(String specialPersonMark) {
        this.specialPersonMark = specialPersonMark;
    }

    
    @Column(name="ApprovalDocMark", nullable=false, length=1)
    public String getApprovalDocMark() {
        return this.approvalDocMark;
    }
    
    public void setApprovalDocMark(String approvalDocMark) {
        this.approvalDocMark = approvalDocMark;
    }

    
    @Column(name="NoticeSusp", nullable=false, length=1)
    public String getNoticeSusp() {
        return this.noticeSusp;
    }
    
    public void setNoticeSusp(String noticeSusp) {
        this.noticeSusp = noticeSusp;
    }

    
    @Column(name="SecuritySusp", nullable=false, length=1)
    public String getSecuritySusp() {
        return this.securitySusp;
    }
    
    public void setSecuritySusp(String securitySusp) {
        this.securitySusp = securitySusp;
    }

    
    @Column(name="Security4Susp", nullable=false, length=1)
    public String getSecurity4susp() {
        return this.security4susp;
    }
    
    public void setSecurity4susp(String security4susp) {
        this.security4susp = security4susp;
    }

    
    @Column(name="AviaPoliceSusp", nullable=false, length=1)
    public String getAviaPoliceSusp() {
        return this.aviaPoliceSusp;
    }
    
    public void setAviaPoliceSusp(String aviaPoliceSusp) {
        this.aviaPoliceSusp = aviaPoliceSusp;
    }

    
    @Column(name="OtherMark", nullable=false, length=1)
    public String getOtherMark() {
        return this.otherMark;
    }
    
    public void setOtherMark(String otherMark) {
        this.otherMark = otherMark;
    }

    
    @Column(name="DataMsg", nullable=false, length=1)
    public String getDataMsg() {
        return this.dataMsg;
    }
    
    public void setDataMsg(String dataMsg) {
        this.dataMsg = dataMsg;
    }

    
    @Column(name="ReEntryNo", nullable=false, length=8)
    public String getReEntryNo() {
        return this.reEntryNo;
    }
    
    public void setReEntryNo(String reEntryNo) {
        this.reEntryNo = reEntryNo;
    }

    
    @Column(name="FaceRecogMark", length=1)
    public String getFaceRecogMark() {
        return this.faceRecogMark;
    }
    
    public void setFaceRecogMark(String faceRecogMark) {
        this.faceRecogMark = faceRecogMark;
    }

    
    @Column(name="StayDays", nullable=false, length=4)
    public String getStayDays() {
        return this.stayDays;
    }
    
    public void setStayDays(String stayDays) {
        this.stayDays = stayDays;
    }

    
    @Column(name="VisaKind", nullable=false, length=1)
    public String getVisaKind() {
        return this.visaKind;
    }
    
    public void setVisaKind(String visaKind) {
        this.visaKind = visaKind;
    }

    
    @Column(name="Reserved", length=30)
    public String getReserved() {
        return this.reserved;
    }
    
    public void setReserved(String reserved) {
        this.reserved = reserved;
    }

    
    @Column(name="MatchRatio", precision=5)
    public Long getMatchRatio() {
        return this.matchRatio;
    }
    
    public void setMatchRatio(Long matchRatio) {
        this.matchRatio = matchRatio;
    }

    
    @Column(name="WriteBackFlag", nullable=false, length=1)
    public String getWriteBackFlag() {
        return this.writeBackFlag;
    }
    
    public void setWriteBackFlag(String writeBackFlag) {
        this.writeBackFlag = writeBackFlag;
    }

    
    @Column(name="WriteBackRcode", nullable=false, length=4)
    public String getWriteBackRcode() {
        return this.writeBackRcode;
    }
    
    public void setWriteBackRcode(String writeBackRcode) {
        this.writeBackRcode = writeBackRcode;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="WriteBackTime", length=23)
    public Date getWriteBackTime() {
        return this.writeBackTime;
    }
    
    public void setWriteBackTime(Date writeBackTime) {
        this.writeBackTime = writeBackTime;
    }

    
    @Column(name="CutFlag", nullable=false, length=1)
    public String getCutFlag() {
        return this.cutFlag;
    }
    
    public void setCutFlag(String cutFlag) {
        this.cutFlag = cutFlag;
    }

    
    @Column(name="CutRcode", nullable=false, length=4)
    public String getCutRcode() {
        return this.cutRcode;
    }
    
    public void setCutRcode(String cutRcode) {
        this.cutRcode = cutRcode;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CutTime", length=23)
    public Date getCutTime() {
        return this.cutTime;
    }
    
    public void setCutTime(Date cutTime) {
        this.cutTime = cutTime;
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

    
    @Column(name="PermitDocType", length=1)
    public String getPermitDocType() {
        return this.permitDocType;
    }
    
    public void setPermitDocType(String permitDocType) {
        this.permitDocType = permitDocType;
    }

    
    @Column(name="ApplyType", length=1)
    public String getApplyType() {
        return this.applyType;
    }
    
    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    
    @Column(name="TaxCount", precision=2, scale=0)
    public Integer getTaxCount() {
        return this.taxCount;
    }
    
    public void setTaxCount(Integer taxCount) {
        this.taxCount = taxCount;
    }

    
    @Column(name="KeepCount", precision=2, scale=0)
    public Integer getKeepCount() {
        return this.keepCount;
    }
    
    public void setKeepCount(Integer keepCount) {
        this.keepCount = keepCount;
    }

    
    @Column(name="SaveCount", precision=2, scale=0)
    public Integer getSaveCount() {
        return this.saveCount;
    }
    
    public void setSaveCount(Integer saveCount) {
        this.saveCount = saveCount;
    }

    
    @Column(name="CustomCount", precision=2, scale=0)
    public Integer getCustomCount() {
        return this.customCount;
    }
    
    public void setCustomCount(Integer customCount) {
        this.customCount = customCount;
    }

    
    @Column(name="PassCount", precision=2, scale=0)
    public Integer getPassCount() {
        return this.passCount;
    }
    
    public void setPassCount(Integer passCount) {
        this.passCount = passCount;
    }

    
    @Column(name="CustomDesc", length=50)
    public String getCustomDesc() {
        return this.customDesc;
    }
    
    public void setCustomDesc(String customDesc) {
        this.customDesc = customDesc;
    }

    
    @Column(name="FlightFlag", length=1)
    public String getFlightFlag() {
        return this.flightFlag;
    }
    
    public void setFlightFlag(String flightFlag) {
        this.flightFlag = flightFlag;
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




}


