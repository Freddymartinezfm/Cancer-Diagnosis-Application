package server.diagnosis.server_management;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientConnect implements Runnable {
    private static final Logger logger = LogManager.getLogger();

	private Socket clientSocket;
	// private Diagnosis d;

	public ClientConnect(Socket clientSocket) {
		logger.info("Client Connect stub log");
		this.clientSocket = clientSocket;
	}

	@Override
	public void run() {

		try {
			InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream());

			// Diagnosis implementation goes below here
			if (in.readLine().equals("Team 5 start")) {
				String s = "Client sent: " + in.readLine();
				logger.info(s);
				out.println("It's working!!!");
			}




			//out.close();
			//in.close();
			//isr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
}
