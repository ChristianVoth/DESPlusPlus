package MensaComponents;

import Core.Model;
import MensaComponents.Events.*;
import statistics.Queue;

public class Mensa extends Core.Model {
    private static double startTime = 0.0;
    protected static int NUM_FD = 1;
    protected static int NUM_CO = 1;
    public Queue<Student> studentQueue;
    public Queue<FoodDistribution> freeFDQueue;
    public Queue<Student> studentCOQUeue;
    public Queue<Checkout> freeCOQueue;
    private int studentBenamser = 0;

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
        freeCOQueue = new Queue<>();
        studentCOQUeue = new Queue<>();

        FoodDistribution FD;
        for (int i = 0; i < NUM_FD; i++) {
            FD = new FoodDistribution("FD" + i);
            freeFDQueue.enqueue(FD);
        }

        Checkout CO;
        for (int i = 0; i < NUM_CO; i++) {
            CO = new Checkout("CO" + i);
            freeCOQueue.enqueue(CO);
        }




        schedule(new StudentGeneratorEvent(this, "StudentGeneratorEvent", 0.0, null));
        setStopTime(20.0);




    }

    public static void main(String[] args) {
        Mensa mensa = new Mensa("Mensa Model");
        mensa.run();
    }

    public int getStudentBenamser(){
        studentBenamser++;
        return studentBenamser;

    }
}
