package server.diagnosis.server_management;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import server.diagnosis.DiagnosisImplementation;
import server.diagnosis.StubImplementation;
import server.diagnosis.component.xmlparser.xmlManager;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class Peer extends Thread {

	private Socket socket;
	private static final Logger logger = LogManager.getLogger(Peer.class);

	public Peer(Socket socket) {
		System.out.println("Client connected:" + socket.getChannel());
		System.out.println("Client socket port:  " + socket.getLocalPort());
		System.out.println("Client address: " + socket.getInetAddress());
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// create new xmlfile at location to parse
			System.out.println("File transfer start");
			
			File outputFile = new File("patient_info2.xml");
			InputStream in = socket.getInputStream();
			OutputStream out = new FileOutputStream(outputFile);
			byte[] bytes = new byte[2 * 1024];
			int count;
			while ((count = in.read(bytes)) > 0) {
				out.write(bytes, 0, count);
			}
			out.close();
			//in.close; //closing this closes the socket
			System.out.println("File recieved");

			xmlManager manager = new xmlManager();
			manager.parse(outputFile);

			DiagnosisImplementation impl = new StubImplementation();
			int diagnosis = impl.runDiagnosis(manager.getInfo());

			//new socket to return results to client
			Socket socket1 = new Socket("localhost", 5000);
			OutputStream output = new DataOutputStream(socket1.getOutputStream());
			output.write(diagnosis);
			socket1.close();
			//end

		} catch (IOException e) {
			System.out.println("Oops no client connnection: " + e.getMessage());

		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// a connection has been closed
				System.out.println("connection closed: " + e.getMessage());

			}
		}
	}
}
