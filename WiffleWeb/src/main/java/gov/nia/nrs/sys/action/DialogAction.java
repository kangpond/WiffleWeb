package gov.nia.nrs.sys.action;

import gov.nia.nrs.action.BaseAction;

import java.util.Collection;

public abstract class DialogAction extends BaseAction{

	private static final long serialVersionUID = 1L;

	protected String keyword;

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public abstract String getLists();
	
	public abstract String getDescs();
}
