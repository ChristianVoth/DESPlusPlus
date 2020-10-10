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
 * Base class for all classes in statistics package. Contains all methods which are necessary to be implemented by each
 * of said classes.
 */
public abstract class Reportable extends BasicModelComponent {
    /**
     * Counter for total number of observations.
     */
    private int observations;
    /**
     * Model time since last reset is stored.
     */
    private double lastReset;

    /**
     *
     * @param parentModel : model the reportable object belongs to
     * @param name : name of the reportable object
     */
    public Reportable(Model parentModel, String name) {
        super(parentModel, name);
    }

    /**
     * @return the queue report
     */
    public abstract QueueReport getQueueReport();

    /**
     *
     * @return other reports
     */

    public abstract Report getReport();

    /**
     * Reset observations and save current model time.
     */
    public void reset() {
        lastReset = getModel().currentTime();
        observations = 0;

    }

    /**
     * @return  current amount of observations
     */
    public int getObservations() {

        return observations;
    }

    /**
     * Increases amount of observations
     */
    public void incObservations() {

         observations++;
    }

    /**
     * @return time since last reset
     */
    public double getLastReset() {

        return lastReset;
    }
}
