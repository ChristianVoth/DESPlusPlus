package mensaComponents;

import core.Entity;
import core.Model;

import javax.persistence.*;
import java.time.Instant;
import java.time.Instant;

/**
 * The Student entity encapsulates all information associated with a student.
 */
@javax.persistence.Entity
@Table(name="student", schema="studentssep")
public class Student extends Entity {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int Id;

    @Column(name="studentname")
    private String studentName;

    @Column(name="arrival")
    private Instant studentArrival;

    public Student() {

    }

    public Student(Model parentModel, String name, Instant studentArrival) {
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

    public Instant getStudentArrival() {
        return studentArrival;
    }

    public void setStudentArrival(Instant studentArrival) {
        this.studentArrival = studentArrival;
    }
}
