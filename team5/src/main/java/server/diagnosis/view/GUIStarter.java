/* GUIStarter.java
version 1.0.1
11/29/2020
Copywrite UCO Software Engineering I Group 5
 */
package server.diagnosis.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import server.diagnosis.component.LoggingManager;

public class GUIStarter {
	
	public GUIStarter() {
        LoggingManager.logger.info("info");
		start();
	}

	private void start() {

        JFrame window = new JFrame();
        ImageIcon ribbon = new ImageIcon("team5\\src\\main\\java\\ribbon.jpg");
        
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400, 100);
        window.setTitle("Team 5 Breast Cancer Diagnosis Application");
        window.setIconImage(ribbon.getImage());

        Panel panel = new Panel(window);
        panel.init();

        window.pack();
        window.setVisible(true);

	}

}
