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

import core.LogHandler;
import core.Model;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Accumulate extends Statistic {

    /**
     *
     */
    private static final LogHandler myLog = new LogHandler();

    /**
     *
     */
    private Sorting sorting = new Sorting();

    /**
     *
     */
    private List<ListEntry> accumulate = new ArrayList<>();

    /**
     *
     */
    private List<Double> timeOfChanges = new ArrayList<>();

    /**
     *
     */
    private List<Double> timeOfExists = new ArrayList<>();

    /**
     *
     */
    private double median;

    /**
     *
     */
    private double firstQuantile;

    /**
     *
     */
    private double thirdQuantile;

    /**
     *
     */
    private double totalOfQueueEntries = 0;

    /**
     *
     * @param parentModel
     * @param name
     */
    public Accumulate(Model parentModel, String name) {
        super(parentModel, name);
    }

    /**
     *
     * @param val
     */
    public void update(double val) {

        ListEntry entry = new ListEntry(val, getModel().currentTime());
        accumulate.add(entry);
        super.update(val);
    }

    /**
     *
     */
    public void incTotalOfQueueEntries() {
        totalOfQueueEntries++;
    }

    /**
     *
     * @return
     */
    public Quantiles getQuantiles() {

        if (accumulate.size() <= 0) {
            return null;
        }
        calculateTimeDifferences();

        sorting.sortList(timeOfChanges);

        int npFirstQuantile = (int) (timeOfChanges.size() * 0.25d);
        int npThirdQuantile = (int) (timeOfChanges.size() * 0.75d);

        if (timeOfChanges.size() % 2 != 0) {
            median = timeOfChanges.get((timeOfChanges.size() / 2));
            firstQuantile = timeOfChanges.get(npFirstQuantile);
            thirdQuantile = timeOfChanges.get(npThirdQuantile);
        } else {
            median = (timeOfChanges.get((timeOfChanges.size() / 2))
                    + timeOfChanges.get(timeOfChanges.size() / 2 - 1)) * 0.5d;
            firstQuantile = (timeOfChanges.get(npFirstQuantile)
                    + timeOfChanges.get((npFirstQuantile - 1)) * 0.5d);
            thirdQuantile = (timeOfChanges.get(npThirdQuantile)
                    + timeOfChanges.get((npThirdQuantile - 1)) * 0.5d);
        }

        return new Quantiles(median, firstQuantile, thirdQuantile);



    }

    /**
     *
     * @return
     */
    public double getMean() {
        double timeWeightedSum = 0;

        for (int i = 0; i < accumulate.size() - 1; i++) {
            timeWeightedSum += accumulate.get(i).value
                    * (accumulate.get(i + 1).timeOfChange
                    - accumulate.get(i).timeOfChange);

        }
        return timeWeightedSum / totalOfQueueEntries;
    }

    /**
     *
     * @return
     */
    public double getStdDev() {

        double intermediateResult = 0;

        try {
            for (int i = 0; i < accumulate.size() - 1; i++) {
                intermediateResult += (Math.pow(accumulate.get(i).value
                        - getMean(), 2));
            }

        } catch (Exception e) {
            myLog.logger.info("boi, ListSize: " + accumulate.size()
                    + "intermediateResult: " + intermediateResult
                    + "Exception: " + e);
        }
        return Math.sqrt(intermediateResult
                / (totalOfQueueEntries - 1));
        //-1 because we are dealing with samples
    }

    /**
     *
     * @return
     */
    public double getMinimumWaitTime() {

        //calculateTimeDifferences();
        sorting.sortList(timeOfChanges);
        return timeOfChanges.get(0);


    }

    /**
     *
     * @return
     */
    public double getMaximumWaitTime() {

        //calculateTimeDifferences();
        sorting.sortList(timeOfChanges);
        return timeOfChanges.get(timeOfChanges.size() - 1);
    }

    /**
     *
     */
    public void calculateTimeDifferences() {

        findExits();

        int exitNumber = 0;

        if (accumulate.size() > 0) {

            for (int i = 1; i < accumulate.size() - 1; i++) {

                if (accumulate.get(i).value > accumulate.get(i - 1).value) {
                    double timeOfEntry = accumulate.get(i).timeOfChange;
                    double timeOfExit = timeOfExists.get(exitNumber);
                    timeOfChanges.add(timeOfEntry - timeOfExit);
                    exitNumber++;

                }
            }
        }


    }

    /**
     *
     * @return
     */
    public List getTimeOfChanges() {
        calculateTimeDifferences();
        sorting.sortList(timeOfChanges);
        return timeOfChanges;
    }

    /**
     *
     */
    public void findExits() {
        for (int i = 1; i < accumulate.size() - 1; i++) {
            if (accumulate.get(i).value < accumulate.get(i - 1).value) {
                timeOfExists.add(accumulate.get(i).timeOfChange);
            }
        }
    }

    /**
     *
     * @return
     */
    @Override
    public WaitingTimeReport getReport() {
        return new WaitingTimeReport(getMean(), getQuantiles(),
                getMinimumWaitTime(), getMaximumWaitTime());
    }
}
