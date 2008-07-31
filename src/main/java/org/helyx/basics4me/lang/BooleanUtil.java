package org.helyx.basics4me.lang;

public class BooleanUtil {

	public static final String TRUE = "true";
	public static final String FALSE = "false";

	private BooleanUtil() {
		super();
	}
	
	public static boolean getBoolean(String systemProperty) {
		String systemPropertyValue = java.lang.System.getProperty(systemProperty);
		
		return TRUE.equals(systemPropertyValue);
	}
	
}
