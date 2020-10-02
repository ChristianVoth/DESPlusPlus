package mensaComponents;

import core.Entity;
import core.Model;

/**
 * The Checkout entity encapsulates all data relevant for a checkout.
 */
public class Checkout extends Entity {

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
}
