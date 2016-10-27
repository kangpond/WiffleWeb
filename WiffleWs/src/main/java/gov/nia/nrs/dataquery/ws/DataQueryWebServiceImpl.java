package gov.nia.nrs.dataquery.ws;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.dao.FsChildGrowthDelayDao;
import gov.nia.nrs.dao.FsDisabledPersonDao;
import gov.nia.nrs.dao.FsDriverLicenceDao;
import gov.nia.nrs.dao.FsForeignHealthCareDao;
import gov.nia.nrs.dao.FsLowIncomeDao;
import gov.nia.nrs.dao.FsOldAllowanceDao;
import gov.nia.nrs.dao.IsuranceDao;
import gov.nia.nrs.dao.iis.ApplicantDao;
import gov.nia.nrs.dao.iis.ApplyCaseDao;
import gov.nia.nrs.dao.iis.ApplyCaseForeignDao;
import gov.nia.nrs.dao.iis.ApplyCaseRelationDao;
import gov.nia.nrs.dao.iis.DataQueryDao;
import gov.nia.nrs.dao.iis.ForeignSpouseDao;
import gov.nia.nrs.dao.iis.HouseholdMarriageDao;
import gov.nia.nrs.dao.iis.InterviewRecordsDao;
import gov.nia.nrs.dao.iis.SefCertifyDao;
import gov.nia.nrs.dao.iis.TwSpouseDao;
import gov.nia.nrs.dao.imm.DailyImmigrationsDao;
import gov.nia.nrs.dao.imm.ForeignPassportDao;
import gov.nia.nrs.dao.imm.ImmigrationsDao;
import gov.nia.nrs.dao.imm.MultiCitizenshipDao;
import gov.nia.nrs.dao.imm.PassengersDao;
import gov.nia.nrs.dao.imm.PermitDao;
import gov.nia.nrs.dao.security.ReferenceDao;
import gov.nia.nrs.dataquery.bean.ApplyCaseListResp;
import gov.nia.nrs.dataquery.bean.DataDetailResp;
import gov.nia.nrs.dataquery.bean.DataListResp;
import gov.nia.nrs.dataquery.bean.DataQueryReq;
import gov.nia.nrs.dataquery.bean.ImmiListResp;
import gov.nia.nrs.dataquery.bean.InterviewDetailResp;
import gov.nia.nrs.dataquery.bean.InterviewListResp;
import gov.nia.nrs.dataquery.bean.MultiCitizenshipQueryReq;
import gov.nia.nrs.dataquery.bean.PassportVo;
import gov.nia.nrs.domain.FsDriverLicence;
import gov.nia.nrs.domain.FsForeignHealthCare;
import gov.nia.nrs.domain.iis.Applicant;
import gov.nia.nrs.domain.iis.ApplyCase;
import gov.nia.nrs.domain.iis.ApplyCaseRelation;
import gov.nia.nrs.domain.iis.ForeignSpouse;
import gov.nia.nrs.domain.iis.HouseholdMarriage;
import gov.nia.nrs.domain.iis.InterviewRecords;
import gov.nia.nrs.domain.iis.SefCertify;
import gov.nia.nrs.domain.iis.TwSpouse;
import gov.nia.nrs.domain.imm.DailyImmigrations;
import gov.nia.nrs.domain.imm.ForeignPassport;
import gov.nia.nrs.domain.imm.Immigrations;
import gov.nia.nrs.domain.imm.MultiCitizenship;
import gov.nia.nrs.domain.imm.Passengers;
import gov.nia.nrs.domain.imm.Permit;
import gov.nia.nrs.domain.security.ReferenceItemNew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author Jay Lin
 *
 */
@Service
public class DataQueryWebServiceImpl implements DataQueryWebService {

    private static final Logger logger = LoggerFactory.getLogger(DataQueryWebServiceImpl.class);

