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
 * Entity is the base class for model entities.
 */
public class Entity extends DynamicObject {
    /**
     * The name of the entity.
     */
    private String entityName;
    private Model parentModel;

    /**
     * Creates a new Entity with a given name.
     * @param name
     *          java.lang.String : The name of the entity
     */
    public Entity(Model parentModel, String name) {
        super(name);
        this.entityName = name;
        this.parentModel = parentModel;
        this.priority = 100;

    }

    public Entity(Model parentModel, String name, int priority) {
        super(name);
        this.parentModel = parentModel;
        this.entityName = name;
        this.priority = priority;

    }

    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.priority,((Entity) o).priority);
    }


}


