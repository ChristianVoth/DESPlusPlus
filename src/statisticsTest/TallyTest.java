/**
 * Project: DES++
 * $Header: $
 * Author: Christian Voth, Lennart Eikens, Lars Batterham, Steffen Kleinhaus
 * Last Change:
 *      by: $Author:
 *      date: $Date:
 * Copyright (c): DES++, 2020
 */

package statisticsTest;


import core.Model;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import statistics.Tally;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
class TallyTest {

    /**
     *
     */
    private List<Double> tallyTest = new ArrayList<>();

    /**
     *
     */
    private Model model;

    /**
     *
     */
    Tally tally = new Tally(model, "TallyTest");




    @Test
    void getMeanWholeNumbers() {
        double mean;

        for (int i = 1; i <= 5; i++) {
            tally.update(i);
        }

        assertEquals(3, tally.getMean());

    }

    @Test
    void getMeanNegativeNumbers() {

        for (int i = -1; i >= -5; i--) {
            tally.update(i);
        }

        assertEquals(-3d, tally.getMean());
    }

    @Test
    void getMeanDecialNumber() {

        for (double i = 6; i > 0; i -= 0.5) {
            tally.update(i);
        }

        assertEquals(3.25d, tally.getMean());
    }

    @Test
    void getStdDevPositiveNumber() {

        for (int i = 1; i <= 5; i++) {
            tally.update(i);
        }

        assertEquals(1.4142d, tally.getStdDev());

    }

    @Test
    void getStdDevNegativeNumber() {

        for (int i = -1; i >= -5; i--) {
            tally.update(i);
        }

        assertEquals(1.4142d, tally.getStdDev());
    }

    @Test
    void getStdDeDecimalNumber() {

        for (double i = 6; i > 0; i -= 0.5d) {
            tally.update(i);
        }

        assertEquals(1.7260d, tally.getStdDev());
    }


    @Disabled
    void getReportWithNoValue() {

        String result = "Number of Observations: " + tally.getObservations()
                + " Min: " + tally.getMin()
                + " Max: " + tally.getMax() + " Mean: " + tally.getMean()
                + " Standard Deviation: " + tally.getStdDev()
                + " since last Reset at: " + tally.getLastReset();
    }

    @Disabled
    void getReportWithValue() {

        tally.update(5d);
        tally.update(-4d);
        tally.update(3d);

        String result = "Number of Observations: " + tally.getObservations()
                + " Min: " + tally.getMin()
                + " Max: " + tally.getMax() + " Mean: " + tally.getMean()
                + " Standard Deviation: " + tally.getStdDev()
                + " since last Reset at: " + tally.getLastReset();
    }

    @Test
    void getMedianGanzahlig() {
        for (int i = 1; i <= 6; i++) {
            tally.update(i);
        }
    }

    @Test
    void getMedianNonGanzahling() {
        for (int i = 1; i < 6; i++) {
            tally.update(i);
        }
    }

    @Test
    void firstQuatilNonIntegral() {

        for (int i = 1; i < 6; i++) {
            tally.update(i);
        }
    }

    @Test
    void firstQuantilWholeNumber() {


        tally.update(4);
        tally.update(3);
        tally.update(3);
        tally.update(4);
        tally.update(4);
        tally.update(6);
        tally.update(5);
        tally.update(6);
        tally.update(8);
        tally.update(7);
        tally.update(7);
        tally.update(7);
    }
}
