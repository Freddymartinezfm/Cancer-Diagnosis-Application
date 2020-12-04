package server.diagnosis;

public class DiagnosisTest {

	
	public static void main(String[] args) {
		// run diagnosis
		DiagnosisImplementation impl = new StubImplementation();
		Diagnosis diag = new Diagnosis(impl);

		// in the future, this will more than likely have a parameter with the actual informatin to do the diagnosis
		diag.runDiagnosis();

	}
	
}
