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
public class UniformDistribution extends Distribution {

    /**
     *
     */
    private double max;

    /**
     *
     */
    private double min;

    /**
     *
     */
    private double sample;

    /**
     *
     * @param parentModel
     * @param name
     * @param seed
     * @param mmin
     * @param mmax
     */
    public UniformDistribution(Model parentModel, String name, long seed,
                               double mmin, double mmax) {

        super(parentModel, name, seed);
        this.min = mmin;
        this.max = mmax;
    }

    /**
     *
     */
    public double sample() {
        return sample = min + ((max - min) * nextRandomDouble());

    }

    /**
     *
     */
    public double getMin() {
        return this.min;
    }

    /**
     *
     */
    public double getMax() {
        return this.max;
    }

    /**
     *
     */
    public QueueReport getReport() {
        return null;
    }

}
