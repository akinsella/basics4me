package org.helyx.basics4me.test;

import org.helyx.basics4me.lang.SystemUtil;

import junit.framework.TestCase;

public class SystemUtilTest extends TestCase {

	public void testSystemUtil() {
		assertEquals("test", SystemUtil.getProperty("null.key", "test"));
		assertEquals(null, SystemUtil.getProperty("null.key", null));
	}

	
}
