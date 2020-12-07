/* Main.java
version 1.0.1
11/29/2020
Copywrite UCO Software Engineering I Group 5
 */

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;

//import server.diagnosis.component.LoggingManager;
//import server.diagnosis.component.xmlparser.xmlManager;
import server.diagnosis.server_management.PeerManagement;
import server.diagnosis.view.GUIStarter;
//https://github.com/Freddymartinezfm/Cancer-Diagnosis-Application.git
//git@github.com:Freddymartinezfm/Cancer-Diagnosis-Application.git

public class Main {
    public static void main(String[] args) {
        new GUIStarter();
        new PeerManagement();
    }
}


