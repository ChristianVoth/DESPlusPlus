package mensaComponents;

import core.Entity;
import core.Model;

/**
 * The FoodDistribution entity encapsulates all data relevant for a
 * food distribution.
 */
public class FoodDistribution extends Entity {
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
}
