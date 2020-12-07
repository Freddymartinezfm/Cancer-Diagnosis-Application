package server.diagnosis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.JFrame;
import org.junit.Test;

import JUnit4.jupiter.api.BeforeEach;
import server.diagnosis.controller.GUIActionListener;
import server.diagnosis.view.Panel;

public class GUIActionListenerTest {
	
	JFrame window1 = new JFrame();
	Panel panel = new Panel(window1);
	GUIActionListener guiInstance = new GUIActionListener(panel);
	String[] patientTest = guiInstance.getPatientInfo();;

	@Test
	public void testSaveForm() {
		
		guiInstance.fillTextFieldOne();
		guiInstance.saveForm();
		assertNotNull(patientTest[1]);
		assertEquals("The array should be full of ones", "1", patientTest[0]);

	}


	// test validateForm()
	
}
