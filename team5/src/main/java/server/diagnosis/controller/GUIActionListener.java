/* GUIActionListener.java
version 1.0.1
11/29/2020
Copywrite UCO Software Engineering I Group 5
 */
package server.diagnosis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Integer;
import javax.sound.sampled.SourceDataLine;
import javax.swing.*;

import server.diagnosis.component.UserTextAreaAppender;
import server.diagnosis.server_management.Client;
import server.diagnosis.view.Panel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.OutputStreamAppender;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.message.Message;



public class GUIActionListener implements ActionListener {
    private static final Logger logger = LogManager.getLogger(GUIActionListener.class);
    
    private Panel panel;
    private JTextArea output;
    private String[] patientInfo = new String[11]; // this is the array to be used for the XML
    private String[] patientInfoPrint = new String[11]; // this is the array to be used for the textArea output
    private boolean valid;

    public GUIActionListener(Panel panel) {
        logger.info("stub log");
        this.panel = panel;
        output = panel.getStuff();
        // info should be validated here, or in the xml code.
        // UserTextAreaAppender appender = new UserTextAreaAppender(this.output);
        // org.apache.log4j.LogManager.getRootLogger().addAppender(appender);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        
        JButton button = (JButton) e.getSource();
        if (button == panel.getValidButton()) {
            saveForm();
            valid = validate();
            panel.getCanvas().repaint();

        } else if (button == panel.getDiagnoseButton()) {
            //connecting code to be added for the server
            output.append("Connecting for diagnosis\n");
            // info should be verified

            // remove line below (for testing purposes)
            valid = true;
            
            if (valid) new Client();

            panel.getCanvas().repaint();
            
        } else if (button == panel.getLoginButton()) {
            //dummy prototype for logging in
            output.append("Logging in...\n");

            panel.getCanvas().repaint();

        } else if (button == panel.getDisconnectButton()) {
            //code to close the ports and then exit program
            output.append("Disconnecting\n");
            panel.getCanvas().repaint();

        } else if (button == panel.getLoadButton()) {
            //prototype for loading patient data from database
            output.append("Loading\n");
            panel.getCanvas().repaint();

        } else if (button == panel.getClearButton()) {
            patientInfo = null;
            output.append("Cleared patient info\n"); //empties array
            panel.getCanvas().repaint();
        } else if (button == panel.getClearTextAreaButton()) {          
            output.selectAll();
            output.replaceSelection(null);
            panel.getCanvas().repaint();
        }
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
                        output.append("Invalid input.\n");
                        return false;
                    }
                }
                int temp = Integer.parseInt(tempString);
                if (temp >= 0 && temp < 11 ) { 
                 count ++;
                }
            }            
        }
        if (count == 10) {
            output.append("Input accepted...\n");
            printForm();
            output.append("Please press Diagnose button if patient information is correct\n");
            panel.getDiagnoseButton().setEnabled(true);
            return true;
        } else {
            output.append("Invalid: Please enter a numeric value from 1-10\n");
            return false;
        }
    }

    private void saveForm() {
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
            output.append(patientInfoPrint[i] +"\n");
        }
    }

    public String[] getPatientInfo() {
        return patientInfo;
    }
}