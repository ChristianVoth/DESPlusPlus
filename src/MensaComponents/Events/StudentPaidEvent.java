package MensaComponents.Events;

import Core.*;
import MensaComponents.*;

public class StudentPaidEvent extends Event {

    private Checkout currentCheckout;
    private Mensa currentModel;
    private Student currentStudent;


    public StudentPaidEvent(Model parentModel, String name, double time, Entity entity, Entity other) {
        super(parentModel, name, time, entity);
        currentModel = (Mensa)parentModel;
        currentStudent = (Student)entity;
        currentCheckout = (Checkout)other;

    }


    @Override
    public void eventRoutine() {

        currentModel.freeCOQueue.enqueue(currentCheckout);

        currentModel.freeCOQueue.showList();




    }
}
