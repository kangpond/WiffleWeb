package gov.nia.nrs.eums;


public enum FieldEnum {
	type("type","系統別"),
	startDate("startDate","起始日期"),
	endDate("endDate","結束日期"),
	actionType("actionType","動作"),

	personId("personId","身分證號"),
	passportNo("passportNo","護照號碼"),
	permitNo("permitNo","收件號"),
	residentIdNo("residentIdNo","居留證碼 "),
	firstReceiveNo("firstReceiveNo","首次收件號"),
	nation("nation","國籍"),
	chineseName("chineseName","中文姓名"),
	englishName("englishName","英文姓名"),
	birthDate("birthDate","出生日期"),

	userId("userId","帳號"),
	userName("userName","姓名"),
	deptId("deptId","單位"),
	deptType("deptType","單位類別");
	
	private String field;
	private String fieldName;
	
	private FieldEnum(String field, String fieldName) {
		this.field = field;
		this.fieldName = fieldName;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public static FieldEnum fromFields(String fieldName) {
		FieldEnum result = null;
		for (FieldEnum field : FieldEnum.values()) {
			if (field.field.equals(fieldName)) {
				result = field;
				break;
			}
		}
		return result;
	}
}
