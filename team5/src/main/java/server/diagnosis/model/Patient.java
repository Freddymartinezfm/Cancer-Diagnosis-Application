package server.diagnosis.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Patient {
    private static final Logger logger = LogManager.getLogger();


    private int id;
    private int thickness;
    private int uniformity_size;
    private int uniformity_shape;
    private int adhesion;
    private int epithelial_size;
    private int bare_nuclei;
    private int chromatin;
    private int mitosis;
    private int diagnosis_class;

    public Patient() {
        logger.info("stub log");
        
    }


    
}
