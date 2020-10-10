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
 * Custom object to store quantile values. Used to report quantiles as one object.
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
     * Stores the value of the third quantile
     */
    public double thirdQuantile;

    /**
     *
     * @param median : median passed in to be stored
     * @param firstQuantile : first quantile passed in to be stored
     * @param thirdQuantile : third quantile passed in to be stored
     */
    public Quantiles(double median, double firstQuantile,
                     double thirdQuantile) {
        this.median = median;
        this.firstQuantile = firstQuantile;
        this.thirdQuantile = thirdQuantile;
    }
}
