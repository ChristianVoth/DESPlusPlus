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

import statistics.Reportable;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *  Model is an abstract base class for simulation models.
 */
public abstract class Model {

    private String name;

    /**
     * If false it turns the Student Generator off.
     */
    private boolean isOpen = true;

    /**
     *
     */
    public ArrayList<Reportable> reportables = new ArrayList<>();

    /**
     * Constructs a model, with the give name.
     * @param name
     *              java.lang.String : The name of this model
     */
    public Model(String name) {
        this.name = name;

    }

    /**
     *
     */
    private EventListImpl eventListImpl = new EventListImpl();

    /**
     * The current time of the simulation run.
     */
    private double currentTime;

    /**
     * The stop time of the simulation run.
     */
    private Instant stopTime;

    /**
     *
     */
    private boolean running = true;

    private Instant startDate;


    /**
     * The init() method must be implemented by all model subclasses and is
     * invoked at the start of each run() to schedule all required initial
     * events for beginning a schedule cycle.
     */
    public abstract void init();

    /**
     * The schedule() method is used to insert events in the event list.
     * @param e
     *          Event : The Event that we insert in the event list.
     */
    public void schedule(Event e) {
        eventListImpl.insert(e);
    }


    /**
     * The cancel() method is used to remove
     * a specific event from the event list.
     * @param e
     *          Event : The Event that we want to remove from the event list.
     */
    public void cancel(Event e) {
        eventListImpl.remove(e);
    }

    /**
     * The run() method starts the simulation.
     */
    public void run() {
        Event currentEvent;
        init();

        while (running && !eventListImpl.isEmpty()) {
            System.out.println(currentTime);
            eventListImpl.showList();


            currentEvent = eventListImpl.getFirst();

            System.out.println(currentTime());
            System.out.println(currentEvent.getTime());


            if(currentEvent.getTime() < currentTime){

                ErrorMessage error = new ErrorMessage(this, "The next Event seems to lie in the past!",
                        currentEvent.getName() + " for Entity: " + currentEvent.getEntity().getName(),
                        "The Time this Event was scheduled for, has been wrongly calculated",
                        "Make sure Distributions are used properly!", currentTime);
                throw new NegativeRunTimeException(error);
            } else {

                currentTime = currentEvent.getTime();

                eventListImpl.removeFirst();
                currentEvent.eventRoutine();

            }

            if (currentTime >= ChronoUnit.SECONDS.between(startDate, stopTime)) {

                System.out.println(currentTime);
                System.out.println(ChronoUnit.SECONDS.between(startDate, stopTime));
                isOpen = false;
            }
        }
    }


    /**
     * The method setStopTime() can schedule a simulation
     * experiment´s termination.
     * @param time
     *              double : the time which will be the stop time
     */
    public void setStopTime(double time) {
        stopTime = getStartDate().plusSeconds((long) time);
        System.out.println(stopTime);
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
    public double currentTime() {
        return currentTime;
    }

    /**
     * The method getStopTime() returns the set stop time.
     * @return
     *      the time when the simulation stops
     */
    public Instant getStopTime() {
        return stopTime;
    }

    public void setStartDate(Instant i){
        startDate = i;
    }


    public Instant getStartDate(){
        return startDate;
    }

    public long getDifference(){
        return ChronoUnit.SECONDS.between(startDate, stopTime);
    }

    public long getDifference(Instant instant1, Instant instant2){
        long difference = ChronoUnit.SECONDS.between(instant1, instant2);
        System.out.println(difference);

        return difference;
    }

    /**
     *
     */
    public void report() {
        for (Reportable r : reportables) {

            System.out.println(r.getReport());
        }


    }

    /**
     *
     * @param r
     */
    public void registerReportable(Reportable r) {
        reportables.add(r);
    }

    /**
     * Get Method for the variable isOpen
     * @return
     *      a boolean
     */
    public boolean getIsOpen() {
        return isOpen;
    }

    /**
     * Setter to change whether a Object is open or not.
     * @param b
     */

    public void setIsOpen(boolean b) {
        isOpen = b;
    }

    public String getName(){
        return name;
    }


}

