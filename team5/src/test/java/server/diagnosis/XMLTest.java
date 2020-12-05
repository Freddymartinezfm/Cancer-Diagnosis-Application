package server.diagnosis;

import org.junit.Test;

import server.diagnosis.component.xmlparser.*;

public class XMLTest {
    @Test
    public void xmlTest() {
        String [] patientInfo = new String[11];
        xmlManager xmlmanage = new xmlManager();
        xmlmanage.build();
        xmlmanage.parse();

       
    }   
}
