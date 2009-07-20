package org.helyx.basics4me.test;

import junit.framework.TestCase;

import org.helyx.basics4me.lang.CharUtil;

public class CharUtilTest extends TestCase {

	public void testWhitespace0x1cTo0x20() {
		assertFalse(CharUtil.isWhitespace((char)0x1b));
		assertTrue(CharUtil.isWhitespace((char)0x1c));
		assertTrue(CharUtil.isWhitespace((char)0x1d));
		assertTrue(CharUtil.isWhitespace((char)0x1e));
		assertTrue(CharUtil.isWhitespace((char)0x1f));
		assertTrue(CharUtil.isWhitespace((char)0x20));
		assertFalse(CharUtil.isWhitespace((char)0x21));
	}

	public void testWhitespace0x9To0xd() {
		assertFalse(CharUtil.isWhitespace((char)0x8));
		assertTrue(CharUtil.isWhitespace((char)0x9));
		assertTrue(CharUtil.isWhitespace((char)0xa));
		assertTrue(CharUtil.isWhitespace((char)0xb));
		assertTrue(CharUtil.isWhitespace((char)0xc));
		assertTrue(CharUtil.isWhitespace((char)0xd));
		assertFalse(CharUtil.isWhitespace((char)0xe));
	}

	public void testWhitespace0x1680() {
		assertFalse(CharUtil.isWhitespace((char)0x167f));
		assertTrue(CharUtil.isWhitespace((char)0x1680));
		assertFalse(CharUtil.isWhitespace((char)0x1681));
	}

	public void testWhitespaceLt0x2000To0x200b() {
		assertFalse(CharUtil.isWhitespace((char)0x1fff));
		assertTrue(CharUtil.isWhitespace((char)0x2000));
		assertTrue(CharUtil.isWhitespace((char)0x2001));
		assertTrue(CharUtil.isWhitespace((char)0x2002));
		assertTrue(CharUtil.isWhitespace((char)0x2003));
		assertTrue(CharUtil.isWhitespace((char)0x2004));
		assertTrue(CharUtil.isWhitespace((char)0x2005));
		assertTrue(CharUtil.isWhitespace((char)0x2006));
		assertFalse(CharUtil.isWhitespace((char)0x2007));
		assertTrue(CharUtil.isWhitespace((char)0x2008));
		assertTrue(CharUtil.isWhitespace((char)0x2009));
		assertTrue(CharUtil.isWhitespace((char)0x200a));
		assertTrue(CharUtil.isWhitespace((char)0x200b));
		assertFalse(CharUtil.isWhitespace((char)0x200c));
	}

	public void testWhitespace0x20280x20290x3000() {		
		assertFalse(CharUtil.isWhitespace((char)0x2027));
		assertTrue(CharUtil.isWhitespace((char)0x2028));
		assertTrue(CharUtil.isWhitespace((char)0x2029));
		assertFalse(CharUtil.isWhitespace((char)0x202a));
		
		assertFalse(CharUtil.isWhitespace((char)0x2fff));
		assertTrue(CharUtil.isWhitespace((char)0x3000));
		assertFalse(CharUtil.isWhitespace((char)0x3001));
	}
	
}
