package server.diagnosis.server_management;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import server.diagnosis.DiagnosisImplementation;
import server.diagnosis.StubImplementation;
import server.diagnosis.component.xmlparser.xmlManager;




public class Peer extends Thread {

	private Socket socket;
	private static final Logger logger = LogManager.getLogger(Peer.class);
	private Panel panel;

	public Peer(Socket socket) {
		logger.info("Client connected:" + socket.getChannel());
		logger.info("Client socket port:  " + socket.getLocalPort());
		logger.info("Client address: " + socket.getInetAddress());
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			// create new xmlfile at location to parse
			logger.info("New request received from client");
			File outputFile = new File("patient_info2.xml");
			InputStream in = socket.getInputStream();
			OutputStream out = new FileOutputStream(outputFile);
			byte[] bytes = new byte[2 * 1024];
			int count;
			logger.info("File transfer started.");
			while ((count = in.read(bytes)) > 0) {
				out.write(bytes, 0, count);
			}
			out.close();
			logger.info("File recieved.");

			xmlManager manager = new xmlManager();
			manager.parse(outputFile);

			DiagnosisImplementation impl = new StubImplementation();
			int diagnosis = impl.runDiagnosis(manager.getInfo());

			//new socket to return results to client
			Socket socket1 = new Socket("localhost", 5000);
			OutputStream output = new DataOutputStream(socket1.getOutputStream());
			output.write(diagnosis);
			String d = String.valueOf(diagnosis);
			logger.info("Diagnosis response is " + d + ".");
			socket1.close();
			//end

		} catch (IOException e) {
			logger.warn("No client connnection: " + e.getMessage());
            panel.getStuff().append("Error with connection");


		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				// a connection has been closed
				logger.info("Connection closed: " + e.getMessage());

			}
		}
	}
}
