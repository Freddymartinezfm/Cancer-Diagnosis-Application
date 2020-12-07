package server.diagnosis.server_management;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
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
	private static final Logger logger = LogManager.getLogger(Peer.class);


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
			InetAddress ip = socket.getInetAddress();
			
			String s = " ";
			while (true) { 
				if (ip.isLoopbackAddress()){  // local connection
					System.out.println("Local connection ");
					output.println("Local connection ");
					logger.info("local");
					s = input.readLine();
					System.out.println(s);
					output.println("response contains:  " + s +  "diagnosis result");
				} else { // remote connection
					System.out.println("Remote connection ");
					//create new xmlfile at location to parse
					File outputFile = new File("patient_info2.xml");
					InputStream in = socket.getInputStream();
					OutputStream out = new FileOutputStream(outputFile);
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
					s = input.readLine();
					logger.info("remote connection: " +  s);
					output.println("response " + " diag result ");
					System.out.println("read " + s + " from connection ");
					
				}


				// Diagnosis implementation goes below here, outside of if else statement 
				// either way a diagnosis will have to be completed, and can reside outside the loop
				// loop indefinately reading the input from the connection.
				// if (s.equals("exit")){
				// 	System.out.println("Client requested to close server: ");
				// 	break;
				// }

			}			

			// moved to scratch.txt

			// if code reaches here, a client did not connect 

		} catch (IOException e){
			System.out.println("Oops no client connnection: " +e.getMessage());
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
