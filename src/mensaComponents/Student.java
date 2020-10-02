package mensaComponents;

import core.Entity;
import core.Model;

/**
 * The Student entity encapsulates all information associated with a student.
 */
public class Student extends Entity {

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
}
