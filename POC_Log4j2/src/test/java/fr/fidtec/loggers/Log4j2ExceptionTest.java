package fr.fidtec.loggers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

class Log4j2ExceptionTest {

    private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(Log4j2ExceptionTest.class);

    private static final String NOM_FICHIER_CONFIG_LOG4J2 =  "src/test/resources/throwable/log4j2.xml";

    @BeforeAll // remplace Junit4 @BeforeClass
    static void BeforeAll() {
        // Injection du fichier de configuration de Log4j2
        LoggerContext context = (org.apache.logging.log4j.core.LoggerContext) LogManager.getContext(false);
        File file = new File(NOM_FICHIER_CONFIG_LOG4J2);
        context.setConfigLocation(file.toURI());
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
}