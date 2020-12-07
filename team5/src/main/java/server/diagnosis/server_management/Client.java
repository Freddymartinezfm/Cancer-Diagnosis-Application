package server.diagnosis.server_management;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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
		// diagnoses array size needs to match number of peerPorts
		int[] diagnoses = new int[1];
		String s;
		int diagnosesCount = 0;

		for (int p: peerPorts) {

			try(Socket socket = new Socket("localhost", p)){
				
				//start of convert file to byte data
				File xmlFile = new File("patient_info.xml");
				InputStream inFile = new FileInputStream(xmlFile);
				OutputStream outFile = socket.getOutputStream();
				int count;
				byte[] bytes = new byte[2*1024];
				while ((count = inFile.read(bytes)) > 0) {
					outFile.write(bytes, 0, count);
				}
				inFile.close();
				outFile.close();
				//end

				BufferedReader echoes = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				s = echoes.readLine();
				diagnoses[count] = Integer.parseInt(s);
				echoes.close();
				
			} catch(IOException e){
				System.out.println("uh oh" + e.getMessage());
			}
			diagnosesCount++;
		}
		for(int e: diagnoses) {
			System.out.println(e);
		}
	}
}