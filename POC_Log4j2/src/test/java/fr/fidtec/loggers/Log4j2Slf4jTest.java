package fr.fidtec.loggers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class Log4j2Slf4jTest {

    @Test
    void simpleTest() {
        LOGGER.trace("Trace log message");
        LOGGER.debug("Debug log message");
        LOGGER.info("Info log message");
        LOGGER.warn("Warn log message");
        LOGGER.error("Error log message");
        // LOGGER.fatal("Fatal log message"); fatal n'existe pas avec Slf4j
    }

    @Test
    void withExceptionTest() {
        LOGGER.error("Error log message", new Exception("CustomException"));
    }

    @Test
    void withStringPlaceHoldersTest() {
        LOGGER.error("Test de logs pour {}", "Fidele"); // Test de logs pour Fidele
    }
}
