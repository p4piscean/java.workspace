package com.dy.algorithm.aho.corasick;

import junit.framework.*;

public class TestAll extends TestCase {
    public static Test suite() {
	TestSuite suite = new TestSuite();
	suite.addTestSuite(TestState.class);
	suite.addTestSuite(TestAhoCorasick.class);
	suite.addTestSuite(TestQueue.class);
	return suite;
    }
}
