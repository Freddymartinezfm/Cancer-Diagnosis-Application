package server.diagnosis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import JUnit4.jupiter.api.BeforeEach;

public class DiagnosisTest {
	// @Test
	// public void testPositiveDiagnosis(){
	// 	DiagnosisImplementation impl = new StubImplementation();
	// 	Diagnosis diag = new Diagnosis(impl);
	// 	int result =  diag.runDiagnosis(BeforeEach.negativeXml);

	// 	assertEquals(4, result);


	// } 

	@Test
	public void testNegativeDiagnosis(){
		DiagnosisImplementation impl = new StubImplementation();
		Diagnosis diag = new Diagnosis(impl);
		int result =  diag.runDiagnosis(BeforeEach.positiveXml);

		assertEquals("Result of a negative diagnosis to show not cancer ", 2, result);



	} 
	
}
