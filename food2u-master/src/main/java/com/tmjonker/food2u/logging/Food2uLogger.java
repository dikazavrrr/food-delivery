package com.tmjonker.food2u.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Food2uLogger {

    private static FileHandler fileHandler;
    private static SimpleFormatter simpleFormatter;

    public static Logger setUp(String name) {

        Logger logger = Logger.getLogger(name);

        logger.setLevel(Level.INFO);

        try {
            fileHandler = new FileHandler("food2u-log.log", true);
            simpleFormatter = new SimpleFormatter();
            fileHandler.setFormatter(simpleFormatter);
            logger.addHandler(fileHandler);
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new RuntimeException("Error creating log files");
        }

        return logger;
    }
}
