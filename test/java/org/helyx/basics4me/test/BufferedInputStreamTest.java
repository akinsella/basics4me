package org.helyx.basics4me.test;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.helyx.basics4me.lang.UrlUtil;

import com.sun.perseus.platform.BufferedInputStream;

public class BufferedInputStreamTest extends TestCase {

	public void testClassUrl() throws IOException {
		try {
			InputStream is = UrlUtil.openStream("/org/helyx/basics4me/test/test-content.properties");
			assertNotNull(is);
			BufferedInputStream bis = new BufferedInputStream(is);
			try {
				int intValue = 0;
				
				while((intValue = bis.read()) >= 0) {
					System.out.println((char)intValue);
				}
			}
			finally {
				bis.close();
				bis = null;
				is = null;
			}
		}
		catch(Throwable t) {
			t.printStackTrace();
		}
	}
	
}
