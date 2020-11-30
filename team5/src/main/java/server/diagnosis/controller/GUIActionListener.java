package server.diagnosis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import server.diagnosis.view.Panel;


public class GUIActionListener implements ActionListener {

    private Panel panel;
    private JTextArea output;

    public GUIActionListener(Panel panel) {
        this.panel = panel;
        output = panel.getStuff();
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        
        JButton button = (JButton) e.getSource();
        if (button == panel.getValidButton()) {
            output.setText("Validating");
            panel.getCanvas().repaint();
            //validity button
        } else if (button == panel.getDiagnoseButton()) {
            //connecting code
            output.setText("Connecting for diagnosis");
            panel.getCanvas().repaint();
            
        } else if (button == panel.getDisconnectButton()) {
            //disconnect from servers
            output.setText("Disconnecting");
            panel.getCanvas().repaint();
        }
        else if (button == panel.getLoadButton()) {
            //disconnect from servers
            output.setText("Loading");
            panel.getCanvas().repaint();
        } else if (button == panel.getClearButton()) {
            //disconnect from servers
            output.setText("Clearing..");
            panel.getCanvas().repaint();
        }
    }
}