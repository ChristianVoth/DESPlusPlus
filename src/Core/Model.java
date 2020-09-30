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

import statistics.Reportable;
import java.util.ArrayList;

public abstract class Model {

    public boolean isOpen = true;

    public ArrayList<Reportable> reportables = new ArrayList<>();

    public Model(String name) {

    }

    private EventListImpl eventListImpl = new EventListImpl();

    private double currentTime;

    private double stopTime;

    private boolean running = true;



    public abstract void init();

    public void schedule(Event e){

        eventListImpl.insert(e);

    }



    public void cancel(Event e){

        eventListImpl.remove(e);
    }

    public void run() {
        Event currentEvent;
        init();

            while (running && !eventListImpl.isEmpty()) {
                System.out.println(currentTime);
                eventListImpl.showList();


                currentEvent = eventListImpl.getFirst();
                currentTime = currentEvent.getTime();
                eventListImpl.removeFirst();






                currentEvent.eventRoutine();

                if (currentTime >= stopTime)
                    isOpen = false;
              //  System.out.println(currentTime);


            }
    }



    public void setStopTime(double time){

        stopTime = time;

    }

    public void stop() {

        running = false;

    }

    public double currentTime(){

        return currentTime;

    }
    public double getStopTime() {
        return stopTime;
    }


    public void report() {

        for (Reportable r : reportables) {
            r.getReport();
        }

    }

    public void registerReportable(Reportable r){

        reportables.add(r);

    }


}

