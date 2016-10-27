package gov.nia.nrs.domain.iis;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * InterviewRecords
 */
@Entity
@Table(name="InterviewRecords"
)
public class InterviewRecords  implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Long seq;
    private String receiveNo;
    private String f2fPerson;
    private String timesF2fTalk;
    private String firstReceiveNo;
    private String startF2fTalkDate;
    private String startF2fTalkTime;
    private String endF2fTalkDate;
    private String endF2fTalkTime;
    private String officer1position;
    private String officer1name;
    private String officer2position;
    private String officer2name;
    private String recordPosition;
    private String recordName;
    private String talkPlace;
    private Integer f2fResult;
    private String f2fTalkDate;
    private String f2fNotifyDesc;
    private String f2fNotifyNo;
    private String f2fNotifyTalkPlace;
    private String remark;
    private String entryDate;
    private String entryFlyNo;
    private String exitDate;
    private String exitFlyNo;
    private String telNo1;
    private String telNo2;
    private String keyinUid;
    private String maintainUid;
    private Date lastUpdateTime;
    private String maintainHost;
    private String appealStatus;
    private String filler;
    private String deleteFlag;
    private String createDeptId;
    private Date createTime;
    private String createUserId;
    private String maintainDeptId;
    private String maintainProgramId;
    private String mainUserId;
    private String officierDeptId1;
    private String officierDeptId2;
    private String officierId1;
    private String officierId2;
    private String recordId;
    private String caseId;
    private String fact;
    private String law;
    private Date importTime;
    private Long appointInterviewSeq;
    private Integer mark1;
    private Integer mark2;
    private Integer mark3;
    private Integer mark4;
    private Integer mark5;
    private Integer mark6;
    private Integer mark7;
    private Integer mark8;
    private String deadline;
    private String underTakeDept;
    private Long txnMark;
    private Date syncTime;

    public InterviewRecords() {}

	
    public InterviewRecords(Long seq, String receiveNo, String f2fPerson, String timesF2fTalk) {
        this.seq = seq;
        this.receiveNo = receiveNo;
        this.f2fPerson = f2fPerson;
        this.timesF2fTalk = timesF2fTalk;
    }
    public InterviewRecords(Long seq, String receiveNo, String f2fPerson, String timesF2fTalk, String firstReceiveNo, String startF2fTalkDate, String startF2fTalkTime, String endF2fTalkDate, String endF2fTalkTime, String officer1position, String officer1name, String officer2position, String officer2name, String recordPosition, String recordName, String talkPlace, Integer f2fResult, String f2fTalkDate, String f2fNotifyDesc, String f2fNotifyNo, String f2fNotifyTalkPlace, String remark, String entryDate, String entryFlyNo, String exitDate, String exitFlyNo, String telNo1, String telNo2, String keyinUid, String maintainUid, Date lastUpdateTime, String maintainHost, String appealStatus, String filler, String deleteFlag, String createDeptId, Date createTime, String createUserId, String maintainDeptId, String maintainProgramId, String mainUserId, String officierDeptId1, String officierDeptId2, String officierId1, String officierId2, String recordId, String caseId, String fact, String law, Date importTime, Long appointInterviewSeq, Integer mark1, Integer mark2, Integer mark3, Integer mark4, Integer mark5, Integer mark6, Integer mark7, Integer mark8, String deadline, String underTakeDept, Long txnMark, Date syncTime) {
        this.seq = seq;
        this.receiveNo = receiveNo;
        this.f2fPerson = f2fPerson;
        this.timesF2fTalk = timesF2fTalk;
        this.firstReceiveNo = firstReceiveNo;
        this.startF2fTalkDate = startF2fTalkDate;
        this.startF2fTalkTime = startF2fTalkTime;
        this.endF2fTalkDate = endF2fTalkDate;
        this.endF2fTalkTime = endF2fTalkTime;
        this.officer1position = officer1position;
        this.officer1name = officer1name;
        this.officer2position = officer2position;
        this.officer2name = officer2name;
        this.recordPosition = recordPosition;
        this.recordName = recordName;
        this.talkPlace = talkPlace;
        this.f2fResult = f2fResult;
        this.f2fTalkDate = f2fTalkDate;
        this.f2fNotifyDesc = f2fNotifyDesc;
        this.f2fNotifyNo = f2fNotifyNo;
        this.f2fNotifyTalkPlace = f2fNotifyTalkPlace;
        this.remark = remark;
        this.entryDate = entryDate;
        this.entryFlyNo = entryFlyNo;
        this.exitDate = exitDate;
        this.exitFlyNo = exitFlyNo;
        this.telNo1 = telNo1;
        this.telNo2 = telNo2;
        this.keyinUid = keyinUid;
        this.maintainUid = maintainUid;
        this.lastUpdateTime = lastUpdateTime;
        this.maintainHost = maintainHost;
        this.appealStatus = appealStatus;
        this.filler = filler;
        this.deleteFlag = deleteFlag;
        this.createDeptId = createDeptId;
        this.createTime = createTime;
        this.createUserId = createUserId;
        this.maintainDeptId = maintainDeptId;
        this.maintainProgramId = maintainProgramId;
        this.mainUserId = mainUserId;
        this.officierDeptId1 = officierDeptId1;
        this.officierDeptId2 = officierDeptId2;
        this.officierId1 = officierId1;
        this.officierId2 = officierId2;
        this.recordId = recordId;
        this.caseId = caseId;
        this.fact = fact;
        this.law = law;
        this.importTime = importTime;
        this.appointInterviewSeq = appointInterviewSeq;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
        this.mark4 = mark4;
        this.mark5 = mark5;
        this.mark6 = mark6;
        this.mark7 = mark7;
        this.mark8 = mark8;
        this.deadline = deadline;
        this.underTakeDept = underTakeDept;
        this.txnMark = txnMark;
        this.syncTime = syncTime;
    }
   
    @Id 

    
    @Column(name="Seq", unique=true, nullable=false, precision=12, scale=0)
    public Long getSeq() {
        return this.seq;
    }
    
    public void setSeq(Long seq) {
        this.seq = seq;
    }

    
    @Column(name="ReceiveNo", nullable=false, length=12)
    public String getReceiveNo() {
        return this.receiveNo;
    }
    
    public void setReceiveNo(String receiveNo) {
        this.receiveNo = receiveNo;
    }

    
    @Column(name="F2fPerson", nullable=false, length=1)
    public String getF2fPerson() {
        return this.f2fPerson;
    }
    
    public void setF2fPerson(String f2fPerson) {
        this.f2fPerson = f2fPerson;
    }

    
    @Column(name="TimesF2fTalk", nullable=false, length=1)
    public String getTimesF2fTalk() {
        return this.timesF2fTalk;
    }
    
    public void setTimesF2fTalk(String timesF2fTalk) {
        this.timesF2fTalk = timesF2fTalk;
    }

    
    @Column(name="FirstReceiveNo", length=12)
    public String getFirstReceiveNo() {
        return this.firstReceiveNo;
    }
    
    public void setFirstReceiveNo(String firstReceiveNo) {
        this.firstReceiveNo = firstReceiveNo;
    }

    
    @Column(name="StartF2fTalkDate", length=8)
    public String getStartF2fTalkDate() {
        return this.startF2fTalkDate;
    }
    
    public void setStartF2fTalkDate(String startF2fTalkDate) {
        this.startF2fTalkDate = startF2fTalkDate;
    }

    
    @Column(name="StartF2fTalkTime", length=4)
    public String getStartF2fTalkTime() {
        return this.startF2fTalkTime;
    }
    
    public void setStartF2fTalkTime(String startF2fTalkTime) {
        this.startF2fTalkTime = startF2fTalkTime;
    }

    
    @Column(name="EndF2fTalkDate", length=8)
    public String getEndF2fTalkDate() {
        return this.endF2fTalkDate;
    }
    
    public void setEndF2fTalkDate(String endF2fTalkDate) {
        this.endF2fTalkDate = endF2fTalkDate;
    }

    
    @Column(name="EndF2fTalkTime", length=4)
    public String getEndF2fTalkTime() {
        return this.endF2fTalkTime;
    }
    
    public void setEndF2fTalkTime(String endF2fTalkTime) {
        this.endF2fTalkTime = endF2fTalkTime;
    }

    
    @Column(name="Officer1Position", length=40)
    public String getOfficer1position() {
        return this.officer1position;
    }
    
    public void setOfficer1position(String officer1position) {
        this.officer1position = officer1position;
    }

    
    @Column(name="Officer1Name", length=80)
    public String getOfficer1name() {
        return this.officer1name;
    }
    
    public void setOfficer1name(String officer1name) {
        this.officer1name = officer1name;
    }

    
    @Column(name="Officer2Position", length=40)
    public String getOfficer2position() {
        return this.officer2position;
    }
    
    public void setOfficer2position(String officer2position) {
        this.officer2position = officer2position;
    }

    
    @Column(name="Officer2Name", length=80)
    public String getOfficer2name() {
        return this.officer2name;
    }
    
    public void setOfficer2name(String officer2name) {
        this.officer2name = officer2name;
    }

    
    @Column(name="RecordPosition", length=40)
    public String getRecordPosition() {
        return this.recordPosition;
    }
    
    public void setRecordPosition(String recordPosition) {
        this.recordPosition = recordPosition;
    }

    
    @Column(name="RecordName", length=80)
    public String getRecordName() {
        return this.recordName;
    }
    
    public void setRecordName(String recordName) {
        this.recordName = recordName;
    }

    
    @Column(name="TalkPlace", length=2)
    public String getTalkPlace() {
        return this.talkPlace;
    }
    
    public void setTalkPlace(String talkPlace) {
        this.talkPlace = talkPlace;
    }

    
    @Column(name="F2fResult")
    public Integer getF2fResult() {
        return this.f2fResult;
    }
    
    public void setF2fResult(Integer f2fResult) {
        this.f2fResult = f2fResult;
    }

    
    @Column(name="F2fTalkDate", length=8)
    public String getF2fTalkDate() {
        return this.f2fTalkDate;
    }
    
    public void setF2fTalkDate(String f2fTalkDate) {
        this.f2fTalkDate = f2fTalkDate;
    }

    
    @Column(name="F2fNotifyDesc", length=20)
    public String getF2fNotifyDesc() {
        return this.f2fNotifyDesc;
    }
    
    public void setF2fNotifyDesc(String f2fNotifyDesc) {
        this.f2fNotifyDesc = f2fNotifyDesc;
    }

    
    @Column(name="F2fNotifyNo", length=10)
    public String getF2fNotifyNo() {
        return this.f2fNotifyNo;
    }
    
    public void setF2fNotifyNo(String f2fNotifyNo) {
        this.f2fNotifyNo = f2fNotifyNo;
    }

    
    @Column(name="F2fNotifyTalkPlace", length=2)
    public String getF2fNotifyTalkPlace() {
        return this.f2fNotifyTalkPlace;
    }
    
    public void setF2fNotifyTalkPlace(String f2fNotifyTalkPlace) {
        this.f2fNotifyTalkPlace = f2fNotifyTalkPlace;
    }

    
    @Column(name="Remark", length=160)
    public String getRemark() {
        return this.remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }

    
    @Column(name="EntryDate", length=8)
    public String getEntryDate() {
        return this.entryDate;
    }
    
    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    
    @Column(name="EntryFlyNo", length=6)
    public String getEntryFlyNo() {
        return this.entryFlyNo;
    }
    
    public void setEntryFlyNo(String entryFlyNo) {
        this.entryFlyNo = entryFlyNo;
    }

    
    @Column(name="ExitDate", length=8)
    public String getExitDate() {
        return this.exitDate;
    }
    
    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    
    @Column(name="ExitFlyNo", length=6)
    public String getExitFlyNo() {
        return this.exitFlyNo;
    }
    
    public void setExitFlyNo(String exitFlyNo) {
        this.exitFlyNo = exitFlyNo;
    }

    
    @Column(name="TelNo1", length=15)
    public String getTelNo1() {
        return this.telNo1;
    }
    
    public void setTelNo1(String telNo1) {
        this.telNo1 = telNo1;
    }

    
    @Column(name="TelNo2", length=15)
    public String getTelNo2() {
        return this.telNo2;
    }
    
    public void setTelNo2(String telNo2) {
        this.telNo2 = telNo2;
    }

    
    @Column(name="KeyinUid", length=10)
    public String getKeyinUid() {
        return this.keyinUid;
    }
    
    public void setKeyinUid(String keyinUid) {
        this.keyinUid = keyinUid;
    }

    
    @Column(name="MaintainUid", length=10)
    public String getMaintainUid() {
        return this.maintainUid;
    }
    
    public void setMaintainUid(String maintainUid) {
        this.maintainUid = maintainUid;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="LastUpdateTime", length=23)
    public Date getLastUpdateTime() {
        return this.lastUpdateTime;
    }
    
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    
    @Column(name="MaintainHost", length=25)
    public String getMaintainHost() {
        return this.maintainHost;
    }
    
    public void setMaintainHost(String maintainHost) {
        this.maintainHost = maintainHost;
    }

    
    @Column(name="AppealStatus", length=1)
    public String getAppealStatus() {
        return this.appealStatus;
    }
    
    public void setAppealStatus(String appealStatus) {
        this.appealStatus = appealStatus;
    }

    
    @Column(name="Filler", length=29)
    public String getFiller() {
        return this.filler;
    }
    
    public void setFiller(String filler) {
        this.filler = filler;
    }

    
    @Column(name="DeleteFlag", length=1)
    public String getDeleteFlag() {
        return this.deleteFlag;
    }
    
    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    
    @Column(name="CreateDeptId", length=4)
    public String getCreateDeptId() {
        return this.createDeptId;
    }
    
    public void setCreateDeptId(String createDeptId) {
        this.createDeptId = createDeptId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CreateTime", length=23)
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    
    @Column(name="CreateUserId", length=10)
    public String getCreateUserId() {
        return this.createUserId;
    }
    
    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    
    @Column(name="MaintainDeptId", length=4)
    public String getMaintainDeptId() {
        return this.maintainDeptId;
    }
    
    public void setMaintainDeptId(String maintainDeptId) {
        this.maintainDeptId = maintainDeptId;
    }

    
    @Column(name="MaintainProgramId", length=20)
    public String getMaintainProgramId() {
        return this.maintainProgramId;
    }
    
    public void setMaintainProgramId(String maintainProgramId) {
        this.maintainProgramId = maintainProgramId;
    }

    
    @Column(name="MainUserId", length=10)
    public String getMainUserId() {
        return this.mainUserId;
    }
    
    public void setMainUserId(String mainUserId) {
        this.mainUserId = mainUserId;
    }

    
    @Column(name="OfficierDeptId1", length=10)
    public String getOfficierDeptId1() {
        return this.officierDeptId1;
    }
    
    public void setOfficierDeptId1(String officierDeptId1) {
        this.officierDeptId1 = officierDeptId1;
    }

    
    @Column(name="OfficierDeptId2", length=10)
    public String getOfficierDeptId2() {
        return this.officierDeptId2;
    }
    
    public void setOfficierDeptId2(String officierDeptId2) {
        this.officierDeptId2 = officierDeptId2;
    }

    
    @Column(name="OfficierID1", length=10)
    public String getOfficierId1() {
        return this.officierId1;
    }
    
    public void setOfficierId1(String officierId1) {
        this.officierId1 = officierId1;
    }

    
    @Column(name="OfficierID2", length=10)
    public String getOfficierId2() {
        return this.officierId2;
    }
    
    public void setOfficierId2(String officierId2) {
        this.officierId2 = officierId2;
    }

    
    @Column(name="RecordId", length=10)
    public String getRecordId() {
        return this.recordId;
    }
    
    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    
    @Column(name="CaseId", length=10)
    public String getCaseId() {
        return this.caseId;
    }
    
    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    
    @Column(name="Fact", length=1000)
    public String getFact() {
        return this.fact;
    }
    
    public void setFact(String fact) {
        this.fact = fact;
    }

    
    @Column(name="Law", length=1000)
    public String getLaw() {
        return this.law;
    }
    
    public void setLaw(String law) {
        this.law = law;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="ImportTime", length=23)
    public Date getImportTime() {
        return this.importTime;
    }
    
    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }

    
    @Column(name="AppointInterviewSeq", precision=18, scale=0)
    public Long getAppointInterviewSeq() {
        return this.appointInterviewSeq;
    }
    
    public void setAppointInterviewSeq(Long appointInterviewSeq) {
        this.appointInterviewSeq = appointInterviewSeq;
    }

    
    @Column(name="Mark1")
    public Integer getMark1() {
        return this.mark1;
    }
    
    public void setMark1(Integer mark1) {
        this.mark1 = mark1;
    }

    
    @Column(name="Mark2")
    public Integer getMark2() {
        return this.mark2;
    }
    
    public void setMark2(Integer mark2) {
        this.mark2 = mark2;
    }

    
    @Column(name="Mark3")
    public Integer getMark3() {
        return this.mark3;
    }
    
    public void setMark3(Integer mark3) {
        this.mark3 = mark3;
    }

    
    @Column(name="Mark4")
    public Integer getMark4() {
        return this.mark4;
    }
    
    public void setMark4(Integer mark4) {
        this.mark4 = mark4;
    }

    
    @Column(name="Mark5")
    public Integer getMark5() {
        return this.mark5;
    }
    
    public void setMark5(Integer mark5) {
        this.mark5 = mark5;
    }

    
    @Column(name="Mark6")
    public Integer getMark6() {
        return this.mark6;
    }
    
    public void setMark6(Integer mark6) {
        this.mark6 = mark6;
    }

    
    @Column(name="Mark7")
    public Integer getMark7() {
        return this.mark7;
    }
    
    public void setMark7(Integer mark7) {
        this.mark7 = mark7;
    }

    
    @Column(name="Mark8")
    public Integer getMark8() {
        return this.mark8;
    }
    
    public void setMark8(Integer mark8) {
        this.mark8 = mark8;
    }

    
    @Column(name="Deadline", length=8)
    public String getDeadline() {
        return this.deadline;
    }
    
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    
    @Column(name="UnderTakeDept", length=4)
    public String getUnderTakeDept() {
        return this.underTakeDept;
    }
    
    public void setUnderTakeDept(String underTakeDept) {
        this.underTakeDept = underTakeDept;
    }

    
    @Column(name="TxnMark")
    public Long getTxnMark() {
        return this.txnMark;
    }
    
    public void setTxnMark(Long txnMark) {
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




}


