package fr.fidtec;

import com.google.common.flogger.FluentLogger;
import org.junit.jupiter.api.Test;

class FluentLoggerTest {

    private static final FluentLogger log = FluentLogger.forEnclosingClass();

    @Test
    void loggerTest() {
        log.atFinest().log("Finest log message");
        log.atFiner().log("Finer log message");
        log.atFine().log("Fine log message");

        log.atInfo().log("Info log message");
        log.atConfig().log("Config log message");

        log.atWarning().log("Warn log message");
        log.atSevere().log("Severe log message");

        log.atInfo().log("Je suis %s", "Fidele");
    }
}
