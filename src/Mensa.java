import java.util.ArrayList;
import java.util.LinkedList;

public class Mensa extends Model {
    private static double startTime = 0.0;
    protected static int NUM_FD = 1;
    protected Queue<Student> studentQueue;
    protected Queue<FoodDistribution> freeFDQueue;

    /**
     * protected static int NUM_CO = 1;
     * protected FifoQueue<Student> studentCOQueue;
     * protected FifoQueue<Checkout> freeCOQueue;
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



        StudentGeneratorEvent studentGenerator = new StudentGeneratorEvent(this, "StudentGeneratorEvent", 6.0, null);
        System.out.println("studentGenerator" + studentGenerator.scheduledTime);
        schedule(studentGenerator);
        setStopTime(10.0);




    }

    public static void main(String[] args) {
        Mensa mensa = new Mensa("Mensa Model");
        mensa.run();
    }

}
