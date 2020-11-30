package view;

import java.awt.*;

import java.awt.Color;


import javax.swing.JPanel;

public class Canvas extends JPanel {

    private Panel panel;

    public Canvas(Panel p) {
        panel = p;
        setPreferredSize(new Dimension(500, 550));
        setBackground(Color.black);
    }


    // public void init(){
    //     JTextField stuff = new JTextField("Here is where all the text will go in terms of success in connecting to the server and logs");
    //     stuff.setForeground(Color.green);
    //     stuff.setFont(new Font("Courier New", Font.BOLD, 12));


    // }
    
    
    
}

