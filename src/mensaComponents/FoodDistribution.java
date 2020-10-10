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
 * The FoodDistribution entity encapsulates all data relevant for a
 * food distribution.
 */
@javax.persistence.Entity
@Table(name = "staff", schema = "studentssep")
public class FoodDistribution extends Entity {

    /**
     * A variable to store the Id of the food distribution.
     */
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int Id;

    /**
     * A variable to store the name of the food distribution.
     */
    @Column(name = "name")
    private String name;

    /**
     * A variable to store the time instant when
     * the food distribution starts working.
     */
    @Column(name = "workBegin")
    private Instant workBegin;

    /**
     * A variable to store the time instant when the
     * food distribution stops working.
     */
    @Column(name = "workEnd")
    private Instant workEnd;

    /**
     * A variable to store the department in which
     * the staff is working.
     */
    @Column(name = "department")
    private String department;

    /**
     * Constructor of the food distribution entity.
     * @param parentModel
     *              Model : The model the entity belongs to
     * @param name
     *              java.lang.String : The name of the food distribution
     */
    public FoodDistribution(Model parentModel, String name) {
        super(parentModel, name);
    }

    /**
     *
     * @param parentModel
     *      Model : The model the entity belongs to
     * @param name
     *      java.lang.String : The name of the food distribution
     * @param workBegin
     *      Instant : A time instant when the checkout starts working
     * @param workEnd
     *      Instant : A time instant when the checkout stops working
     */
    public FoodDistribution(Model parentModel, String name,
                            Instant workBegin, Instant workEnd) {
        super(parentModel, name);
        this.name = name;
        this.workBegin = workBegin;
        this.workEnd = workEnd;
    }

    /**
     * Default Constructor.
     */
    public FoodDistribution() {

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
     *      int : The id of the food distribution
     */
    public void setId(int id) {
        Id = id;
    }

    /**
     * Get Method for the name of the food distribution.
     * @return java.lang.String the name of the food distribution
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Set Method to name the food distribution.
     * @param name
     *      java.lang.String : The name of the food distribution
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get Method for the time when the food distribution starts working.
     * @return a time instant when the food distribution starts working
     */
    public Instant getWorkBegin() {
        return workBegin;
    }

    /**
     * Set Method for the working begin of the food distribution.
     * @param workBegin
     *      Instant : A time instant when the food distribution starts working
     */
    public void setWorkBegin(Instant workBegin) {
        this.workBegin = workBegin;
    }

    /**
     * Get Method for the working end of the food distribution.
     * @return a time instant when the food distribution end working
     */
    public Instant getWorkEnd() {
        return workEnd;
    }

    /**
     * Set Method for the working end of the food distribution.
     * @param workEnd
     *      Instant : A time instant when the food distribution stops working
     */
    public void setWorkEnd(Instant workEnd) {
        this.workEnd = workEnd;
    }
}

