package fr.fidtec;

import com.google.common.flogger.FluentLogger;

/* https://howtodoinjava.com/java/library/fluent-logging-with-flogger/
 Flogger, similar to SLF4J, acts as an abstraction and uses the underlying logging framework as implementation.
 We can use Flogger with Java Logging API, Log4j2 and even SLF4J. By default, flogger uses Java Util Logging API (JUL).
 */
public class FloggerExemple {

    private static final FluentLogger log = FluentLogger.forEnclosingClass();

    public static void main(String... args) {

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
