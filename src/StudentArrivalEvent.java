public class StudentArrivalEvent extends Event{

    private Mensa currentModel;
    private Student currentStudent;

    public StudentArrivalEvent(Model parentModel, String name, double time, Entity entity) {
        super(parentModel, name, time, entity);
        currentModel = (Mensa)parentModel;
        currentStudent = (Student)entity;
    }

    @Override
    void eventRoutine() {


        currentModel.studentQueue.enqueue(currentStudent);
        if (!currentModel.freeFDQueue.isEmpty()) {
            FoodDistribution foodDistribution = currentModel.freeFDQueue.first();

            currentModel.freeFDQueue.remove(foodDistribution);

            currentModel.studentQueue.remove(currentStudent);
        }

    }
}