    @Resource ForeignSpouseDao foreignSpouseDao;
    @Resource ApplicantDao applicantDao;
    @Resource ApplyCaseDao applyCaseDao;
    @Resource DataQueryDao dataQueryDao;
    @Resource ForeignPassportDao foreignPassportDao;
    @Resource MultiCitizenshipDao multiCitizenshipDao;
    @Resource PassengersDao passengersDao;
    @Resource PermitDao permitDao;
    @Resource DailyImmigrationsDao dailyImmigrationsDao;
    @Resource ImmigrationsDao immigrationsDao;
    @Resource InterviewRecordsDao interviewRecordsDao;
    @Resource TwSpouseDao twSpouseDao;
    @Resource HouseholdMarriageDao householdMarriageDao;
    @Resource ReferenceDao referenceDao;
    @Resource FsDriverLicenceDao fsDriverLicenceDao;
    @Resource IsuranceDao isuranceDao; 
    @Resource FsForeignHealthCareDao foreignHealthCareDao;
    @Resource FsChildGrowthDelayDao fsChildGrowthDelayDao;
    @Resource SefCertifyDao sefCertifyDao;
    @Resource FsDisabledPersonDao fsDisabledPersonDao;
    @Resource FsOldAllowanceDao fsOldAllowanceDao;
    @Resource FsLowIncomeDao fsLowIncomeDao;
    @Resource ApplyCaseForeignDao applyCaseForeignDao;
    @Resource ApplyCaseRelationDao applyCaseRelationDao;
    
    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.dataquery.ws.DataQueryWebService#queryForList(gov.nia.nrs.dataquery.bean.DataQueryReq)
     */
    @Override
    public List<DataListResp> queryForList(DataQueryReq req) throws Exception {
        logger.debug("DataQueryWebServiceImpl.queryForList, req={}", req.toString());
        List<DataListResp> returnList = new ArrayList<DataListResp>();
        try {
            List<ForeignSpouse> foreignSpouseList = dataQueryDao.queryForList(req);
            if (foreignSpouseList != null && foreignSpouseList.size() > 0) {
                for (ForeignSpouse foreignSpouse : foreignSpouseList) {
                    DataListResp resp = new DataListResp();
                    resp.setResidentIdNo(foreignSpouse.getId().getResidentIdNo());
                    resp.setChineseName(foreignSpouse.getChineseName());
                    resp.setEnglishName(foreignSpouse.getEnglishName());
                    resp.setBirthDate(foreignSpouse.getBirthDate());
                    resp.setPassportNo(StringUtils.isBlank(foreignSpouse.getForeignPassportNo()) ? foreignSpouse.getPassportNo() : foreignSpouse
                            .getForeignPassportNo());
                    resp.setPersonId(foreignSpouse.getPersonId());
                    resp.setFirstReceiveNo(foreignSpouse.getId().getFirstReceiveNo());
                    returnList.add(resp);
                }
            }
        } catch (Exception e) {
            logger.error("DataQueryWebServiceImpl.queryForList", e);
            throw e;
        }
        return returnList;
    }

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.dataquery.ws.DataQueryWebService#queryForDetail(java.lang.String, java.lang.String)
     */
    @Override
    public DataDetailResp queryForDetail(String firstReceiveNo, String residentIdNo) throws Exception {
        logger.debug("DataQueryWebServiceImpl.queryForDetail, firstReceiveNo={}, residentIdNo={}", firstReceiveNo, residentIdNo);
        DataDetailResp respt = new DataDetailResp();
        try {

            String firstReceiveNoTemp = StringUtils.isBlank(firstReceiveNo) ? " " : firstReceiveNo;
            String residentIdNoTemp = StringUtils.isBlank(residentIdNo) ? " " : residentIdNo;

            ForeignSpouse foreignSpouse = foreignSpouseDao.query(residentIdNoTemp, firstReceiveNoTemp);

            if (foreignSpouse != null) {
                respt.setChineseName(foreignSpouse.getChineseName());
                respt.setEnglishName(foreignSpouse.getEnglishName());
                respt.setBirthDate(foreignSpouse.getBirthDate());
                respt.setGender(foreignSpouse.getGender());
                respt.setPosition(transIntToStr(foreignSpouse.getPosition()));
                respt.setFsType(foreignSpouse.getFsType());
                respt.setResidentIdNo(foreignSpouse.getId().getResidentIdNo());
                respt.setPersonId(foreignSpouse.getPersonId());
                respt.setFirstReceiveNo(foreignSpouse.getId().getFirstReceiveNo());
                respt.setForeignPassportNo(foreignSpouse.getForeignPassportNo());
                respt.setPassportNo(foreignSpouse.getPassportNo());
                respt.setNation(transIntToStr(foreignSpouse.getNation()));
            }

            if (!StringUtils.isBlank(firstReceiveNo)) {
                Applicant applicant = applicantDao.getApplicantBy1stRecvNo(firstReceiveNo);
                if (applicant != null) {
                    respt.setEducation(transIntToStr(applicant.getEducation()));
                    respt.setOccupation(transIntToStr(applicant.getOccupation()));
                    respt.setTelA(applicant.getTelA());
                    respt.setAddr1B(applicant.getAddr1a());
                    respt.setAddr2B(applicant.getAddr2a());
                    respt.setAddr3B(applicant.getAddr3a());
                    respt.setAddr4B(applicant.getAddr4a());
                    respt.setCityA(applicant.getCityA());
                    respt.setTownshipA(applicant.getTownshipA());
                    respt.setZipCodeA(applicant.getZipCodeA());
                    respt.setVillageA(applicant.getVillageA());
                    respt.setNeighborhoodA(applicant.getNeighborhoodA());
                    respt.setRoadA(applicant.getRoadA());
                    respt.setLaneA(applicant.getLaneA());
                    respt.setAlleyA(applicant.getAlleyA());
                    respt.setNumberA(applicant.getNumberA());
                    respt.setBirthPlaceCode(transIntToStr(applicant.getBirthPlaceCode()));
                    respt.setBirthPlace1(transIntToStr(applicant.getBirthPlace1()));
                    respt.setBirthPlace2(applicant.getBirthPlace2());
                    respt.setMobile(applicant.getMobile());
                }
            }
        } catch (Exception e) {
            logger.error("DataQueryWebServiceImpl.queryForDetail", e);
            throw e;
        }
        return respt;
    }

