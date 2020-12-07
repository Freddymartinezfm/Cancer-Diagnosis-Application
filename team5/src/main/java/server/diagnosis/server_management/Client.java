package server.diagnosis.server_management;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client {
	private static final Logger logger = LogManager.getLogger();

	public Client() {
		logger.info("Client stub log");
		start();
	}

	public void start() {
		String hostName = "127.0.0.1";

		// add more port numbers to peerPorts to test multiple systems
		int[] peerPorts = { 7123 };
		// diagnoses array size needs to match number of peerPorts
		int[] diagnoses = new int[1];

		int diagnosesCount = 0;
		Socket socket1;

		for (int p : peerPorts) {
			System.out.println("start peerports");
			try (Socket socket = new Socket(hostName, p)) {
				System.out.println("socket started");
				System.out.println(socket.toString());
				// start of convert file to byte data
				File xmlFile = new File("patient_info.xml");
				InputStream inFile = new FileInputStream(xmlFile);
				OutputStream outFile = socket.getOutputStream();
				int count;
				byte[] bytes = new byte[2 * 1024];
				while ((count = inFile.read(bytes)) > 0) {
					outFile.write(bytes, 0, count);
				}
				System.out.println("File sent");
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
				System.out.println("uh oh " + e.getMessage());
				System.out.println();
			}
			diagnosesCount++;
		}
		int positive = 0, negative = 0;
		for (int e : diagnoses) {
			if (e == 2) {
				positive++;
			} else {
				negative++;
			}
			System.out.println(e);
		}

		if (positive > negative) {
			System.out.println("No cancer");
		} else {
			System.out.println("Cancer");
		}
	}
}