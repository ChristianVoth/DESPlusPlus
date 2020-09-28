package MensaComponents.Events;

import Core.*;
import MensaComponents.*;

public class StudentArrivalEvent extends Event {

    private Mensa currentModel;
    private Student currentStudent;
    private Student nextInLine;
    private Entity currentOther;
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
            currentOther = currentModel.freeFDQueue.getFirst();
            currentModel.freeFDQueue.remove(currentOther);

            nextInLine = currentModel.studentQueue.getFirst();
            currentModel.studentQueue.remove(nextInLine);
            StudentGotFoodEvent studentGotFood = new StudentGotFoodEvent(currentModel, "StudentGotFoodEvent", currentModel.currentTime() + 2.0, nextInLine, currentOther);
            currentModel.schedule(studentGotFood);



        }

    }
}
