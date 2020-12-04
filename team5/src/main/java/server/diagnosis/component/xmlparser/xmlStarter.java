package server.diagnosis.component.xmlparser;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class xmlStarter {
    public xmlStarter(){
        start();
    }

    private void start(){
        //testing build and parse
        xmlBuild xmlBuilder = new xmlBuild();
        xmlBuilder.build();

        

    }
}
