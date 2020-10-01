package mensaComponents.events;

import core.*;
import mensaComponents.*;

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

        currentModel.studentCOQueue.enqueue(currentStudent);
        currentModel.idleFDQueue.enqueue(currentOther);


        if (!currentModel.idleCOQueue.isEmpty()) {

            currentCheckout = currentModel.idleCOQueue.getFirst();

            currentModel.idleCOQueue.remove(currentCheckout);
            nextInLine = currentModel.studentCOQueue.getFirst();
            currentModel.studentCOQueue.remove(nextInLine);

            StudentPaidEvent studentPaid = new StudentPaidEvent(currentModel, "StudenPaidEvent", currentModel.currentTime() + currentModel.getStudentPayTime(), nextInLine, currentCheckout);
            currentModel.schedule(studentPaid);
        }
            if (!currentModel.studentFDQueue.isEmpty() && currentModel.currentTime() >= currentModel
            .getStopTime()) {
                currentModel.schedule(new StudentGotFoodEvent(currentModel, "StudentGotFoodEvent", currentModel.currentTime() + currentModel.getChoosingFoodTime(), currentModel.studentFDQueue.getFirst(), currentModel.idleFDQueue.getFirst()));
                currentModel.studentFDQueue.remove(currentModel.studentFDQueue.getFirst());
            }

    }
}

