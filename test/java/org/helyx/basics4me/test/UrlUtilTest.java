package org.helyx.basics4me.test;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.helyx.basics4me.lang.UrlUtil;

public class UrlUtilTest extends TestCase {

	public void testClassUrl() throws IOException {
		try {
			InputStream is = UrlUtil.openStream("/org/helyx/basics4me/test/test-content.properties");
			assertNotNull(is);
			try {
				int intValue = -1;
				
				while((intValue = is.read()) >= 0) {
					System.out.println((char)intValue);
				}
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
