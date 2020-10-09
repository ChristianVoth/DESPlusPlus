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

import core.BasicModelComponent;
import core.Model;

/**
 *
 */
public abstract class Reportable extends BasicModelComponent {
    /**
     *
     */
    private int observations;
    /**
     *
     */
    private double lastReset;

    /**
     *
     * @param parentModel
     * @param name
     */
    public Reportable(Model parentModel, String name) {
        super(parentModel, name);
    }

    /**
     *
     */
    public abstract QueueReport getReport();

    /**
     *
     */
    public void reset() {
        lastReset = getModel().currentTime();
        observations = 0;

    }

    /**
     *
     */
    public int getObservations() {

        return observations;
    }

    /**
     *
     */
    public int incObservations() {

        return observations++;
    }

    /**
     *
     */
    public double getLastReset() {

        return lastReset;
    }
}
