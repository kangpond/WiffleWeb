package gov.nia.nrs.eums;

/**
 * 撤參註記
 */
public enum DeleteMark {
	
	YES	("Y", "是"), 
	NO	("N", "否");

	private String code;
	private String description;

	DeleteMark(String code, String description) {
		this.code = code;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return description;
	}
	
	public static DeleteMark fromCode(String code) {
		DeleteMark result = NO;
		for (DeleteMark item : DeleteMark.values()) {
			if (item.getCode().equals(code)) {
				result = item;
				break;
			}
		}
		return result;
	}
}
