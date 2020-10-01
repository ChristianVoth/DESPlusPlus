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

/**
 * Defines an interface to design the event list for the model.
 */
public interface EventList {

    /**
     *  Method to insert an event into the event list.
     * @param e
     *      Event : The event which will be added to the event list
     */
     void insert(Event e);

    /**
     * Method to return the first index of the event list.
     * @return
     *      the event
     */
     Event getFirst();

    /**
     * Method to remove the first index of the event list.
     */
     void removeFirst();

    /**
     * Method to remove a specific event from the event list.
     * @param e
     *      Event : The specific event to be removed
     * @return
     *      the index of the event
     */
     int remove(Event e);

    /**
     * Method to return the size of the event list.
     * @return
     *      the size as integer value
     */
     int size();

    /**
     * Method to check if the event list is empty.
     * @return
     *       a boolean
     */
     boolean isEmpty();

    /**
     * Method to print out the current event list.
     */
    void showList();
}
