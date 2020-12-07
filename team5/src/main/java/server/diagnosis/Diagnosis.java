package server.diagnosis;

import java.util.*;

/**
 * 
 */
public class Diagnosis {
	
	/**
	 * 
	 */
	private DiagnosisImplementation impl;

	/**
	 * Default constructor
	 */
	public Diagnosis(DiagnosisImplementation impl) {
		this.impl = impl;
		
	}

	/**
	 * 
	 */
	public int runDiagnosis(String[] xml) {
		// TODO implement here
		return impl.runDiagnosis(xml);
	}

	/**
	 * @return 
	 */
	public DiagnosisImplementation getImpl() {
		// TODO implement here
		return impl;
	}

	/**
	 * @param value
	 */
	public void setImpl(DiagnosisImplementation value) {
		// TODO implement here
		this.impl = value;
	}

}