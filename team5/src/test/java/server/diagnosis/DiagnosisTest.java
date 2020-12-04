package server.diagnosis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import JUnit4.jupiter.api.BeforeEach;

public class DiagnosisTest {

	@Test
	public void testDiagnosisResult(){
		DiagnosisImplementation impl = new StubImplementation();
		Diagnosis diag = new Diagnosis(impl);
		int result =  diag.runDiagnosis(BeforeEach.xml);

		assertEquals(1, result);


	} 
	
}
