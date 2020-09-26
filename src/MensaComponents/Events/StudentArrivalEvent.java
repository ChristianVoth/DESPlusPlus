package MensaComponents.Events;

import Core.*;
import MensaComponents.*;

public class StudentArrivalEvent extends Event {

    private Mensa currentModel;
    private Student currentStudent;
    private int numStundents;


    public StudentArrivalEvent(Model parentModel, String name, double time, Entity entity) {
        super(parentModel, name, time, entity);
        currentModel = (Mensa)parentModel;
        currentStudent = (Student)entity;
        //scheduledTime = time;

    }

    @Override
    public void eventRoutine() {


        currentModel.studentQueue.enqueue(currentStudent);
        if (!currentModel.freeFDQueue.isEmpty()) {
            FoodDistribution foodDistribution = currentModel.freeFDQueue.getFirst();

            currentModel.freeFDQueue.remove(foodDistribution);

            currentModel.studentQueue.remove(currentStudent);




        }
        System.out.println("HI");
        System.out.println(currentModel.currentTime());

    }
}
