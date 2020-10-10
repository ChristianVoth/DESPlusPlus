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

    /**
     *  The Model the Entity is part of
     */
    private Model parentModel;

    /**
     * Creates a new Entity with a given name.
     * @param name
     *          java.lang.String : The name of the entity.
     * @param associatedModel
     *          core.Model : The model this entity belongs to.
     */
    public Entity(Model associatedModel, String name) {
        super(name);
        this.entityName = name;
        this.parentModel = associatedModel;
        this.priority = 100;

    }

    /**
     *
     * @param associatedModel
     *          core.Model : The model this entity belongs to
     * @param name
     *          java.lang.String : The name of the entity
     * @param priority
     *          int : The priority of the entity
     */
    public Entity(Model associatedModel, String name, int priority) {
        super(name);
        this.parentModel = associatedModel;
        this.entityName = name;
        this.priority = priority;

    }

    /**
     * Default Constructor
     */
    public Entity() {

    }

    /**
     *
     * @param o the Object which should be compared
     * @return an integer value
     */
    @Override
    public int compareTo(Object o) {
        return Integer.compare(this.priority, ((Entity) o).priority);
    }


}


