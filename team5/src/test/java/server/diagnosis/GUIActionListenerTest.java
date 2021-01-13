package server.diagnosis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.JFrame;
import org.junit.Test;

import JUnit4.jupiter.api.BeforeEach;
import junit.framework.TestCase;
import server.diagnosis.controller.GUIActionListener;
import server.diagnosis.view.Panel;

public class GUIActionListenerTest extends TestCase {

	public GUIActionListenerTest(String name){
		super(name);
	}

	// guiInstance moved to BeforeEach class to initiliaze only once
	
	

	@Test
	public void testSaveForm() {
		
		BeforeEach.guiInstance.fillTextFieldOne();
		BeforeEach.guiInstance.saveForm();
		assertNotNull(BeforeEach.patientTest[1]);
		assertEquals("The array should be full of ones", "1", BeforeEach.patientTest[1]);

	}


	// test validateForm()
	
}
