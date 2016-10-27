package gov.nia.nrs.utils;

import java.io.Serializable;

public enum ActionType implements Serializable {
	Login("0", "登入"),
	Logout("1", "登出"),
	Add("2", "新增"),
	Update("3", "修改"),
	Query("4", "查詢"),
	Delete("5", "刪除"),
	Print("6", "列印"),
	Unknown("9", "Unknown"),
	Revoke("10","撤管"),
	Unrevoke("11", "取消撤管");

	private String type;
	private String description;

	private ActionType(final String type, final String description) {
		this.type = type;
		this.description = description;
	}

	public String toString() {
		return description;
	}

	public static ActionType fromString(final String type) {
		return byType(type);
	}

    public static ActionType byType(final String type) {
        for (ActionType e : ActionType.values()) {
            if (e.type.equals(type)) {
                return e;
            }
        }
        return Unknown;
    }

    public String getType() {
    	return this.type;
    }
}