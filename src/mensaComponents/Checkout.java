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
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.time.Instant;


/**
 * The Checkout entity encapsulates all data relevant for a checkout.
 */
@javax.persistence.Entity
@Table(name = "staff", schema = "studentssep")
public class Checkout extends Entity {


    /**
     * A variable to store the Id of the checkout.
     */
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    /**
     * A variable to store the name of the checkout.
     */
    @Column(name = "name")
    private String name;

    /**
     * A variable to store the time instant when the checkout starts working.
     */
    @Column(name = "workBegin")
    private Instant workBegin;

    /**
     * A variable to store the time instant when the checkout stops working.
     */
    @Column(name = "workEnd")
    private Instant workEnd;

    /**
     * A variable to store the department in which the staff is working.
     */
    @Column(name = "department")
    private String department;

    /**
     * Constructor of the checkout entity.
     * @param parentModel
     *              Model : The model the entity belongs to
     * @param name
     *              java.lang.String : The name of the checkout
     */
    public Checkout(Model parentModel, String name) {
        super(parentModel, name);
    }

    /**
     *
     * @param parentModel
     *          Model : The model the entity belongs to
     * @param name
     *          java.lang.String : The name of the checkout
     * @param workBegin
     *          Instant : A time instant when the checkout starts working
     * @param workEnd
     *          Instant : A time instant when the checkout stops working
     */
    public Checkout(Model parentModel, String name, Instant workBegin,
                    Instant workEnd) {
        super(parentModel, name);
        this.name = name;
        this.workBegin = workBegin;
        this.workEnd = workEnd;
    }

    /**
     * Default Constructor.
     */
    public Checkout() {

    }

    /**
     * Get Method for the Id.
     * @return an integer value (the id)
     */
    public int getId() {
        return Id;
    }

    /**
     * Set Method for the Id
     * @param id
     *      int : The id of the checkout
     */
    public void setId(int id) {
        Id = id;
    }

    /**
     * Get Method for the name of the checkout.
     * @return java.lang.String the name of the checkout
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Set Method to name the checkout.
     * @param name
     *      java.lang.String : The name of the checkout
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get Method for the time when the checkout starts working.
     * @return a time instant when the checkout starts working
     */
    public Instant getWorkBegin() {
        return workBegin;
    }

    /**
     * Set Method for the working begin of the checkout.
     * @param workBegin
     *      Instant : A time instant when the checkout starts working
     */
    public void setWorkBegin(Instant workBegin) {
        this.workBegin = workBegin;
    }

    /**
     * Get Method for the working end of the checkout.
     * @return a time instant when the checkout end working
     */
    public Instant getWorkEnd() {
        return workEnd;
    }

    /**
     * Set Method for the working end of the checkout.
     * @param wworkEnd
     *      Instant : A time instant when the checkout stops working
     */
    public void setWorkEnd(Instant wworkEnd) {
        this.workEnd = wworkEnd;
    }

    /**
     * Get Method to get the department of the checkout.
     * @return java.lang.String : The department the checkout is working for
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Set Method for the department of the checkout.
     * @param ddepartment
     *      java.lang.String : The department the checkout is working for
     */
    public void setDepartment(String ddepartment) {
        this.department = ddepartment;
    }
}

