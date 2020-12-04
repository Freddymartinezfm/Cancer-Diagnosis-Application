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
        xmlBuild builder = new xmlBuild();
        builder.build();

        xmlParse parser = new xmlParse();
        parser.parse();

    }
}
