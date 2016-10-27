package gov.nia.nrs.dao;

import gov.nia.nrs.bean.AuditQueryBean;
import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.domain.ReportMgmt;
import gov.nia.nrs.eums.ProcessStateEnum;
import gov.nia.nrs.utils.DateUtils;

import java.io.File;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("reportMgmtDao")
@Transactional
public class ReportMgmtDaoImpl extends BaseDaoImpl<ReportMgmt, String> implements ReportMgmtDao {
	
    private static final Logger log = Logger.getLogger(ReportMgmtDaoImpl.class);

	@Override
	public String createReportMgmt(AuditQueryBean queryBean,UserProfile up) {
		ReportMgmt mgmt = new ReportMgmt();
		log.debug("ReportMgmtDaoImpl createReportMgmt.....");
		BeanUtils.copyProperties(queryBean, mgmt);
		if(StringUtils.isNotBlank(queryBean.getStartDate())){
			mgmt.setStartDate(DateUtils.formatStrDateWOSlash(queryBean.getStartDate()));
		}
		if(StringUtils.isNotBlank(queryBean.getEndDate())){
			mgmt.setEndDate(DateUtils.formatStrDateWOSlash(queryBean.getEndDate()));
		}
		if(StringUtils.isNotBlank(queryBean.getBirthDate())){
			mgmt.setEndDate(DateUtils.formatStrDateWOSlash(queryBean.getBirthDate()));
		}
		mgmt.setRequestTime(new Date());
		mgmt.setUserId(queryBean.getUserId());
		//登入者的ID來產生NoSQLKey
		mgmt.setReportId(createReportKey(up.getUserId()));
		mgmt.setReportDeptId(up.getDeptId());
		mgmt.setReportUserId(up.getUserId());
		mgmt.setReportName("稽核查詢紀錄");
		mgmt.setSubType("0");
		mgmt.setProcessState(ProcessStateEnum.processing.getState());
		
		save(mgmt);
		return mgmt.getReportId();
	}
	
	private ReportMgmt getReportMgmt(String reportId){
		return find(reportId);
	}
	
	@Override
	public void updateReportMgmt(String reportId, String filePath ,String state){
		ReportMgmt mgmt = getReportMgmt(reportId);
		if(mgmt != null){
			log.debug("Saving  ReportMgmt :" +reportId);
			mgmt.setProcessState(state);
			mgmt.setResponTime(new Date());
			mgmt.setFilePath(filePath);
			save(mgmt);
			flush();
		}
	}


	@Override
	public Map<String,Object> getReportMgmtList(ReportMgmt mgnt,UserProfile up,int offset) {
		int max = 10;
		
		Map<String,Object> condition = new HashMap<String,Object>();
		StringBuffer sb = new StringBuffer(" from ReportMgmt  ");
		//TODO 這裡要問清楚是否要帶登入者帳號，ReportMgmt.userId 是查詢條件
		sb.append(" where reportUserId =:userId ");
		condition.put("userId", up.getUserId());
		
		if(StringUtils.isNotBlank(up.getDeptId())){
			sb.append(" and reportDeptId =:depId ");
			condition.put("depId", up.getDeptId());
		}
		
		if(StringUtils.isNotBlank(mgnt.getStartDate()) && 
				StringUtils.isNotBlank(mgnt.getEndDate())){
			sb.append(" and requestTime between :startDate and :endDate ");
			condition.put("startDate", DateUtils.getDateFromString(mgnt.getStartDate(),"0","0","0"));
			condition.put("endDate", DateUtils.getDateFromString(mgnt.getEndDate(),"23","59","59"));
		}
//		else{
//			Date today = new Date();
//			condition.put("startDate", DateUtils.getDateFromString(today,"0","0","0"));
//			condition.put("endDate", DateUtils.getDateFromString(today,"23","59","59"));
//		}
		
		int totalCount = 0;
		StringBuffer countHql = new StringBuffer(sb.toString());
        countHql.insert(0, "select count(reportId) ");
        Query count = getSession().createQuery(countHql.toString());
        for (String key : condition.keySet()) {
            count.setParameter(key, condition.get(key));
        }
        List<Long> _clist = count.list();
        if (_clist != null && _clist.size() > 0) {
            totalCount = _clist.get(0).intValue();
        }
        sb.append("order by requestTime desc");
        
        Query query = getSession().createQuery(sb.toString());
        query.setMaxResults(max);
        query.setFirstResult(offset * max);
        for (String key : condition.keySet()) {
            query.setParameter(key, condition.get(key));
        }
        List<ReportMgmt> qList = query.list();
		
        Map<String,Object> returnMap = new HashMap<String,Object>();
        returnMap.put("totalCount", totalCount);
        List<Map<String,Object>> rList = new ArrayList<Map<String,Object>>();
        returnMap.put("reportMgmtList", rList);
        if(qList != null && qList.size() >0){
        	for(ReportMgmt r:qList){
        		Map<String,Object> rMap = new HashMap<String,Object>();
        		rMap.put("reportName", r.getReportName());
        		rMap.put("requestTime", r.getRequestTime());
        		rMap.put("responTime", r.getResponTime());
        		rMap.put("processState", r.getProcessState());
        		rMap.put("filePath", r.getFilePath());
        		rMap.put("reportId", r.getReportId());
        		rMap.put("isExist", isExist(r.getFilePath()));
        		rList.add(rMap);
        	}
        }
		return returnMap;
	}
	
	private boolean isExist(String filePath){
		boolean isExist = false;
		if(StringUtils.isNotEmpty(filePath)){
			isExist = new File(filePath).exists();
		}
		return isExist;
	}
	
	
	
	public String createReportKey(String userId){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
		SimpleDateFormat codeSdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		Date begin = new Date();
		String key = sdf.format(begin);
		String codeStr = codeSdf.format(begin);

		String shaKey = userId + codeStr;
		log.debug("shaKey :"+shaKey);
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-1");	
			md.update(shaKey.getBytes());
			BigInteger bi = new BigInteger(1, md.digest());
	        String biKey = bi.toString(16).toUpperCase();
	        //System.out.println("biKey :"+biKey);
	        log.debug("biKey :"+biKey);
	        if(StringUtils.isNotBlank(biKey) && biKey.length()>=4){
	        	int len = biKey.length();
	        	key = key + biKey.substring(len-4, len);
	        }
	        log.debug(key);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return key;
	}
}
