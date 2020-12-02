package server.diagnosis.server_management;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ServerStarter {
	private static final Logger logger = LogManager.getLogger();


	private int[] ports = {1001, 1002, 1003};

	public ServerStarter() {
		logger.info("stub log");
		
		for(int i = 0; i < ports.length; i++) {
			// new Server(ports[i]).start();
		}
		

		//new Server(ports[0]).start();
		//new Server(ports[1]).start();
		//new Server(ports[2]).start();

	}

	
}
