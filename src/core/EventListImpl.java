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

import java.util.ArrayList;
import java.util.Collections;

/**
 * The Class <EventListImpl> is a implementation for the <EventList> interface.
 */
public class EventListImpl implements EventList {

    /**
     * ??
     */
    private Event event;

    /**
     * The event list used to store events.
     */
    ArrayList<Event> eventList = new ArrayList<>();

    /**
     * Method to insert an event into the event list.
     *
     * @param e Event : The event which will be added to the event list
     */
    @Override
    public void insert(Event e) {
        eventList.add(e);
        Collections.sort(eventList);
    }

    /**
     * Method to return the first index of the event list.
     *
     * @return the event
     */
    @Override
    public Event getFirst() {

        return eventList.get(0);
    }

    /**
     * Method to remove the first index of the event list.
     */
    @Override
    public void removeFirst() {

        eventList.remove(0);
    }

    /**
     * Method to remove a specific event from the event list.
     *
     * @param e Event : The specific event to be removed
     * @return
     */
    @Override
    public int remove(Event e) {
        int indexOfe;
        indexOfe = eventList.indexOf(e);
        eventList.remove(indexOfe);
        return indexOfe;
    }

    /**
     * Method to return the size of the event list.
     *
     * @return the size as integer value
     */
    @Override
    public int size() {

        return eventList.size();
    }

    /**
     * Method to check if the event list is empty.
     *
     * @return a boolean
     */
    @Override
    public boolean isEmpty() {

        return eventList.isEmpty();
    }

    /**
     * Method to print out the current event list.
     */
    @Override
    public void showList() {
        int count = 1;
        for (Event e : eventList) {
            if (e.getEntity() != null) {
                System.out.println(count + ". " + e.getEntity().getName()
                        + ": " + e.getName() + " " + e.scheduledTime);
                count++;
            } else {
                System.out.println(count + ". " + "n/a: "
                        + e.getName() + " " + e.scheduledTime);
                count++;
            }
        }
        System.out.println();
    }
}
