package JUnit4.jupiter.api;

import javax.swing.JTextArea;

import server.diagnosis.view.GUIStarter;
import server.diagnosis.view.Panel;

public @interface BeforeEach {


	

	

	String[] positiveXml =  {"<Dataset>\n" +
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
	"    <class>2</class>\t//this is what our intelligent model determines\n" +
	"</Dataset>"};

	String[] negativeXml =  {"<Dataset>\n" +
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
	"    <class>2</class>\t//this is what our intelligent model determines\n" +
	"</Dataset>"};





}
