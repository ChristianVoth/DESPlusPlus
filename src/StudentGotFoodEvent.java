public class StudentGotFoodEvent extends Event {


    private Mensa currentModel;
    private Student currentStudent;

    public StudentGotFoodEvent(Model parentModel, String name, double time, Entity entity) {
        super(parentModel, name, time, entity);
        currentModel = (Mensa)parentModel;
        currentStudent = (Student)entity;
    }


    @Override
    void eventRoutine() {



    }
}
