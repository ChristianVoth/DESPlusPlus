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
public class WaitingTimeReport extends QueueReport {

    /**
     *
     */
    public double meanWaitingTime;

    /**
     *
     */
    public Quantiles quantiles;

    /**
     *
     */
    public double minimumWaitingTime;

    /**
     *
     */
    public double maximumWaitingTime;

    /**
     *
     * @param mmeanWaitingTime
     * @param qquantiles
     * @param mminimumWaitingTime
     * @param mmaximumWaitingTime
     */
    public WaitingTimeReport(double mmeanWaitingTime, Quantiles qquantiles,
                             double mminimumWaitingTime,
                             double mmaximumWaitingTime) {
        this.meanWaitingTime = mmeanWaitingTime;
        this.quantiles = qquantiles;
        this.minimumWaitingTime = mminimumWaitingTime;
        this.maximumWaitingTime = mmaximumWaitingTime;
    }

}
