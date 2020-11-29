package server_management;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	private int port = 0;
	private ServerSocket server = null;
	private Socket client = null;

	public Server(int port) {
		this.port = port;
	}

	public void start() {
		initializeServer();
		startListening();
	}

	private void initializeServer() {
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
			// Thread t allows for this server to be multi-threaded
			Thread t = new Thread(new ClientConnect(client));
			t.start();
		}
	}

	private void log(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) throws IOException {
		new Server(1001).start();
	}
	
}
