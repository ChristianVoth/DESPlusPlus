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
 * Abstract base class which count, tally and accumulate extend.
 * Stores maximums and minimums of each object.
 */
public abstract class Statistic extends Reportable {

    /**
     * Stores minimum.
     */
    private double min = 0;
    /**
     * Stores maximum.
     */
    private double max = 0;

    /**
     *
     * @param parentModel : model this statistic object belongs to
     * @param name : name of this statistic object
     */
    public Statistic(Model parentModel, String name) {
        super(parentModel, name);
    }

    /**
     * Examine if new minimum or maximum is reached.
     * If it is, update accordingly.
     * @param val
     */
    public void update(double val) {
        if (val > max) {
            max = val;
        }
        if (val < min) {
            min = val;
            incObservations();
        }
    }

    /**
     * @return minimum
     */
    public double getMin() {
        return min;
    }

    /**
     * @return maximum
     */
    public double getMax() {
        return max;
    }

}
