package server.diagnosis.view;

import javax.swing.JFrame;

import server.diagnosis.component.LoggingManager;

public class GUIStarter {
	
	public GUIStarter() {
        LoggingManager.logger.info("info");
		start();
	}

	private void start() {

		JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocation(400, 100);
        window.setTitle("Group 5 Breast Cancer Diagnosis Application");

        Panel panel = new Panel(window);
        panel.init();

        window.pack();
        window.setVisible(true);

	}

}
