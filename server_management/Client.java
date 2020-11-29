package server_management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import org.w3c.dom.Document;

public class Client {

	private int port = 0;
	private String host = "localhost";

	private BufferedReader stdIn;
	private ObjectInputStream reader;
	private ObjectOutputStream writer;
	private Document usersLoginRequestXML;
	
	private Socket server = null;

	public Client(int port) {
		this.port = port;
	}

	public void run() throws IOException {
		initializeClient();
		startSession();
	}

	private void initializeClient() {
		try {
			log("Initializing Client...");
			server = new Socket(host, port);
			stdIn = new BufferedReader(new InputStreamReader(System.in));
			writer = new ObjectOutputStream(server.getOutputStream());
			reader = new ObjectInputStream(server.getInputStream());
		} catch(IOException e) {
			System.err.println(e);
			System.exit(1);
		}
	}

	private void startSession() throws IOException {
		Scanner input = new Scanner(System.in);
		boolean continueTesting = true;
		boolean continueTesting2;
		String userInput;

		log("Starting Session...");

		//while(continueTesting) {

		//}
	}


	private void log(String msg) {
		System.out.println(msg);
	}

	public static void main(String[] args) throws IOException {
		new Client(1001).run();
	}
	
}
