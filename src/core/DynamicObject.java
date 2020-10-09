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
 * DynamicObject provides an abstract template for temporary simulation objects,
 * such as events and entities.
 */
public abstract class DynamicObject extends BasicModelComponent
                                    implements Comparable<Object> {
    /**
     *
     */
    int priority;

    /**
     * The Time for which the event is scheduled.
     */
    double scheduledTime;

    /**
     * Constructs a Dynamic Object for a specific model, with a specific name.
     *
     * @param parentModel Model : Model : The model this object is associated to
     * @param name        java.lang.String : The name of the object
     */
    public DynamicObject(Model parentModel, String name) {
        super(parentModel, name);
    }

    /**
     * Constructs a Dynamic Object with a specific name.
     *
     * @param name java.lang.String : The name of the object
     */
    public DynamicObject(String name) {
        super(name);
    }

    /**
     *
     */
    public DynamicObject() {

    }

    /**
     * @return
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param p
     */
    public void setPriority(int p) {
        priority = p;
    }

    /**
     * @return
     */
    public double getScheduledTime() {
        return scheduledTime;
    }
}
