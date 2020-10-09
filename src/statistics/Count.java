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
public class Count extends Statistic {

    /**
     *
     */
    private double value = 0;

    /**
     *
     * @param parentModel
     * @param name
     */
    public Count(Model parentModel, String name) {
        super(parentModel, name);
    }

    /**
     *
     * @param val
     */
    public void update(double val) {
        value += val;
        super.update(value);
    }

    /**
     *
     * @return
     */
    public double getValue() {
        return value;
    }

    /**
     *
     */
    public void reset() {
        super.reset();
        value = 0;
    }

    /**
     *
     * @return
     */
    @Override
    public QueueReport getReport() {
        return null;
    }
}
