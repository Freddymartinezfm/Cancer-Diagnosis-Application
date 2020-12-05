package server.diagnosis.component.xmlparser;

public class xmlManager {
    private xmlBuild builder;
    private xmlParse parser;
    String[] patientInfo;

    public xmlManager() {
        builder = new xmlBuild();
        parser = new xmlParse();
        patientInfo = new String[11];
    }

    public void build() {
        builder.build(patientInfo);
    }

    public void parse() {
        parser.parse();
    }

}
