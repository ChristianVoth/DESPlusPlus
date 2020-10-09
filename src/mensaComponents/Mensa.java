package mensaComponents;


import core.Model;
import core.TimeHandler;
import mensaComponents.events.CloseStaffEvent;
import mensaComponents.events.OpenStaffEvent;
import mensaComponents.events.StudentArrivalEvent;
import mensaComponents.events.StudentGeneratorEvent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import statistics.*;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.ArrayList;
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

    public List queueLengths = new ArrayList();

    /**
     * model parameter : the number of checkouts.
     */
    public int NUM_CO;


    /**
     * model parameter : the number of food distributions.
     */
    public int NUM_FD;

    public int foodResource;

    private int numOfStaff;


    public Mensa () {
        super();

    }

    public Mensa(String name, int numOfFD, int numOfCO) {
        super(name);
        this.NUM_FD = numOfFD;
        this.NUM_CO = numOfCO;
    }


    /**
     * model parameter : the start time.
     */
    private static double startTime = 0.0;

    private TimeHandler timeHandler = new TimeHandler();




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

    public Queue<FoodDistribution> closedFDQueue;

    public Queue<Checkout> closedCOQueue;

    public Queue<Object> closedStaffQueue;

    public Queue<Object> openStaffQueue;

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

    private UniformDistribution cookingTime;

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

    public double getCookingTIme() {
        return  cookingTime.sample();
    }



    /**
     * Mensa constructor.
     *
     * Creates a new Mensa model via calling the constructor of the superclass.
     * @param name
     *          java.lang.String : The name of the model
     */


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
        //This Time is in UTC
        this.setStartDate(Instant.parse("2020-06-10T06:00:00Z"));

        // set the stop time of the simulation
        setStopTime(36000.0);

        foodResource = 50;

        numOfStaff = 2;

        switch(numOfStaff) {
            case 1:
                cookingTime = new UniformDistribution(this, "Ein Koch", 1, 720, 960);
                break;
            case 2:
                cookingTime = new UniformDistribution(this, "Zwei Köche", 1, 450, 720);
                break;
            case 3:
                cookingTime = new UniformDistribution(this, "Drei Köche", 1, 300, 450);
                break;
            default:
        }



        // initialise the studentArrivalTime
        //studentArrivalTime = new ExponentialDistribution(this,
               // "Student Arrival Generator", 1, 5);
        studentArrivalTime = new ExponentialDistribution(this, "SAG", 1, 180);
        // initialise the choosingFoodTime
        choosingFoodTime = new UniformDistribution(this,
                "Choosing Food Duration-Generator", 1, 100 , 300);
        // initialise the studentPayTime
        studentPayTime = new UniformDistribution(this,
                "Student Pay Duration-Generator", 1, 100, 300);
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

        closedStaffQueue = new Queue<>(this, "Not Working Staff");
        closedFDQueue = new Queue<>(this, "Closed Food Distribution");
        closedCOQueue = new Queue<>(this, "Closed Checkout");

        studentNameQueue = new Queue<>(this, "Student Name Queue");


        registerReportable(studentFDQueue);
        registerReportable(studentCOQueue);

        switch(studentGenerator) {
            case 1:
                // gets the students from a database
                System.out.println(NUM_FD + " " +NUM_CO);
                SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(FoodDistribution.class).addAnnotatedClass(Student.class).addAnnotatedClass(Checkout.class).buildSessionFactory();



                Session session = factory.getCurrentSession();
                session.beginTransaction();
                List<FoodDistribution> theFD = session.createQuery("from FoodDistribution fd where fd.department = 'FoodDistribution'").list();
                for (FoodDistribution tempFD : theFD) {
                    FoodDistribution FD = new FoodDistribution(this, tempFD.getName(), tempFD.getWorkBegin(), tempFD.getWorkEnd());
                    closedStaffQueue.enqueue(FD);
                    schedule(new OpenStaffEvent(this, "Open Food Distribution", this.getDifference(this.getStartDate(), tempFD.getWorkBegin()), FD));
                    schedule(new CloseStaffEvent(this, "Close Food Distribution", this.getDifference(this.getStartDate(), tempFD.getWorkEnd()), FD));
                }
                List<Checkout> theCO = session.createQuery("from Checkout co where co.department = 'Checkout' ").list();
                for (Checkout tempCO : theCO) {
                    Checkout CO = new Checkout(this, tempCO.getName(), tempCO.getWorkBegin(), tempCO.getWorkEnd());
                    closedStaffQueue.enqueue(CO);
                    schedule(new OpenStaffEvent(this, "Open Checkout", this.getDifference(this.getStartDate(), tempCO.getWorkBegin()), CO));
                    schedule(new CloseStaffEvent(this, "Close Checkout", this.getDifference(this.getStartDate(), tempCO.getWorkEnd()), CO));
                }

                List<Student> theStudents = session.createQuery("from Student").list();
                for (Student tempStudent : theStudents) {
                    Student student = new Student(this, tempStudent.getStudentName());
                    double studentArrivalTime = timeHandler.calculateDifference(getStartDate(), tempStudent.getStudentArrival());
                    System.out.println(getStartDate());
                    System.out.println(studentArrivalTime);
                    schedule(new StudentArrivalEvent(this, "StudentArrivalEvent", studentArrivalTime, student));
                }
                session.getTransaction().commit();

                break;
            case 2:
                FoodDistribution FD;
                for (int i = 0; i < NUM_FD; i++) {
                    // create a new food distribution
                    FD = new FoodDistribution(this, "FD" + i);
                    // put it in the idleFDQUeue
                    idleFDQueue.enqueue(FD);
                }

                // place the checkouts into the idleCOQueue
                Checkout CO;
                for (int i = 0; i < NUM_CO; i++) {
                    // create a new checkout
                    CO = new Checkout(this, "CO" + i);
                    // put it in the idleCOQueue
                    idleCOQueue.enqueue(CO);
                }

                    //generates students
                    schedule(new StudentGeneratorEvent(this, "StudentGeneratorEvent", 0.0, null));

                break;
            default:

        }
    }

    /**
     * Runs the model.
     */
    public ArrayList simulate(Model m) {
        // create model
        //Mensa mensa = new Mensa("Mensa Model");
        // check if start time is bigger than the stop time
        //if (startTime > mensa.getDifference()) {
            // yes, it is
            // print error
           // System.out.println("The start time cannot be larger "
                              //  + "than the stop time."
                               // + " Please make sure to change one of the"
                                //+ " values before starting the simulation!");
       // } else {
            // it is not

            // start the simulation
            m.run();
        //}
        // generate the report

        return m.report();


        //System.out.println(m.queueLengths);
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
