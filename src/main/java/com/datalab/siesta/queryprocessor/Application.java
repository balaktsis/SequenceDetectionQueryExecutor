package com.datalab.siesta.queryprocessor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.log4j.Logger;

/**
 * Main Class to start the application
 */
@SpringBootApplication
public class Application {

//    private static final Logger logger = LoggerFactory.getLogger(Application.class);


    /**
     * Initializes the Logger and starts the application
     * @param args
     */
    public static void main(String[] args) {
//        Logger logger = LoggerFactory.getLogger(Application.class);
//        logger.info("This is how you configure Log4J with SLF4J");
        ApplicationContext applicationContext =SpringApplication.run(Application.class, args);
    }

}
