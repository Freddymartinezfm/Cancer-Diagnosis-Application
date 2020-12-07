package server.diagnosis;

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
		System.out.println(total);
		int result = total % 2;
		result *= 2;
		return result;

	}

}