    /*
     * (non-Javadoc)
     *
     * @see gov.nia.nrs.dataquery.ws.DataQueryWebService#queryApplyCaseList(java.lang.String)
     */
    @Override
    public List<ApplyCaseListResp> queryApplyCaseList(String firstReceiveNo) throws Exception {
        logger.debug("DataQueryWebServiceImpl.queryApplyCaseList, firstReceiveNo={}", firstReceiveNo);
        List<ApplyCaseListResp> respList = new ArrayList<ApplyCaseListResp>();
        if (StringUtils.isBlank(firstReceiveNo)) {
            return respList;
        }
        try {
            List<ApplyCase> applyCaseList = applyCaseDao.getApplyCaseByFirstReceiveNo(firstReceiveNo);
            if (applyCaseList != null && applyCaseList.size() > 0) {
                for (ApplyCase applyCase : applyCaseList) {
                    ApplyCaseListResp resp = new ApplyCaseListResp();
                    resp.setApplyDate(applyCase.getApplyDate());
                    resp.setReceiveNo(applyCase.getReceiveNo());
                    resp.setApplyType(applyCase.getApplyType());
                    resp.setReason(applyCase.getReason().toString());
                    resp.setReceiveBureau(transIntToStr(applyCase.getReceiveBureau()));
                    resp.setDecideMark(transIntToStr(applyCase.getDecideMark()));
                    resp.setDecideDate(applyCase.getDecideDate());
                    String applicantType = applyCase.getApplicantType();
                    if (applicantType.matches("[M,H,O]{1}")) {
                        resp.setExitExpiryDate(applyCase.getExitExpiryDate());
                    } else if (applicantType.matches("[F,L]{1}")) {
                        resp.setRcEndDate(applyCase.getRcEndDate());
                    }
                    resp.setResidenceStatus(applyCase.getResidenceStatus());
                    resp.setForeignPassportNo(applyCase.getForeignPassportNo());
                    resp.setPassportNo(applyCase.getPassportNo());
                    respList.add(resp);
                }
            }
        } catch (Exception e) {
            logger.error("DataQueryWebServiceImpl.queryApplyCaseList", e);
            throw e;
        }
        return respList;
    }

    private String transIntToStr(Integer inInt) {
        if (inInt != null) {
            return inInt.toString();
        }
        return "";
    }

