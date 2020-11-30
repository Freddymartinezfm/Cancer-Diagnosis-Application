package server_management;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientConnect implements Runnable {

	public Socket client;
	public ObjectInputStream in;
	public ObjectOutputStream out;

	public ClientConnect(Socket client) {
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
		System.out.println("Code to diagnose patient is called here.");
	}
	
}
