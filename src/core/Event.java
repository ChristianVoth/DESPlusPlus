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
 * The Event class abstracts general functionality for events.
 * All events store their time and a reference to the
 * entity they are associated with.
 * Both values are passed as parameters to the event´s constructor.
 */
public abstract class Event extends DynamicObject {

    private int i;
    /**
     *
     */
    private Entity entity;
    /**
     *
     */
    private String eventName;

    /**
     * Creates a new event of the given model , with the given name
     * and a given time and a given entity.
     * @param parentModel
     *                Model :  The model this event is associated to
     * @param name
     *                java.lang.String : The name of this event
     * @param time
     *                double : The time when the event will occur
     * @param entity
     *                Entity : The entity which the event is associated with ?`?
     */
    public Event(Model parentModel, String name, double time, Entity entity) {
        super(parentModel, name);
        this.entity = entity;
        this.scheduledTime = time;
        this.eventName = name;
    }

    /**
     * The method getTime() returns the time when the event is scheduled for.
     * @return
     *      the time when the event is scheduled for
     */
    public double getTime() {
        return scheduledTime;
    }

    /**
     * The method getEntity() returns the entity
     * which is associated to the specific event.
     * @return
     *      the entity which is associated to the specific event
     */
    public Entity getEntity() {
        return this.entity;
    }

    /**
     * The abstract method eventRoutine() must be implemented
     * by the modeller in form of the model specific subclasses
     * for making all relevant changes of state.
     */
    protected abstract void eventRoutine();

    @Override
    public int compareTo(Object o) {
        return Double.compare(this.scheduledTime, ((Event) o).scheduledTime);
    }
}
