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
    private Student currentStudent;

    /**
     *
     */
    private FoodDistribution currentOther;

    /**
     *
     */
    private Checkout checkout;

    /**
     *
     */
    private Student nextInLine;

    /**
     *
     */
    private Student nextForCheckout;

    /**
     *
     * @param parentModel
     * @param name
     * @param time
     * @param entity
     * @param currentOther
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
     *
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
