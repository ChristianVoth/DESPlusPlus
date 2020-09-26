package MensaComponents.Events;

import Core.*;
import MensaComponents.*;

public class StudentGotFoodEvent extends Event {

    private FoodDistribution currentOther;
    private Mensa currentModel;
    private Student currentStudent;
    private Checkout currentCheckout;

    public StudentGotFoodEvent(Model parentModel, String name, double time, Entity student, Entity other) {
        super(parentModel, name, time, student);
        currentModel = (Mensa)parentModel;
        currentStudent = (Student)student;
        currentOther = (FoodDistribution)other;
    }


    @Override
    public void eventRoutine() {

           currentModel.studentCOQUeue.enqueue(currentStudent);
           currentModel.freeFDQueue.enqueue(currentOther);

            currentModel.freeFDQueue.showList();

            if (!currentModel.freeCOQueue.isEmpty()) {

                Checkout checkout = currentModel.freeCOQueue.getFirst();
                currentCheckout = checkout;
                currentModel.freeCOQueue.remove(checkout);
                currentModel.studentCOQUeue.remove(currentStudent);

                StudentPaidEvent studentPaid = new StudentPaidEvent(currentModel, "StudenPaidEvent", currentModel.currentTime() + 2.0, currentStudent, currentCheckout);
                currentModel.schedule(studentPaid);
            }
    }
}