    @Override
    public List<PassportVo> queryPassportList(DataDetailResp resp) throws Exception {
        logger.debug("DataQueryWebServiceImpl.queryPassportList, resp={}", resp.toString());
        List<PassportVo> passportNoList = new ArrayList<PassportVo>();
        if (!StringUtils.isBlank(resp.getPassportNo())) {
            PassportVo passportVo = new PassportVo(resp.getPassportNo(), "35", ForeignSpouse.class.getSimpleName());
            passportNoList.add(passportVo);
        }
        if (!StringUtils.isBlank(resp.getForeignPassportNo()) && !StringUtils.isBlank(resp.getNation())) {
            PassportVo passportVo = new PassportVo(resp.getForeignPassportNo(), resp.getNation(), ForeignSpouse.class.getSimpleName());
            passportNoList.add(passportVo);
        }
        // query from ApplyCase
        if (!StringUtils.isBlank(resp.getFirstReceiveNo())) {
            List<ApplyCase> applyCaseList = applyCaseDao.getApplyCaseByFirstReceiveNo(resp.getFirstReceiveNo());
            if (applyCaseList != null && applyCaseList.size() > 0) {
                for (ApplyCase applyCase : applyCaseList) {
                    if (!StringUtils.isBlank(applyCase.getPassportNo())) {
                        if (!passportNoList.contains(new PassportVo(applyCase.getPassportNo(), "35")))
                            passportNoList.add(new PassportVo(applyCase.getPassportNo(), "35", ApplyCase.class.getSimpleName()));
                    }
                    if (!StringUtils.isBlank(applyCase.getForeignPassportNo())) {
                        if (!passportNoList.contains(new PassportVo(applyCase.getForeignPassportNo(), transIntToStr(applyCase.getOverseaResident()))))
                            passportNoList.add(new PassportVo(applyCase.getForeignPassportNo(), transIntToStr(applyCase.getOverseaResident()), ApplyCase.class
                                    .getSimpleName()));
                    }
                }
            }
        }
        // query from foreignPassport
        if (passportNoList != null && passportNoList.size() > 0) {
            List<ForeignPassport> foreignPassportList = foreignPassportDao.queryByPassportNoList(passportNoList);
            if (foreignPassportList != null && foreignPassportList.size() > 0) {
                for (ForeignPassport foreignPassport : foreignPassportList) {
                    if (!StringUtils.isBlank(foreignPassport.getId().getPassportNo())) {
                        if (!passportNoList
                                .contains(new PassportVo(foreignPassport.getId().getPassportNo(), transIntToStr(foreignPassport.getId().getNation()))))
                            passportNoList.add(new PassportVo(foreignPassport.getId().getPassportNo(), transIntToStr(foreignPassport.getId().getNation()),
                                    ForeignPassport.class.getSimpleName()));
                    }
                }
            }
        }
        // query from MultiCitizenship
        if (!StringUtils.isBlank(resp.getPassportNo())) {
            MultiCitizenshipQueryReq mulReq = new MultiCitizenshipQueryReq();
            mulReq.setPassportNo(resp.getPassportNo());
            mulReq.setNation("35");
            mulReq.setBirthDate(resp.getBirthDate());
            List<MultiCitizenship> mulList = multiCitizenshipDao.query(mulReq);
            if (mulList != null && mulList.size() > 0) {
                for (MultiCitizenship mul : mulList) {
                    if (!passportNoList.contains(new PassportVo(mul.getId().getPassportNo(), transIntToStr(mul.getNation()))))
                        passportNoList.add(new PassportVo(mul.getId().getPassportNo(), transIntToStr(mul.getNation()), MultiCitizenship.class.getSimpleName()));
                }
            }
        }

        if (!StringUtils.isBlank(resp.getForeignPassportNo()) && !StringUtils.isBlank(resp.getNation())) {
            MultiCitizenshipQueryReq mulReq = new MultiCitizenshipQueryReq();
            mulReq.setPassportNo(resp.getForeignPassportNo());
            mulReq.setNation(resp.getNation());
            mulReq.setBirthDate(resp.getBirthDate());
            List<MultiCitizenship> mulList = multiCitizenshipDao.query(mulReq);
            if (mulList != null && mulList.size() > 0) {
                for (MultiCitizenship mul : mulList) {
                    if (!passportNoList.contains(new PassportVo(mul.getId().getPassportNo(), transIntToStr(mul.getNation()))))
                        passportNoList.add(new PassportVo(mul.getId().getPassportNo(), transIntToStr(mul.getNation()), MultiCitizenship.class.getSimpleName()));
                }
            }
        }

        // 整理
        List<PassportVo> outResult = new ArrayList<PassportVo>();
        for (PassportVo p : passportNoList) {
            if (!"0".equals(p.getPassportNo()) && !"9".equals(p.getPassportNo()) && !"99".equals(p.getPassportNo()) && !"999".equals(p.getPassportNo())
                    && !"9999".equals(p.getPassportNo()) && !"99999".equals(p.getPassportNo()) && !"999999".equals(p.getPassportNo())
                    && !"9999999".equals(p.getPassportNo()) && !"99999999".equals(p.getPassportNo()) && !"999999999".equals(p.getPassportNo())
                    && !"9999999999".equals(p.getPassportNo())) {
                if (!outResult.contains(p))
                    outResult.add(p);
            }
        }
        return outResult;
    }

