package server.diagnosis.server_management;

public class ServerStarter {

	private int[] ports = {1001, 1002, 1003};

	public ServerStarter() {

		
		for(int i = 0; i < ports.length; i++) {
			new Server(ports[i]).start();
		}
		

		//new Server(ports[0]).start();
		//new Server(ports[1]).start();
		//new Server(ports[2]).start();

	}

	
}
