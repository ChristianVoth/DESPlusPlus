/**
 * Project: DES++
 * $Header: $
 * Author: Christian Voth, Lennart Eikens, Lars Batterham, Steffen Kleinhaus
 * Last Change:
 *      by: $Author:
 *      date: $Date:
 * Copyright (c): DES++, 2020
 */

package core;

/**
 * BasicModelComponent is a simple implementation to derive concrete
 * components from.
 */
public class BasicModelComponent implements ModelComponent {

    /**
     * The model which the model component is used in.
     */
    private Model parent;

    /**
     * The name of the model component.
     */
    private String basicModelComponentName;

    /**
     * Constructs a model component with a name and a reference to the model in
     * which it is used.
     * @param parentModel
     *          Model : The model in which the component is used
     * @param name
     *          java.lang.String : The name of the model component
     */
    public BasicModelComponent(Model parentModel, String name) {
        if (name == null) {
            basicModelComponentName = "unnamed";
        } else {
            basicModelComponentName = name;
        }
        parent = parentModel;
    }

    /**
     * Constructs a model component with a name.
     * @param name
     *          java.lang.String : The name of the model component
     */
    public BasicModelComponent(String name) {
        if (name == null) {
            basicModelComponentName = "unnamed";
        } else {
            basicModelComponentName = name;
        }
    }

    /**
     * Method to get the model in which the model component is used in.
     * @return
     *      Model : The model in which the model component is used in
     */
    @Override
    public Model getModel() {
        return parent;
    }

    /**
     * Method to get the name of the model component.
     * @return
     *      java.lang.String : The name of the model component
     */
    @Override
    public String getName() {
        return basicModelComponentName;
    }
}
