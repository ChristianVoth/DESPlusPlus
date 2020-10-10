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
 * Custom object storing the reports from both accumulate and tally.
 */
public class QueueReport {

    /**
     * Stores the tally report.
     */
    public QueueLengthReport queueLengthReport;

    /**
     * Stores the accumulate report.
     */
    public WaitingTimeReport waitingTimeReport;

    /**
     * Stores the associated queue.
     */
    public Queue queue;

    /**
     *
     * @param qqueueLengthReport : tally report to be stored
     * @param wwaitingTimeReport : accumulate report to be stored
     * @param qqueue : associated queue
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
