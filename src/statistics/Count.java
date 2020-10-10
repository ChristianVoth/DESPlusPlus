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

/**
 * Simple counter which can be implemented anywhere in a user-defined model, be it for resources or other items
 * needing simple data storage.
 */
public class Count extends Statistic {

    /**
     * Every counter starts at 0.
     */
    private double value = 0;

    /**
     *
     * @param parentModel : reference to the model the count object belongs to
     * @param name : name of count object
     */
    public Count(Model parentModel, String name) {
        super(parentModel, name);
    }

    @Override
    public QueueReport getQueueReport() {
        return null;
    }

    /**
     * Update method is called when changes occur to the count.
     * @param val : indicates by how much value should be incremented or decremented
     */
    public void update(double val) {
        value += val;
        super.update(value);
    }

    /**
     *
     * @return the current value of the count
     */
    public double getValue() {
        return value;
    }

    /**
     * Resets count to 0.
     */
    public void reset() {
        super.reset();
        value = 0;
    }

    /**
     *
     * @return the Report
     */
    @Override
    public Report getReport() {
        return null;
    }
}
