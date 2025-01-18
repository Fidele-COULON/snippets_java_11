package fr.fidtec.loggers;

import org.junit.jupiter.api.Test;

class Log4j2SimpleTest {

    private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(Log4j2SimpleTest.class);

    @Test
    void simpleTest() {
        LOG.trace("Trace log message");
        LOG.debug("Debug log message");
        LOG.info("Info log message");
        LOG.warn("Warn log message");
        LOG.error("Error log message");
        LOG.fatal("Fatal log message");
    }

    @Test
    void withExceptionTest() {
        LOG.error("Error log message", new Exception("CustomException"));
    }

    @Test
    void withStringPlaceHoldersTest() {
        LOG.error("Test de logs pour %s", "Fidele"); // Test de logs pour %s
        LOG.error("Test de logs pour {}", "Fidele"); // Test de logs pour Fidele
    }
}