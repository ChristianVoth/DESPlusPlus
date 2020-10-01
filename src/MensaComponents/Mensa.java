package MensaComponents;

import MensaComponents.Events.*;
import statistics.ExponentialDistribution;
import statistics.Queue;
import statistics.UniformDistribution;

public class Mensa extends Core.Model {
    private static double startTime = 0.0;
    protected static int NUM_FD = 2;
    protected static int NUM_CO = 2;
    public Queue<Student> studentFDQueue;
    public Queue<FoodDistribution> idleFDQueue;
    public Queue<Student> studentCOQueue;
    public Queue<Checkout> idleCOQueue;
    private int nameExtension = 0;

    private ExponentialDistribution studentArrivalTime;
    private UniformDistribution choosingFoodTime;
    private UniformDistribution studentPayTime;


    public double getStudentArrivalTime(){
        return studentArrivalTime.sample();
    }

    public double getChoosingFoodTime(){
        return choosingFoodTime.sample();
    }

    public double getStudentPayTime(){
        return studentPayTime.sample();
    }




    public Mensa(String name) {
        super(name);
    }

    @Override
    public void init() {

        studentArrivalTime = new ExponentialDistribution(this, "Student Arrival Generator", 1, 3.0);
        choosingFoodTime = new UniformDistribution(this, "Choosing Food Duration-Generator" , 1, 0.25, 1.0);
        studentPayTime = new UniformDistribution(this, "Student Pay Duration-Generator", 1, 0.5, 1.25);

        idleFDQueue = new Queue<>(this, "Idle Food Distribution Queue");
        studentFDQueue = new Queue<>(this, "Student Food Distribution Queue");
        idleCOQueue = new Queue<>(this, "Idle Checkout Queue");
        studentCOQueue = new Queue<>(this, "Student Checkout Queue");

        registerReportable(studentFDQueue);
        registerReportable(studentCOQueue);

        FoodDistribution FD;
        for (int i = 0; i < NUM_FD; i++) {
            FD = new FoodDistribution("FD" + i);
            idleFDQueue.enqueue(FD);
        }

        Checkout CO;
        for (int i = 0; i < NUM_CO; i++) {
            CO = new Checkout("CO" + i);
            idleCOQueue.enqueue(CO);
        }


        schedule(new StudentGeneratorEvent(this, "StudentGeneratorEvent", 0.0, null));
        setStopTime(50.0);


    }

    public static void simulate() {

        Mensa mensa = new Mensa("Mensa Model");
        if (startTime > mensa.getStopTime()) {
            System.out.println("The start time cannot be larger than the stop time. Please make sure to change one of the values before starting the simulation!");
        } else {
            mensa.run();
        }
        mensa.report();
    }

    public int getNameExtension(){
        nameExtension++;
        return nameExtension;

    }
}
