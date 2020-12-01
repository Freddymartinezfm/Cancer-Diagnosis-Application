package server.diagnosis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Integer;

import javax.swing.*;

import server.diagnosis.view.Panel;


public class GUIActionListener implements ActionListener {

    private Panel panel;
    private JTextArea output;
    private String[] patientInfo = new String[12]; // this is the array to be used for the XML
    private String[] patientInfoPrint = new String[12]; // this is the array to be used for the textArea output

    public GUIActionListener(Panel panel) {
        this.panel = panel;
        output = panel.getStuff();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton button = (JButton) e.getSource();
        if (button == panel.getValidButton()) {
            saveForm();
            validate();
            output.setText("Validating");
            //add: print to textArea if valid or not
            panel.getCanvas().repaint();

        } else if (button == panel.getDiagnoseButton()) {
            //connecting code to be added for the server
            output.setText("Connecting for diagnosis");
            panel.getCanvas().repaint();
            
        } else if (button == panel.getLoginButton()) {
            //dummy prototype for logging in
            output.setText("Logging in...");
            panel.getCanvas().repaint();

        } else if (button == panel.getDisconnectButton()) {
            //code to close the ports and then exit program
            output.setText("Disconnecting");
            panel.getCanvas().repaint();

        } else if (button == panel.getLoadButton()) {
            //prototype for loading patient data from database
            output.setText("Loading");
            panel.getCanvas().repaint();

        } else if (button == panel.getClearButton()) {
            //clears patient form before it's saved into the array
            output.setText("Clearing..");
            panel.getCanvas().repaint();
        }
    }
    private boolean validate() {
        int count = 0;
        //add: code for the id range values
        for (int i = 0; i < patientInfo.length; i++) {
            String tempString = patientInfo[i].trim();
            int temp = Integer.parseInt(tempString);
            if (temp >= 0 && temp < 11) {
                count ++;
            }
        }
        if (count == 11) {
            //add: code to enable the Diagnose button
            System.out.println("input accepted");
            return true;
        } else {
            System.out.println("Invalid input");
            return false;
        }
    }

    private void saveForm() {
        patientInfo[1] = panel.getPatientIDText().getText();
        patientInfo[2] = panel.getClumpText().getText();
        patientInfo[3] = panel.getCellText().getText();
        patientInfo[4] = panel.getCellText2().getText();
        patientInfo[5] = panel.getAdText().getText();
        patientInfo[6] = panel.getSingText().getText();
        patientInfo[7] = panel.getBareText().getText();
        patientInfo[8] = panel.getBlandText().getText();
        patientInfo[9] = panel.getNormText().getText();
        patientInfo[10] = panel.getMitText().getText();
        patientInfo[11] = panel.getClassText().getText();

        patientInfoPrint[1] = "Patient ID: " + panel.getPatientIDText().getText();
        patientInfoPrint[2] = "Clump Thickness: " + panel.getClumpText().getText();
        patientInfoPrint[3] = "Uniformity Cell Size: " + panel.getCellText().getText();
        patientInfoPrint[4] = "Uniformity Cell Shape: " + panel.getCellText2().getText();
        patientInfoPrint[5] = "Marginal Adhesion: " + panel.getAdText().getText();
        patientInfoPrint[6] = "Single Epithelial Cell Size: " + panel.getSingText().getText();
        patientInfoPrint[7] = "Bare Nuclei: " + panel.getBareText().getText();
        patientInfoPrint[8] = "Bland Chromatin: " + panel.getBlandText().getText();
        patientInfoPrint[9] = "Normal Nucleoli: " + panel.getNormText().getText();
        patientInfoPrint[10] = "Mitoses: " + panel.getMitText().getText();
        patientInfoPrint[11] = "Class: " + panel.getClassText().getText();

    }

    private void printForm() {

    }

    public String[] getPatientInfo() {
        return patientInfo;
    }
}