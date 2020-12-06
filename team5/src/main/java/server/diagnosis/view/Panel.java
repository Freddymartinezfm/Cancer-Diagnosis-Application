/* Panel.java
version 1.0.3
11/29/2020
Copywrite UCO Software Engineering I Group 5
 */
package server.diagnosis.view;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import server.diagnosis.controller.GUIActionListener;

public class Panel  {

    // <id>1000025</id>
    // <thickness>5</thickness>
    // <uniformity_size>1</uniformity_size>
    // <uniformity_shape>1</uniformity_shape>
    // <adhesion>1</adhesion>
    // <epithelial_size>2</epithelial_size>
    // <bare_nuclei>1</bare_nuclei>
    // <chromatin>3</chromatin>
    // <nucleoli>1</nucleoli>
    // <mitoses>1</mitoses>
    // <class>2</class>

    private JFrame window;
    JLabel medPic = new JLabel(new ImageIcon("resources\\images\\med.jpg"));

    private JButton diagnoseButton = new JButton("Diagnose");
    private JButton disconnectButton = new JButton("End Session");
    private JButton validButton = new JButton("Validate");
    private JButton loadButton = new JButton("Load");
    private JButton clearButton = new JButton("Clear");
    private JButton clearTextAreaButton = new JButton("Clear Screen");
    private JButton loginButton = new JButton("Login"); //dummy button for prototype

    JTextField patientIDText = new JTextField();
    JTextField clumpText = new JTextField();
    JTextField cellText = new JTextField();
    JTextField cellText2 = new JTextField();
    JTextField adText = new JTextField();
    JTextField singText = new JTextField();
    JTextField bareText = new JTextField();
    JTextField blandText = new JTextField();
    JTextField normText = new JTextField();
    JTextField mitText = new JTextField();
    JTextField classText = new JTextField();

    private Canvas canvas;
    private JTextArea stuff;

    public Panel(JFrame window) {
        this.window = window;
    }

