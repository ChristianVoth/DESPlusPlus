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
import java.util.Random;

/**
 * Abstract base class for distributions, which are
 * constructed using java.util.Random.
 */
abstract class Distribution extends Reportable {

    /**
     * Seed can be used for the generator in order to receive
     * the same sequence of generated numbers. This can be
     * useful when testing.
     */
    private long seed;

    /**
     * New Randomizer, generating values between 0 and 1.
     */
    private Random random = new Random();

    /**
     *
     * @param parentModel : reference to the model this distribution belongs to
     * @param name : name of this distribution
     * @param s : seed for which numbers are generated
     */
    Distribution(Model parentModel, String name, long s) {
        super(parentModel, name);

        this.seed = s;
    }

    /**
     * Method is implemented in each distribution.
     * @return sample of a given distribution
     */
    public abstract double sample();

    /**
     *
     * @return the seed used for number generation
     */
    public long getSeed() {

        return this.seed;
    }

    /**
     * Resets the seed.
     */
    public void reset() {
        super.reset();
        this.seed = 0L;

    }

    /**
     *
     * @return next random value between 0 and 1
     */
    protected double nextRandomDouble() {

        return random.nextDouble();
    }
}
