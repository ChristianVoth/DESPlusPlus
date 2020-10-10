/**
 * Project: DES++
 * $Header: $
 * Author: Christian Voth, Lennart Eikens, Lars Batterham, Steffen Kleinhaus
 * Last Change:
 *      by: $Author:
 *      date: $Date:
 * Copyright (c): DES++, 2020
 */

package mensaComponents;

import core.Entity;
import core.Model;
import javax.persistence.*;
import java.time.Instant;


/**
 * The Student entity encapsulates all information associated with a student.
 */
@javax.persistence.Entity
@Table(name = "student", schema = "studentssep")
public class Student extends Entity {

    /**
     * A variable to store the Id of the student.
     */
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    /**
     * A variable to store the name of the student.
     */
    @Column(name = "studentname")
    private String studentName;
    /**
     * A variable to store the student arrival time.
     */
    @Column(name = "arrival")
    private Instant studentArrival;

    /**
     * Default Constructor.
     */
    public Student() {

    }

    /**
     * Constructor of the student entity.
     * @param parentModel
     *          Model : The model the entity belongs to
     * @param name
     *          java.lang.String : The name of the student
     * @param studentArrival
     *          Instant : A time instant when the student arrives
     */
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

    /**
     * Get Method for the Id.
     * @return an integer value (the id)
     */
    public int getId() {
        return Id;
    }

    /**
     * Set Method for the Id.
     * @param id
     *      int : The id of the student
     */
    public void setId(int id) {
        Id = id;
    }

    /**
     * Get Method for the name of the student.
     * @return java.lang.String the name of the student
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * Set Method to name the student.
     * @param studentName
     *      java.lang.String : The name of the student
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * Get Method for the student arrival time.
     * @return a time instant for the arrival time
     */
    public Instant getStudentArrival() {
        return studentArrival;
    }

    /**
     * Set Method for the student arrival time.
     * @param studentArrival
     *          Instant : A time instant for the student arrival time
     */
    public void setStudentArrival(Instant studentArrival) {
        this.studentArrival = studentArrival;
    }
}
