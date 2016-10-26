/**
 *
 */
package gov.nia.nrs.dataquery.action;

import gov.nia.nrs.action.BaseAction;
import gov.nia.nrs.dataquery.bean.ApplyCaseListResp;
import gov.nia.nrs.dataquery.bean.DataDetailResp;
import gov.nia.nrs.dataquery.bean.DataListResp;
import gov.nia.nrs.dataquery.bean.DataQueryReq;
import gov.nia.nrs.dataquery.bean.ImmiListResp;
import gov.nia.nrs.dataquery.bean.InterviewDetailResp;
import gov.nia.nrs.dataquery.bean.InterviewListResp;
import gov.nia.nrs.dataquery.bean.PassportVo;
import gov.nia.nrs.dataquery.ws.DataQueryWebService;
import gov.nia.nrs.utils.vo.NiiAddressVo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Jay Lin
 *
 */
@Namespace("/dataQuery")
public class DataQueryAction extends BaseAction {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(DataQueryAction.class);

    public static final String QUERY = "query";
    public static final String LIST = "list";
    public static final String DETAIL = "detail";

    private DataQueryReq req;
    private List<DataListResp> respList;
    private DataDetailResp resp;
    private List<ApplyCaseListResp> applyCaseList;
    private List<ImmiListResp> immiList;
    private List<InterviewListResp> interviewList;
    protected NiiAddressVo niiAddressVo;
    protected String firstReceiveNo;
    protected String residentIdNo;
    private InterviewDetailResp interviewResp;
    private String interviewSeq;

    @Resource
    protected DataQueryWebService dataQueryWebService;

    @Action(value = "inquiry", results = {@Result(name = QUERY, location = "dataQuery.inquiry", type = "tiles")})
    public String inquiry() throws Exception {
        logger.debug("DataQueryAction.inquiry");
        getRequest().getSession().setAttribute("DATAQUERY_DETAIL_RESP", null);
        getRequest().getSession().setAttribute("DATAQUERY_DETAIL_PASSPORTNO_LIST", null);
        return QUERY;
    }

    @Action(value = "list", results = {@Result(name = LIST, location = "dataQuery.list", type = "tiles")})
    public String list() throws Exception {
        logger.debug("DataQueryAction.list");
        try {
            respList = dataQueryWebService.queryForList(req);
        } catch (Exception e) {
            logger.error("DataQueryAction.list error", e);
            throw e;
        }
        return LIST;
    }

    @Action(value = "detail", results = {@Result(name = DETAIL, location = "dataQuery.detail", type = "tiles")})
    public String detail() throws Exception {
        logger.debug("DataQueryAction.detail");
        try {
            getRequest().getSession().setAttribute("DATAQUERY_DETAIL_RESP", null);
            getRequest().getSession().setAttribute("DATAQUERY_DETAIL_PASSPORTNO_LIST", null);

            resp = dataQueryWebService.queryForDetail(firstReceiveNo, residentIdNo);
            getRequest().getSession().setAttribute("DATAQUERY_DETAIL_RESP", resp);

            List<PassportVo> passportVoList = dataQueryWebService.queryPassportList(resp);
            getRequest().getSession().setAttribute("DATAQUERY_DETAIL_PASSPORTNO_LIST", passportVoList);

            niiAddressVo = new NiiAddressVo();
            niiAddressVo.setZipCode(resp.getZipCodeA());
            niiAddressVo.setCity(resp.getCityA());
            niiAddressVo.setTownship(resp.getTownshipA());
            niiAddressVo.setVillage(resp.getVillageA());
            niiAddressVo.setNeighborhood(resp.getNeighborhoodA());
            niiAddressVo.setRoad(resp.getRoadA());
            niiAddressVo.setLane(resp.getLaneA());
            niiAddressVo.setAlley(resp.getAlleyA());
            niiAddressVo.setNumber(resp.getNumberA());
        } catch (Exception e) {
            logger.error("DataQueryAction.detail error", e);
            throw e;
        }
        return DETAIL;
    }

    @Action(value = "queryApplyCaseList", results = {@Result(name = LIST, location = "dataQuery.applyCaseList", type = "tiles")})
    public String queryApplyCaseList() throws Exception {
        logger.debug("DataQueryAction.queryApplyCaseList");
        try {
            applyCaseList = dataQueryWebService.queryApplyCaseList(firstReceiveNo);
        } catch (Exception e) {
            logger.error("DataQueryAction.queryApplyCaseList error", e);
            throw e;
        }
        return LIST;
    }

