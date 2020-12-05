package server.diagnosis;

import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import server.diagnosis.component.xmlparser.xmlBuild;
import server.diagnosis.component.xmlparser.xmlParse;

public class xmlBuildTest  {
	public static final Logger logger = LogManager.getLogger();
	


	@Test
	public void testXmlBuild(){
		xmlBuild xmlBuild = new xmlBuild();
		xmlBuild.build();
		// assertNotNull(xmlBuild.build());
		
	}

	@Test
	public void testXmlParse(){
		xmlParse xmlParse = new xmlParse();
		xmlParse.parse();
		// assertNotNull(xmlParse.parse());

		
	}
	
}
