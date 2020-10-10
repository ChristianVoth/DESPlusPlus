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

import java.util.List;

/**
 * Custom object to store all values concerning queue lengths.
 */
public class QueueLengthReport extends QueueReport {

    /**
     * Stores mean queue length.
     */
    public double meanQueueLength;

    /**
     * Stores quantiles.
     */
    public Quantiles quantiles;

    /**
     * Stores minimum queue length.
     */
    public double minimumQueueLength;

    /**
     * Stores maximum queue length.
     */
    public double maximumQueueLength;

    /**
     *
     * @param mmeanQueueLength : mean queue length to be stored
     * @param qquantiles : quantiles to be stored
     * @param mmaximumQueueLength : maximum queue length to be stored
     */
    public QueueLengthReport(double mmeanQueueLength, Quantiles qquantiles,
                             double mmaximumQueueLength) {
        this.meanQueueLength = mmeanQueueLength;
        this.quantiles = qquantiles;
        this.minimumQueueLength = 0;
        this.maximumQueueLength = mmaximumQueueLength;
    }

}
