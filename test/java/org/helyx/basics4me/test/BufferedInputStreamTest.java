package org.helyx.basics4me.test;

import java.io.IOException;
import java.io.InputStream;

import junit.framework.TestCase;

import org.helyx.basics4me.io.BufferedInputStream;
import org.helyx.basics4me.lang.UrlUtil;

public class BufferedInputStreamTest extends TestCase {

	public void testClassUrl() throws IOException {
		InputStream is = UrlUtil.openStream("/org/helyx/basics4me/test/test-content.properties");
		assertNotNull(is);
		BufferedInputStream bis = new BufferedInputStream(is);
		try {
			int intValue = 0;
			
			while((intValue = bis.read()) >= 0) {
				System.out.print((char)intValue);
			}
		}
		finally {
			bis.close();
			
			bis = null;
			is = null;
		}
	}
	
}
