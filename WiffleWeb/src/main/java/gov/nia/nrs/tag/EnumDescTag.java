package gov.nia.nrs.tag;

import gov.nia.nrs.utils.TypeConverterManager;

import java.lang.reflect.Method;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;

public class EnumDescTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String value;
	private String type;
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public int doStartTag() throws JspException {
		if (StringUtils.isBlank(type))
			return SKIP_BODY;
		
		if (StringUtils.isBlank(value))
			return SKIP_BODY;
		
		boolean isEnum = false;
		
		String desc = "";
		try {
			// type 是 enum
			Class<Enum> enumClass = (Class<Enum>) Class.forName(type);
			Method method = enumClass.getMethod("values", null);
			Object[] oos = (Object[])method.invoke(null);
			
			Object selected = null;
			for (Object o : oos) {
//				if (o instanceof CodeProvider) {
//					if (((CodeProvider)o).getCode().equals(value)) {
//						selected = o;
//						break;
//					}
//				} else {
					method = enumClass.getMethod("getCode", null);
					if (method.invoke(o) instanceof String) {
						String code = (String)method.invoke(o);
						if (value.equals(code)) {
							selected = o;
							break;
						}
					}
//				}
			}
			
			if (selected != null) {
				Enum selectedEnum = (Enum) selected;
				desc = selectedEnum.toString();
			}

			if (StringUtils.isNotBlank(desc)){
				isEnum = true;
			}

			if (isEnum) {
				this.pageContext.getOut().print(desc);
				return SKIP_BODY;
			}
		} catch (Exception e) {
			//throw new JspException("ValueConverterTag 執行錯誤" , e);
		}
	
		try {
			// type 是 TypeConverter
			desc = TypeConverterManager.convertToString(type, value); 

			if (StringUtils.isNotBlank(desc))
				this.pageContext.getOut().print(desc);
			
		} catch (Exception e) {
			//throw new JspException("ValueConverterTag 執行錯誤" , e);
		}
		
		return SKIP_BODY;
	}
	
}
