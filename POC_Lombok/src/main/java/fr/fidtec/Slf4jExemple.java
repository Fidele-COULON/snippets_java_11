package fr.fidtec;

import lombok.extern.slf4j.Slf4j;


// Apache Commons Logging and SLF4J are logging facades
// In this case use SLF4J (Commons Logging is older and has some classloader issues)

// @CommonsLog
//    Creates private static final org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory.getLog(LogExample.class);

// @Slf4j
//    Creates private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(LogExample.class);

// @XSlf4j
//    Creates private static final org.slf4j.ext.XLogger log = org.slf4j.ext.XLoggerFactory.getXLogger(LogExample.class);

// https://www.slf4j.org/extensions.html

@Slf4j
public class Slf4jExemple {
    public static void main(String... args) {
        log.trace("Trace log message");
        log.debug("Debug log message");
        log.info("Info log message");
        log.warn("Warn log message");
        log.error("Error log message");

        log.error("Error log message", new Exception("Test Exception"));

        log.error("Test de logs pour {}", "Fidele"); // Test de logs pour Fidele
    }
}
