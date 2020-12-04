/* Main.java
version 1.0.1
11/29/2020
Copywrite UCO Software Engineering I Group 5
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import server.diagnosis.component.LoggingManager;
import server.diagnosis.server_management.ServerStarter;
import server.diagnosis.view.GUIStarter;

public class Main {
    public static void main(String[] args) {
        // LoggingManager.logger.info("info");
         new GUIStarter();
         new ServerStarter();

        // xmlBuild xmlBuild = new xmlBuild();
        // xmlBuild.build();
    }
}
