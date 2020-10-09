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
 * This class represents an entity (and event) source, which continually
 * generates students (and their arrival events) and then schedule itself
 * for the point in time when the next truck arrival is due.
 */

public class StudentGeneratorEvent extends Event {

    /**
     * Creates an Object from the mensa class which will
     * represent the current model.
     */
    private Mensa currentModel;
    /**
     *
     */
    private int num;


    /**
     * Constructs a new StudentGeneratorEvent.
     * @param parentModel
     *              Model : The model this event belongs to
     * @param name
     *              java.lang.String : The event´s name
     * @param time
     *              double : The time when the event occur
     * @param entity
     *              Entity : The entity which is associated with the event
     */

    public StudentGeneratorEvent(Model parentModel, String name,
                                 double time, Entity entity) {
        super(parentModel, name, time, entity);
        currentModel = (Mensa) parentModel;
    }

    /**
     * The eventRoutine() describes the generating of a new Student.
     *
     * It creates a new student, a new StudentArrivalEvent and
     * schedules itself again for the next student generation
     */

    @Override
    public void eventRoutine() {


            Student student
                    = new Student(currentModel, "Student"
                    + currentModel.getNameExtension());

            currentModel.schedule(new StudentArrivalEvent(currentModel,
                    "Student Arrival Event",
                    currentModel.currentTime(), student));
            System.out.println(currentModel.getIsOpen());
        if (currentModel.getIsOpen()) {
            double testTime = currentModel.getStudentArrivalTime();
                currentModel.schedule(new StudentGeneratorEvent(currentModel,
                        "StudentGeneratorEvent", currentModel.currentTime()
                        + testTime, null));
                System.out.println("Test: " + testTime);
        }
    }
}

