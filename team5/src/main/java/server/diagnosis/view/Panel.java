package server.diagnosis.view;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import server.diagnosis.controller.GUIActionListener;
import server.diagnosis.view.Panel;
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

    private JButton diagnoseButton = new JButton("Diagnose");
    private JButton disconnectButton = new JButton("End Session");
    private JButton validButton = new JButton("Validate");
    private JButton loadButton = new JButton("Load");
    private JButton clearButton = new JButton("Clear");

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
        westPanel.setPreferredSize(new Dimension(250, 400));
        westPanel.setBackground(Color.lightGray);
        westPanel.setForeground(Color.black);
        westPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

        // consider turning these into formatted text fields
        JTextField firstName = new JTextField();
        JTextField lastName = new JTextField();
        // JTextField middle = new JTextField();
         JTextField patientID = new JTextField();

        firstName.setBackground(Color.white);
        firstName.setBorder(new LineBorder(Color.darkGray, 1));
        JLabel firstName1 = new JLabel("First Name: ");
        westPanel.add(firstName1);
        westPanel.add(firstName);
        firstName.setPreferredSize(new Dimension(100, 20));
        firstName1.setPreferredSize(new Dimension(100, 20));

        lastName.setBackground(Color.white);
        lastName.setBorder(new LineBorder(Color.darkGray, 1));
        JLabel lastName1 = new JLabel("Last Name: ");
        westPanel.add(lastName1);
        westPanel.add(lastName);
        lastName.setPreferredSize(new Dimension(100, 20));
        lastName1.setPreferredSize(new Dimension(100, 20));

        // JSeparator s = new JSeparator(SwingConstants.HORIZONTAL);
        // westPanel.add(s);

        // variables
        JLabel IDName = new JLabel("ID Number: ");
        JTextField IDNum = new JTextField();
        IDNum.setBackground(Color.white);
        IDNum.setBorder(new LineBorder(Color.darkGray, 1));
        IDName.setPreferredSize(new Dimension(100, 20));
        IDNum.setPreferredSize(new Dimension(100, 20));
        westPanel.add(IDName);
        westPanel.add(IDNum);
        IDNum.setEditable(true);

        JLabel clump = new JLabel("Clump Thickness: ");
        JTextField clumpbox = new JTextField();
        clumpbox.setBackground(Color.white);
        clumpbox.setBorder(new LineBorder(Color.darkGray, 1));
        clump.setPreferredSize(new Dimension(100, 20));
        clumpbox.setPreferredSize(new Dimension(90, 20));
        westPanel.add(clump);
        westPanel.add(BorderLayout.EAST, clumpbox);
        clumpbox.setEditable(true);

        JLabel cellSize = new JLabel("Cell Size: ");
        JTextField cellbox = new JTextField();
        cellbox.setBackground(Color.white);
        cellbox.setBorder(new LineBorder(Color.darkGray, 1));
        cellbox.setPreferredSize(new Dimension(100, 20));
        cellSize.setPreferredSize(new Dimension(100, 20));
        westPanel.add(cellSize);
        westPanel.add(cellbox);
        cellbox.setEditable(true);

        JLabel cellShape = new JLabel("Cell Shape: ");
        JTextField cellbox2 = new JTextField();
        cellbox2.setBackground(Color.white);
        cellbox2.setBorder(new LineBorder(Color.darkGray, 1));
        cellbox2.setPreferredSize(new Dimension(100, 20));
        cellShape.setPreferredSize(new Dimension(100, 20));
        westPanel.add(cellShape);
        westPanel.add(cellbox2);
        cellbox2.setEditable(true);

        JLabel ad = new JLabel("Adhesion: ");
        JTextField adbox = new JTextField();
        adbox.setBackground(Color.white);
        adbox.setBorder(new LineBorder(Color.darkGray, 1));
        adbox.setPreferredSize(new Dimension(100, 20));
        ad.setPreferredSize(new Dimension(100, 20));
        westPanel.add(ad);
        westPanel.add(adbox);
        adbox.setEditable(true);

        JLabel singleCellSize = new JLabel("Single Cell Size: ");
        JTextField singbox = new JTextField();
        singleCellSize.setPreferredSize(new Dimension(100, 20));
        singbox.setPreferredSize(new Dimension(100, 20));
        singbox.setBackground(Color.white);
        singbox.setBorder(new LineBorder(Color.darkGray, 1));
        westPanel.add(singleCellSize);
        westPanel.add(singbox);
        singbox.setEditable(true);

        JLabel bareNuclei = new JLabel("Bare Nuclei: ");
        JTextField barebox = new JTextField();
        bareNuclei.setPreferredSize(new Dimension(100, 20));
        barebox.setPreferredSize(new Dimension(100, 20));
        barebox.setBackground(Color.white);
        barebox.setBorder(new LineBorder(Color.darkGray, 1));
        westPanel.add(bareNuclei);
        westPanel.add(barebox);
        barebox.setEditable(true);

        JLabel blandChromatin = new JLabel("Bland Chromatin: ");
        JTextField blandbox = new JTextField();
        blandChromatin.setPreferredSize(new Dimension(100, 20));
        blandbox.setPreferredSize(new Dimension(100, 20));
        blandbox.setBackground(Color.white);
        blandbox.setBorder(new LineBorder(Color.darkGray, 1));
        westPanel.add(blandChromatin);
        westPanel.add(blandbox);
        barebox.setEditable(true);

        JLabel normalNucleoli = new JLabel("Normal Nucleoi: ");
        JTextField normbox = new JTextField();
        normalNucleoli.setPreferredSize(new Dimension(100, 20));
        normbox.setPreferredSize(new Dimension(100, 20));
        normbox.setBackground(Color.white);
        normbox.setBorder(new LineBorder(Color.darkGray, 1));
        westPanel.add(normalNucleoli);
        westPanel.add(normbox);
        normbox.setEditable(true);

        JLabel mitosis = new JLabel("Mitosis: ");
        JTextField mitbox = new JTextField();
        mitosis.setPreferredSize(new Dimension(100, 20));
        mitbox.setPreferredSize(new Dimension(100, 20));
        mitbox.setBackground(Color.white);
        mitbox.setBorder(new LineBorder(Color.darkGray, 1));
        westPanel.add(mitosis);
        westPanel.add(mitbox);
        barebox.setEditable(true);

        JLabel class1 = new JLabel("Class: ");
        JTextField classbox = new JTextField();
        class1.setPreferredSize(new Dimension(100, 20));
        classbox.setPreferredSize(new Dimension(90, 20));
        classbox.setBackground(Color.white);
        classbox.setBorder(new LineBorder(Color.darkGray, 1));
        westPanel.add(class1);
        westPanel.add(BorderLayout.EAST, classbox);
        barebox.setEditable(true);

        // validButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        westPanel.add(BorderLayout.CENTER, validButton);
        westPanel.add(BorderLayout.CENTER, loadButton);
        westPanel.add(BorderLayout.CENTER, clearButton);

        // JTextField clump = new JTextField();
        // JTextField cellSize = new JTextField();
        // JTextField cellShape = new JTextField();
        // JTextField adhesion = new JTextField();
        // JTextField singleCellSize = new JTextField();
        // JTextField bareNuclei = new JTextField();
        // JTextField blandChromatin = new JTextField();
        // JTextField normalNucleoli = new JTextField();
        // JTextField mitosis = new JTextField();
        // JTextField class1 = new JTextField();

        // panel for connecting
        JPanel southPanel = new JPanel();
        cp.add(BorderLayout.SOUTH, southPanel);
        southPanel.add(diagnoseButton);
        southPanel.add(disconnectButton);
        southPanel.setPreferredSize(new Dimension(400, 40));

        // panel for doctor's info and login
        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(1, 2));
        cp.add(BorderLayout.NORTH, northPanel);
        northPanel.setPreferredSize(new Dimension(400, 40));
        northPanel.setBackground(Color.darkGray);

        Border loweredbeveled = BorderFactory.createBevelBorder(BevelBorder.LOWERED);

        // login box and border
        JTextField login = new JTextField();
        login.setEditable(true);
        login.setBackground(Color.lightGray);
        login.setForeground(Color.black);
        login.setFont(new Font("Times New Roman", Font.BOLD, 15));

        TitledBorder loginBorder;
        loginBorder = BorderFactory.createTitledBorder(loweredbeveled, "Username/Email");
        loginBorder.setTitleJustification(TitledBorder.LEFT);
        login.setBorder(loginBorder);
        northPanel.add(login);

        // password box
        JPasswordField password = new JPasswordField();
        password.setEditable(true);
        password.setBackground(Color.lightGray);
        password.setForeground(Color.black);
        password.setFont(new Font("Courier New", Font.BOLD, 15));

        TitledBorder passBorder;
        passBorder = BorderFactory.createTitledBorder(loweredbeveled, "Password");
        passBorder.setTitleJustification(TitledBorder.LEFT);
        password.setBorder(passBorder);
        northPanel.add(password);

        canvas = new Canvas(this);
        cp.add(BorderLayout.CENTER, canvas);
        stuff = new JTextArea("Ready for session");
        stuff.setEditable(false);
        JTextField stuff2 = new JTextField("in terms of success in connecting to the server and logs ");
        stuff.setBorder(new LineBorder(Color.black, 1));

        stuff.setForeground(Color.green);
        stuff.setBackground(Color.black);
        stuff.setFont(new Font("Courier New", Font.BOLD, 12));
        canvas.add(stuff);

        //action listeners
        GUIActionListener listener = new GUIActionListener(this);
        validButton.addActionListener(listener);
        diagnoseButton.addActionListener(listener);
        disconnectButton.addActionListener(listener);
        loadButton.addActionListener(listener);
        clearButton.addActionListener(listener);
    }

    public JTextArea getStuff(){
        return stuff;
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
}
