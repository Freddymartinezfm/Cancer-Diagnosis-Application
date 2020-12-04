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

/*
private void initializeServer() {
		logger.info("initializeServer");
		try {
			server = new ServerSocket(port);
			log("Server initialized on port: " + Integer.toString(port));
		} catch(IOException e) {
			System.err.println("Could not listen on port: " + port);
			System.err.println(e);
			System.exit(1);
		}
	}

	private void startListening() {
		while(true) {
			try {
				client = server.accept();
			} 
			catch(IOException e) {
				System.err.println("Accept failed.");
				System.err.println(e);
				System.exit(1);
			}

			Thread t = new Thread(new ClientConnect(client));
			t.start();
		}
	}

	private void log(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) throws IOException {
		new Server().start();
	}

*/
