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

import excepctionHandling.ErrorMessage;
import excepctionHandling.NegativeTimeException;

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

            myLog.logger.severe("Your startDate-Value:" + startDate + "is greater than your date-Value: " + date);

            ErrorMessage error = new ErrorMessage(
                    (Model) null, "Your date Value: " + date + "seems to be gerater than your startDate Value: " + startDate, "calculateDifference-Method Class: Timehandler",
                    "Your ", "Pick a startDate that doesn't lie in the future! ", -1
            );

            throw new NegativeTimeException(error);

        }


        difference = ChronoUnit.SECONDS.between(startDate, date);
        myLog.logger.finer("Value between startDate und date: " + difference);

        return (int) difference;
    }

}
