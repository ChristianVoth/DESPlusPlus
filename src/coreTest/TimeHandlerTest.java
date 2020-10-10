package coreTest;

import core.TimeHandler;
import excepctionHandling.NegativeTimeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class TimeHandlerTest {
    TimeHandler timeHandler = new TimeHandler();



    @Test
    void calculateDifference() {
        Instant date1 = Instant.now();
        Instant date2 = date1.plusSeconds(50);

        assertEquals(50, timeHandler.calculateDifference(date1, date2));
    }

    @Test
    void calculateDifferenceThrowNegativeTime() {
        Instant date1 = Instant.now();
        Instant date2 = date1.minusSeconds(50);

        assertThrows(NegativeTimeException.class,
                () -> {
                    timeHandler.calculateDifference(date1, date2);
                });
    }
}