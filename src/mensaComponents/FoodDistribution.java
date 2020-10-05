package mensaComponents;

import core.Entity;
import core.Model;

import javax.persistence.*;
import java.time.Instant;
import java.time.Instant;

/**
 * The FoodDistribution entity encapsulates all data relevant for a
 * food distribution.
 */
@javax.persistence.Entity
@Table(name="staff", schema="studentssep")
public class FoodDistribution extends Entity {

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
     * Constructor of the food distribution entity.
     * @param parentModel
     *              Model : The model the entity belongs to
     * @param name
     *              java.lang.String : The name of the food distribution
     */
    public FoodDistribution(Model parentModel, String name) {
        super(parentModel, name);
    }

    public FoodDistribution(Model parentModel, String name, Instant workBegin, Instant workEnd) {
        super(parentModel, name);
        this.name = name;
        this.workBegin = workBegin;
        this.workEnd = workEnd;
    }
    public FoodDistribution() {

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
}

