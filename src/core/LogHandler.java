package core;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.*;

public class LogHandler {
    public static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public LogHandler()  {
        ConsoleHandler ch = new ConsoleHandler();
        FileHandler fh = null;

        //resets Log-Handler
        LogManager.getLogManager().reset();

        logger.setLevel(Level.ALL);

        ch.setLevel(Level.SEVERE);
        logger.addHandler(ch);

        try {
            fh = new FileHandler("Log.log");
            fh.setLevel(Level.FINE);
            logger.addHandler(fh);
        } catch (IOException e ) {
            logger.log(Level.SEVERE, "File couldn't be open " + e);
        }
    }
}
