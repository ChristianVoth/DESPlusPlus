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
import excepctionHandling.NullEventException;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

/**
 * The Class <EventListImpl> is a implementation for the <EventList> interface.
 */
public class EventListImpl implements EventList {
    /**
     *
     */
    LogHandler myLogger = new LogHandler();

    /**
     * A simple counter.
     */
    private int counter = 0;

    /**
     *
     */
    DateTimeFormatter formatter = DateTimeFormatter
            .ofLocalizedDateTime(FormatStyle.MEDIUM)
            .withLocale(Locale.GERMANY).withZone(ZoneId.systemDefault());

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
        if (e == null) {
            myLogger.logger.severe("Cannot insert Event e:"
                + e.getModel().getName() + " into Queue. Value of e was null");
            ErrorMessage error = new ErrorMessage((Model) null,
                    "The Event that you wanted to to insert has a "
                            + "Value of null!",
                    "EventName: " + e.getName() + " Entity: "
                            + e.getEntity().getName(),
                    "Event e: " + e.getName() + " has a Value of null",
                    "Make sure that your entities cannot become null", e.getTime());

            throw new NullEventException(error);
        }
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
        if (eventList.isEmpty()) {
            myLogger.logger.info(
                    "You tried to remove an Event but your List is Empty");
            return -1;
        }

        if (e == null) {
            myLogger.logger.severe("Cannot remove Event e:"
                    + e.getName() + " from Queue. Value of e was null");
            ErrorMessage error = new ErrorMessage((Model) null,
            "The Event that you wanted to to remove has a "
                    + "Value of null!",
              "Eventname: " + e.getName() + " Entity: "
                      + e.getEntity().getName(),
                    "Event e: " + e.getName() + " has a Value of null",
            "Make sure that your entities cannot become null", e.getTime());

            throw new NullEventException(error);
        }
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
        counter++;
        int count = 1;

        for (Event e : eventList) {
            String timeOutput = formatter.format(e.getModel().getStartDate().
                    plusSeconds((long) e.scheduledTime));
            if (e.getEntity() != null) {
                System.out.println(count + ". " + e.getEntity().getName()
                        + ": " + e.getName() + " " + timeOutput);
                count++;
            } else {
                System.out.println(count + ". " + "n/a: "
                        + e.getName() + " " + timeOutput);
                count++;
            }
        }
        System.out.println();
    }
}
