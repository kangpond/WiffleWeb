package gov.nia.nrs.service;

import gov.nia.nrs.bean.AuditQueryBean;
import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.dao.AuditSummaryDao;
import gov.nia.nrs.dao.CityDao;
import gov.nia.nrs.dao.UserApplyDao;
import gov.nia.nrs.domain.Functions;
import gov.nia.nrs.domain.UserApply;
import gov.nia.nrs.eums.FieldEnum;
import gov.nia.nrs.utils.BeanClone;
import gov.nia.nrs.utils.DateUtils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.annotation.Resource;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;
import net.sf.jasperreports.engine.export.JExcelApiExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Base64Utils;

import com.lowagie.text.pdf.PdfWriter;

@Service("reportService")
@Transactional
public class ReportServiceImpl implements ReportService {
	
    private static final Logger log = Logger.getLogger(ReportServiceImpl.class);

	@Autowired ApplicationContext appContext;
	@Resource AuditSummaryDao auditSummaryDao;
	@Resource UserApplyDao userApplyDao;
	@Resource CityDao cityDao; 
//	@Resource AuditCreateDao auditCreateDao;
	@Resource GovernmentService governmentService;
	@Resource FunctionService functionService;
    @Resource UserApplyFunctionService userApplyFunctionService;
    
	@Override
	public String exportReport(List<? extends Object> inputList,AuditQueryBean queryBean,UserProfile up,String folder,boolean isZip) throws Exception {
		Map<String,Object> parameter = new HashMap<String,Object>();  
		parameter.put("startDate", queryBean.getStartDate());
		parameter.put("endDate", queryBean.getEndDate());
		//這邊之後要跟EIP串
		parameter.put("createDeptName", up.getDeptName());
		parameter.put("createUser", up.getUserName());
		parameter.put("conditions", getQueryValues(queryBean));
		
		JasperPrint jp = getJasperPrint(inputList,parameter,"audits");
		
		//getZipFile(jpList,queryBean.getOperationType());
		return writeExcelFile(jp,folder,isZip);
	}
	
	
	private String writeExcelFile(JasperPrint jp,String folder,boolean isZip) throws IOException, JRException{
		String fileName = folder+File.separator+jp.getName()+"_"+DateUtils.getDateToString(new Date(), "yyyyMMddHHmmssSS")+".xls";
		OutputStream os = new FileOutputStream(fileName, false);
		os.write(exportExcel(jp));
		os.flush();
		os.close();
		return isZip?folder:fileName;
	}
	
	@Deprecated
	private String getZipFile(List<JasperPrint> jpList,String reportType) throws IOException, JRException{
		String fileName = ""; //getFilePath(reportType);
		OutputStream os = new FileOutputStream(fileName, false);
		ZipOutputStream zos = new ZipOutputStream(new BufferedOutputStream(os));
		
		for(JasperPrint jp :jpList){
			ZipEntry zip = new ZipEntry(jp.getName()+"_"+DateUtils.getDateToString(new Date(), "yyyyMMddHHmmssSS")+".xls");
			zos.setLevel(Deflater.NO_COMPRESSION);
			zos.putNextEntry(zip);
			zos.write(exportExcel(jp));
			zos.closeEntry();
		}
		zos.finish();
		zos.close();
		return fileName;
	}
	
	private String getQueryValues(AuditQueryBean queryBean) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		StringBuffer condtions = new StringBuffer();
		Map<?, ?> beanMap = BeanUtils.describe(queryBean);
		
		if (beanMap != null) {
			for (Object key : beanMap.keySet()) {
			  if ("class".equalsIgnoreCase((String) key) 
					  	|| "metaClass".equalsIgnoreCase((String) key) )
					continue;
			  
	          if (StringUtils.isNotBlank((String) beanMap.get(key))) {
	        	condtions.append(FieldEnum.fromFields((String) key).getFieldName()).append(":");
		        condtions.append((String) beanMap.get(key));
		        condtions.append(",");
	          }
			}
		}
		
		return condtions.toString().substring(0, condtions.toString().lastIndexOf(","));
	}
	
	private JasperPrint getJasperPrint(List<?> resultList,Map<String,Object> parameter,String jasperName) throws IOException, JRException{
		JRDataSource dataSource = null;
		if(resultList != null && resultList.size() > 0 ){
			dataSource = new JRBeanCollectionDataSource(resultList,false);
		}else{
			dataSource = new JREmptyDataSource();
		}
		File reports = appContext.getResource("/report/" + jasperName + ".jasper").getFile();
		
		log.debug("jasper path:"+reports.getPath());
		JasperReport jasperReport = (JasperReport)JRLoader.loadObject(reports);//loadObject(realpath);
		JasperPrint	_print = JasperFillManager.fillReport(jasperReport, parameter, dataSource);
		return _print;
	}
	
	
	private byte[] exportExcel(JasperPrint print) throws JRException, IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		JRAbstractExporter exporter = new JExcelApiExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,  print);
		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, true);
		//exporter.setParameter(JRXlsExporterParameter.MAXIMUM_ROWS_PER_SHEET, 50000);
		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, false);
		exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN, true);
		exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, true);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, baos);
		exporter.setParameter(JRXlsExporterParameter.PASSWORD, "!@#$??zxcv");
		exporter.exportReport();
		baos.flush();
		baos.close();
		return baos.toByteArray();
	}
	
	
	private void exportExcel(JasperPrint print, OutputStream os) throws JRException, IOException {
		JRAbstractExporter exporter = new JExcelApiExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT,  print);
