package fr.fidtec.loggers;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;

@Log4j2
class Log4j2LombokTest {

    @Test
    void simpleTest() {
        LOGGER.trace("Trace log message");
        LOGGER.debug("Debug log message");
        LOGGER.info("Info log message");
        LOGGER.warn("Warn log message");
        LOGGER.error("Error log message");
        LOGGER.fatal("Fatal log message");
    }

    @Test
    void withExceptionTest() {
        LOGGER.error("Error log message", new Exception("CustomException"));
    }
}
