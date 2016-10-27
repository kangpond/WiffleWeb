package gov.nia.nrs.service;

import gov.nia.nrs.bean.AuditQueryBean;
import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.dao.AuditQueryDao;
import gov.nia.nrs.dao.ReportMgmtDao;
import gov.nia.nrs.dao.iis.CodeDataDao;
import gov.nia.nrs.domain.Audit;
import gov.nia.nrs.eums.ProcessStateEnum;
import gov.nia.nrs.utils.ActionType;
import gov.nia.nrs.utils.BeanClone;
import gov.nia.nrs.utils.DateUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service("auditQuerySevice")
public class AuditQuerySeviceImpl implements AuditQuerySevice {

    private static final Logger log = Logger.getLogger(AuditQuerySeviceImpl.class);

    @Resource AuditQueryDao auditQueryDao;
    @Resource ReportMgmtDao reportMgmtDao;
    @Resource ReportService reportService;
//    @Resource AuditCreateDao auditCreateDao;
    @Resource CodeDataDao codeDataDao;
    
    
    
    @Value("${maxrowcount}")
    private int maxrowcount;
    /**
     * 
     */
    @Value("${report.folder}")
    private String caseReportFolder;
    
    @Override
    public String searchAuditQuery(AuditQueryBean queryBean,UserProfile up,String reportId) throws Exception{
      String filePath =""; 
      try {
//    	  	long startTime = System.currentTimeMillis();
	  		int totalCount = auditQueryDao.totalCount(queryBean,up,"Audit");
	  		log.debug("VAllAuditQuery totalCount:"+totalCount);
	  		if(totalCount > 0){
	  			int offset = calPageSize(totalCount);
		  		log.debug("VAllAuditQuery offset:"+ offset);
	    	  
		  		String folder = getFilePath();
//		  		auditCreateDao.createQueryAudit(queryBean, up);
		  		
		  		boolean isZip = false;
		  		if(offset > 1) isZip = true;
		  		
		  		for(int i=0; i<offset;i++){
					List<Audit> _list = (List<Audit>) auditQueryDao.search(queryBean,up, Audit.class,true,i,50000);
					List<Map<String,Object>> collection = new ArrayList<Map<String,Object>>();
					for(Audit vaq:_list){
						Map<String,Object> oMap = new HashMap<String, Object>();
			    		BeanClone.object2Map(vaq, oMap, null);

						if(StringUtils.isNotBlank(vaq.getActionType())){
							oMap.put("actionType", ActionType.byType(vaq.getActionType()).toString());
						}
						if(StringUtils.isNotBlank(vaq.getType())){
//							oMap.put("type", sysMappingService.getSystemName(vaq.getType()));
						}
						
						if(StringUtils.isNotBlank(vaq.getNation())){
//							oMap.put("nation", codeDataDao.getDataValue(vaq.getNation()));
						}
						
						if(vaq.getAuditTime() != null){
							oMap.put("auditTime", DateUtils.getDateToString(vaq.getAuditTime(), "yyyy/MM/dd HH:mm:ss"));
						}
						
						if(vaq.getLast2updateTime() != null){
							oMap.put("last2updateTime", DateUtils.getDateToString(vaq.getLast2updateTime(), "yyyy/MM/dd HH:mm:ss"));
						}
						
						collection.add(oMap);
					}
					//如果不需壓縮 直接回傳 filePath
					filePath = reportService.exportReport(collection,queryBean,up,folder,isZip);
				}
		  		if(offset > 1)
		  			filePath = execRuntime(folder);
	  		}else{
	  			//查無資料
	  			if(StringUtils.isNotEmpty(reportId))
	  			  reportMgmtDao.updateReportMgmt(reportId, null, ProcessStateEnum.notfound.getState());
	  		}
	  		
//	  	 log.debug("Generate VAllAuditQuery cost : " + DateUtils.getProcessTime(System.currentTimeMillis() - startTime));	
	   } catch (Exception e) {
		   log.error("AuditQuerySeviceImpl searchAuditQuery:", e);
		  if(StringUtils.isNotEmpty(reportId))
			  reportMgmtDao.updateReportMgmt(reportId, null,ProcessStateEnum.exception.getState());
		  throw e;
	   } finally {
		   log.debug("===== Finish Call AuditQuerySeviceImpl searchAuditQuery =====");
	   }
       return filePath;
    }

    
	private String getFilePath(){
		String reportDate = DateUtils.getDateToString(new Date(), "yyyyMMdd");
		String folerName = DateUtils.getDateToString(new Date(), "yyyyMMddHHmmssSS");
		StringBuilder path = new StringBuilder(caseReportFolder);
			path.append("AuditCloud"+reportDate).append(File.separator);
			path.append("AuditNRSQuery");
		
		path.append("_").append(folerName).append(File.separator);
		
		File f = new File(path.toString());
		if(!f.getParentFile().exists() || !f.exists()){
			f.mkdirs();
		}
		log.debug("Export Excel file Path:"+ f.getAbsolutePath());
		return f.getAbsolutePath();
	}
	
	private int calPageSize(int totalCount){
		int offset = 0;
		offset += Math.ceil(totalCount/maxrowcount);
		if(totalCount%maxrowcount > 0){
			offset += 1;
		}
		return offset;
	}
	
	private String execRuntime(String filePath) throws IOException, InterruptedException{
		Runtime rt = Runtime.getRuntime();
		Process proc = rt.exec("jar -cvfM "+filePath+".zip -C "+filePath+File.separator+" .");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream(),"UTF-8"));
		String line = null;
		while((line = in.readLine()) != null){
			System.out.println(line);
			log.debug("Process result :"+line);
		}
		
		int result = proc.waitFor();
		log.debug("waitFor result :"+result);
		if(result == 0){
			File f = new File(filePath);
			FileUtils.cleanDirectory(f);
			if(f.isDirectory()){
				f.delete();
			}
		}
		
		if(in != null){
			in.close();
		}
		
		return filePath+".zip";
	}
	
}
