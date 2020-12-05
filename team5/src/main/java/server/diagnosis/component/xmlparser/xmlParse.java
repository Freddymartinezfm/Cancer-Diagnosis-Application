package server.diagnosis.component.xmlparser;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class xmlParse {
    private DocumentBuilderFactory factory;
    private File inputFile;
    private DocumentBuilder builder;
    private String[] patientInfo = new String[11];

    public xmlParse() {
        factory = DocumentBuilderFactory.newInstance();
    }

    public void parse() {
        try {
            inputFile = new File("patient_info.xml");
            builder = factory.newDocumentBuilder();

            Document doc = builder.parse(inputFile);
            Element root = doc.getDocumentElement();

            //System.out.println("Testing xmlParse");
           // System.out.println("Expecting root to be Dataset");
           // System.out.println("Root :" + root.getNodeName());

            NodeList list = doc.getElementsByTagName("Patient");
            // only one patient in xml
            Node n = list.item(0);

            Element e = (Element) n;
            // storing is just to show we can extract and use the data
            patientInfo[0] = e.getAttribute("id");
            patientInfo[1] = e.getElementsByTagName("clump_thickness").item(0).getTextContent();
            patientInfo[2] = e.getElementsByTagName("uniformity_cell_size").item(0).getTextContent();
            patientInfo[3] = e.getElementsByTagName("uniformity_cell_shape").item(0).getTextContent();
            patientInfo[4] = e.getElementsByTagName("marginal_adhesion").item(0).getTextContent();
            patientInfo[5] = e.getElementsByTagName("single_epithelial_cell_size").item(0).getTextContent();
            patientInfo[6] = e.getElementsByTagName("bare_nuclei").item(0).getTextContent();
            patientInfo[7] = e.getElementsByTagName("bland_chromatin").item(0).getTextContent();
            patientInfo[8] = e.getElementsByTagName("normal_nucleoli").item(0).getTextContent();
            patientInfo[9] = e.getElementsByTagName("mitoses").item(0).getTextContent();
            patientInfo[10] = e.getElementsByTagName("class").item(0).getTextContent();

        } catch (Exception e) {
            System.out.println("Error in parse");
        }
    }

    public String[] getPatientInfo() {
        return patientInfo;
    }
}
