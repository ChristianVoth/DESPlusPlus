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
     * Method to calculate the Difference between the start date and a date given to it.
     * @param startDate
     *      Instant : A time instant for the start date
     * @param date
     *      Instant : A time instant for the date
     * @return
     *      The difference as int value
     */
    public int calculateDifference(Instant startDate, Instant date) {
        long difference;
        int compare = date.compareTo(startDate);

       if (compare < 0) {

            myLog.logger.severe("You picked a Date: " + date + " that lies behind your startDate: " + startDate);

            ErrorMessage error = new ErrorMessage(
                    null, "Your given date lies in the past", "calculateDifference-Method Class: Timehandler",
                    "Your given date: " + date + " is lies in the Past ", "Pick a startDate that comes " +
                    "before your Date ", -1
            );

            throw new NegativeTimeException(error);

        }


        difference = ChronoUnit.SECONDS.between(startDate, date);
        myLog.logger.finer("Value between startDate und date: " + difference);

        return (int) difference;
    }

}
