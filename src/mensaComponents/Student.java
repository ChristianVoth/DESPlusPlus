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
     *
     */
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    /**
     *
     */
    @Column(name = "studentname")
    private String studentName;
    /**
     *
     */
    @Column(name = "arrival")
    private Instant studentArrival;

    /**
     *
     */
    public Student() {

    }

    /**
     *
     * @param parentModel
     * @param name
     * @param studentArrival
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
     *
     * @return
     */
    public int getId() {
        return Id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        Id = id;
    }

    /**
     *
     * @return
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     *
     * @param studentName
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     *
     * @return
     */
    public Instant getStudentArrival() {
        return studentArrival;
    }

    /**
     *
     * @param studentArrival
     */
    public void setStudentArrival(Instant studentArrival) {
        this.studentArrival = studentArrival;
    }
}
