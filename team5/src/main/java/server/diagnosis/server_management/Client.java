package server.diagnosis.server_management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

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
		Socket clientSocket;
		PrintWriter out;
		BufferedReader in;
		InputStreamReader isr;
		// add more port numbers to peerPorts to test multiple systems
		int[] peerPorts = {7123};

		for (int p: peerPorts) {
			try(Socket socket = new Socket("localhost", p)){
				BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);
				// now get info from user or oher server
				Scanner sc = new Scanner(System.in);
				String echoString; // object to send back to server
				String response;
				do {
					System.out.println("enter data to be echoed");
					echoString = sc.nextLine();
					stringToEcho.println(echoString);
					if (!echoString.equals("exit")) {
						response = echoes.readLine();
						System.out.println(response + " other data to be be sent back");
					}
				} while (!echoString.equals("exit"));
			} catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
		
	}

}