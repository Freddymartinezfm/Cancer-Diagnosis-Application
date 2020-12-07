package server.diagnosis;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import org.junit.Test;

import JUnit4.jupiter.api.BeforeEach;
import server.diagnosis.controller.GUIActionListener;
import server.diagnosis.view.GUIStarter;
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
	}


	// test validateForm()
	
}
