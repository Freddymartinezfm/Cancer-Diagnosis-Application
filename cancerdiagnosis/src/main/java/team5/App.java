package team5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

/**
 * Hello world!
 *
 */
public class App {
    private static final Logger logger = (Logger)LogManager.getLogger(App.class);



    public static void main( String[] args ){
        logger.info("info: ");
    
        System.out.println( "Hello World!" );
    }
}
