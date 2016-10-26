package gov.nia.nrs.eums;

public enum ProcessStateEnum {

	
	processing("1","執行中"),
	completed("2","完成"),
	exception("3","執行異常"),
	notfound("4","查無資料");
	
	private String state;
	private String description;
	
	private ProcessStateEnum(String state, String description) {
		this.state = state;
		this.description = description;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
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
	
	public static ProcessStateEnum fromState(String state) {
		ProcessStateEnum result = null;
		for (ProcessStateEnum p : ProcessStateEnum.values()) {
			if (p.state.equals(state)) {
				result = p;
				break;
			}
		}
		return result;
	}
}
