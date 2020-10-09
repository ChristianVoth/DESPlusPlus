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
     *
     */
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    /**
     *
     */
    private int Id;

    /**
     *
     */
    @Column(name = "name")
    private String name;

    /**
     *
     */
    @Column(name = "workBegin")
    private Instant workBegin;

    /**
     *
     */
    @Column(name = "workEnd")
    private Instant workEnd;

    /**
     *
     */
    @Column(name = "department")
    private String department;

    /**
     * Constructor of the checkout entity.
     * @param pparentModel
     *              Model : The model the entity belongs to
     * @param nname
     *              java.lang.String : The name of the checkout
     */
    public Checkout(Model pparentModel, String nname) {
        super(pparentModel, nname);
    }

    /**
     *
     * @param pparentModel
     * @param nname
     * @param wworkBegin
     * @param wworkEnd
     */
    public Checkout(Model pparentModel, String nname, Instant wworkBegin,
                    Instant wworkEnd) {
        super(pparentModel, nname);
        this.name = nname;
        this.workBegin = wworkBegin;
        this.workEnd = wworkEnd;
    }

    /**
     *
     */
    public Checkout() {

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
    @Override
    public String getName() {
        return name;
    }

    /**
     *
     * @param nname
     */
    public void setName(String nname) {
        this.name = nname;
    }

    /**
     *
     * @return
     */
    public Instant getWorkBegin() {
        return workBegin;
    }

    /**
     *
     * @param wworkBegin
     */
    public void setWorkBegin(Instant wworkBegin) {
        this.workBegin = wworkBegin;
    }

    /**
     *
     * @return
     */
    public Instant getWorkEnd() {
        return workEnd;
    }

    /**
     *
     * @param wworkEnd
     */
    public void setWorkEnd(Instant wworkEnd) {
        this.workEnd = wworkEnd;
    }

    /**
     *
     * @return
     */
    public String getDepartment() {
        return department;
    }

    /**
     *
     * @param ddepartment
     */
    public void setDepartment(String ddepartment) {
        this.department = ddepartment;
    }
}

