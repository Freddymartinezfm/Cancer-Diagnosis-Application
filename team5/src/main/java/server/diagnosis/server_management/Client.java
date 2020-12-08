package server.diagnosis.server_management;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import server.diagnosis.view.Panel;

public class Client {
	private static final Logger logger = LogManager.getLogger();
	private int[] diagnoses;
	private String finalDiagnosis;
	private Panel panel;

	public Client() {
		start();
	}

	public void start() {
		String hostName = "127.0.0.1";

		// add more port numbers to peerPorts to test multiple systems
		int[] peerPorts = { 7123 };
		// diagnoses array size needs to match number of peerPorts
		diagnoses = new int[1];

		int diagnosesCount = 0;
		Socket socket1;

		for (int p : peerPorts) {

			logger.info("Connection request sent to server.");
			
			try (Socket socket = new Socket(hostName, p)) {
				
				logger.info("Client socket started: " + socket.toString());
				// start of convert file to byte data
				File xmlFile = new File("patient_info.xml");
				InputStream inFile = new FileInputStream(xmlFile);
				OutputStream outFile = socket.getOutputStream();
				int count;
				byte[] bytes = new byte[2 * 1024];
				while ((count = inFile.read(bytes)) > 0) {
					outFile.write(bytes, 0, count);
				}
				logger.info("File sent from client to server");
				inFile.close();
				outFile.close();
				// end

				//start of accept socket to accept results from peer				
					ServerSocket serverSocket = new ServerSocket(5000);	//5000 is random
					socket1 = serverSocket.accept();			
					InputStream input = new DataInputStream(socket1.getInputStream());
					byte[] b = new byte[64];
					input.read(b);
					diagnoses[diagnosesCount] = b[0];
					socket1.close();
					serverSocket.close();
				//end

			} catch (IOException e) {
				logger.error("Exception: " + e.getMessage());
				panel.getStuff().append("There was an error in the system.");

			}
			diagnosesCount++;
			logger.info("Server response has been provided\n");
		}
		tallyDiagnoses();
	}
	public void tallyDiagnoses() {
		int positive = 0, negative = 0;
		for (int e : diagnoses) {
			if (e == 2) {
				positive++;
			} else {
				negative++;
			}
		}

		if (positive > negative) {
			finalDiagnosis = " cancer is not detected.";
		} else {
			finalDiagnosis = " cancer is detected.";
		}
	}

	public String getFinalDiagnosis() {
		return finalDiagnosis;
	}
}