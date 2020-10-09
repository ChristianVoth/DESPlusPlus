/**
 * Project: DES++
 * $Header: $
 * Author: Christian Voth, Lennart Eikens, Lars Batterham, Steffen Kleinhaus
 * Last Change:
 *      by: $Author:
 *      date: $Date:
 * Copyright (c): DES++, 2020
 */

package statistics;

import core.Model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 */
public class Tally extends Statistic {

    /**
     *
     */
    private List<Double> tally = new ArrayList<>();

    /**
     *
     * @param parentModel
     * @param name
     */
    public Tally(Model parentModel, String name) {
        super(parentModel, name);

    }

    /**
     *
     */
    private Sorting sorting = new Sorting();

    /**
     *
     * @param val
     */
    public void update(double val) {
        tally.add(val);
        super.update(val);
    }

    /**
     *
     * @return
     */
    public double getMaxQueueLength() {
        sorting.sortList(tally);
        return tally.get(tally.size() - 1);
    }

    /**
     *
     * @return
     */
    public double getMean() {

        double sum = 0;
        for (double val: tally) {
            sum +=  val;
        }


        return sum / tally.size();

    }

    /**
     *
     * @return
     */
    public double getStdDev() {
        double stdDev;
        double intermediateResult = 0;
        for (double val : tally) {
            intermediateResult += (Math.pow(val - getMean(), 2));
        }

        stdDev = Math.sqrt(intermediateResult / tally.size());

        return stdDev;
    }

    /**
     *
     * @return
     */
    public Quantiles getQuantiles() {
        Collections.sort(tally);
        int npFirstQuantile = (int) (tally.size() * 0.25d);
        int npThirdQuantile = (int) (tally.size() * 0.75d);

        /**
         *
         */
        double median;

        /**
         *
         */
        double firstQuantile;

        /**
         *
         */
        double thirdQuantile;


        if (tally.size() % 2 != 0) {
            median = tally.get(tally.size() / 2);
            firstQuantile = tally.get(npFirstQuantile);
            thirdQuantile = tally.get(npThirdQuantile);
        } else {
            median = (tally.get(tally.size() / 2)
                    + tally.get(tally.size() / 2 - 1)) * 0.5d;
            firstQuantile = (tally.get(npFirstQuantile)
                    + tally.get(npFirstQuantile - 1)) * 0.5d;
            thirdQuantile = (tally.get(npThirdQuantile)
                    + tally.get(npThirdQuantile - 1)) * 0.5d;

        }

        return new Quantiles(median, firstQuantile, thirdQuantile);


    }

    /**
     *
     */
    public List getTally() {
        return tally;
    }

    /**
     *
     */
    @Override
    public QueueLengthReport getReport() {
        return new QueueLengthReport(getMean(), getQuantiles(),
                getMaxQueueLength());

    }
}