    public void init() {
        Container cp = window.getContentPane();

        // panel for inputting form information
        JPanel westPanel = new JPanel();
        cp.add(BorderLayout.WEST, westPanel);
        westPanel.setPreferredSize(new Dimension(250, 550));
        westPanel.setBackground(Color.lightGray);
        westPanel.setForeground(Color.black);
        westPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

        // variables
        JLabel IDName = new JLabel("ID Number: ");
        patientIDText.setBackground(Color.white);
        patientIDText.setBorder(new LineBorder(Color.darkGray, 1));
        IDName.setPreferredSize(new Dimension(100, 20));
        patientIDText.setPreferredSize(new Dimension(100, 20));
        westPanel.add(IDName);
        westPanel.add(patientIDText);
        patientIDText.setEditable(true);
        
        JLabel clumpLabel = new JLabel("Clump Thickness: ");
        clumpLabel.setPreferredSize(new Dimension(100, 20));
        westPanel.add(clumpLabel);
        clumpText.setPreferredSize(new Dimension(100, 20));
        clumpText.setBackground(Color.white);
        clumpText.setBorder(new LineBorder(Color.darkGray, 1));
        westPanel.add(clumpText);
        clumpText.setEditable(true);

        JLabel cellSize = new JLabel("Cell Size: ");
        cellText.setBackground(Color.white);
        cellText.setBorder(new LineBorder(Color.darkGray, 1));
        cellText.setPreferredSize(new Dimension(100, 20));
        cellSize.setPreferredSize(new Dimension(100, 20));
        westPanel.add(cellSize);
        westPanel.add(cellText);
        cellText.setEditable(true);

        JLabel cellShape = new JLabel("Cell Shape: ");
        cellText2.setBackground(Color.white);
        cellText2.setBorder(new LineBorder(Color.darkGray, 1));
        cellText2.setPreferredSize(new Dimension(100, 20));
        cellShape.setPreferredSize(new Dimension(100, 20));
        westPanel.add(cellShape);
        westPanel.add(cellText2);
        cellText2.setEditable(true);

        JLabel ad = new JLabel("Adhesion: ");
        adText.setBackground(Color.white);
        adText.setBorder(new LineBorder(Color.darkGray, 1));
        adText.setPreferredSize(new Dimension(100, 20));
        ad.setPreferredSize(new Dimension(100, 20));
        westPanel.add(ad);
        westPanel.add(adText);
        adText.setEditable(true);

        JLabel singleCellSize = new JLabel("Single Cell Size: ");
        singleCellSize.setPreferredSize(new Dimension(100, 20));
        singText.setPreferredSize(new Dimension(100, 20));
        singText.setBackground(Color.white);
        singText.setBorder(new LineBorder(Color.darkGray, 1));
        westPanel.add(singleCellSize);
        westPanel.add(singText);
        singText.setEditable(true);

        JLabel bareNuclei = new JLabel("Bare Nuclei: ");
        bareNuclei.setPreferredSize(new Dimension(100, 20));
        bareText.setPreferredSize(new Dimension(100, 20));
        bareText.setBackground(Color.white);
        bareText.setBorder(new LineBorder(Color.darkGray, 1));
        westPanel.add(bareNuclei);
        westPanel.add(bareText);
        bareText.setEditable(true);

        JLabel blandChromatin = new JLabel("Bland Chromatin: ");
        blandChromatin.setPreferredSize(new Dimension(100, 20));
        blandText.setPreferredSize(new Dimension(100, 20));
        blandText.setBackground(Color.white);
        blandText.setBorder(new LineBorder(Color.darkGray, 1));
        westPanel.add(blandChromatin);
        westPanel.add(blandText);
        bareText.setEditable(true);

        JLabel normalNucleoli = new JLabel("Normal Nucleoi: ");
        normalNucleoli.setPreferredSize(new Dimension(100, 20));
        normText.setPreferredSize(new Dimension(100, 20));
        normText.setBackground(Color.white);
        normText.setBorder(new LineBorder(Color.darkGray, 1));
        westPanel.add(normalNucleoli);
        westPanel.add(normText);
        normText.setEditable(true);

        JLabel mitosis = new JLabel("Mitosis: ");
        mitosis.setPreferredSize(new Dimension(100, 20));
        mitText.setPreferredSize(new Dimension(100, 20));
        mitText.setBackground(Color.white);
        mitText.setBorder(new LineBorder(Color.darkGray, 1));
        westPanel.add(mitosis);
        westPanel.add(mitText);
        bareText.setEditable(true);

        JLabel class1 = new JLabel("Class: ");
        class1.setPreferredSize(new Dimension(100, 20));
        classText.setPreferredSize(new Dimension(100, 20));
        classText.setBackground(Color.white);
        classText.setBorder(new LineBorder(Color.darkGray, 1));
        westPanel.add(class1);
        westPanel.add(BorderLayout.EAST, classText);
        bareText.setEditable(true);

        westPanel.add(BorderLayout.CENTER, validButton);
        westPanel.add(BorderLayout.CENTER, loadButton);
        westPanel.add(BorderLayout.CENTER, clearButton);

        //adds gui pic
        if (medPic == null){
            System.err.println("picutre error");
        } else {
            System.err.println("picture loaded successfully");
            westPanel.add(BorderLayout.CENTER, medPic);
            medPic.setBorder(new LineBorder(Color.lightGray, 1));

        }

        // panel for connecting
        JPanel southPanel = new JPanel();
        cp.add(BorderLayout.SOUTH, southPanel);
        southPanel.add(diagnoseButton);
        diagnoseButton.setEnabled(false);
        southPanel.add(disconnectButton);
        southPanel.add(clearTextAreaButton);
        southPanel.setPreferredSize(new Dimension(400, 40));

        // panel for doctor's info and login
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        cp.add(BorderLayout.NORTH, northPanel);
        northPanel.setPreferredSize(new Dimension(400, 44));
        northPanel.setBackground(Color.lightGray);

        Border loweredbeveled = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

        // login Text and border
        JTextField login = new JTextField();
        login.setEditable(true);
        login.setBackground(Color.lightGray);
        login.setForeground(Color.black);
        login.setFont(new Font("Times New Roman", Font.BOLD, 15));
        login.setPreferredSize(new Dimension(320, 38));

        TitledBorder loginBorder;
        loginBorder = BorderFactory.createTitledBorder(loweredbeveled, "Username/Email");
        loginBorder.setTitleJustification(TitledBorder.LEFT);
        login.setBorder(loginBorder);
        northPanel.add(BorderLayout.WEST, login);

        // password Text
        JPasswordField password = new JPasswordField();
        password.setEditable(true);
        password.setBackground(Color.lightGray);
        password.setForeground(Color.black);
        password.setFont(new Font("Courier New", Font.BOLD, 15));
        password.setPreferredSize(new Dimension(320, 38));

        TitledBorder passBorder;
        passBorder = BorderFactory.createTitledBorder(loweredbeveled, "Password");
        passBorder.setTitleJustification(TitledBorder.LEFT);
        password.setBorder(passBorder);
        northPanel.add(BorderLayout.WEST, password);

        //login button
        northPanel.add(BorderLayout.EAST, loginButton);

        //text area
        canvas = new Canvas(this);
        cp.add(BorderLayout.CENTER, canvas);
        stuff = new JTextArea(" Ready for session\n");
        JScrollPane scrollPane = new JScrollPane(stuff);
        canvas.add(scrollPane);
        stuff.setEditable(false);
        stuff.setLineWrap(true);
        stuff.setBorder(new LineBorder(Color.black, 1));
        scrollPane.setBorder(new LineBorder(Color.black, 1));
        scrollPane.setPreferredSize(new Dimension(500, 550));
        stuff.setForeground(Color.green);
        stuff.setBackground(Color.black);
        stuff.setFont(new Font("Courier New", Font.BOLD, 12));
        canvas.add(scrollPane);

        //action listeners
        GUIActionListener listener = new GUIActionListener(this);
        validButton.addActionListener(listener);
        diagnoseButton.addActionListener(listener);
        disconnectButton.addActionListener(listener);
        loadButton.addActionListener(listener);
        clearButton.addActionListener(listener);
        clearTextAreaButton.addActionListener(listener);
        loginButton.addActionListener(listener);

    }

    public JTextArea getStuff(){
        return stuff;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getValidButton() {
        return validButton;
    }

    public JButton getDisconnectButton() {
        return disconnectButton;
    }

    public JButton getDiagnoseButton() {
        return diagnoseButton;
    }

    public JButton getClearButton() {
        return clearButton;
    }

    public JButton getLoadButton() {
        return loadButton;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public JTextField getPatientIDText() {
        return patientIDText;
    }

    public JTextField getClumpText() {
        return clumpText;
    }

    public JTextField getCellText() {
        return cellText;
    }

    public JTextField getCellText2() {
        return cellText2;
    }

    public JTextField getAdText() {
        return adText;
    }

    public JTextField getSingText() {
        return singText;
    }

    public JTextField getBareText() {
        return bareText;
    }

    public JTextField getBlandText() {
        return blandText;
    }

    public JTextField getNormText() {
        return normText;
    }

    public JTextField getMitText() {
        return mitText;
    }

    public JTextField getClassText() {
        return classText;
    }

    public JButton getClearTextAreaButton() {
        return clearTextAreaButton;
    }

    
}
