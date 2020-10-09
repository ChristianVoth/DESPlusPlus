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
 *
 */
public abstract class Statistic extends Reportable {

    /**
     *
     */
    private double min = 0;
    /**
     *
     */
    private double max = 0;

    /**
     *
     * @param parentModel
     * @param name
     */
    public Statistic(Model parentModel, String name) {
        super(parentModel, name);
    }

    /**
     *
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
     *
     */
    public double getMin() {
        return min;
    }

    /**
     *
     */
    public double getMax() {
        return max;
    }

}
