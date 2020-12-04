package server.diagnosis.server_management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client {
    private static final Logger logger = LogManager.getLogger();
	
	public Client(){
		logger.info("Client stub log");
		start();
	}

	public void start() {
		String hostName = "127.0.0.1";
		int port = 7123;
		Socket clientSocket;
		PrintWriter out;
		BufferedReader in;
		InputStreamReader isr;

		try {
			clientSocket = new Socket(hostName, port);
			logger.info("Client Socket connected to Server Socket");
			out = new PrintWriter(clientSocket.getOutputStream(), true);
			isr = new InputStreamReader(clientSocket.getInputStream());
			in = new BufferedReader(isr);

			// code for sending server patient info below
			out.println("Team 5 start");
			logger.info("Client Sent initial message");
			String s = in.readLine();
			logger.info(s);





			//in.close();
			//isr.close();
			//clientSocket.close();

		} catch (IOException e) {
			System.exit(1);
		}
		
	}

}