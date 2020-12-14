package server.diagnosis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import JUnit4.jupiter.api.BeforeEach;
import junit.framework.TestCase;

public class DiagnosisTest extends TestCase {
	@Test
	public void testPositiveDiagnosis(){
		DiagnosisImplementation impl = new StubImplementation();
		Diagnosis diag = new Diagnosis(impl);
		int result =  diag.runDiagnosis(BeforeEach.xml);

		assertEquals(2, result);


	} 


	public DiagnosisTest(String name){
		super(name);
	}

	@Test
	public void testNegativeDiagnosis(){

		// set up test
		DiagnosisImplementation impl = new StubImplementation();
		Diagnosis diag = new Diagnosis(impl);

		// run test
		int result =  diag.runDiagnosis(BeforeEach.xml);


		// verify test
		assertEquals("Result of a negative diagnosis to show not cancer ", 2, result);



	}

	@Override
	protected void runTest() throws Throwable {
		// TODO Auto-generated method stub
		testNegativeDiagnosis();
		testPositiveDiagnosis();
		
		// super.runTest();
	}
	
}
