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
 * Custom Object to store the value and it's time of change.
 */
public class ListEntry implements Comparable<ListEntry> {
    /**
     * Value which is to be stored.
     */
    double value;
    /**
     * Time at which a change in value occurred.
     */
    double timeOfChange;

    /**
     *
     * @param vvalue : passed value
     * @param ttimeOfChange : time at which value change occurred
     */
    public ListEntry(double vvalue, double ttimeOfChange) {

        this.value = vvalue;
        this.timeOfChange = ttimeOfChange;
    }

    /**
     *
     * @param listOne : different list entry
     * @return negative, 0 or positive value depending on the
     * comparision of two values
     */
    @Override
    public int compareTo(ListEntry listOne) {

       return Double.compare(this.value, listOne.value);
    }
}
