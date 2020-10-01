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
 * DynamicObject provides an abstract base for temporary simulation objects,
 * such as events and entities.
 */
public abstract class DynamicObject extends BasicModelComponent
                                    implements Comparable<Event> {
    /**
     *
     */
    int priority;

    /**
     * The Time when the event is scheduled for ?
     */
    double scheduledTime;

    /**
     * do we really need this?
     */
    long numberOfEntities;

    /**
     * Constructs a Dynamic Object for a specific model, with a specific name.
     * @param parentModel
     *              Model : Model :  The model this object is associated to
     * @param name
     *              java.lang.String : The name of the object
     */
    public DynamicObject(Model parentModel, String name) {
        super(parentModel, name);
    }

    /**
     * Constructs a Dynamic Object with a specific name.
     * @param name
     *              java.lang.String : The name of the object
     */
    public DynamicObject(String name) {
        super(name);
    }

    /**
     *
     * @return
     */
    public int getPriority() {
        return priority;
    }

    /**
     *
     * @param p
     */
    public void setPriority(int p) {
        priority = p;
    }

    /**
     *
     * @return
     */
    public double getScheduledTime() {
        return scheduledTime;
    }

    /**
     *
     * @param e
     * @return
     */
    @Override
    public int compareTo(Event e) {
        return 0;
    }
}
