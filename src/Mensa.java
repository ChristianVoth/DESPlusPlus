import java.util.LinkedList;

public class Mensa extends Model {

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




        FoodDistribution FD;
        for (int i = 0; i < NUM_FD; i++) {
            FD = new FoodDistribution("FD" + i);
            freeFDQueue.enqueue(FD);
        }

    }

    public static void main(String[] args) {
        Mensa mensa = new Mensa("Mensa Model");
    }
}
