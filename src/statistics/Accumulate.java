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

        myLog.logger.finer("Value of Median: " + median + "FirstQuantile: " + firstQuantile
                        + " thirdQuantile: " + thirdQuantile);

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
        myLog.logger.finer("timeWeightedSum Value: " + timeWeightedSum
                + "totalOfQuueueEntries: " + totalOfQueueEntries);
        return timeWeightedSum / totalOfQueueEntries;
    }

    /**
     *
     * @return
     */
    public double getStdDev() {

        double intermediateResult = 0;


            for (int i = 0; i < accumulate.size() - 1; i++) {
                intermediateResult += (Math.pow(accumulate.get(i).value
                        - getMean(), 2));
            }

            myLog.logger.finer("itermediateResult Value: " + intermediateResult
                    + "totalOfQuueueEntries: " + totalOfQueueEntries);

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

        try {


        if (accumulate.size() > 0) {

            for (int i = 1; i < accumulate.size() - 1; i++) {

                if (accumulate.get(i).value > accumulate.get(i - 1).value && timeOfExists.size() > 0) {

                    double timeOfEntry = accumulate.get(i).timeOfChange;
                    double timeOfExit = timeOfExists.get(0);

                    timeOfExists.remove(timeOfExit);
                    timeOfChanges.add(timeOfExit - timeOfEntry);
                    }

                }
            } } catch (IndexOutOfBoundsException exception) {
                myLog.logger.severe("calculateTimeDifferences Method as thrown an OutOfBoundsException: " + exception
                        + "Your timeOfChanges seems to be null");
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
        try {


        for (int i = 1; i < accumulate.size() - 1; i++) {
            if (accumulate.get(i).value < accumulate.get(i - 1).value) {
                timeOfExists.add(accumulate.get(i).timeOfChange);
            }
        } } catch (IndexOutOfBoundsException exception) {
            myLog.logger.severe("findExits Method as thrown an OutOfBoundsException: " + exception
                + "Your timeOfExists seems to be null");
        }
    }
    public void initQueue() {
        ListEntry defaultEntry = new ListEntry(0,0);
        accumulate.add(defaultEntry);

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
