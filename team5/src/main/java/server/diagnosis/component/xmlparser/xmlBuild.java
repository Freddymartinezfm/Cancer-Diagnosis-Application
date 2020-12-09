package server.diagnosis.component.xmlparser;

import java.io.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

import server.diagnosis.view.Panel;

public class xmlBuild {
    private DocumentBuilder builder;
    private DocumentBuilderFactory factory;
    private TransformerFactory transformerFactory;
    private Transformer transformer;
    private Panel panel;

    public xmlBuild(){
        factory = DocumentBuilderFactory.newInstance();
        transformerFactory = TransformerFactory.newInstance();
    }

    public void build(String[] patientInfo){
        //patientInfo not currently used
        try{
            builder = factory.newDocumentBuilder();
            Document doc = builder.newDocument();
            //create root dataset
            Element rootElement = doc.createElement("Dataset");
            doc.appendChild(rootElement);

            //create patient element
            Element patient = doc.createElement("Patient");
            rootElement.appendChild(patient);

            //practice setting patient id
            //id will come from patient model
            Attr id = doc.createAttribute("id");
            id.setValue(patientInfo[0]);   //temp test right now
            patient.setAttributeNode(id);

            //start creating subelements
            Element clump_thickness = doc.createElement("clump_thickness");
            clump_thickness.appendChild(doc.createTextNode(patientInfo[1]));
            patient.appendChild(clump_thickness);

            Element uniformity_cell_size = doc.createElement("uniformity_cell_size");
            uniformity_cell_size.appendChild(doc.createTextNode(patientInfo[2]));
            patient.appendChild(uniformity_cell_size);

            Element uniformity_cell_shape = doc.createElement("uniformity_cell_shape");
            uniformity_cell_shape.appendChild(doc.createTextNode(patientInfo[3]));
            patient.appendChild(uniformity_cell_shape);

            Element marginal_adhesion = doc.createElement("marginal_adhesion");
            marginal_adhesion.appendChild(doc.createTextNode(patientInfo[4]));
            patient.appendChild(marginal_adhesion);
            
            Element single_epithelial_cell_size = doc.createElement("single_epithelial_cell_size");
            single_epithelial_cell_size.appendChild(doc.createTextNode(patientInfo[5]));
            patient.appendChild(single_epithelial_cell_size);

            Element bare_nuclei = doc.createElement("bare_nuclei");
            bare_nuclei.appendChild(doc.createTextNode(patientInfo[6]));
            patient.appendChild(bare_nuclei);

            Element bland_chromatin = doc.createElement("bland_chromatin");
            bland_chromatin.appendChild(doc.createTextNode(patientInfo[7]));
            patient.appendChild(bland_chromatin);

            Element normal_nucleoli = doc.createElement("normal_nucleoli");
            normal_nucleoli.appendChild(doc.createTextNode(patientInfo[8]));
            patient.appendChild(normal_nucleoli);

            Element mitoses = doc.createElement("mitoses");
            mitoses.appendChild(doc.createTextNode(patientInfo[9]));
            patient.appendChild(mitoses);

            //this is the cancer diagnosis, 2 if negative, 4 if positive
            Element _class = doc.createElement("class");
            _class.appendChild(doc.createTextNode(patientInfo[10]));
            patient.appendChild(_class);

            transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("patient_info.xml"));
            transformer.transform(source, result);



        }catch(Exception e){
            System.out.println("Error in build," + e.toString());
            panel.getStuff().append("Error in build");

        }
    }
}
