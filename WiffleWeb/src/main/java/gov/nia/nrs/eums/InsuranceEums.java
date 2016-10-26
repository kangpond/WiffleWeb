package gov.nia.nrs.eums;

public enum InsuranceEums {
	
	I1("變","變更身分"),
	I2("退","退保"),
	I3("調","薪資調整"),
	I4("加","加保"),
	S1("1","在保中"),
	S2("2","停保"),
	S3("3","轉出"),
	S4("4","一般退保"),
	S5("5","死亡退保");
	
	private String code;
	private String description;
	
	private InsuranceEums(String code, String description) {
		this.code = code;
		this.description = description;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public static String fromCode(String code) {
		InsuranceEums result = null;
		for (InsuranceEums i : InsuranceEums.values()) {
			if (i.code.equals(code)) {
				result = i;
				break;
			}
		}
		return result.getDescription();
	}
	
	@Override
	public String toString() {
		return description;
	}
}
