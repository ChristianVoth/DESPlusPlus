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


import java.util.Collections;
import java.util.List;

/**
 *
 */
public class Sorting {

    /**
     *
     * @param unsortedList
     */
     public void sortList(List<Double> unsortedList) {
        Collections.sort(unsortedList);
    }

    /**
     *
     * @param unsortedEntry
     */
    public void sortListEntry(List<ListEntry> unsortedEntry) {
         Collections.sort(unsortedEntry);
    }
}
