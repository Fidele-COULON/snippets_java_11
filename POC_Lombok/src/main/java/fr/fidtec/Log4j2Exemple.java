package fr.fidtec;

import lombok.extern.log4j.Log4j2;

// @Log4j2 Creates
// private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(LogExample.class);
@Log4j2
public class Log4j2Exemple {
    public static void main(String... args) {
        log.trace("Trace log message");
        log.debug("Debug log message");
        log.info("Info log message");
        log.warn("Warn log message");
        log.error("Error log message");
        log.fatal("Fatal log message");
    }
}
