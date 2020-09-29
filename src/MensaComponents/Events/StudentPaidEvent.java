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


        if (!currentModel.studentCOQueue.isEmpty()) {
            currentModel.schedule(new StudentPaidEvent(currentModel, "StudentPaidEvent", currentModel.currentTime() + currentModel.getStudentPayTime(), currentModel.studentCOQueue.getFirst(), currentCheckout));
            currentModel.studentCOQueue.remove(currentModel.studentCOQueue.getFirst());

        } else {
            currentModel.idleCOQueue.enqueue(currentCheckout);
        }
        if (!currentModel.studentCOQueue.isEmpty()) {
            currentModel.schedule(new StudentPaidEvent(currentModel, "StudentPaidEvent", currentModel.currentTime() + 5, currentModel.studentCOQueue.getFirst(), currentCheckout ));
        }
      /*  if(currentModel.currentTime() >= currentModel.getStopTime())
            if (!currentModel.studentQueue.isEmpty()){
            currentModel.schedule(new StudentGotFoodEvent(currentModel, "StudentGotFoodEvent", currentModel.currentTime() + 3, currentModel.studentQueue.getFirst(), null ));
        }*/


    }}
