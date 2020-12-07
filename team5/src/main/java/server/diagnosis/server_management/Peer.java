package server.diagnosis.server_management;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import server.diagnosis.Diagnosis;
import server.diagnosis.DiagnosisImplementation;
import server.diagnosis.StubImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Peer extends Thread {

	private Socket socket;

	public Peer (Socket socket){
		System.out.println("Client socket port:  " +  socket.getLocalPort());
		System.out.println("Client address: " + socket.getInetAddress());
		this.socket = socket;
	}


	@Override
	public void run(){
		try {
			BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
			String echoString = " ";

			while (true){
				echoString = input.readLine();
				System.out.println(echoString);
				output.println("response contains:  " + echoString +  "diagnosis result");


				// diagnosis
				// DiagnosisImplementation impl = new StubImplementation();
				// Diagnosis diag = new Diagnosis(impl);
				// System.out.println(diag);
				// socket.setSoTimeout(5000);
				if (echoString.equals("exit")){
					System.out.println("Client requested to close server: ");
					break;
				}


				/*

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
				 */

				new Peer(socket);
			}

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