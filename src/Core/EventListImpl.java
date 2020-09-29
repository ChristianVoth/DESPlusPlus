/**
 * Project: DES++
 * $Header: $
 * Author: Christian Voth, Lennart Eikens, Lars Batterham, Steffen Kleinhaus
 * Last Change:
 *      by: $Author:
 *      date: $Date:
 * Copyright (c): DES++, 2020
 */

package Core;

import Core.Event;
import Core.EventList;
import java.util.ArrayList;
import java.util.Collections;

public class EventListImpl implements EventList {

    private Event event;


    ArrayList<Event> eventList = new ArrayList<>();

    @Override
    public void insert(Event e) {

        eventList.add(e);
        Collections.sort(eventList);

    }

    @Override
    public Event getFirst() {

        return eventList.get(0);
    }

    @Override
    public void removeFirst() {

         eventList.remove(0);
    }

    @Override
    public int remove(Event e) {
        int indexOfe;
        indexOfe = eventList.indexOf(e);
        eventList.remove(indexOfe);
        return indexOfe;

    }

    @Override
    public int size() {

        return eventList.size();
    }

    @Override
    public boolean isEmpty() {

        return eventList.isEmpty();
    }

    @Override
    public void showList() {
        int count = 1;
        for (Event e : eventList) {

            if (e.getEntity() != null){
            System.out.println(count + ". " +  e.getEntity().getName() + ": " +  e.getName() + " " + e.scheduledTime);
            count++;
        }else {
                System.out.println(count + ". " + "n/a: " + e.getName() + " " + e.scheduledTime);
                count++;
            }
            }
        System.out.println();
    }
}
