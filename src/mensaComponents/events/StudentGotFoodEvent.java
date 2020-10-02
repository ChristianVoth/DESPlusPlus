package mensaComponents.events;

import core.*;
import mensaComponents.*;

/**
 * This class represents the student got food event in the mensa model.
 *
 * It occurs when a student got his food and is finished in
 * the food distribution.
 */
public class StudentGotFoodEvent extends Event {

    /**
     * A reference to the current food distribution in which the student was.
     */
    private FoodDistribution currentOther;

    /**
     * A reference to the model this event is a part of.
     */
    private Mensa currentModel;

    /**
     * A reference to the current student entity which got food.
     */
    private Student currentStudent;

    /**
     * A variable to store the first entry of the idle CO Queue.
     */
    private Checkout currentCheckout;

    /**
     * A reference to the student entity which is the first entry of
     * the studentCOQueue.
     */
    private Student nextInLine;

    /**
     * Constructor of the StudentGotFoodEvent.
     *
     * Used to create a new student a new StudentGotFoodEvent.
     * @param parentModel
     *              Model : The model this event belongs to
     * @param name
     *              java.lang.String : This event´s name
     * @param time
     *              double : The time when the event occur
     * @param student
     *              Entity : The student entity which got food
     * @param other
     *              Entity : The food distribution entity which served the food
     */
    public StudentGotFoodEvent(Model parentModel, String name, double time,
                               Entity student, Entity other) {
        super(parentModel, name, time, student);
        currentModel = (Mensa) parentModel;
        currentStudent = (Student) student;
        currentOther = (FoodDistribution) other;
    }


    /**
     * This eventRoutine() describes what happens when a student got their food.
     */
    @Override
    public void eventRoutine() {

        // the student that got food enters the Checkout queue
        currentModel.studentCOQueue.enqueue(currentStudent);
        // the food distribution that served the food enters
        // the idle FD queue again
        currentModel.idleFDQueue.enqueue(currentOther);

        // check if a checkout is available
        if (!currentModel.idleCOQueue.isEmpty()) {

            // yes, it is

            // get a reference to the first checkout in the idle CO queue
            currentCheckout = currentModel.idleCOQueue.getFirst();
            // remove it from the idle CO queue
            currentModel.idleCOQueue.remove(currentCheckout);
            // get the student next in line in from the student CO queue
            nextInLine = currentModel.studentCOQueue.getFirst();
            // remove him from the student CO queue
            currentModel.studentCOQueue.remove(nextInLine);
            // create a new StudentPaidEvent for the current student,
            // in the current checkout
            StudentPaidEvent studentPaid = new StudentPaidEvent(currentModel,
            "StudenPaidEvent",
             currentModel.currentTime() + currentModel.getStudentPayTime(),
                  nextInLine, currentCheckout);
            // schedule it
            currentModel.schedule(studentPaid);
        }
        // after the simulation time is over,
        // check if there are still people in front of the food distrubtions
        if (!currentModel.studentFDQueue.isEmpty()
            && currentModel.currentTime() >= currentModel
            .getStopTime()) {
            // yes, there are

            // create and schedule a new StudentGotFoodEvent for
            // the student next in line
            currentModel.schedule(new StudentGotFoodEvent(currentModel,
            "StudentGotFoodEvent",
            currentModel.currentTime() + currentModel.getChoosingFoodTime(),
                 currentModel.studentFDQueue.getFirst(),
                 currentModel.idleFDQueue.getFirst()));
            // remove the student
            currentModel.studentFDQueue.remove(currentModel.studentFDQueue.
                    getFirst());
        }
    }
}

