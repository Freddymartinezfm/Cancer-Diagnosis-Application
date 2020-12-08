package server.diagnosis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import server.diagnosis.component.xmlparser.xmlBuild;
import server.diagnosis.component.xmlparser.xmlParse;

public class xmlBuildTest  {
	public static final Logger logger = LogManager.getLogger();
	


	@Test
	public void testXmlBuild(){
		String [] array = {"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"};
		xmlBuild xmlBuild = new xmlBuild();
		xmlBuild.build(array);
		File xmlFile = new File("patient_info.xml");
		assertNotNull(xmlFile);
		
	}

	@Test
	public void testXmlParse(){
		String [] array = {"1", "1", "1", "1", "1", "1", "1", "1", "1", "1", "1"};
		xmlBuild xmlBuild = new xmlBuild();
		xmlBuild.build(array);
		File xmlFile = new File("patient_info.xml");
		xmlParse xmlParse = new xmlParse();
		xmlParse.parse(xmlFile);
		assertEquals("1", xmlParse.getPatientInfo()[0]);

		
	}
	
}
