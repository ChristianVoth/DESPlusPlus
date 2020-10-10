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
 * Report containing all information concerning waiting times.
 */
public class WaitingTimeReport extends QueueReport {

    /**
     * Stores mean waiting time.
     */
    public double meanWaitingTime;

    /**
     * Stores the quantiles.
     */
    public Quantiles quantiles;

    /**
     * Stores the minimum waiting time.
     */
    public double minimumWaitingTime;

    /**
     * Stores the maximum waiting time.
     */
    public double maximumWaitingTime;

    /**
     *
     * @param mmeanWaitingTime : passed mean waiting time
     * @param qquantiles : passed quantiles
     * @param mminimumWaitingTime : passed minimum waiting time
     * @param mmaximumWaitingTime : passed maximum waiting time
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
