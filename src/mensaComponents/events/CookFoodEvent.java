/**
 * Project: DES++
 * $Header: $
 * Author: Christian Voth, Lennart Eikens, Lars Batterham, Steffen Kleinhaus
 * Last Change:
 *      by: $Author:
 *      date: $Date:
 * Copyright (c): DES++, 2020
 */

package mensaComponents.events;

import core.Entity;
import core.Event;
import core.Model;
import mensaComponents.FoodDistribution;
import mensaComponents.Mensa;
import mensaComponents.Student;

/**
 *
 */
public class CookFoodEvent extends Event {

    /**
     *
     */
    private Mensa currentModel;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Student nextInLine;

    /**
     *
     */
    private FoodDistribution currentFD;

    /**
     *
     */
    private Student currentStudent;

    /**
     * Creates a new event of the given model , with the given name
     * and a given time and a given entity.
     *
     * @param parentModel Model :  The model this event is associated to
     * @param name        java.lang.String : The name of this event
     * @param time        double : The time when the event will occur
     */
    public CookFoodEvent(Model parentModel, String name, double time,
                         Entity currentStudent, Entity currentFD) {
        super(parentModel, name, time);
        this.currentModel = (Mensa) parentModel;
        this.name = name;
        this.currentStudent = (Student) currentStudent;
        this.currentFD = (FoodDistribution) currentFD;
    }

    /**
     *
     */
    @Override
    protected void eventRoutine() {

        int amountOfFoodAtStartOfRoutine = currentModel.foodResource;

        currentModel.foodResource = 50;

        StudentGotFoodEvent gotFood  = new StudentGotFoodEvent(currentModel,
                "Got Food", currentModel.
                currentTime(), currentStudent,  currentFD);
        currentModel.schedule(gotFood);


    }
}
