package server.diagnosis.server_management;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import server.diagnosis.Diagnosis;
import server.diagnosis.DiagnosisImplementation;
import server.diagnosis.StubImplementation;
import server.diagnosis.component.xmlparser.xmlManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Peer extends Thread {

	private Socket socket;

	public Peer (Socket socket){
		System.out.println("Client connected:"  + socket.getChannel());
		System.out.println("Client socket port:  " +  socket.getLocalPort());
		System.out.println("Client address: " + socket.getInetAddress());
		this.socket = socket;
	}


	@Override
	public void run(){
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			
			//create new xmlfile at location to parse
			File outputFile = new File("patient_info2.xml");
			OutputStream out = new FileOutputStream(outputFile);
			InputStream in = socket.getInputStream();
			byte[] bytes = new byte[2*1024];
			int count;
			while ((count = in.read(bytes)) > 0) {
				out.write(bytes, 0, count);
			}
			
			xmlManager manager = new xmlManager();
			manager.parse(outputFile);
			
			DiagnosisImplementation impl = new StubImplementation();
			Diagnosis diag = new Diagnosis(impl);
			//diag.runDiagnosis(manager.getInfo());
			System.out.println(diag.runDiagnosis(manager.getInfo()));

			/*while (true){
				String echoString = input.readLine();
				// diagnosis
				System.out.println(echoString);
				DiagnosisImplementation impl = new StubImplementation();
				Diagnosis diag = new Diagnosis(impl);
				System.out.println(diag);
				socket.setSoTimeout(5000);
				output.println("Received " + diag.toString() + " from client."); // back to client
				if (echoString.equals("exit")){
					System.out.println("Client requested to close server: ");
					break;
				}

			}*/

		} catch (IOException e){
			System.out.println("Oops: " +e.getMessage());
		} finally {
			try {
				socket.close();
			} catch (IOException e){
				// a connection has been closed
				System.out.println("connection closed: "  + e.getMessage());

			}
		}
	}
}
