package server.diagnosis.server_management;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClientConnect implements Runnable {
    private static final Logger logger = LogManager.getLogger();

	public Socket client;
	public ObjectInputStream in;
	public ObjectOutputStream out;

	public ClientConnect(Socket client) {
		logger.info("stub log");
		try {
			in = new ObjectInputStream(client.getInputStream());
			out = new ObjectOutputStream(client.getOutputStream());
		} catch(IOException e) {
			System.err.println(e);
			return;
		}
	}

	private void log(String msg) {
		System.out.println(msg);
	}

	@Override
	public void run() {
		System.out.println("Ran in clientConnect.java");
	}
	
}
