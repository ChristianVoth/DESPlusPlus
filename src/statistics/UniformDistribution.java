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
 * Class in order to generate uniformly distributed values.
 */
public class UniformDistribution extends Distribution {

    /**
     * Defines upper limit.
     */
    private double max;

    /**
     * Defines lower limit.
     */
    private double min;

    /**
     *
     * @param parentModel : model this distribution belongs to
     * @param name : name of this distribution
     * @param seed : seed used for java.util.Random generator
     * @param mmin : defined upper limit
     * @param mmax : defined lower limit
     */
    public UniformDistribution(Model parentModel, String name, long seed,
                               double mmin, double mmax) {

        super(parentModel, name, seed);
        this.min = mmin;
        this.max = mmax;
    }

    /**
     * @return value of determined distribution.
     */
    public double sample() {
        return min + ((max - min) * nextRandomDouble());

    }

    /**
     * @return current minimum
     */
    public double getMin() {
        return this.min;
    }

    /**
     * @return current maximum
     */
    public double getMax() {
        return this.max;
    }

    /**
     * @return null
     */
    public QueueReport getQueueReport() {
        return null;
    }

    @Override
    public Report getReport() {
        return null;
    }

}
