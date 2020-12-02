package server.diagnosis.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import javax.sound.sampled.SourceDataLine;
import javax.swing.*;

import server.diagnosis.component.UserTextAreaAppender;
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

    public GUIActionListener(Panel panel) {
        logger.info("stub log");
        this.panel = panel;
        output = panel.getStuff();
        UserTextAreaAppender appender = new UserTextAreaAppender(this.output);
        org.apache.log4j.LogManager.getRootLogger().addAppender(appender);
        


        

    }




    @Override
    public void actionPerformed(ActionEvent e){
        
        JButton button = (JButton) e.getSource();
        if (button == panel.getValidButton()) {
            logger.info("Validating");
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