package mensaComponents.events;

import core.Entity;
import core.Event;
import core.Model;
import mensaComponents.Checkout;
import mensaComponents.FoodDistribution;
import mensaComponents.Mensa;
import mensaComponents.Student;

public class StudentGetFoodEvent extends Event {

    private Mensa currentModel;
    private String name;
    private Student currentStudent;
    private FoodDistribution currentOther;
    private Checkout checkout;
    private Student nextInLine;
    private Student nextForCheckout;


    public StudentGetFoodEvent(Model parentModel, String name, double time, Entity entity, Entity currentOther) {
        super(parentModel, name, time, entity);

        this.currentModel = (Mensa) parentModel;
        this.name = name;
        this.currentStudent = (Student) entity;
        this .currentOther = (FoodDistribution) currentOther;
    }

    @Override
    protected void eventRoutine() {

        if (currentModel.foodResource > 0) {
            currentModel.foodResource--;
            System.out.println(currentModel.foodResource);
            currentModel.idleFDQueue.enqueue(currentOther);
            currentModel.studentCOQueue.enqueue(currentStudent);

            if (!currentModel.idleCOQueue.isEmpty()) {

                System.out.println(currentModel.idleCOQueue.isEmpty());

                checkout = currentModel.idleCOQueue.getFirst();
                currentModel.idleCOQueue.remove(checkout);

                nextForCheckout = currentModel.studentCOQueue.getFirst();
                currentModel.studentCOQueue.remove(nextForCheckout);

                System.out.println(currentModel.studentCOQueue.size());

                StudentPaidEvent studentPaid = new StudentPaidEvent(currentModel, "Student Paid",
                        currentModel.currentTime() + currentModel.getStudentPayTime(), nextForCheckout, checkout);
                currentModel.schedule(studentPaid);

            }
        }
        if (currentModel.foodResource == 0) {
            CookFoodEvent cookFood = new CookFoodEvent(currentModel, "Cook Food", currentModel.currentTime() + currentModel.getCookingTIme(), currentStudent, currentOther);
            currentModel.schedule(cookFood);
        }

        if(!currentModel.studentFDQueue.isEmpty() && currentModel.foodResource > 0 ){

            nextInLine = currentModel.studentFDQueue.getFirst();
            currentModel.studentFDQueue.remove(nextInLine);

            currentOther = currentModel.idleFDQueue.getFirst();
            currentModel.idleFDQueue.remove(currentOther);

            StudentGetFoodEvent getFood = new StudentGetFoodEvent(currentModel, "Student got Food",
                    currentModel.currentTime() + currentModel.getChoosingFoodTime(), nextInLine, currentOther);
            currentModel.schedule(getFood);
        }

    }
}
