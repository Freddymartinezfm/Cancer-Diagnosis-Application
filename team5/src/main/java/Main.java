
// import server.diagnosis.server_management.ServerStarter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import server.diagnosis.view.GUIStarter;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        logger.info("stub log");
         new GUIStarter();
    }       
     // ServerStarter serverStarter = new ServerStarter();
}
