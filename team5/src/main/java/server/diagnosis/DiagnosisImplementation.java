package server.diagnosis;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/** This is the Implemtentor that holds the interface for different types of impementations.
 * Derived classes of this class will override runDiagnosis to provide their unique implmentation.
 * Currently, StubImplementation is the sole derived class and generates a random result from the patient array of information.
 * DiagnosisImplementation could be converted to a interface for better clarity to avoid forcing the stub for runDiagnosis to be present here.
 * 
 * 
 * 
 */
public class DiagnosisImplementation {
	private static final Logger logger = LogManager.getLogger(DiagnosisImplementation.class);

	/**
	 * Default constructor
	 */
	public DiagnosisImplementation() {

	}


	/**
	 * 
	 */
	public int runDiagnosis(String[] xml) {
		return 0;

	}

}