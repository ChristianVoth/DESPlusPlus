package MensaComponents;

import Core.Model;
import MensaComponents.Events.*;
import statistics.Queue;

public class Mensa extends Core.Model {
    private static double startTime = 0.0;
    protected static int NUM_FD = 1;
    public Queue<Student> studentQueue;
    public Queue<FoodDistribution> freeFDQueue;

    /**
     * protected static int NUM_CO = 1;
     * protected FifoQueue<Model.Student> studentCOQueue;
     * protected FifoQueue<Model.Checkout> freeCOQueue;
     *
     * private RANDOM studentArrivalTime;
     * private RANDOM choosingFoodTime;
     * private RANDOM studentPayTime;
     */

    public Mensa(String name) {
        super(name);
    }

    @Override
    public void init() {



        freeFDQueue = new Queue<>();
        studentQueue = new Queue<>();

        FoodDistribution FD;
        for (int i = 0; i < NUM_FD; i++) {
            FD = new FoodDistribution("FD" + i);
            freeFDQueue.enqueue(FD);
        }



        StudentGeneratorEvent studentGenerator = new StudentGeneratorEvent(this, "Model.Events.StudentGeneratorEvent", 6.0, null);
        System.out.println("studentGenerator" + studentGenerator.getScheduledTime());
        schedule(studentGenerator);
        setStopTime(10.0);




    }

    public static void main(String[] args) {
        Mensa mensa = new Mensa("Model.Mensa Core.Model");
        mensa.run();
    }

}
