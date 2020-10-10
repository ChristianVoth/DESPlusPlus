package statisticsTest;

import core.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import statistics.Tally;

import static org.junit.jupiter.api.Assertions.*;

class TallyTest {
    Model model = new Model(
    "TestModel"
    ) {
        @Override
        public void init() {

        }
    };
    Tally tallyTest = new Tally(model, "TestTally");


    @BeforeEach
    void setUp() {
        tallyTest.update(5);
        tallyTest.update(4);
        tallyTest.update(2);
        tallyTest.update(1);

    }

    @Test
    void updateWithGetTally() {
        tallyTest.update(10);

        assertEquals(5,tallyTest.getTally().size());
    }

    @Test
    void getMaxQueueLength() {
        tallyTest.update(50);

        assertEquals(50,tallyTest.getMaxQueueLength());
    }

    @Test
    void getMean() {

        assertEquals(3,tallyTest.getMean());
    }

    @Test
    void getStdDev() {

        assertEquals(1.5811388300841898d, tallyTest.getStdDev());
    }

    @Test
    void getQuantilesMedian() {

        assertEquals(3, tallyTest.getQuantiles().median);
    }

    @Test
    void getQuantilesFirstQuantile() {

        assertEquals(1.5d, tallyTest.getQuantiles().firstQuantile);
    }

    @Test
    void getQuantilesThirdQuantile() {

        assertEquals(4.5, tallyTest.getQuantiles().thirdQuantile);
    }

    @Test
    void getTally() {
        assertEquals(4,tallyTest.getTally().size());
    }

    @Test
    void getQueueReportMedian() {

        assertEquals(tallyTest.getQuantiles().median, tallyTest.getQueueReport().quantiles.median);
    }

    @Test
    void getQueueReportFirstQuantile() {

        assertEquals(tallyTest.getQuantiles().firstQuantile, tallyTest.getQueueReport().quantiles.firstQuantile);
    }

    @Test
    void getQueueReportThirdQuantile() {

        assertEquals(tallyTest.getQuantiles().thirdQuantile, tallyTest.getQueueReport().quantiles.thirdQuantile);
    }

}