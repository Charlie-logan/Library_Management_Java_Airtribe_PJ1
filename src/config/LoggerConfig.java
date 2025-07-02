package config;

import java.io.IOException;
import java.util.logging.*;

public class LoggerConfig {
    public static void configure() {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.ALL);
        try {
            FileHandler fileHandler = new FileHandler("library.log", true);
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Failed to setup logger", e);
        }
    }
}