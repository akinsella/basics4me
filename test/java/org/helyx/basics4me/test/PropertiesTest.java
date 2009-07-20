package org.helyx.basics4me.test;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.helyx.basics4me.lang.UrlUtil;
import org.helyx.basics4me.util.Properties;

public class PropertiesTest extends TestCase {

	public void testProperties() throws IOException {
		try {
			InputStream is = UrlUtil.openStream("/org/helyx/basics4me/test/test-content.properties");
			assertNotNull(is);
			try {
				Properties properties = new Properties();
				properties.load(is);
				assertEquals("test.value", properties.get("test.key"));
				assertNull(properties.get("test.key.1"));
			}
			finally {
				is.close();
				is = null;
			}
		}
		catch(Throwable t) {
			t.printStackTrace();
		}
	}
	
}
