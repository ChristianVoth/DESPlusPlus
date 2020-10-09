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

import core.*;
import mensaComponents.*;

/**
 * This class represents the student arrival event in the Mensa model.
 * It occures when a student arrives at the food distribution to get food.
 */
public class StudentArrivalEvent extends Event {

    /**
     * A reference to the model this event is a port of.
     */
    private Mensa currentModel;

    /**
     * Current Student is a reference to the entity which is initially going
     * trough the eventRoutine().
     */
    private Student currentStudent;

    /**
     * A reference to the student entity which is the first entry of
     * the studentFDQueue.
     */
    private Student nextInLine;

    /**
     * A variable to store the first entry of the idleFDQueue.
     */
    private Entity currentOther;

    /**
     * Constructor of the student arrival event.
     *
     * Used to create a new student arrival event.
     * @param parentModel
     *          Model : The model this events belongs to
     * @param name
     *          java.lang.String : The name of the event
     * @param time
     *          double : The time when the event will occur
     * @param entity
     *          Entity : The entity which is associated with the event
     */
    public StudentArrivalEvent(Model parentModel, String name,
                               double time, Entity entity) {
        super(parentModel, name, time, entity);
        currentModel = (Mensa) parentModel;
        currentStudent = (Student) entity;
    }
    /**
     * This eventRoutine() describes what happens when a student enters
     * the food distribution
     *
     * On arrival, the student will enter the queue in front of
     * the food distribution.
     * It will then check if the food distribution is available.
     * If this is the case, it will occupy the food distribution and schedule a
     * StudentGotFoodEvent.
     * Otherwise the student just waits (does nothing).
     */
    @Override
    public void eventRoutine() {

        // student enters the food distribution queue (studentFDQueue)
        currentModel.studentFDQueue.enqueue(currentStudent);
        System.out.println(currentModel.foodResource);
        // check if a food distribution is available
        if (!currentModel.idleFDQueue.isEmpty()) {

                nextInLine = currentModel.studentFDQueue.getFirst();
                currentModel.studentFDQueue.remove(nextInLine);

                currentOther = currentModel.idleFDQueue.getFirst();
                currentModel.idleFDQueue.remove(currentOther);

                StudentGetFoodEvent gotFood = new StudentGetFoodEvent(currentModel, "Student obtained Food",
                        currentModel.currentTime() + currentModel.getChoosingFoodTime(), nextInLine, currentOther);
                currentModel.schedule(gotFood);


          //  }
        }
    }
}
