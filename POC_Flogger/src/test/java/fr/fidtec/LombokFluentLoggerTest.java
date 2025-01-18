package fr.fidtec;

import lombok.extern.flogger.Flogger;
import org.junit.jupiter.api.Test;

@Flogger
class LombokFluentLoggerTest {

    @Test
    void loggerTest() {
        LOG.atInfo().log("Info lombok log message !!!!");
    }
}
