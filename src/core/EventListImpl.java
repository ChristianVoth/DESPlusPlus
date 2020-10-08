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
    LogHandler myLogger = new LogHandler();

    private int counter = 0;

    DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).
            withLocale(Locale.GERMANY).withZone(ZoneId.systemDefault());

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
        try{
            eventList.add(e);
            Collections.sort(eventList);
        } catch (NullPointerException exception){
            myLogger.logger.severe("Eventvalue E: " + e + "threw a NullPointerException: " + exception);
        }
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
        if(e == null){
            myLogger.logger.severe("You tried to remove an Event with the Value of null ");
            throw new NullPointerException();
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
            String timeOutput = formatter.format(e.getModel().getStartDate().plusSeconds((long)e.scheduledTime));
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
