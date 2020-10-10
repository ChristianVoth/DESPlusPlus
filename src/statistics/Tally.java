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
 * Tally class is used to store non-time-weighted values and calculating statistically relevant data.
 */
public class Tally extends Statistic {

    /**
     * List to store values.
     */
    private List<Double> tally = new ArrayList<>();

    /**
     *
     * @param parentModel : model this object belongs to
     * @param name : name of this object
     */
    public Tally(Model parentModel, String name) {
        super(parentModel, name);

    }

    /**
     * Reference to a sorting object.
     */
    private Sorting sorting = new Sorting();

    /**
     *  Adds passed value to the list.
     * @param val : passed value
     */
    public void update(double val) {
        tally.add(val);
        super.update(val);
    }

    /**
     *
     * @return maximum queue length
     */
    public double getMaxQueueLength() {
        sorting.sortList(tally);
        return tally.get(tally.size() - 1);
    }

    /**
     *
     * @return mean queue length
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
     * @return standard deviation from given mean
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
     * @return calculated quantiles, including the median
     */
    public Quantiles getQuantiles() {

        double median;

        double firstQuantile;

        double thirdQuantile;

        Collections.sort(tally);
        int npFirstQuantile = (int) (tally.size() * 0.25d);
        int npThirdQuantile = (int) (tally.size() * 0.75d);
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
     * @return the tally list
     */
    public List getTally() {
        return tally;
    }

    /**
     *
     */
    @Override
    public QueueLengthReport getQueueReport() {
        return new QueueLengthReport(getMean(), getQuantiles(),
                getMaxQueueLength());

    }

    @Override
    public Report getReport() {
        return null;
    }
}
