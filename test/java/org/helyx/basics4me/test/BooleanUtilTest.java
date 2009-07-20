package org.helyx.basics4me.test;

import junit.framework.TestCase;

import org.helyx.basics4me.lang.BooleanUtil;

public class BooleanUtilTest extends TestCase {

	public void testParseBoolean() {
		assertTrue(BooleanUtil.parseBoolean(BooleanUtil.TRUE));
		assertTrue(!BooleanUtil.parseBoolean(BooleanUtil.FALSE));
		assertTrue(BooleanUtil.parseBoolean("true"));
		assertTrue(!BooleanUtil.parseBoolean("false"));
		assertTrue(!BooleanUtil.parseBoolean("TRUE"));
		assertTrue(!BooleanUtil.parseBoolean("FALSE"));
		assertTrue(!BooleanUtil.parseBoolean("test"));
	}

	public void testParseBooleanIgnoreCase() {
		assertTrue(BooleanUtil.parseBooleanIgnoreCase(BooleanUtil.TRUE));
		assertTrue(!BooleanUtil.parseBooleanIgnoreCase(BooleanUtil.FALSE));
		assertTrue(BooleanUtil.parseBooleanIgnoreCase("true"));
		assertTrue(!BooleanUtil.parseBooleanIgnoreCase("false"));
		assertTrue(BooleanUtil.parseBooleanIgnoreCase("TRUE"));
		assertTrue(!BooleanUtil.parseBooleanIgnoreCase("FALSE"));
		assertTrue(!BooleanUtil.parseBooleanIgnoreCase("test"));
	}
	
}
