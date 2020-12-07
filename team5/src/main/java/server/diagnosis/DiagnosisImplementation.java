package server.diagnosis;

import java.util.Random;

/**
 * 
 */
public class DiagnosisImplementation {



	/**
	 * Default constructor
	 */
	public DiagnosisImplementation() {

	}


	/**
	 * 
	 */
	public int runDiagnosis(String[] xml) {
		// TODO implement here
		int total = 0;
		for(int i = 1; i < xml.length - 1; i++){
			total += Integer.parseInt(xml[i]);
		}
		int result = 0;
		int r = (int) Math.random() * (total - 1 + 1) + 1;
		if(r < total / 2){result = 2;}
		else{result = 4;}
		return result;

	}

}