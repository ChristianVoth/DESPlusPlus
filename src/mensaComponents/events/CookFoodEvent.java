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
 * This class represents the cook food event, which will occur when there
 * are no food resources left and the staff needs to cook new food.
 */
public class CookFoodEvent extends Event {

    /**
     * A reference to the model this event is a port of.
     */
    private Mensa currentModel;

    /**
     * A variable store the name of the event.
     */
    private String name;

    /**
     * A variable to store the next Student in the Food Distribution Queue.
     */
    private Student nextInLine;

    /**
     * A variable to store the current Food Distribution given to this event.
     */
    private FoodDistribution currentFD;

    /**
     * A variable to store the current Student given to this event.
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
     * The eventRoutine() describes what happens when the food is empty.
     * First the food resources are set back to 50 (full).
     * Then the currentStudent in a Food Distribution and the Food Distribution
     * in which he stands in are schedule for a new Student Got Food Event.
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
