package gov.nia.nrs.sys.action;

import gov.nia.nrs.action.BaseAction;
import gov.nia.nrs.ws.ReportWebService;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.util.Base64Utils;

@Namespace("/report")
public class ReportAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@Resource ReportWebService reportWebService;
	
	
	private InputStream is;
	private String exportFileName;
	private String contentType;
	
	public InputStream getIs() {
		return is;
	}

	public void setIs(InputStream is) {
		this.is = is;
	}
	
	public String getExportFileName() {
		return exportFileName;
	}

	public void setExportFileName(String exportFileName) {
		this.exportFileName = exportFileName;
	}
	
	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	@Action(value = "/downloadAuditReport", results = {@Result(type = "stream", params = {"contentType", "%{contentType}", "inputName", "is", "contentDisposition",
            "attachement;filename=%{exportFileName}", "buffersize", "1024"})})
	public String downloadAuditReport(){
		try {
			String ext = FilenameUtils.getExtension(getRequest().getParameter("filePath"));
			setContentType("application/"+ext);
			File file = new File(FilenameUtils.normalize(getRequest().getParameter("filePath")));
			exportFileName = file.getName();
			
			is = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return SUCCESS;
	}
	
	@Action(value = "/searchSummaryByDay", results = {@Result(type = "stream", params = {"contentType", "application/xls", "inputName", "is", "contentDisposition",
            "attachement;filename=%{exportFileName}", "buffersize", "1024"})})
	public String searchSummaryByDay(){
		try {
			setExportFileName("summaryByDay.xls");
			String startDate = getRequest().getParameter("startDate");
			String endDate = getRequest().getParameter("endDate");
			String userId = getRequest().getParameter("userId");
			String report = reportWebService.exportSummaryByDay(getUserProfile(),startDate,endDate,userId);
			is = new ByteArrayInputStream(Base64Utils.decodeFromString(report));
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return SUCCESS;
	}
	
	@Action(value = "/downloadApplyFrom", results = {@Result(type = "stream", params = {"contentType", "application/pdf", "inputName", "is", "contentDisposition",
            "attachement;filename=%{exportFileName}", "buffersize", "1024"})})
	public String downloadApplyFrom(){
		try {
			setExportFileName("applyFunctionFrom.pdf");
			String report = reportWebService.downloadApplyFrom(getRequest().getParameter("uuid"));
			is = new ByteArrayInputStream(Base64Utils.decodeFromString(report));
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return SUCCESS;
	}
}
