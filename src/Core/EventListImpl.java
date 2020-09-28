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


            System.out.println(count + ": " + e.scheduledTime + ""+ e.getName());
            count++;
        }
    }
}
