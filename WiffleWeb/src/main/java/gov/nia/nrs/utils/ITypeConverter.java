package gov.nia.nrs.utils;

public interface ITypeConverter
{
	Object convertTo(Object value);
	Object convertFrom(Object value);
	String convertToString(Object value);
	Object convertFromString(String value);
}
