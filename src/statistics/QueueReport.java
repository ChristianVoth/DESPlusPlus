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
public class QueueReport {

    /**
     *
     */
    public QueueLengthReport queueLengthReport;

    /**
     *
     */
    public WaitingTimeReport waitingTimeReport;

    /**
     *
     */
    public Queue queue;

    /**
     *
     * @param qqueueLengthReport
     * @param wwaitingTimeReport
     * @param qqueue
     */
    QueueReport(QueueLengthReport qqueueLengthReport,
                WaitingTimeReport wwaitingTimeReport, Queue qqueue) {

        this.queueLengthReport = qqueueLengthReport;
        this.waitingTimeReport = wwaitingTimeReport;
        this.queue = qqueue;
    }

    /**
     *
     */
    public QueueReport() {

    }
}
