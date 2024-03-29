/* GUIActionListener.java
version 1.0.1
11/29/2020
Copywrite UCO Software Engineering I Group 5
 */
package server.diagnosis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import server.diagnosis.component.xmlparser.xmlManager;
import server.diagnosis.server_management.Client;
import server.diagnosis.view.Panel;



public class GUIActionListener implements ActionListener {
    private static final Logger logger = LogManager.getLogger(GUIActionListener.class);
    
    private Panel panel;
    private JTextArea output;
    private String[] patientInfo = new String[11]; // this is the array to be used for the XML
    private String[] patientInfoPrint = new String[11]; // this is the array to be used for the textArea output
    private JTextField[] textFieldAr = new JTextField[11];
    private boolean valid;
    private xmlManager xmlManager;
    private Client client;

    public GUIActionListener(Panel panel) {
        this.panel = panel;
        output = panel.getStuff();
    }


    @Override
    public void actionPerformed(ActionEvent e){
        String diagnosis = " ";
        
        JButton button = (JButton) e.getSource();
        if (button == panel.getValidButton()) {
            saveForm();
            valid = validate();
            if(valid){
                xmlManager = new xmlManager();
                xmlManager.build(patientInfo); 
            }
            panel.getCanvas().repaint();

        } else if (button == panel.getDiagnoseButton()) {

            //connecting code to be added for the server
            output.append(" Connecting for diagnosis...\n");
            
            // info should be verified
            if (valid) {
                client = new Client();
            }

            diagnosis = client.getFinalDiagnosis();
            output.append("\n The consensus diagnosis is that" + diagnosis + "\n");
            if (button != null){
                JOptionPane.showMessageDialog(panel.getWindow(),
                "Diagnosis is: " + diagnosis);
            }
            panel.getCanvas().repaint();
            
        } else if (button == panel.getLoginButton()) {
            System.out.println("login pressed. ");
            //dummy prototype for logging in
            output.append(" Logging in...\n");
            String userName = panel.getLogin().getText().strip();
            String password = panel.getPassword().getText().strip();
           
            // TODO send to data base or store in seperate class 
            userLogin(userName, password);


            panel.getCanvas().repaint();

        } else if (button == panel.getDisconnectButton()) {
            //code to close the ports and then exit program
            output.append(" Disconnecting\n");
            logger.info("System is shut down.");
            panel.getCanvas().repaint();

        } else if (button == panel.getLoadButton()) {
            //prototype for loading patient data from database
            fillTextFieldOne();
            output.append(" Loading\n");
            panel.getCanvas().repaint();

        } else if (button == panel.getClearButton()) {
            fillTextField();
            clearTextField();
            output.append(" Cleared patient info\n");
            panel.getCanvas().repaint();
            
        } else if (button == panel.getClearTextAreaButton()) {          
            output.selectAll();
            output.replaceSelection(null);
            panel.getCanvas().repaint();
        }
    }

    public boolean userLogin(String userName, String password){

        boolean result = ((userName != null) ? true : false) &&  (password != null) ? true : false;
        JOptionPane.showMessageDialog(panel.getWindow(),
        "username: " + userName + "\n" +
        "password: " + password);
        
        return result;

    }

    

    private boolean validate() {
        int count = 0;
        //add: code for the id range values
        for (int i = 1; i < patientInfo.length; i++) {            
            if(patientInfo[i] == null || patientInfo[i].isEmpty()) {
                break;
            } else {
                String tempString = patientInfo[i].trim();
                char[] chars = tempString.toCharArray();
                for(char c: chars) {
                    if(Character.isLetter(c)) {
                        output.append(" Invalid input.\n");
                        return false;
                    }
                }
                int temp = Integer.parseInt(tempString);
                if (temp > 0 && temp < 11 ) { 
                 count ++;
                }
            }            
        }
        if (count == 10) {
            output.append(" Input accepted:\n\n");
            printForm();
            output.append("\n Please press Diagnose button if patient information is correct.\n");
            panel.getDiagnoseButton().setEnabled(true);
            return true;
        } else {
            output.append(" Invalid: Please enter a numeric value from 1-10\n");
            return false;
        }
    }

