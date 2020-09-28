package MensaComponents.Events;

import Core.*;
import MensaComponents.*;


public class StudentGeneratorEvent extends Event {

    private Mensa currentModel;

   // public int studentBenamser = 1;

    public StudentGeneratorEvent(Model parentModel, String name, double time, Entity entity) {
        super(parentModel, name, time, entity);
        currentModel = (Mensa)parentModel;
        //scheduledTime = time;
    }

    @Override
    public void eventRoutine() {


        Student student = new Student("S" + currentModel.getStudentBenamser());



        currentModel.schedule(new StudentArrivalEvent(currentModel, "StudentArrivalEvent", currentModel.currentTime() +0.0, student));
        currentModel.schedule(new StudentGeneratorEvent(currentModel, "StudentGeneratorEvent", currentModel.currentTime()+ 2.0, null));

    }
}
