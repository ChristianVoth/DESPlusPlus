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
 *
 */
public class OpenStaffEvent extends Event {

    /**
     *
     */
    private Mensa currentModel;

    /**
     *
     */
    private Checkout currentCO;

    /**
     *
     */
    private FoodDistribution currentFD;

    /**
     *
     */
    private boolean isCheckout;

    /**
     *
     * @param parentModel
     * @param name
     * @param time
     * @param entity
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
     *
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