    public void saveForm() {
        patientInfo[0] = panel.getPatientIDText().getText();
        patientInfo[1] = panel.getClumpText().getText();
        patientInfo[2] = panel.getCellText().getText();
        patientInfo[3] = panel.getCellText2().getText();
        patientInfo[4] = panel.getAdText().getText();
        patientInfo[5] = panel.getSingText().getText();
        patientInfo[6] = panel.getBareText().getText();
        patientInfo[7] = panel.getBlandText().getText();
        patientInfo[8] = panel.getNormText().getText();
        patientInfo[9] = panel.getMitText().getText();
        patientInfo[10] = panel.getClassText().getText();

        textFieldAr[0] = panel.getPatientIDText();
        textFieldAr[1] = panel.getClumpText();
        textFieldAr[2] = panel.getCellText();
        textFieldAr[3] = panel.getCellText2();
        textFieldAr[4] = panel.getAdText();
        textFieldAr[5] = panel.getSingText();
        textFieldAr[6] = panel.getBareText();
        textFieldAr[7] = panel.getBlandText();
        textFieldAr[8] = panel.getNormText();
        textFieldAr[9] = panel.getMitText();
        textFieldAr[10] = panel.getClassText();

        patientInfoPrint[0] = "Patient ID: " + panel.getPatientIDText().getText();
        patientInfoPrint[1] = "Clump Thickness: " + panel.getClumpText().getText();
        patientInfoPrint[2] = "Uniformity Cell Size: " + panel.getCellText().getText();
        patientInfoPrint[3] = "Uniformity Cell Shape: " + panel.getCellText2().getText();
        patientInfoPrint[4] = "Marginal Adhesion: " + panel.getAdText().getText();
        patientInfoPrint[5] = "Single Epithelial Cell Size: " + panel.getSingText().getText();
        patientInfoPrint[6] = "Bare Nuclei: " + panel.getBareText().getText();
        patientInfoPrint[7] = "Bland Chromatin: " + panel.getBlandText().getText();
        patientInfoPrint[8] = "Normal Nucleoli: " + panel.getNormText().getText();
        patientInfoPrint[9] = "Mitoses: " + panel.getMitText().getText();
        patientInfoPrint[10] = "Class: " + panel.getClassText().getText();

    }

    private void printForm() {
        for (int i = 0; i < patientInfoPrint.length; i++) {
            output.append("     " + patientInfoPrint[i] +"\n");
        }
    }

    private void clearTextField() {
        for (int i = 0; i < textFieldAr.length; i++) {
            textFieldAr[i].setText(null);
        }
    }

    public void fillTextFieldOne() {
        textFieldAr[0] = panel.getPatientIDText();
        textFieldAr[0].setText("1");
        patientInfo[0] ="1";
        textFieldAr[1] = panel.getClumpText();
        textFieldAr[1].setText("1");
        patientInfo[1] ="1";
        textFieldAr[2] = panel.getCellText();
        textFieldAr[2].setText("1");
        patientInfo[2] ="1";
        textFieldAr[3] = panel.getCellText2();
        textFieldAr[3].setText("1");
        patientInfo[3] ="1";
        textFieldAr[4] = panel.getAdText();
        textFieldAr[4].setText("1");
        patientInfo[4] ="1";
        textFieldAr[5] = panel.getSingText();
        textFieldAr[5].setText("1");
        patientInfo[5] ="1";
        textFieldAr[6] = panel.getBareText();
        textFieldAr[6].setText("1");
        textFieldAr[7] = panel.getBlandText();
        textFieldAr[7].setText("1");
        patientInfo[7] ="1";
        textFieldAr[8] = panel.getNormText();
        patientInfo[8] ="1";
        textFieldAr[8].setText("1");
        textFieldAr[9] = panel.getMitText();
        textFieldAr[9].setText("1");
        patientInfo[9] ="1";
        textFieldAr[10] = panel.getClassText();
        textFieldAr[10].setText("1");
        patientInfo[10] ="1";

    }

    public void fillTextField() {
        
        textFieldAr[0] = panel.getPatientIDText();
        textFieldAr[0].setText("0");
        patientInfo[0] ="0";
        textFieldAr[1] = panel.getClumpText();
        textFieldAr[1].setText("0");
        patientInfo[1] ="0";
        textFieldAr[2] = panel.getCellText();
        textFieldAr[2].setText("0");
        patientInfo[2] ="0";
        textFieldAr[3] = panel.getCellText2();
        textFieldAr[3].setText("0");
        patientInfo[3] ="0";
        textFieldAr[4] = panel.getAdText();
        textFieldAr[4].setText("0");
        patientInfo[4] ="0";
        textFieldAr[5] = panel.getSingText();
        textFieldAr[5].setText("0");
        patientInfo[5] ="0";
        textFieldAr[6] = panel.getBareText();
        textFieldAr[6].setText("0");
        patientInfo[6] ="0";
        textFieldAr[7] = panel.getBlandText();
        textFieldAr[7].setText("0");
        patientInfo[7] ="0";
        textFieldAr[8] = panel.getNormText();
        textFieldAr[8].setText("0");
        patientInfo[8] ="0";
        textFieldAr[9] = panel.getMitText();
        textFieldAr[9].setText("0");
        patientInfo[9] ="0";
        textFieldAr[10] = panel.getClassText();
        textFieldAr[10].setText("0");
        patientInfo[10] ="0";        
    }

    public String[] getPatientInfo() {
        return patientInfo;
    }
}