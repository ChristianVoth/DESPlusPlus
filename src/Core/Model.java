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

/**
 *  Model is an abstract base class for simulation models.
 */
public abstract class Model {

    /**
     * If false it turns the Student Generator off.
     */
    public boolean isOpen = true;

    /**
     *
     */
    public ArrayList<Reportable> reportables = new ArrayList<>();

    /**
     * Constructs a model, with the give name
     * @param name
     *              java.lang.String : The name of this model
     */
    public Model(String name) {

    }


    private EventListImpl eventListImpl = new EventListImpl();

    /**
     * The current time of the simulation run.
     */
    private double currentTime;

    /**
     * The stop time of the simulation run.
     */
    private double stopTime;


    private boolean running = true;


    /**
     * The init() method must be implemented by all model subclasses and is invoked at the start of each run() to
     * schedule all required initial events for beginning a schedule cycle.
     */
    public abstract void init();

    /**
     * The schedule() method is used to insert events in the event list.
     * @param e
     *          Event : The Event that we insert in the event list.
     */
    public void schedule(Event e){

        eventListImpl.insert(e);

    }


    /**
     * The cancel() method is used to remove a specific event from the event list.
     * @param e
     *          Event : The Event that we want to remove from the event list.
     */
    public void cancel(Event e){

        eventListImpl.remove(e);
    }

    /**
     * The run() method starts the simulation
     */
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



            }
    }


    /**
     * The method setStopTime() can schedule a simulation experiment´s termination.
     * @param time
     *              double : the time which will be the stop time
     */
    public void setStopTime(double time){

        stopTime = time;

    }

    /**
     * The stop() method tells the scheduler to shut down.
     */
    public void stop() {

        running = false;

    }

    /**
     * The method currentTime() returns the currentTime of the simulation run.
     * @return
     *          currentTime : The current time of the simulation run.
     */
    public double currentTime(){

        return currentTime;

    }

    /**
     * The method getStopTime() returns the set stop time.
     * @return
     */
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

