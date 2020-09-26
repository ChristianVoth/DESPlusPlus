public class StudentGeneratorEvent extends Event{

    private Mensa currentModel;

    int studentBenamser = 0;

    public StudentGeneratorEvent(Model parentModel, String name, double time, Entity entity) {
        super(parentModel, name, time, entity);
        currentModel = (Mensa)parentModel;
        //scheduledTime = time;
    }

    @Override
    void eventRoutine() {


        Student student = new Student("S" + studentBenamser);
        studentBenamser++;

        StudentArrivalEvent studentArrival = new StudentArrivalEvent(currentModel, "StudentArrivalEvent", currentModel.currentTime()+0.0, student);
        System.out.println("StudentArrival" + studentArrival.scheduledTime);
        currentModel.schedule(studentArrival);

        currentModel.schedule(new StudentGeneratorEvent(currentModel, "StudentGeneratorEvent", currentModel.currentTime()+ 2.0, student));
        System.out.println("Generator?" + scheduledTime);

    }
}
