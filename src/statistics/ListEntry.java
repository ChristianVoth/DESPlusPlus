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
public class ListEntry implements Comparable<ListEntry> {
    /**
     *
     */
    double value;
    /**
     *
     */
    double timeOfChange;

    /**
     *
     * @param v1
     * @param v2
     */
    public ListEntry(double v1, double v2) {

        value = v1;
        timeOfChange = v2;
    }

    /**
     *
     * @param listOne
     * @return
     */
    @Override
    public int compareTo(ListEntry listOne) {

       return Double.compare(this.value, listOne.value);
    }
}
