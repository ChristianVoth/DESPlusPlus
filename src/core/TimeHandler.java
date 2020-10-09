/**
 * Project: DES++
 * $Header: $
 * Author: Christian Voth, Lennart Eikens, Lars Batterham, Steffen Kleinhaus
 * Last Change:
 *      by: $Author:
 *      date: $Date:
 * Copyright (c): DES++, 2020
 */

package core;

import java.time.temporal.ChronoUnit;
import java.time.*;

public class TimeHandler {
    /**
     *
     */
    LogHandler myLog = new LogHandler();

    /**
     *
     * @param startDate
     * @param date
     * @return
     */
    public int calculateDifference(Instant startDate, Instant date) {
        long difference = 0;
        int compare = startDate.compareTo(date);

        if (compare < 0) {
            myLog.logger.info("Your Date is greater than your startDate."
                    + "startDate: " + startDate + " date: " + date);
        }

        try {
            difference = ChronoUnit.SECONDS.between(startDate, date);
        } catch (NullPointerException e) {
            myLog.logger.info("You tried to pase in an null value. startDate: "
                    + startDate + " date: " + date);
        } finally {
            return (int) difference;
        }










    }


}
