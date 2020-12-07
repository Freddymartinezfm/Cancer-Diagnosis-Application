package server.diagnosis;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 
 */
public class StubImplementation extends DiagnosisImplementation {
	public static final Logger logger = LogManager.getLogger(StubImplementation.class);

	/**
	 * Default constructor
	 */
	public StubImplementation() {

	}

	/**
	 * 
	 */
	@Override
	public int runDiagnosis(String[] xml) {
		// TODO implement here
		logger.info("runDiagnosis(String xml) : start");
		int total = 0;
		for(int i = 1; i < xml.length - 1; i++){
			total += Integer.parseInt(xml[i]);
		}
		int result = 0;
		int r = (int) Math.random() * (total - 1 + 1) + 1;
		if(r < total / 2){result = 2;}
		else{result = 4;}
		logger.info("runDiagnosis(String xml) : end");
		return 2;


		
	}

}