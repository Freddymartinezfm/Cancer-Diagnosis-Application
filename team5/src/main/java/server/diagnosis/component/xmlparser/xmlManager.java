package server.diagnosis.component.xmlparser;

import java.io.File;

public class xmlManager {
    xmlParse parser = new xmlParse();
    xmlBuild builder = new xmlBuild();

    public void build(String[] patientInfo){
        builder.build(patientInfo);
    }

    public void parse(File xmlFile){
        parser.parse(xmlFile);
    }

    public String [] getInfo(){
        return parser.getPatientInfo();
    }
}
