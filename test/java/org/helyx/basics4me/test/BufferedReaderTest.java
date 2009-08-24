package org.helyx.basics4me.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import junit.framework.TestCase;

import org.helyx.basics4me.io.BufferedReader;
import org.helyx.basics4me.lang.UrlUtil;

public class BufferedReaderTest extends TestCase {

	public void testClassUrl() throws IOException {
		InputStream is = UrlUtil.openStream("/org/helyx/basics4me/test/test-content.properties");
		assertNotNull(is);
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		try {
			String line = null;
			
			while((line = br.readLine()) != null) {
				System.out.print(line);
			}
		}
		finally {
			br.close();
			
			br = null;
			isr = null;
			is = null;
		}
	}
	
}
