package mensaComponents;


import core.TimeHandler;
import mensaComponents.events.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import statistics.Count;
import statistics.ExponentialDistribution;
import statistics.Queue;
import statistics.UniformDistribution;

import java.util.GregorianCalendar;
import java.util.List;

/**
 * This is the model class. It is the main class of the event-oriented model of
 * a mensa.Student arrive at the food distribution to get food. They wait in
 * line until a food distribution is available. After the students got their
 * food, they move on to the checkout. They wait in line in front of the
 * checkout till one is available. After the student paid the student
 * will leave the mensa.
 */
public class Mensa extends core.Model {

    /**
     * model parameter : the start time.
     */
    private static double startTime = 0.0;

    public static GregorianCalendar startDate = new GregorianCalendar(2020, 10, 4, 8, 0, 0);

    private TimeHandler timeHandler = new TimeHandler();


    /**
     * model parameter : the number of food distributions.
     */
    protected static int NUM_FD = 2;

    /**
     * model parameter : the number of checkouts.
     */
    protected static int NUM_CO = 2;

    public Queue<String> studentNameQueue;

    /**
     * A waiting queue object is used to represent the waiting line in front of
     * the food distributions.
     * Every time a student arrives it is inserted into this queue
     * (in front of FD) and will be remove if a FD is available.
     */
    public Queue<Student> studentFDQueue;

    /**
     * A waiting queue object is used to represent the available
     * food distributions.
     *
     * If there is no student waiting for service the FD will
     * return here and wait for the next student to come.
     */
    public Queue<FoodDistribution> idleFDQueue;

    /**
     * A waiting queue object is used to represent the waiting line
     * in front of the checkouts.
     * Every time a student arrives it is inserted into this queue
     * (in front of CO) and will be remove if a CO is available.
     */
    public Queue<Student> studentCOQueue;

    /**
     * A waiting queue object is used to represent the available checkouts.
     *
     * If there is no student waiting for service the CO will return
     * here and wait for the next student to come.
     */
    public Queue<Checkout> idleCOQueue;

    /**
     * Variable to name the students.
     */
    private int nameExtension = 0;

    /**
     * Random number stream used to draw an arrival time for the next student.
     */
    private ExponentialDistribution studentArrivalTime;
    /**
     * Random number stream used to draw a choosing food time for a student.
     * Describes the time the student need to choose his food.
     */
    private UniformDistribution choosingFoodTime;
    /**
     * Random number stream used to draw a pay time for a student.
     * Describes the time the student need to pay his meal.
     */
    private UniformDistribution studentPayTime;

    /**
     * A simple count how many students got served.
     */
    public Count studentsServed;

    /**
     * Returns a sample of the random stream used to determine the next
     * truck arrival time.
     * @return double a studentArrivalTime sample
     */
    public double getStudentArrivalTime() {
        return studentArrivalTime.sample();
    }

    /**
     * Returns a sample of the random stream used to determine
     * the time the student needs to choose food.
     * @return double a choosingFoodTime sample
     */
    public double getChoosingFoodTime() {
        return choosingFoodTime.sample();
    }

    /**
     * Returns a sample of the random stream used to determine
     * the time the student needs to pay for the food.
     * @return double a studentPayTime sample
     */
    public double getStudentPayTime() {
        return studentPayTime.sample();
    }


    /**
     * Mensa constructor.
     *
     * Creates a new Mensa model via calling the constructor of the superclass.
     * @param name
     *          java.lang.String : The name of the model
     */
    public Mensa(String name) {
        super(name);
    }

    /**
     * Activates dynamic model components (events).
     *
     * This method is used to place all events on the event
     * list of the simulator which are necessary to start the simulation.
     *
     * In this case, the student generator event will have
     * to be created and scheduled for the start time of the simulation.
     *
     * Also, it initialises static model components like distributions
     * and queues.
     */
    @Override
    public void init() {

        int studentGenerator = 2;

        // initialise the studentArrivalTime
        studentArrivalTime = new ExponentialDistribution(this,
                "Student Arrival Generator", 1, 180.0);
        // initialise the choosingFoodTime
        choosingFoodTime = new UniformDistribution(this,
                "Choosing Food Duration-Generator", 1, 15, 60);
        // initialise the studentPayTime
        studentPayTime = new UniformDistribution(this,
                "Student Pay Duration-Generator", 1, 30, 75k);
        // initialise the studentsServed count
        studentsServed = new Count(this, "Students Served Count");
        // initialise the idleFDQueue
        idleFDQueue = new Queue<>(this, "Idle Food Distribution Queue");
        // initialise the studentFDQueue
        studentFDQueue = new Queue<>(this, "Student Food Distribution Queue");
        // initialise the idleCOQueue
        idleCOQueue = new Queue<>(this, "Idle Checkout Queue");
        // initialise the studentCOQueue
        studentCOQueue = new Queue<>(this, "Student Checkout Queue");

        studentNameQueue = new Queue<>(this, "Student Name Queue");


        registerReportable(studentFDQueue);
        registerReportable(studentCOQueue);
        registerReportable(studentsServed);

        // place the food distributions into the idleFDQueue
        FoodDistribution FD;
        for (int i = 0; i < NUM_FD; i++) {
            // create a new food distribution
            FD = new FoodDistribution(this,"FD" + i);
            // put it in the idleFDQUeue
            idleFDQueue.enqueue(FD);
        }

        // place the checkouts into the idleCOQueue
        Checkout CO;
        for (int i = 0; i < NUM_CO; i++) {
            // create a new checkout
            CO = new Checkout(this,"CO" + i);
            // put it in the idleCOQueue
            idleCOQueue.enqueue(CO);
        }

        switch(studentGenerator) {
            case 1:
                // gets the students from a database
                SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
                Session session = factory.getCurrentSession();
                session.beginTransaction();
                List<Student> theStudents = session.createQuery("from Student").list();
                for (Student tempStudent : theStudents) {
                    Student student = new Student(this, tempStudent.getStudentName());


                    schedule(new StudentArrivalEvent(this,"StudentArrivalEvent", tempStudent.getStudentArrival(), student));
                }
                session.getTransaction().commit();
                break;
            case 2:

                GregorianCalendar arrival = new GregorianCalendar(2020, 10, 4, 8, 40, 0);

                double studentArrival = timeHandler.calculateDifference(startDate, arrival);
                System.out.println(studentArrival);
                //generates students
                schedule(new StudentGeneratorEvent(this, "StudentGeneratorEvent", studentArrival, null));
        }



       // set the stop time of the simulation
        setStopTime(50.0);
    }

    /**
     * Runs the model.
     */
    public static void simulate() {
        // create model
        Mensa mensa = new Mensa("Mensa Model");
        // check if start time is bigger than the stop time
        if (startTime > mensa.getStopTime()) {
            // yes, it is
            // print error
            System.out.println("The start time cannot be larger "
                                + "than the stop time."
                                + " Please make sure to change one of the"
                                + " values before starting the simulation!");
        } else {
            // it is not

            // start the simulation
            mensa.run();
        }
        // generate the report
        mensa.report();
    }

    /**
     * Get Method to get the name extension for the students.
     * @return integer the name extension
     */
    public int getNameExtension() {
        nameExtension++;
        return nameExtension;

    }
}
