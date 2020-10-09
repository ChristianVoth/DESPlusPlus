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
 *
 */
abstract class Distribution extends Reportable {

    /**
     *
     */
    private long seed;

    /**
     *
     */
    private Random random = new Random();

    /**
     *
     * @param parentModel
     * @param name
     * @param sseed
     */
    public Distribution(Model parentModel, String name, long sseed) {
        super(parentModel, name);

        this.seed = sseed;
    }

    /**
     *
     * @return
     */
    public abstract double sample();

    /**
     *
     * @return
     */
    public long getSeed() {

        return this.seed;
    }

    /**
     *
     */
    public void reset() {
        super.reset();
        this.seed = 0L;

    }

    /**
     *
     * @return
     */
    protected double nextRandomDouble() {

        return random.nextDouble();
    }
}
