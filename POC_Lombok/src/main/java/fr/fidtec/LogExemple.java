package fr.fidtec;

import lombok.extern.java.Log;
import java.util.logging.*;

// Choix des loggers : Logback > Log4j > JDK logging/JUL

// https://projectlombok.org/features/log
// @Log creates
// private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(LogExample.class.getName());
// JUL
@Log
public class LogExemple {

    public static void main(String... args) {
        log.entering("LogExemple", "main");

        log.finest("Coucou en finest !"); // LOWEST LEVEL
        log.finer("Coucou en finer !");
        log.fine("Coucou en fine !");
        log.info("Coucou en info !");
        log.config("Coucou en config !");
        log.warning("Coucou en warning !");
        log.severe("Coucou en severe !"); // HIGHEST LEVEL

        log.log(Level.SEVERE, "Hello World !!!! en mode SEVERE", new Exception("C'est une exception"));

        log.exiting("LogExemple", "main");
    }
}
