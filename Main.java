import javax.swing.*;
import java.awt.*;

import view.Panel;
public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setLocation(400, 100);
        window.setTitle("Group 5 Breast Cancer Diagnosis Application");

        var panel  = new Panel(window);
        panel.init();

        window.pack();
        window.setVisible(true);

    }


}

