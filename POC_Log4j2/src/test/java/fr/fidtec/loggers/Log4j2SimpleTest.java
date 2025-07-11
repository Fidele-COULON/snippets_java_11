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
        LOG.error("Error log message", new Exception("CustomException1"));
        /* Génère message + ST :
            java.lang.Exception: CustomException1
	            at fr.fidtec.loggers.Log4j2SimpleTest.withExceptionTest(Log4j2SimpleTest.java:21)
	            at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	            at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77)
	     */

        // https://stackoverflow.com/questions/63729726/log4j-2-not-logging-out-throwable
        LOG.error(new Exception("CustomException2")); // public void error(final Object message)
        /* Génère message to String
        2025-01-24 20:27:02,721 [main] ERROR fr.fidtec.loggers.Log4j2SimpleTest - java.lang.Exception: CustomException2
         */
    }

    @Test
    void withStringPlaceHoldersTest() {
        LOG.error("Test de logs pour %s", "Fidele"); // Test de logs pour %s
        LOG.error("Test de logs pour {}", "Fidele"); // Test de logs pour Fidele
    }
}