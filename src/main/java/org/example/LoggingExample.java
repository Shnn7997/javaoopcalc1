package org.example;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingExample {
    private static final Logger logger = Logger.getLogger(Calculator.class.getName());

    public static void setupLogger() {
        try {
            FileHandler handler = new FileHandler("calculator.log", true);
            handler.setFormatter(new SimpleFormatter());

            logger.addHandler(handler);

            logger.setLevel(Level.ALL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}