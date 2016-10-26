package gov.nia.nrs.login.bean;

public class LoginICForm
{
	private String personId;
	/** 憑證PIN碼(密碼) */
	private String password;
	/** Session ID */
	private String content;
	/** 憑證序號 */
	private String certSn;
	/** 憑證卡號 */
	private String certCardNumber;
	/** 自然人序號 */
	private String subjectSN;
	/** 擁有者名稱 */
	private String certOwnerName;
	/** 名稱 */
	private String certUserName;
	/** 憑證擁有者ID */
	private String ownerId;
	/** 憑證主卡或附卡 */
	private String isMainCard;
	/** 憑證主旨 */
	private String certSubject;
	/** 憑證主體 */
	private String signedData;

	public String getPersonId()
	{
		return personId;
	}

	public void setPersonId(String personId)
	{
		this.personId = personId;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getCertSn()
	{
		return certSn;
	}

	public void setCertSn(String certSn)
	{
		this.certSn = certSn;
	}

	public String getCertCardNumber()
	{
		return certCardNumber;
	}

	public void setCertCardNumber(String certCardNumber)
	{
		this.certCardNumber = certCardNumber;
	}

	public String getSubjectSN()
	{
		return subjectSN;
	}

	public void setSubjectSN(String subjectSN)
	{
		this.subjectSN = subjectSN;
	}

	public String getCertOwnerName()
	{
		return certOwnerName;
	}

	public void setCertOwnerName(String certOwnerName)
	{
		this.certOwnerName = certOwnerName;
	}

	public String getCertUserName()
	{
		return certUserName;
	}

	public void setCertUserName(String certUserName)
	{
		this.certUserName = certUserName;
	}

	public String getOwnerId()
	{
		return ownerId;
	}

	public void setOwnerId(String ownerId)
	{
		this.ownerId = ownerId;
	}

	public String getIsMainCard()
	{
		return isMainCard;
	}

	public void setIsMainCard(String isMainCard)
	{
		this.isMainCard = isMainCard;
	}

	public String getCertSubject()
	{
		return certSubject;
	}

	public void setCertSubject(String certSubject)
	{
		this.certSubject = certSubject;
	}

	public String getSignedData()
	{
		return signedData;
	}

	public void setSignedData(String signedData)
	{
		this.signedData = signedData;
	}

	private String enCodePassword()
	{
		if (password == null)
		{
			return "";
		}
		else
		{
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < password.trim().length(); i++)
				sb.append("*");
			return sb.toString();
		}
	}

	@Override
	public String toString()
	{
		return "LoginICForm [personId=" + personId + ", password=" + enCodePassword() + ", content=" + content
				+ ", certSn=" + certSn + ", certCardNumber=" + certCardNumber + ", subjectSN=" + subjectSN
				+ ", certOwnerName=" + certOwnerName + ", certUserName=" + certUserName + ", ownerId=" + ownerId
				+ ", isMainCard=" + isMainCard + ", certSubject=" + certSubject + ", signedData.length="
				+ ((signedData == null) ? "0" : signedData.length()) + "]";
	}

}
