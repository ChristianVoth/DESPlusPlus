package MensaComponents.Events;

import Core.*;
import MensaComponents.*;

public class StudentArrivalEvent extends Event {

    private Mensa currentModel;
    private Student currentStudent;
    private Student nextInLine;
    private Entity currentOther;
    private int numStundents;
    private double zufallStudentGotFood;


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
            zufallStudentGotFood = (double) (Math.random() * 5) +1;
            nextInLine = currentModel.studentQueue.getFirst();
            currentModel.studentQueue.remove(nextInLine);
            System.out.println(currentModel.studentQueue.size());
            StudentGotFoodEvent studentGotFood = new StudentGotFoodEvent(currentModel, "StudentGotFoodEvent", currentModel.currentTime() + zufallStudentGotFood, nextInLine, currentOther);
            currentModel.schedule(studentGotFood);



        }

    }
}
