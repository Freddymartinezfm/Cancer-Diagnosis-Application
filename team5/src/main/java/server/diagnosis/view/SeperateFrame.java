package server.diagnosis.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class SeperateFrame extends JFrame {
    protected Dimension defaultSize = new Dimension(200, 200);
    protected Framework framework = null;

    public SeperateFrame(Framework controller){
        super("new frame");
        framework = controller;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);


        addWindowListener(framework);
        // copied

        JMenu menu = new JMenu("Window");
            menu.setMnemonic(KeyEvent.VK_W);
            JMenuItem item = null;
            //close
            item = new JMenuItem("Close");
            item.setMnemonic(KeyEvent.VK_C);
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Close window");
                    SeperateFrame.this.setVisible(false);
                    SeperateFrame.this.dispose();
                }
            });
            menu.add(item);

            //new
            item = new JMenuItem("New");
            item.setMnemonic(KeyEvent.VK_N);
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("New window");
                    framework.makeNewWindow();
                }
            });
            menu.add(item);

            //quit
            item = new JMenuItem("Quit");
            item.setMnemonic(KeyEvent.VK_Q);
            item.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("Quit request");
                    // framework.quit(SeperateFrame.this);
                }
            });
            menu.add(item);

            JMenuBar menuBar = new JMenuBar();
            menuBar.add(menu);
            setJMenuBar(menuBar);

            setSize(defaultSize);
        

    }
}
