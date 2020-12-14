package server.diagnosis;


import junit.framework.Test;
import junit.framework.TestSuite;

public class Suite extends TestSuite {
	public Suite(){
	}
	
	public static Test suite(){
		TestSuite suite= new TestSuite();
		suite.addTest(new DiagnosisTest("testPositiveDiagnosis"));
		suite.addTest(new DiagnosisTest("testNegativeDiagnosis"));
		suite.addTest(new xmlBuildTest("testXmlParse"));
		suite.addTest(new xmlBuildTest("testXmlBuild"));
		suite.addTest(new GUIActionListenerTest("testSaveForm"));
		return suite;	
	}
		
}
