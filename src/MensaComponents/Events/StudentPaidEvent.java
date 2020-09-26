package MensaComponents.Events;

import Core.*;
import MensaComponents.*;

public class StudentPaidEvent extends Event {

    private Mensa currentModel;
    private Student currentStudent;


    public StudentPaidEvent(Model parentModel, String name, double time, Entity entity) {
        super(parentModel, name, time, entity);
        currentModel = (Mensa)parentModel;
        currentStudent = (Student)entity;
    }


    @Override
    public void eventRoutine() {

    }
}
