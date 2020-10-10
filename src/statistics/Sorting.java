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
 * Custom Object used to sort Lists.
 */
public class Sorting {

    /**
     * Sorts given list.
     * @param unsortedList : list to be sorted
     */
     public void sortList(List<Double> unsortedList) {
        Collections.sort(unsortedList);
    }

    /**
     * Sorts given entry.
     * @param unsortedEntry : ListEntry which needs to be sorted
     */
    public void sortListEntry(List<ListEntry> unsortedEntry) {
         Collections.sort(unsortedEntry);
    }
}
