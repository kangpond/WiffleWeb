/**
 * 
 */
package gov.nia.nrs.sys.action;

import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.login.bean.LoginICForm;
import gov.nia.nrs.utils.StringUtil;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import tw.com.chttl.CertUtil;

/**
 * @author Yang
 *
 */
public class UserCAApplyAction extends UserApplyAction {

	private static final Logger logger = Logger.getLogger(UserCAApplyAction.class);

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private LoginICForm loginIcForm;

	public LoginICForm getLoginIcForm(){
		return loginIcForm;
	}

	public void setLoginIcForm(LoginICForm loginIcForm){
		this.loginIcForm = loginIcForm;
	}
	
	
	@Action(value = "loginApply", results = { @Result(name = INPUT, location = "login", type = "tiles"),
			@Result(name = SUCCESS, location = "userApply.apply", type = "tiles")
	})
	public String loginApply() throws Exception
	{
		logger.debug("loginApply, loginIcForm=" + loginIcForm);

		message = "";
		if (loginIcForm == null || StringUtil.isEmpty(loginIcForm.getPersonId())
				|| StringUtil.isEmpty(loginIcForm.getPassword()))
		{
			message = "請輸入帳號和密碼";
			return INPUT;
		}
//		else if (StringUtil.isEmpty(loginIcForm.getSignedData()))
//		{
//			message = "取不到憑證的資訊，請確認卡片是否有接好";
//			return INPUT;
//		}

		try
		{
//			if (!StringUtil.isEmpty(verifyIc()))
//			{
//				return INPUT;
//			}
			prepare(StringUtils.EMPTY);
			userApply.setUserId(loginIcForm.getPersonId());
			userApply.setCertificateSn(loginIcForm.getCertSn());
			return SUCCESS;
		}
		catch (Exception e)
		{
			logger.error("auth error", e);
			message = "登入失敗!";
			return INPUT;
		}
	}
	
	
	
	@Action(value = "/saveUserApply",results={
			@Result(name = "success", location = "userAnnounce",type="redirectAction",params={"uuid","${userApply.getUuid()}"}),
			@Result(name = "input", location = "userApply.apply",type="tiles")
	})
	public String saveUserApply(){
//		String[] functionIds = getRequest().getParameterValues("functionId");
		String functionIds = getRequest().getParameter("functionIds");
		String[] citys = getRequest().getParameterValues("cityCode");
		userApply.setReportCity(StringUtils.join(citys, ","));
		
		List<Attachment> attachments = new ArrayList<Attachment>();
        attachments.add(new Attachment("userApply", "application/json", userApply));
        attachments.add(new Attachment("functionIds", "application/json", functionIds));
		
        UserProfile up = new UserProfile();
        up.setUserId(userApply.getUserId());
        up.setMaintainFunctionId("UserAccountApply");
        attachments.add(new Attachment("userProfile", "application/json", up));

        String direction = INPUT;
        String uuid = userApplyWebService.saveUserApply(attachments);
        if(!StringUtil.isEmptyOrBlank(uuid)){
        	userApply.setUuid(uuid);
			direction = SUCCESS;
		}else{
			prepare(StringUtils.EMPTY);
//			setUserFunctions(Arrays.asList(functionIds));
			setSelectedCitys(Arrays.asList(citys));
		}
		return direction;
	}
	
	@Action(value = "userAnnounce", results = {
			@Result(name = SUCCESS, location = "userApply.announ", type = "tiles")
	})
	public String userAnnounce(){
		return SUCCESS;
	}
	
	
	/**
	 * @return 非空白代表有錯誤
	 */
	private String verifyIc()
	{
		try
		{
			//目前沒有驗，只取SerialNumber
			byte[] byteCert = Base64.decodeBase64(loginIcForm.getSignedData());
			X509Certificate cert = CertUtil.generateCert(byteCert);
//			System.out.println("主體=" + cert.getSubjectDN());
//			System.out.println("發行者=" + cert.getIssuerDN());
//			System.out.println("效期始=" + cert.getNotBefore());
//			System.out.println("效期止=" + cert.getNotAfter());
//			System.out.println("SN=" + cert.getSerialNumber().toString(16));
//			System.out.println("CRL發佈點=" + CertUtil.getCRLDistributionPoint(cert));
//			System.out.println("發行者憑證發佈點=" + CertUtil.getIssuerURL(cert));
//			System.out.println("OCSP發佈點=" + CertUtil.getOCSP(cert));
//			System.out.println("正附卡註記=" + CertUtil.getCardType(cert));
//			System.out.println("憑證種類=" + CertUtil.getCertType(cert));
//			System.out.println("統一編號=" + CertUtil.getEnterpriseId(cert));
//			System.out.println("組織OID=" + CertUtil.getOrgOID(cert));
//			System.out.println("身份證末碼=" + CertUtil.getPersonId(cert));
//			System.out.println("主體形式=" + CertUtil.getSubjectType(cert));
//			System.out.println("主體OID=" + CertUtil.getSubjectTypeOID(cert));
			String serialNo = cert.getSerialNumber().toString(16);
			loginIcForm.setCertSn(serialNo);
			logger.info("verifyIc finish, loginIcForm=" + loginIcForm);
			return "";
		}
		catch (Exception e)
		{
			logger.error("verifyIc error", e);
			return "驗證失敗，請重新確認！";
		}
	}
}
