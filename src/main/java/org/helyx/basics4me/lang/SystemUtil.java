package org.helyx.basics4me.lang;

public class SystemUtil {

	private SystemUtil() {
		super();
	}
	
	public static String getProperty(String systemProperty, String defaultValue) {
		String systemPropertyValue = java.lang.System.getProperty(systemProperty);
		if (systemPropertyValue == null) {
			return defaultValue;
		}
		
		return systemPropertyValue;
	}
	
}
