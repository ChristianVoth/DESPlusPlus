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
public class ExponentialDistribution extends Distribution {

    /**
     *
     */
    private double mean;

    /**
     *
     */
    private double sample;

    /**
     *
     * @param parentModel
     * @param name
     * @param seed
     * @param mmean
     */
    public ExponentialDistribution(Model parentModel, String name,
                                   long seed, double mmean) {
        super(parentModel, name, seed);
        this.mean = mmean;
    }

    /**
     *
     * @return
     */
    public double sample() {
        return sample = -Math.log(nextRandomDouble()) * mean;
    }

    /**
     *
     * @return
     */
    public double getMean() {
        return this.mean;
    }

    /**
     *
     * @return
     */
    public QueueReport getReport() {
        return null;
    }


}
