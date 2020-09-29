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

public abstract class DynamicObject extends BasicModelComponent implements Comparable<Event> {

    int priority;
    double scheduledTime;
    long numberOfEntities;

    public DynamicObject(Model parentModel, String name) {
        super(parentModel, name);
    }

    public DynamicObject(String name) {
        super(name);
    }


    public int getPriority() {

        return priority;
    }

    public void setPriority(int p) {

        priority = p;
    }

    public double getScheduledTime() {

        return scheduledTime;
    }


    @Override
    public int compareTo(Event e) {
        return 0;
    }

}
