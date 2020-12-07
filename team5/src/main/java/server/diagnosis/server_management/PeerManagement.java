package server.diagnosis.server_management;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import server.diagnosis.Diagnosis;
import server.diagnosis.DiagnosisImplementation;
import server.diagnosis.StubImplementation;
import server.diagnosis.view.GUIStarter;

public class PeerManagement {
	private static final Logger logger = LogManager.getLogger();

	private Peer server;
	public PeerManagement(){
		// new GUIStarter();
		start();
	}

	public void start(){

		
		try (ServerSocket serverSocket = new ServerSocket(7123)){ // try with resources
			logger.info("System is ready to serve requests.");
		
			while(true){
				Socket socket = serverSocket.accept(); // blocked until a connection is made
				
				server = new Peer(socket);
			
				server.start();
				
			}
		} catch (IOException e) {
			logger.error("Server Exception " + e.getMessage());
		}
	}
}
