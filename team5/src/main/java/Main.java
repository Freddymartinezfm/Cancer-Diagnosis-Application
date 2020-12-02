
// import server.diagnosis.server_management.ServerStarter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import server.diagnosis.component.LoggingManager;
import server.diagnosis.server_management.ServerStarter;
import server.diagnosis.view.GUIStarter;

public class Main {
    // private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) {
        LoggingManager.logger.info("info");
         new GUIStarter();
         new ServerStarter();

    }       
     
}
