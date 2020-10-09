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
 *
 */
public class QueueLengthReport extends QueueReport {

    /**
     *
     */
    public double meanQueueLength;

    /**
     *
     */
    public Quantiles quantiles;

    /**
     *
     */
    public double minimumQueueLength;

    /**
     *
     */
    public double maximumQueueLength;

    /**
     *
     * @param mmeanQueueLength
     * @param qquantiles
     * @param mmaximumQueueLength
     */
    public QueueLengthReport(double mmeanQueueLength, Quantiles qquantiles,
                             double mmaximumQueueLength) {
        this.meanQueueLength = mmeanQueueLength;
        this.quantiles = qquantiles;
        this.minimumQueueLength = 0;
        this.maximumQueueLength = mmaximumQueueLength;
    }

}
