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
import org.junit.jupiter.api.Test;
import statistics.Count;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 */
class CountTest {

    /**
     *
     */
    private Model model;

    /**
     *
     */
    private Count countTest = new Count(model, "countTester");


    @Test
    void getValuePositiveNumber() {
        double valuePositive = 5d;
        countTest.update(valuePositive);
        assertEquals(5.0, countTest.getValue());
    }

    @Test
    void getValueNegativeNumber() {
        double valueNegative = -5d;
        countTest.update(valueNegative);
        assertEquals(-5d, countTest.getValue());
    }

    @Test
    void getReportPostive() {

        double valPositive = 5d;

        countTest.update(valPositive);



        int observation = countTest.getObservations();
        double min = countTest.getMin();
        double max = countTest.getMax();
        double lastReset = countTest.getLastReset();
    }

    @Test
    void getReportNegative() {
        double valNegative = -10d;
        countTest.update(valNegative);

        int observation = countTest.getObservations();
        double min = countTest.getMin();
        double max = countTest.getMax();
        double lastReset = countTest.getLastReset();

        String result = "Number of Observations: " + observation + " Min: "
                + min + " Max: " + max + " since last Reset at: " + lastReset;
    }
}
