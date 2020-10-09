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

/**
 *
 */
public class Quantiles {

    /**
     *
     */
    public double median;

    /**
     *
     */
    public double firstQuantile;

    /**
     *
     */
    public double thirdQuantile;

    /**
     *
     * @param mmedian
     * @param ffirstQuantile
     * @param tthirdQuantile
     */
    public Quantiles(double mmedian, double ffirstQuantile,
                     double tthirdQuantile) {
        this.median = mmedian;
        this.firstQuantile = ffirstQuantile;
        this.thirdQuantile = tthirdQuantile;
    }
}