    @SuppressWarnings("unchecked")
    @Action(value = "queryImmiList", results = {@Result(name = LIST, location = "dataQuery.immiList", type = "tiles")})
    public String queryImmiList() throws Exception {
        logger.debug("DataQueryAction.queryImmiList");
        try {
            Object resp2 = getRequest().getSession().getAttribute("DATAQUERY_DETAIL_RESP");
            Object passportVoList2 = getRequest().getSession().getAttribute("DATAQUERY_DETAIL_PASSPORTNO_LIST");

            if (resp2 instanceof DataDetailResp) {
                PassportVo[] passportArray = new PassportVo[0];
                if (passportVoList2 != null) {
                    passportArray = ((List<PassportVo>) passportVoList2).toArray(passportArray);
                }
                immiList = dataQueryWebService.queryImmiList((DataDetailResp) resp2, passportArray);
            } else {
                immiList = new ArrayList<ImmiListResp>();
            }
        } catch (Exception e) {
            logger.error("DataQueryAction.queryImmiList error", e);
            throw e;
        }
        return LIST;
    }

    @Action(value = "queryInterviewList", results = {@Result(name = LIST, location = "dataQuery.interviewList", type = "tiles")})
    public String queryInterviewList() throws Exception {
        logger.debug("DataQueryAction.queryInterviewList");
        try {
            interviewList = dataQueryWebService.queryInterviewList(firstReceiveNo);
        } catch (Exception e) {
            logger.error("DataQueryAction.queryInterviewList error", e);
            throw e;
        }
        return LIST;
    }

    @Action(value = "queryInterviewDetail", results = {@Result(name = DETAIL, location = "dataQuery.interviewDetail", type = "tiles")})
    public String queryInterviewDetail() throws Exception {
        logger.debug("DataQueryAction.queryInterviewDetail");
        try {
            interviewResp = dataQueryWebService.queryInterview(interviewSeq);
        } catch (Exception e) {
            logger.error("DataQueryAction.queryInterviewDetail error", e);
            throw e;
        }
        return DETAIL;
    }

    /**
     * @return the req
     */
    public DataQueryReq getReq() {
        return req;
    }

    /**
     * @param req the req to set
     */
    public void setReq(DataQueryReq req) {
        this.req = req;
    }

    /**
     * @return the respList
     */
    public List<DataListResp> getRespList() {
        return respList;
    }

    /**
     * @param respList the respList to set
     */
    public void setRespList(List<DataListResp> respList) {
        this.respList = respList;
    }

    /**
     * @return the resp
     */
    public DataDetailResp getResp() {
        return resp;
    }

    /**
     * @param resp the resp to set
     */
    public void setResp(DataDetailResp resp) {
        this.resp = resp;
    }

    /**
     * @return the applyCaseList
     */
    public List<ApplyCaseListResp> getApplyCaseList() {
        return applyCaseList;
    }

    /**
     * @param applyCaseList the applyCaseList to set
     */
    public void setApplyCaseList(List<ApplyCaseListResp> applyCaseList) {
        this.applyCaseList = applyCaseList;
    }

    /**
     * @return the niiAddressVo
     */
    public NiiAddressVo getNiiAddressVo() {
        return niiAddressVo;
    }

    /**
     * @param niiAddressVo the niiAddressVo to set
     */
    public void setNiiAddressVo(NiiAddressVo niiAddressVo) {
        this.niiAddressVo = niiAddressVo;
    }

    /**
     * @return the firstReceiveNo
     */
    public String getFirstReceiveNo() {
        return firstReceiveNo;
    }

    /**
     * @param firstReceiveNo the firstReceiveNo to set
     */
    public void setFirstReceiveNo(String firstReceiveNo) {
        this.firstReceiveNo = firstReceiveNo;
    }

    /**
     * @return the residentIdNo
     */
    public String getResidentIdNo() {
        return residentIdNo;
    }

    /**
     * @param residentIdNo the residentIdNo to set
     */
    public void setResidentIdNo(String residentIdNo) {
        this.residentIdNo = residentIdNo;
    }

    /**
     * @return the immiList
     */
    public List<ImmiListResp> getImmiList() {
        return immiList;
    }

    /**
     * @param immiList the immiList to set
     */
    public void setImmiList(List<ImmiListResp> immiList) {
        this.immiList = immiList;
    }

    /**
     * @return the interviewList
     */
    public List<InterviewListResp> getInterviewList() {
        return interviewList;
    }

    /**
     * @param interviewList the interviewList to set
     */
    public void setInterviewList(List<InterviewListResp> interviewList) {
        this.interviewList = interviewList;
    }

    /**
     * @return the interviewResp
     */
    public InterviewDetailResp getInterviewResp() {
        return interviewResp;
    }

    /**
     * @param interviewResp the interviewResp to set
     */
    public void setInterviewResp(InterviewDetailResp interviewResp) {
        this.interviewResp = interviewResp;
    }

    /**
     * @return the interviewSeq
     */
    public String getInterviewSeq() {
        return interviewSeq;
    }

    /**
     * @param interviewSeq the interviewSeq to set
     */
    public void setInterviewSeq(String interviewSeq) {
        this.interviewSeq = interviewSeq;
    }
}
