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
 * Custom object to store quantile values. Used to report
 * quantiles as one object.
 */
public class Quantiles {

    /**
     * Stores the value of the median.
     */
    public double median;

    /**
     * Stores the value of the first quantile.
     */
    public double firstQuantile;

    /**
     * Stores the value of the third quantile.
     */
    public double thirdQuantile;

    /**
     *
     * @param mmedian : median passed in to be stored
     * @param ffirstQuantile : first quantile passed in to be stored
     * @param tthirdQuantile : third quantile passed in to be stored
     */
    public Quantiles(double mmedian, double ffirstQuantile,
                     double tthirdQuantile) {
        this.median = mmedian;
        this.firstQuantile = ffirstQuantile;
        this.thirdQuantile = tthirdQuantile;
    }
}
