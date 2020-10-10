/**
 * Project: DES++
 * $Header: $
 * Author: Christian Voth, Lennart Eikens, Lars Batterham, Steffen Kleinhaus
 * Last Change:
 *      by: $Author:
 *      date: $Date:
 * Copyright (c): DES++, 2020
 */

package mensaComponents.events;

import core.Entity;
import core.Event;
import core.Model;
import mensaComponents.Checkout;
import mensaComponents.FoodDistribution;
import mensaComponents.Mensa;

/**
 * This class represents the open staff event in the Mensa model.
 * It occures when a staff (Food Distribution or Checkout) wants to open.
 */
public class OpenStaffEvent extends Event {

    /**
     * A reference to the model this event is a port of.
     */
    private Mensa currentModel;

    /**
     * A variable to store the Checkout which is given to the event.
     */
    private Checkout currentCO;

    /**
     * A variable to store the Food Distribution which is given to the event.
     */
    private FoodDistribution currentFD;

    /**
     * isCheckout is a boolean variable which stores true or false when the Entity
     * given to this event is a checkout or not.
     */
    private boolean isCheckout;

    /**
     * Constructor to create a Open Staff Event.
     * @param parentModel
     *      core.Model : The model this event is scheduled in.
     * @param name
     *      java.lang.String : The name of this event.
     * @param time
     *      double : The time when the event occurs
     * @param entity
     *      Entity : The entity which is associated with the event
     */
    public OpenStaffEvent(Model parentModel, String name,
                          double time, Entity entity) {
        super(parentModel, name, time, entity);

        if (entity.getClass() == Checkout.class) {
            this.currentCO = (Checkout) entity;
            isCheckout = true;
        } else {
            this.currentFD = (FoodDistribution) entity;
            isCheckout = false;
        }
        this.currentModel = (Mensa) parentModel;
    }

    /**
     * This eventRoutine() describes what happens when Staff Member
     * (Food Distribution or Checkout) wants to open.
     */
    @Override
    protected void eventRoutine() {

        if (isCheckout) {
            if (currentModel.closedStaffQueue.indexOf(currentCO) >= 0) {
                currentModel.closedStaffQueue.remove(currentCO);
            }
        currentModel.idleCOQueue.enqueue(currentCO);
        } else {
            if (currentModel.closedStaffQueue.indexOf(currentFD) >= 0) {
            currentModel.closedStaffQueue.remove(currentFD);
            }
        currentModel.idleFDQueue.enqueue(currentFD);
        }
    }
}
