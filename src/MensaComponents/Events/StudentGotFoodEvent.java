package MensaComponents.Events;

import Core.*;
import MensaComponents.*;

public class StudentGotFoodEvent extends Event {

    private FoodDistribution currentOther;
    private Mensa currentModel;
    private Student currentStudent;
    private Checkout currentCheckout;
    private Student nextInLine;

    public StudentGotFoodEvent(Model parentModel, String name, double time, Entity student, Entity other) {
        super(parentModel, name, time, student);
        currentModel = (Mensa) parentModel;
        currentStudent = (Student) student;
        currentOther = (FoodDistribution) other;
    }


    @Override
    public void eventRoutine() {

        currentModel.studentCOQUeue.enqueue(currentStudent);
        currentModel.freeFDQueue.enqueue(currentOther);


        if (!currentModel.freeCOQueue.isEmpty()) {

            currentCheckout = currentModel.freeCOQueue.getFirst();

            currentModel.freeCOQueue.remove(currentCheckout);
            nextInLine = currentModel.studentCOQUeue.getFirst();
            currentModel.studentCOQUeue.remove(nextInLine);

            StudentPaidEvent studentPaid = new StudentPaidEvent(currentModel, "StudenPaidEvent", currentModel.currentTime() + 2.0, nextInLine, currentCheckout);
            currentModel.schedule(studentPaid);
        }
            if (!currentModel.studentQueue.isEmpty() && currentModel.currentTime() >= currentModel
            .getStopTime()) {
                currentModel.schedule(new StudentGotFoodEvent(currentModel, "StudentGotFoodEvent", currentModel.currentTime() + 3, currentModel.studentQueue.getFirst(), currentModel.freeFDQueue.getFirst()));
                currentModel.studentQueue.remove(currentModel.studentQueue.getFirst());
            }

    }
}

