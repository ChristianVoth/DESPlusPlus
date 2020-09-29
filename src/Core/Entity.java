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

public class Entity extends DynamicObject {

    private String entityName;

    public Entity(String name) {
        super(name);
        this.entityName = name;

    }



    @Override
    public int compareTo(Event e) {
        return super.compareTo(e);
    }
}


