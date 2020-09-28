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


        if (!currentModel.studentCOQUeue.isEmpty()) {
            currentModel.schedule(new StudentPaidEvent(currentModel, "StudentPaidEvent", currentModel.currentTime() + 3, currentModel.studentCOQUeue.getFirst(), currentCheckout));
            currentModel.studentCOQUeue.remove(currentModel.studentCOQUeue.getFirst());

        } else {
            currentModel.freeCOQueue.enqueue(currentCheckout);
        }



      /*  if(currentModel.currentTime() >= currentModel.getStopTime())
            if (!currentModel.studentQueue.isEmpty()){
            currentModel.schedule(new StudentGotFoodEvent(currentModel, "StudentGotFoodEvent", currentModel.currentTime() + 3, currentModel.studentQueue.getFirst(), null ));
        }*/


    }}
