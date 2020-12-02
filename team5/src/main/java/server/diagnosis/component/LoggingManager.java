package server.diagnosis.component;

import org.apache.log4j.WriterAppender;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggingManager extends WriterAppender {
	public static final Logger logger = LogManager.getLogger();
	
	

	public static void displayLogLevels(){
		logger.info("info");
		logger.trace("log info");
		logger.debug("log debug");
		logger.info("log info");
		logger.warn("log warn");
		logger.error("log error");
		logger.fatal("log fatal");

	}

}

