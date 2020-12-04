package server.diagnosis;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 */
public class StubImplementation extends DiagnosisImplementation {
	public static final Logger logger = LogManager.getLogger();

	/**
	 * Default constructor
	 */
	public StubImplementation() {

	}

	/**
	 * 
	 */
	public void runDiagnosis() {
		// TODO implement here
		logger.info("Stub Implementation");

		
	}

}