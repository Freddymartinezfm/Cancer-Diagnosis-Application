package server.diagnosis;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import server.diagnosis.component.xmlparser.*;

public class XMLTest {
    @Test
    public void xmlTest() {
        xmlManager xmlmanage = new xmlManager();
        xmlmanage.build();
        xmlmanage.parse();

        String [] array = xmlmanage.getInfo();

        //check that patientid = 1234 from the build class
        assertEquals("1234", array[0]);
    }
}
