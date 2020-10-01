package mensaComponents.events;

import core.*;
import mensaComponents.*;


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


        Student student = new Student("Student" + currentModel.getNameExtension());



        currentModel.schedule(new StudentArrivalEvent(currentModel, "StudentArrivalEvent", currentModel.currentTime(), student));
        if (currentModel.getIsOpen() == true){
            double testTime = currentModel.getStudentArrivalTime();
            currentModel.schedule(new StudentGeneratorEvent(currentModel, "StudentGeneratorEvent", currentModel.currentTime() + testTime, null));
            System.out.println("Test: " + testTime);
        }



    }
}
