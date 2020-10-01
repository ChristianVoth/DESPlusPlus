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
 * The interface ModelComponent serves to represent model components in very
 * general terms. Each model component has a name and a reference to the model
 * in which it is used.
 */
public interface ModelComponent {

    /**
     * Method to get the model in which the model component is used.
     * @return
     *     Model : The model in which the component is used
     */
    Model getModel();

    /**
     * Method to get the name of model component.
     * @return
     *      java.lang.String : The name of the model component
     */
    String getName();

}
