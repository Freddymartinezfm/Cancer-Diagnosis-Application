package server.diagnosis.model;

import server.diagnosis.controller.GUIActionListener;

public class Patient {

    GUIActionListener l;
    String[] patientObjectInfo = l.getPatientInfo();

    // private String id;
    // private String thickness;
    // private String uniformity_size;
    // private String uniformity_shape;
    // private String adhesion;
    // private String epithelial_size;
    // private String bare_nuclei;
    // private String chromatin;
    // private String mitosis;
    // private String diagnosisClass;

    public Patient(String[] patientObjectInfo) {
        this.patientObjectInfo = patientObjectInfo;
    }
    
}
