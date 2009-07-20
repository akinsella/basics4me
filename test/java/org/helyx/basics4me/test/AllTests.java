package org.helyx.basics4me.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.helyx.basics4me.test");
		//$JUnit-BEGIN$
		suite.addTestSuite(BooleanUtilTest.class);
		suite.addTestSuite(CharUtilTest.class);
		suite.addTestSuite(SystemUtilTest.class);
		//$JUnit-END$
		return suite;
	}

}
