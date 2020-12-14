package JUnit4.jupiter.api;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import server.diagnosis.controller.GUIActionListener;
import server.diagnosis.view.GUIStarter;
import server.diagnosis.view.Panel;

public @interface BeforeEach {

	JFrame window1 = new JFrame();
	Panel panel = new Panel(window1);
	GUIActionListener guiInstance = new GUIActionListener(panel);
	String[] patientTest = guiInstance.getPatientInfo();


	

	

	String[] xml =  {"<Dataset>\n" +
	"    <id>1000025</id>\n" +
	"    <thickness>5</thickness>\n" +
	"    <uniformity_size>1</uniformity_size>\n" +
	"    <uniformity_shape>1</uniformity_shape>\n" +
	"    <adhesion>1</adhesion>\n" +
	"    <epithelial_size>2</epithelial_size>\n" +
	"    <bare_nuclei>1</bare_nuclei>\n" +
	"    <chromatin>3</chromatin>\n" +
	"    <nucleoli>1</nucleoli>\n" +
	"    <mitoses>1</mitoses>\n" +
	"    <class>4</class>\t//this is what our intelligent model determines\n" +
	"</Dataset>"};

	





}
