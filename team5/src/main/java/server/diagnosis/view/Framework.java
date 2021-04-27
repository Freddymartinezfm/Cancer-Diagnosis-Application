package server.diagnosis.view;

import java.awt.Dimension;

import javax.swing.*;
import java.awt.event.*;
public class Framework extends WindowAdapter{

    public Framework(){
        makeNewWindow();
    }

    public void makeNewWindow(){
        JFrame loginFrame = new SeperateFrame(this);
        // Panel loginPanel = new Panel(loginFrame);
        loginFrame.setPreferredSize(new Dimension(500, 400));
       



        loginFrame.setVisible(true);

    }
}