//		exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, true);
//		exporter.setParameter(JRXlsExporterParameter.MAXIMUM_ROWS_PER_SHEET, 55000);
		exporter.setParameter(JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, false);
		exporter.setParameter(JRXlsExporterParameter.IS_COLLAPSE_ROW_SPAN, true);
		exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE, true);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, os);
		exporter.exportReport();
		os.flush();
		os.close();
	}
	
	private void exportPdfList(List<JasperPrint> printList, OutputStream os){
		try {
			JRPdfExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRPdfExporterParameter.OUTPUT_STREAM, os);
			exporter.setParameter(JRPdfExporterParameter.JASPER_PRINT_LIST, printList);
//			exporter.setParameter(JRPdfExporterParameter.IS_ENCRYPTED, Boolean.TRUE);
//			exporter.setParameter(JRPdfExporterParameter.IS_128_BIT_KEY, Boolean.TRUE);
			exporter.setParameter(JRPdfExporterParameter.PERMISSIONS,new Integer(PdfWriter.AllowPrinting));
			exporter.exportReport();
			os.flush();
			os.close();
		} catch (JRException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private JasperReport getSubReport(String jasperName) throws IOException, JRException{
		File reports = appContext.getResource("/report/" + jasperName + ".jasper").getFile();
		JasperReport jasperReport = (JasperReport)JRLoader.loadObject(reports);
		return jasperReport;
	}
	
	
	@Override
	public String exportSummaryByDay(UserProfile up, String startDate, String endDate, String userId) throws Exception{
		Map<String,Object> param = new HashMap<String,Object>();
		param.put("startDate", startDate);
		param.put("endDate", endDate);
		param.put("createDeptName", up.getDeptName());
		param.put("createUser", up.getUserName());
		param.put("deptName", up.getDeptName());
		//SUBREPORT
		param.put("SUBREPORT", getSubReport("summaryByDay_subreport1"));
		
		List<Map<String,?>> summary= auditSummaryDao.searchSummaryByDay(up,startDate,endDate,userId);
		param.put("LIST", new JRMapCollectionDataSource(summary));
		
		JasperPrint jasper = getJasperPrint(null,param,"summaryByDay");
		ByteArrayOutputStream  boas = new ByteArrayOutputStream();
		exportExcel(jasper,boas);
		
		//寫audit
//		auditCreateDao.createQueryAudit(queryBean, up);
		return  Base64Utils.encodeToString(boas.toByteArray());
	}


	@Override
	public String downloadApplyFrom(String uuid) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, IOException, JRException {
		Map<String,Object> params = new HashMap<String,Object>(); 
		ByteArrayOutputStream  boas = new ByteArrayOutputStream();
		List<JasperPrint> jasperList = new  ArrayList<JasperPrint>();
		List<Map<String,?>> dataList = new ArrayList<Map<String,?>>();
		UserApply ua = userApplyDao.find(uuid);
		BeanClone.object2Map(ua, params, null);
		
		if(params != null && !params.isEmpty()){
			if(params.get("deptId") != null){
				params.put("organName", governmentService.getGovDesc(ua.getDeptId()));
			}
			
			if(params.get("reportCity") != null){
				params.put("reportCity", cityDao.getCityDesc(ua.getReportCity().split(",")));
			}
			
			List<String> userFunctions = userApplyFunctionService.getApplyFunctionList(uuid);
			List<Functions> subFuncList = functionService.getFunctionList(new Functions("1", "1", null, null, null));
			
			for(Functions sub : subFuncList){
				Map<String,String> fMap = new HashMap<String, String>();
				fMap.put("mainNode", functionService.getFunctionName(sub.getUpperFunctionId()));
				fMap.put("subNode", sub.getFunctionName());
				
				for(String fid : userFunctions){
					if(StringUtils.equalsIgnoreCase(sub.getFunctionId(), fid)){
						fMap.put("check", "V");
					}
				}
				
				dataList.add(fMap);
			}
		}
		
		params.put("SUBREPORT", getSubReport("userApplyFrom_subreport1"));
		params.put("LIST", new JRMapCollectionDataSource(dataList));
		
		jasperList.add(getJasperPrint(null ,params,"userApplyFrom"));
		jasperList.add(getJasperPrint(null ,null,"userApplyFrom2"));
		exportPdfList(jasperList,boas);
		return Base64Utils.encodeToString(boas.toByteArray());
	}
	
}