    @Override
    public List<ImmiListResp> queryImmiList(DataDetailResp resp, PassportVo[] passportVoList) throws Exception {
        logger.debug("DataQueryWebServiceImpl.queryImmiList, resp={}", resp.toString());
        List<String> passengerIds = new ArrayList<String>();
        // find by PassportNo list
        if (passportVoList != null && passportVoList.length > 0) {
            List<Passengers> passengersList = passengersDao.queryByPassportNoList(Arrays.asList(passportVoList));
            if (passengersList != null && passengersList.size() > 0) {
                for (Passengers passengers : passengersList) {
                    if (!StringUtils.isBlank(passengers.getPassengerId()))
                        if (!passengerIds.contains(passengers.getPassengerId()))
                            passengerIds.add(passengers.getPassengerId());
                }
            }
        }

        // find by PersonId
        if (!StringUtils.isBlank(resp.getPersonId())) {
            List<Passengers> passengersList = passengersDao.queryByPersonId(resp.getPersonId(), resp.getBirthDate());
            if (passengersList != null && passengersList.size() > 0) {
                for (Passengers passengers : passengersList) {
                    if (!StringUtils.isBlank(passengers.getPassengerId()))
                        if (!passengerIds.contains(passengers.getPassengerId()))
                            passengerIds.add(passengers.getPassengerId());
                }
            }
        }
        // find by FirstReceiveNo
        if (!StringUtils.isBlank(resp.getFirstReceiveNo())) {
            // Passengers
            List<Passengers> passengersList = passengersDao.queryByFirstRecvNo(resp.getFirstReceiveNo());
            if (passengersList != null && passengersList.size() > 0) {
                for (Passengers passengers : passengersList) {
                    if (!StringUtils.isBlank(passengers.getPassengerId()))
                        if (!passengerIds.contains(passengers.getPassengerId()))
                            passengerIds.add(passengers.getPassengerId());
                }
            }
            // Permit
            List<Permit> permitList = permitDao.queryByFirstReceiveNo(resp.getFirstReceiveNo());
            if (permitList != null && permitList.size() > 0) {
                for (Permit permit : permitList) {
                    if (!StringUtils.isBlank(permit.getPassengerId()))
                        if (!passengerIds.contains(permit.getPassengerId()))
                            passengerIds.add(permit.getPassengerId());
                }
            }
        }

        List<ImmiListResp> respList = new ArrayList<ImmiListResp>();
        if (passengerIds != null && passengerIds.size() > 0) {
            // query Immigrations
            List<Immigrations> immigrationsList = immigrationsDao.queryByPassengerIds(passengerIds);
            if (immigrationsList != null && immigrationsList.size() > 0) {
                for (Immigrations immigrations : immigrationsList) {
                    ImmiListResp respTemp = new ImmiListResp();
                    respTemp.setImmigrateType(transIntToStr(immigrations.getImmigrateType()));
                    respTemp.setImmigrateDate(immigrations.getId().getImmigrateDate());
                    respTemp.setPort(transIntToStr(immigrations.getPort()));
                    respTemp.setFlightNo(immigrations.getFlightNo());
                    respTemp.setFromTo(transIntToStr(immigrations.getFromTo()));
                    respTemp.setImmigWay(immigrations.getImmigWay());
                    respTemp.setPermitNo(immigrations.getPermitNo());
                    respTemp.setPassportNo(immigrations.getPassportNo());
                    respTemp.setFromDaily("N");
                    respList.add(respTemp);
                }
            }
            // query DailyImmigrations
            List<DailyImmigrations> dailyList = dailyImmigrationsDao.queryByPassengerIds(passengerIds);
            if (dailyList != null && dailyList.size() > 0) {
                for (DailyImmigrations dailys : dailyList) {
                    ImmiListResp respTemp = new ImmiListResp();
                    respTemp.setImmigrateType(transIntToStr(dailys.getImmigrateType()));
                    respTemp.setImmigrateDate(dailys.getId().getImmigrateDate());
                    respTemp.setPort(transIntToStr(dailys.getId().getPort()));
                    respTemp.setFlightNo(dailys.getFlightNo());
                    respTemp.setFromTo(transIntToStr(dailys.getFromTo()));
                    respTemp.setImmigWay(dailys.getImmigWay());
                    respTemp.setPermitNo(dailys.getPermitNo());
                    respTemp.setPassportNo(dailys.getPassportNo());
                    respTemp.setFromDaily("Y");
                    respList.add(respTemp);
                }
            }
        }

        Collections.sort(respList, new Comparator<ImmiListResp>() {
            @Override
            public int compare(ImmiListResp o1, ImmiListResp o2) {

                int compare = o2.getImmigrateDate().compareTo(o1.getImmigrateDate());
                if (compare == 0) {
                    if ("Y".equals(o1.getFromDaily())) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
                return compare;
            }
        });
        return respList;
    }
    
    @Override
    public List<InterviewListResp> queryInterviewList(String firstReceiveNo) throws Exception {
        logger.debug("DataQueryWebServiceImpl.queryInterviewList, firstReceiveNo={}", firstReceiveNo);
        List<InterviewListResp> respList = new ArrayList<InterviewListResp>();
        if (StringUtils.isBlank(firstReceiveNo)) {
            return respList;
        }
        List<InterviewRecords> recordsList = interviewRecordsDao.queryByFirstReceiveNo(firstReceiveNo);
        if (recordsList != null && recordsList.size() > 0) {
            for (InterviewRecords records : recordsList) {
                InterviewListResp resp = new InterviewListResp();
                resp.setReceiveNo(records.getReceiveNo());
                resp.setF2fPerson(records.getF2fPerson());
                resp.setStartF2fTalkDate(records.getStartF2fTalkDate());
                resp.setTalkPlace(records.getTalkPlace());
                resp.setF2fResult(transIntToStr(records.getF2fResult()));
                resp.setSeq(records.getSeq().toString());
                respList.add(resp);
            }
        }
        return respList;
    }

    @Override
    public InterviewDetailResp queryInterview(String seq) throws Exception {
        logger.debug("DataQueryWebServiceImpl.queryInterviewList, seq={}", seq);
        InterviewDetailResp resp = new InterviewDetailResp();
        if (!StringUtils.isBlank(seq) && StringUtils.isNumeric(seq)) {
            InterviewRecords records = interviewRecordsDao.queryByKey(new Long(seq));
            resp.setReceiveNo(records.getReceiveNo());
            resp.setF2fPerson(records.getF2fPerson());
            resp.setStartF2fTalkDate(records.getStartF2fTalkDate());
            resp.setStartF2fTalkTime(records.getStartF2fTalkTime());
            resp.setTalkPlace(records.getTalkPlace());
            resp.setRemark(records.getRemark());
            resp.setEntryDate(records.getEntryDate());
            resp.setEntryFlyNo(records.getEntryFlyNo());
            resp.setTelNo1(records.getTelNo1());
            resp.setAppealStatus(records.getAppealStatus());
            resp.setFirstReceiveNo(records.getFirstReceiveNo());
            resp.setTimesF2fTalk(records.getTimesF2fTalk());
            resp.setEndF2fTalkDate(records.getEndF2fTalkDate());
            resp.setEndF2fTalkTime(records.getEndF2fTalkTime());
            resp.setF2fResult(transIntToStr(records.getF2fResult()));
            resp.setExitDate(records.getExitDate());
            resp.setExitFlyNo(records.getExitFlyNo());
            resp.setTelNo2(records.getTelNo2());
        }
        return resp;
    }
    

	@Override
	public List<Map<String, String>> getMarriageCondition(UserProfile userProfile,String firstReceiveNo) {
		return twSpouseDao.getMarriageCondition(userProfile,firstReceiveNo);
	}

	@Override
	public HouseholdMarriage getMarriageInfo(UserProfile userProfile,String personId, String marrageDate) {
		return householdMarriageDao.getHouseholdMarriage(personId, marrageDate);
	}

	@Override
	public List<ReferenceItemNew> getMissingReport(String firstReceiveNo,String residentIdNo,
			 String englishName, String chineseName,String birthDate) throws Exception {
		return referenceDao.getMissingReport(firstReceiveNo, residentIdNo, englishName, chineseName, birthDate);
	}

	@Override
	public List<FsDriverLicence> getDriverLicence(UserProfile userProfile,String firstReceiveNo) {
		return fsDriverLicenceDao.getDriverLicence(userProfile, firstReceiveNo) ;
	}


	@Override
	public Map<String, Object> getIsuranceInfo(UserProfile userProfile,String firstReceiveNo,
			 String residentIdNo, String isuranceType,Integer offset) {
		return isuranceDao.getIsuranceInfo(userProfile, firstReceiveNo, residentIdNo, isuranceType,offset);
	}

	@Override
	public List<FsForeignHealthCare> getHealCareInfo(UserProfile userProfile,String firstReceiveNo, String residentIdNo) {
		return foreignHealthCareDao.getHealCareInfo(userProfile, firstReceiveNo, residentIdNo);
	}

	@Override
	public List<Map<String, Object>> getChildHealCareInfo(UserProfile userProfile, String firstReceiveNo, String residentIdNo) {
		List<FsForeignHealthCare> fsList = getHealCareInfo(userProfile, firstReceiveNo, residentIdNo);
		List<Map<String, Object>> _list = new ArrayList<Map<String,Object>>();
		if(fsList.size() > 0){
			for(FsForeignHealthCare fshc : fsList){
				Map<String, Object> fsMap = new HashMap<String, Object>();
				fsMap.put("childNo", fshc.getChildNo());
				
				fsMap.put("firstChildPersonId", fshc.getFirstChildPersonId());
				fsMap.put("firstChildChineseName", fshc.getFirstChildChineseName());
				fsMap.put("firstChildBirthDate", fshc.getFirstChildBirthDate());
				fsMap.put("firstChildHealth", fshc.getFirstChildHealth());
				fsMap.put("firstChildLive", fshc.getFirstChildLive());
				fsMap.put("firstChildCheckDate", fshc.getFirstChildCheckDate());
				fsMap.put("firstChildStunt", fshc.getFirstChildStunt());
				fsMap.put("firstGrowthDelay", fsChildGrowthDelayDao.checkingGrowthDelay(userProfile, fshc.getFirstChildPersonId()) ? "是":"否");
				
				fsMap.put("secondChildPersonId", fshc.getSecondChildPersonId());
				fsMap.put("secondChildChineseName", fshc.getSecondChildChineseName());
				fsMap.put("secondChildBirthDate", fshc.getSecondChildBirthDate());
				fsMap.put("secondChildHealth", fshc.getSecondChildHealth());
				fsMap.put("secondChildLive", fshc.getSecondChildLive());
				fsMap.put("secondChildCheckDate", fshc.getSecondChildCheckDate());
				fsMap.put("secondChildStunt", fshc.getSecondChildStunt());
				fsMap.put("secondGrowthDelay", fsChildGrowthDelayDao.checkingGrowthDelay(userProfile, fshc.getSecondChildPersonId()) ? "是":"否");
				
				fsMap.put("thirdChildPersonId", fshc.getThirdChildPersonId());
				fsMap.put("thirdChildChineseName", fshc.getThirdChildChineseName());
				fsMap.put("thirdChildBirthDate", fshc.getThirdChildBirthDate());
				fsMap.put("thirdChildHealth", fshc.getThirdChildHealth());
				fsMap.put("thirdChildLive", fshc.getThirdChildLive());
				fsMap.put("thirdChildCheckDate", fshc.getThirdChildCheckDate());
				fsMap.put("thirdChildStunt", fshc.getThirdChildStunt());
				fsMap.put("thirdGrowthDelay", fsChildGrowthDelayDao.checkingGrowthDelay(userProfile, fshc.getThirdChildPersonId()) ? "是":"否" );
				
				fsMap.put("fourthChildPersonId", fshc.getFourthChildPersonId());
				fsMap.put("fourthChildChineseName", fshc.getFourthChildChineseName());
				fsMap.put("fourthChildBirthDate", fshc.getFourthChildBirthDate());
				fsMap.put("fourthChildHealth", fshc.getFourthChildHealth());
				fsMap.put("fourthChildLive", fshc.getFourthChildLive());
				fsMap.put("fourthChildCheckDate", fshc.getFourthChildCheckDate());
				fsMap.put("fourthChildStunt", fshc.getFourthChildStunt());
				fsMap.put("fourthGrowthDelay", fsChildGrowthDelayDao.checkingGrowthDelay(userProfile, fshc.getFourthChildPersonId()) ? "是":"否" );
				
				fsMap.put("fifthChildPersonId", fshc.getFifthChildPersonId());
				fsMap.put("fifthChildChineseName", fshc.getFifthChildChineseName());
				fsMap.put("fifthChildBirthDate", fshc.getFifthChildBirthDate());
				fsMap.put("fifthChildHealth", fshc.getFifthChildHealth());
				fsMap.put("fifthChildLive", fshc.getFifthChildLive());
				fsMap.put("fifthChildCheckDate", fshc.getFifthChildCheckDate());
				fsMap.put("fifthChildStunt", fshc.getFifthChildStunt());
				fsMap.put("fifthGrowthDelay", fsChildGrowthDelayDao.checkingGrowthDelay(userProfile, fshc.getFifthChildPersonId()) ? "是":"否" );
				
				fsMap.put("sixthChildPersonId", fshc.getSixthChildPersonId());
				fsMap.put("sixthChildChineseName", fshc.getSixthChildChineseName());
				fsMap.put("sixthChildBirthDate", fshc.getSixthChildBirthDate());
				fsMap.put("sixthChildHealth", fshc.getSixthChildHealth());
				fsMap.put("sixthChildLive", fshc.getSixthChildLive());
				fsMap.put("sixthChildCheckDate", fshc.getSixthChildCheckDate());
				fsMap.put("sixthChildStunt", fshc.getSixthChildStunt());
				fsMap.put("sixthGrowthDelay", fsChildGrowthDelayDao.checkingGrowthDelay(userProfile, fshc.getSixthChildPersonId()) ? "是":"否" );
				
				_list.add(fsMap);
			}
		}
		
		return _list;
	}

	@Override
	public List<SefCertify> getSefCertifyList(UserProfile userProfile, String firstReceiveNo, String residentIdNo) {
		String firstReceiveNoTemp = StringUtils.isBlank(firstReceiveNo) ? " " : firstReceiveNo;
        String residentIdNoTemp = StringUtils.isBlank(residentIdNo) ? " " : residentIdNo;

        ForeignSpouse foreignSpouse = foreignSpouseDao.query(residentIdNoTemp, firstReceiveNoTemp);
        
        List<SefCertify> sList = null;
        if(foreignSpouse != null){
        	sList = sefCertifyDao.getSefCertifyList(foreignSpouse.getTwSpousePersonId());
        }
		return sList;
	}

	@Override
	public SefCertify getSefCertifyInfo(UserProfile userProfile, String documentNo) {
		return sefCertifyDao.getSefCertifyInfo(userProfile,documentNo);
	}

	@Override
	public Map<String, Object> getAllowanceInfo(UserProfile userProfile, String firstReceiveNo, String residentIdNo) {
		Map<String, Object> infoMap = new HashMap<String, Object>();
		
		String firstReceiveNoTemp = StringUtils.isBlank(firstReceiveNo) ? " " : firstReceiveNo;
        String residentIdNoTemp = StringUtils.isBlank(residentIdNo) ? " " : residentIdNo;

        ForeignSpouse foreignSpouse = foreignSpouseDao.query(residentIdNoTemp, firstReceiveNoTemp);
        if(foreignSpouse != null){
        	TwSpouse twSpouse = twSpouseDao.getTwSpouse(foreignSpouse.getTwSpousePersonId(),firstReceiveNo);
        	if(twSpouse != null){
        		if(StringUtils.equals(twSpouse.getDisabledMark(), "1")){
        			infoMap.put("disableList", fsDisabledPersonDao.getDisabledPersonList(twSpouse.getId().getPersonId()));
        		}
        		
        		if(StringUtils.equals(twSpouse.getOldAllowance(), "1")){
        			infoMap.put("allowanceList", fsOldAllowanceDao.getAllowanceList(twSpouse.getId().getPersonId()));
        		}
        		
        		if(StringUtils.equals(twSpouse.getLowIncomeMark(), "1")){
        			infoMap.put("lowIncomeList", fsLowIncomeDao.getLowIncomeList(twSpouse.getId().getPersonId()));
        		}
        	}
        }
		
		return infoMap;
	}

	@Override
	public Map<String, Object> getForiegnInfo(UserProfile userProfile, String firstReceiveNo) {
		Map<String, Object> caseMap = new HashMap<String, Object>();
		List<ApplyCase> applyCases = applyCaseDao.getApplyCaseFL(firstReceiveNo);
		if(applyCases.size() > 0){
			Applicant applicant = applicantDao.getApplicantBy1stRecvNo(firstReceiveNo);
			ApplyCase applyCase = applyCases.get(0);
			caseMap.put("receiveNo", applyCase.getReceiveNo());
			caseMap.put("remark", applyCase.getReMark());
			caseMap.put("entryDate", applicant.getEntryDate());
			caseMap.put("exitDate", applicant.getExitDate());
			caseMap.put("serviceOfficeName", applicant.getServiceOfficeName());
			caseMap.put("serviceOfficeTel", applicant.getServiceOfficeTel());
			
			List<Map<String,String>> workAddressList =	applyCaseForeignDao.getAddressList(firstReceiveNo, "2");
			if(workAddressList.size() > 0){
				caseMap.put("addressWK", workAddressList.get(0).get("address"));
				caseMap.put("telNoWK", workAddressList.get(0).get("telNo"));
			}
			
			ApplyCaseRelation relation = applyCaseRelationDao.getApplyCaseRelation(applyCase.getReceiveNo());
			caseMap.put("relation", relation.getRelation());
			caseMap.put("chineseName", relation.getChineseName());
			caseMap.put("nation", relation.getNation());
			caseMap.put("relTel", relation.getRelTel());
			caseMap.put("englishName", relation.getEnglishName());
			caseMap.put("relationIdNo", relation.getRelationIdNo());
			caseMap.put("passportList", applyCaseDao.getPassportInfoList(firstReceiveNo, applicant.getResidentIdNo()));
			caseMap.put("workList", applyCaseForeignDao.getWorkInfoList(firstReceiveNo));
			caseMap.put("livingAddressList", applyCaseForeignDao.getAddressList(firstReceiveNo, "1"));
			caseMap.put("workAddressList", workAddressList);
		}
		return caseMap;
	}
	
	
	
	
}
