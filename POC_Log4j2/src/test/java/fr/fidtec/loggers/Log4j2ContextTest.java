package fr.fidtec.loggers;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.core.LoggerContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

@Log4j2
public class Log4j2ContextTest {

    private static final String NOM_FICHIER_CONFIG_LOG4J2 =  "src/test/resources/context/log4j2.xml";

    @BeforeAll // remplace Junit4 @BeforeClass
    static void BeforeAll() {
        // Injection du fichier de configuration de Log4j2
        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        File file = new File(NOM_FICHIER_CONFIG_LOG4J2);
        context.setConfigLocation(file.toURI());
    }

    @Test
    void simpleTest() {

        ThreadContext.put("UserName", "Fidele COULON");

        LOGGER.trace("Trace log message");
        LOGGER.debug("Debug log message");
        LOGGER.info("Info log message");
        LOGGER.warn("Warn log message");
        LOGGER.error("Error log message");
        LOGGER.fatal("Fatal log message");
    }
}
