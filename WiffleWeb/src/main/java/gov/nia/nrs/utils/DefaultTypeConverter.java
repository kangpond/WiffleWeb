package gov.nia.nrs.utils;

public class DefaultTypeConverter implements ITypeConverter
{
	public final static DefaultTypeConverter INSTANCE = new DefaultTypeConverter();

	private DefaultTypeConverter() {}

	@Override
	public Object convertTo(Object value)
	{
		return value;
	}

	@Override
	public Object convertFrom(Object value)
	{
		return value;
	}

	@Override
	public String convertToString(Object value) {
		if (value == null)
			return "";

		return "" + value;
	}

	@Override
	public Object convertFromString(String value) {
		return value;
	}
}