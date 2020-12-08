/* Canvas.java
version 1.0.0
11/29/2020
Copywrite UCO Software Engineering I Group 5
 */
package server.diagnosis.view;

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
    
}

