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
     * Exponential distributions rely on a rate, at which events occur.
     */
    private double rate;

    /**
     *
     * @param parentModel : reference to the model this distribution belongs to
     * @param name : name of this distribution
     * @param seed : seed used for number generation
     * @param rrate : used as a parameter in the distribution
     */
    public ExponentialDistribution(Model parentModel, String name,
                                   long seed, double rrate) {
        super(parentModel, name, seed);
        this.rate = rrate;
    }

    /**
     * Exponential distribution is modelled by using the inverse method,
     * allowing to use the number generator provided
     * by Java.
     * @return sample of exponential distribution
     */
    public double sample() {
        return -Math.log(nextRandomDouble()) * rate;
    }

    /**
     *
     * @return the set rate.
     */
    public double getRate() {
        return this.rate;
    }

    /**
     *
     * @return the QueueReport
     */
    public QueueReport getQueueReport() {
        return null;
    }

    @Override
    public Report getReport() {
        return null;
    }


}
