package fr.fidtec;

import com.google.common.flogger.StackSize;
import lombok.extern.flogger.Flogger;

import java.util.logging.Level;

// https://www.baeldung.com/flogger-logging
// @Flogger Creates
// private static final com.google.common.flogger.FluentLogger log = com.google.common.flogger.FluentLogger.forEnclosingClass();

/* https://howtodoinjava.com/java/library/fluent-logging-with-flogger/
 Flogger, similar to SLF4J, acts as an abstraction and uses the underlying logging framework as implementation.
 We can use Flogger with Java Logging API, Log4j2 and even SLF4J. By default, flogger uses Java Util Logging API (JUL).
 */

// Ne se lance pas dans IntelliJ
@Flogger
public class FloggerExemple {

    public static void main(String... args) {

        log.atFinest().log("Finest log message");
        log.atFiner().log("Finer log message");
        log.atFine().log("Fine log message");

        log.atInfo().log("Info log message");
        log.atConfig().log("Config log message");

        log.atWarning().log("Warn log message");
        log.atSevere().log("Severe log message");

        log.atInfo().log("Je suis %s", "Fidele");



        log.at(Level.SEVERE)
                .log("Hello World !!!! en mode SEVERE", new Exception("C'est une exception"));

        log.at(Level.SEVERE)
                .withCause(new Exception("C'est une exception"))
                .log("Hello World !!!! en mode SEVERE");

        /*
            StackSize.SMALL: Produces a small stack suitable for more fine grained debugging.
            StackSize.MEDIUM: Produces a medium sized stack suitable for providing contextual information for most log statements.
            StackSize.LARGE: Produces a large stack suitable for providing highly detailed contextual information.
            StackSize.FULL: Provides the complete stack trace.
            StackSize.NONE: Provides no stack trace. This is useful when the stack size is conditional.
         */

        log.at(Level.SEVERE)
                .withStackTrace(StackSize.FULL)
                .withCause(new Exception("C'est une exception"))
                .log("Hello World !!!! en mode SEVERE");
    }
}
