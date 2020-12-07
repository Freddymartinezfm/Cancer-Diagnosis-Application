package server.diagnosis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import server.diagnosis.component.xmlparser.*;

public class XMLTest {
    @Test
    public void xmlBuildTest() {
        xmlManager xml = new xmlManager();
        //xml.build();
    }

    @Test
    public void xmlParseTest(){
        xmlManager xml = new xmlManager();
        //xml.build();
        xml.parse();
        //preset from xmlBuild
        //assertEquals("1234", xml.getInfo()[0]);
    }
}
