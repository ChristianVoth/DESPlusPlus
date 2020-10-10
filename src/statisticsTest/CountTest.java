package statisticsTest;

import core.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import statistics.Count;

import static org.junit.jupiter.api.Assertions.*;

class CountTest {
    Model model;
    Count count = new Count(model, "CountTest");

    @BeforeEach
    void setUp() {
        count.update(4);
        count.update(3);
        count.update(2);

    }

    @Test
    void updateWithMax() {

        count.update(34);

        assertEquals(43, count.getMax());
    }

    @Test
    void getValue() {

        assertEquals(9, count.getValue());
    }

    @Test
    void reset() {
        count.reset();
        assertEquals(0, count.getValue());

    }
}