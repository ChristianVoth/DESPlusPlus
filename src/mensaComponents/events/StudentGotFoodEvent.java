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
import mensaComponents.Checkout;
import mensaComponents.FoodDistribution;
import mensaComponents.Mensa;
import mensaComponents.Student;

/**
 *
 */
public class StudentGotFoodEvent extends Event {

    /**
     * A reference to the model this event is a part of.
     */
    private Mensa currentModel;

    /**
     * A variable to store the name of the event.
     */
    private String name;

    /**
     * Current Student is a reference to the entity which is initially going
     * trough the eventRoutine().
     */
    private Student currentStudent;

    /**
     * A variable to store the first entry of the idleFDQueue.
     */
    private FoodDistribution currentOther;

    /**
     * A variable to store the first entry of the idleCOQueue.
     */
    private Checkout checkout;

    /**
     * A reference to the student entity which is the first entry of the
     * studentFDQueue.
     */
    private Student nextInLine;

    /**
     * A reference to the student entity which is the first entry of the
     * studentCOQueue.
     */
    private Student nextForCheckout;

    /**
     *
     * @param parentModel
     *      core.Model : The model this events belongs to
     * @param name
     *      java.lang.String : The name of the event
     * @param time
     *      double : The time when the event will occur
     * @param entity
     *      Entity : The entity which is associated with the event
     * @param currentOther
     *      Food Distribution : The Food Distribution which is associated with event
     */
    public StudentGotFoodEvent(Model parentModel, String name,
                               double time, Entity entity,
                               Entity currentOther) {
        super(parentModel, name, time, entity);

        this.currentModel = (Mensa) parentModel;
        this.name = name;
        this.currentStudent = (Student) entity;
        this .currentOther = (FoodDistribution) currentOther;
    }

    /**
     * This eventRoutine() describes what happens when a student got their food
     */
    @Override
    protected void eventRoutine() {

        if (currentModel.foodResource > 0) {
            currentModel.foodResource--;
            currentModel.idleFDQueue.enqueue(currentOther);
            currentModel.studentCOQueue.enqueue(currentStudent);

            if (!currentModel.idleCOQueue.isEmpty()) {

                checkout = currentModel.idleCOQueue.getFirst();
                currentModel.idleCOQueue.remove(checkout);

                nextForCheckout = currentModel.studentCOQueue.getFirst();
                currentModel.studentCOQueue.remove(nextForCheckout);

                StudentPaidEvent studentPaid
                        = new StudentPaidEvent(currentModel, "Student Paid Event",
                        currentModel.currentTime() + currentModel.
                                getStudentPayTime(), nextForCheckout, checkout);
                currentModel.schedule(studentPaid);

            }
        }

        if (currentModel.foodResource == 0) {
            CookFoodEvent cookFood = new CookFoodEvent(currentModel,
                    "Cook Food Event", currentModel.currentTime()
                    + currentModel.getCookingTIme(),
                    currentStudent, currentOther);
            currentModel.schedule(cookFood);
        }

        if (!currentModel.studentFDQueue.isEmpty()
                && currentModel.foodResource > 0) {

            nextInLine = currentModel.studentFDQueue.getFirst();
            currentModel.studentFDQueue.remove(nextInLine);

            currentOther = currentModel.idleFDQueue.getFirst();
            currentModel.idleFDQueue.remove(currentOther);

            StudentGotFoodEvent getFood = new StudentGotFoodEvent(currentModel,
                    "Student Got Food Event",
                    currentModel.currentTime() + currentModel.
                            getChoosingFoodTime(), nextInLine, currentOther);
            currentModel.schedule(getFood);
        }

    }
}
