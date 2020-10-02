package mensaComponents.events;

import core.*;
import mensaComponents.*;

/**
 * This class represents the StudentPaidEvent in the mensa model.
 *
 * It occurs when a student got their food and paid for it.
 */
public class StudentPaidEvent extends Event {

    /**
     * A reference to the current checkout in which the student was.
     */
    private Checkout currentCheckout;

    /**
     * A reference to the model this event is part of.
     */
    private Mensa currentModel;

    /**
     * A reference to the current student that paid.
     */
    private Student currentStudent;

    /**
     * Construcot of the StudentPaidEvent.
     *
     * Used to create a new student paid event.
     * @param parentModel
     *              Model : The model this event belongs to
     * @param name
     *              java.lang.String : This event´s name
     * @param time
     *              double : The time when this event will occur
     * @param entity
     *              Entity : The student which is associated with the event
     * @param other
     *              Entity : The checkout in which the student paid
     */
    public StudentPaidEvent(Model parentModel, String name, double time,
                            Entity entity, Entity other) {
        super(parentModel, name, time, entity);
        currentModel = (Mensa) parentModel;
        currentStudent = (Student) entity;
        currentCheckout = (Checkout) other;
    }

    /**
     * This eventRoutine() describes what happens when a student paid.
     *
     * The student leaves the model.
     * The checkout will then check it there is another student waiting to pay.
     * If there is another student waiting the checkout will service it.
     * It not it will wait in the idle CO queue for the next student to arrive.
     */
    @Override
    public void eventRoutine() {

        // check if there is a student waiting
        if (!currentModel.studentCOQueue.isEmpty()) {

            // yes, there is

            // get the student next in line, create and
            // schedule a new StudentPaidEvent for him
            currentModel.schedule(new StudentPaidEvent(currentModel,
              "StudentPaidEvent",
               currentModel.currentTime() + currentModel.getStudentPayTime(),
                    currentModel.studentCOQueue.getFirst(),
                    currentCheckout));
            // remove the student from the student checkout queue
            currentModel.studentCOQueue.remove(currentModel.studentCOQueue.
                    getFirst());
        } else {
            // no, there isn´t

            // add the current checkout to the idle CO queue
            currentModel.idleCOQueue.enqueue(currentCheckout);
        }
    }
}
