package mensaComponents;

import core.Entity;
import core.Model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.time.Instant;
import java.time.Instant;

/**
 * The Checkout entity encapsulates all data relevant for a checkout.
 */
@javax.persistence.Entity
@Table(name="staff", schema="studentssep")
public class Checkout extends Entity {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int Id;

    @Column(name="name")
    private String name;

    @Column(name="workBegin")
    private Instant workBegin;

    @Column(name="workEnd")
    private Instant workEnd;

    @Column(name="department")
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

    public Checkout(Model parentModel, String name, Instant workBegin, Instant workEnd) {
        super(parentModel, name);
        this.name = name;
        this.workBegin = workBegin;
        this.workEnd = workEnd;
    }

    public Checkout() {

    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getWorkBegin() {
        return workBegin;
    }

    public void setWorkBegin(Instant workBegin) {
        this.workBegin = workBegin;
    }

    public Instant getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(Instant workEnd) {
        this.workEnd = workEnd;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

