package helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {
    private static final Logger Logger = LogManager.getLogger(Log.class);

    public static void info(String message) {
        Logger.info(message);
    }
}