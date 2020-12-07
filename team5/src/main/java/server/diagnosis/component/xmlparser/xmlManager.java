package server.diagnosis.component.xmlparser;

public class xmlManager {
    xmlParse parser = new xmlParse();
    xmlBuild builder = new xmlBuild();

    public void build(String[] patientInfo){
        builder.build(patientInfo);
    }

    public void parse(){
        parser.parse();
    }

    public String [] getInfo(){
        return parser.getPatientInfo();
    }
}
