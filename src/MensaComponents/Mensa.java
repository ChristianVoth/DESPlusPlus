package MensaComponents;

import MensaComponents.Events.*;
import statistics.Queue;

public class Mensa extends Core.Model {
    private static double startTime = 0.0;
    protected static int NUM_FD = 1;
    protected static int NUM_CO = 1;
    public Queue<Student> studentFDQueue;
    public Queue<FoodDistribution> idleFDQueue;
    public Queue<Student> studentCOQueue;
    public Queue<Checkout> idleCOQueue;
    private int nameExtension = 0;

    /**
     * private RANDOM studentArrivalTime;
     * private RANDOM choosingFoodTime;
     * private RANDOM studentPayTime;
     */

    public Mensa(String name) {
        super(name);
    }

    @Override
    public void init() {



        idleFDQueue = new Queue<>();
        studentFDQueue = new Queue<>();
        idleCOQueue = new Queue<>();
        studentCOQueue = new Queue<>();

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
        setStopTime(0.0);




    }

    public static void main(String[] args) {
        Mensa mensa = new Mensa("Mensa Model");
        if (startTime >= mensa.getStopTime()) {
            System.out.println("The start time cannot be larger than the stop time. Please make sure to change one of the values before starting the simulation!");
        } else {
            mensa.run();
        }
    }

    public int getNameExtension(){
        nameExtension++;
        return nameExtension;

    }
}
