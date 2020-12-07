/*
package server.diagnosis.server_management;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Server {

    private static final Logger logger = LogManager.getLogger();
	private int port = 7123;
	private ServerSocket serverSocket = null;

	public void runServer() {
		try {
			serverSocket = new ServerSocket(port);
			logger.info("Socket Server connected to port");
		} catch (IOException e) {
			e.printStackTrace();
		}

		while (true) {
			try {
				Socket clientSocket = serverSocket.accept();
				if (clientSocket == null){
					logger.info("Client Socket error");
				}
				logger.info("Client Socket accepted");
				ClientConnect cc = new ClientConnect(clientSocket);
				new Thread(cc).start();
				logger.info("New thread started");

				clientSocket.close();

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
} 

*/