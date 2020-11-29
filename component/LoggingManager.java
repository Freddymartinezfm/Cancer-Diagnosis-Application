package src.component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingManager {
	private String logger_level;
	private static final org.apache.logging.log4j.core.Logger logger = (org.apache.logging.log4j.core.Logger) LogManager.getLogger(LoggingManager.class);

	public static void main(String[] args) {
		logger.trace("log info");
		logger.debug("log info");
		logger.info("log info");
		logger.warn("log info");
		logger.error("log info");
		logger.fatal("log debug");
	}

	public void setLoggerLevel(String lvl){
		this.logger_level = lvl;
	}
}