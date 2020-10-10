package statisticsTest;

import core.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import statistics.Accumulate;

import static org.junit.jupiter.api.Assertions.*;

class AccumulateTest {
    Model model = new Model("testModel") {
        @Override
        public void init() {

        }
    };
    Accumulate accumulate = new Accumulate(model, "TestAccumulate");

    @BeforeEach
    void setUp() {
        accumulate.update(10);
        accumulate.update(5);
        accumulate.update(85);
    }

    @Test
    void updateWithGetMax() {

        accumulate.update(20);

        assertEquals(85, accumulate.getMax());
    }

    @Test
    void getQuantilesMedian() {

        assertEquals(4, accumulate.getQuantiles().median);

    }

    @Test
    void getQuantilesFirstQuantile() {

        assertEquals(4, accumulate.getQuantiles().firstQuantile);

    }


    @Test
    void getQuantilesThirdQuantile() {


        assertEquals(4, accumulate.getQuantiles().thirdQuantile);
    }


    @Test
    void getMean() {

        assertEquals(4, accumulate.getMean());
    }

    @Test
    void getStdDev() {
        assertEquals(5, accumulate.getStdDev());

    }

    @Test
    void getMinimumWaitTime() {

        assertEquals(4,accumulate.getMinimumWaitTime() );
    }

    @Test
    void getMaximumWaitTime() {

        assertEquals(4,accumulate.getMaximumWaitTime());
    }

}