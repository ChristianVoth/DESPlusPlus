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
import statistics.Accumulate;

/**
 *
 */
class AccumulateTest  {
    /**
     *
     */
    private Model model = new Model("AccModelTest") {
        @Override
        public void init() {

        }
    };
    /**
     *
     */
    private Accumulate acc = new Accumulate(model, "AccumulateTest");

    @Test
    void update() {
    }

    @Test
    void getMean() {
    }

    @Test
    void getStdDev() {
    }

    @Test
    void getMedian() {
        for (int i = 1; i < 5; i++) {
            acc.update(i);
        }
        //assertEquals(2.5d,acc.getMedian());
    }

    @Test
    void getFristQUantil() {

        acc.update(4);
        acc.update(3);
        acc.update(3);
        acc.update(4);
        acc.update(4);
        acc.update(6);
        acc.update(5);
        acc.update(6);
        acc.update(8);
        acc.update(7);
        acc.update(7);
        acc.update(7);

       // assertEquals(4d, acc.getFirstQuantile());

    }

    @Test
    void getReport() {
    }
}