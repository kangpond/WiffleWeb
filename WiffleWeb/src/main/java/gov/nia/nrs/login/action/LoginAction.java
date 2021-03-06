package gov.nia.nrs.login.action;

import gov.nia.nrs.action.BaseAction;
import gov.nia.nrs.bean.UserProfile;
import gov.nia.nrs.login.bean.LoginICForm;
import gov.nia.nrs.login.ws.LoginWebService;
import gov.nia.nrs.utils.StringUtil;

import java.security.cert.X509Certificate;

import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import tw.com.chttl.CertUtil;

import com.fasterxml.jackson.core.JsonProcessingException;

@Namespace("/")
public class LoginAction extends BaseAction
{
	private static final long serialVersionUID = 1065628500030886171L;
	private static final Logger logger = Logger.getLogger(LoginAction.class);

	@Autowired
	private LoginWebService loginWebService;

	private LoginICForm loginIcForm;

	@Action(value = "login", results = { @Result(name = SUCCESS, location = "login", type = "tiles") })
	public String login() throws Exception
	{
		logger.debug("login");
		return SUCCESS;
	}

	@Action(value = "auth", results = { @Result(name = INPUT, location = "login", type = "tiles"),
			@Result(name = SUCCESS, location = "/home", type = "redirect") })
	public String auth() throws Exception
	{
		logger.debug("auth, loginIcForm=" + loginIcForm);

		message = "";
		if (loginIcForm == null || StringUtil.isEmpty(loginIcForm.getPersonId())
				|| StringUtil.isEmpty(loginIcForm.getPassword()))
		{
			message = "請輸入帳號和密碼";
			return INPUT;
		}
		else if (StringUtil.isEmpty(loginIcForm.getSignedData()))
		{
			message = "取不到憑證的資訊，請確認卡片是否有接好";
			return INPUT;
		}

		try
		{
			message = verifyIc();
			if (!StringUtil.isEmpty(message))
			{
				return INPUT;
			}

			message = authUser();
			if (!StringUtil.isEmpty(message))
			{
				return INPUT;
			}
			return SUCCESS;
		}
		catch (Exception e)
		{
			logger.error("auth error", e);
			message = "登入失敗!";
			return INPUT;
		}
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

	/**
	 * @return 非空白代表有錯誤
	 * @throws JsonProcessingException
	 */
	private String authUser() throws JsonProcessingException
	{
		String msg = "";
		UserProfile userProfile = loginWebService.auth(loginIcForm.getPersonId(), loginIcForm.getCertSn());
		if (userProfile != null && StringUtils.isEmpty(userProfile.getErrMsg()))
		{
			getHttpSession().setAttribute("userProfile", userProfile);
		}
		else
		{
			msg = userProfile.getErrMsg();
		}
		return msg;
	}

	@Action(value = "authtest", results = { @Result(name = INPUT, location = "login", type = "tiles"),
			@Result(name = SUCCESS, location = "home", type = "redirect") })
	public String authtest() throws Exception
	{
		logger.debug("authtest, loginIcForm=" + loginIcForm);

		message = "";
		if (loginIcForm == null || StringUtil.isEmpty(loginIcForm.getPersonId())
				|| StringUtil.isEmpty(loginIcForm.getPassword()))
		{
			message = "請輸入帳號和密碼";
			return INPUT;
		}

		try
		{
			message = authUser();
			if (!StringUtil.isEmpty(message))
			{
				return INPUT;
			}
			return SUCCESS;
		}
		catch (Exception e)
		{
			logger.error("authtest error", e);
			message = "登入失敗!";
			return INPUT;
		}
	}

	@Action(value = "logout", results = { @Result(name = SUCCESS, location = "login", type = "tiles") })
	public String logout() throws Exception
	{
		logger.debug("logout");
		HttpSession session = getHttpSession();

		if (session != null)
		{
			session.removeAttribute("userProfile");
			session.invalidate();
		}
		return SUCCESS;
	}

	public LoginICForm getLoginIcForm()
	{
		return loginIcForm;
	}

	public void setLoginIcForm(LoginICForm loginIcForm)
	{
		this.loginIcForm = loginIcForm;
	}
}
