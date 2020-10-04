package mensaComponents;

import core.Entity;
import core.Model;

import javax.persistence.*;

/**
 * The Student entity encapsulates all information associated with a student.
 */
@javax.persistence.Entity
@Table(name="student")
public class Student extends Entity {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int Id;

    @Column(name="name")
    private String studentName;

    @Column(name="arrival")
    private double studentArrival;

    public Student() {

    }

    public Student(Model parentModel, String name, double studentArrival) {
        super(parentModel, name);
        this.studentName = name;
        this.studentArrival = studentArrival;
    }
    /**
     * Constructor of the student entity.
     * @param parentModel
     *              Model : The Model of the entity
     * @param name
     *              java.lang.String : The name of the entity
     */
    public Student(Model parentModel, String name) {
        super(parentModel, name);
    }
    /**
     * Constructor of the student entity.
     * @param parentModel
     *              Model : The model of the entity
     * @param name
     *              java.lang.String : The name of the entity
     * @param priority
     *              integer : The priority of the entity
     */
    public Student(Model parentModel, String name, int priority) {
        super(parentModel, name, priority);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getStudentArrival() {
        return studentArrival;
    }

    public void setStudentArrival(double studentArrival) {
        this.studentArrival = studentArrival;
    }
}
