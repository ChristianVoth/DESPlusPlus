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

import core.*;
import mensaComponents.Checkout;
import mensaComponents.FoodDistribution;
import mensaComponents.Mensa;

/**
 * This class represents the close staff event in the mensa model.
 * It occures to a specific time in the simulation, when the staff wants to close
 * a Food Distribution or Checkout.
 */
public class CloseStaffEvent extends Event {

    /**
     * A reference to the model this event is a part of.
     */
    private Mensa currentModel;

    /**
     * currentCO is a reference to the current Checkout which
     * could be going trough the eventRoutine().
     */
    private Checkout currentCO;

    /**
     * currentFD is a reference to the current Food Distribution which
     * could be going trough the eventRoutine().
     */
    private FoodDistribution currentFD;

    /**
     * isCheckout is a boolean variable which stores true or false, when
     * the Entity given to this event is a checkout or not.
     */
    private boolean isCheckout;

    /**
     * isFoodDistribution is a boolean variable which stores true or false, when
     * the Entity given to this event is food distribution or not.
     */
    private boolean isFoodDistribution;

    /**
     * A variable to store the entity which is given to this event.
     */
    private Entity entity;

    /**
     *
     * @param parentModel
     *      core.Model : The model this event is scheduled in.
     * @param name
     *      java.lang.String : The name of this event
     * @param time
     *      double : The time when the event occurs
     * @param entity
     *      Entity : The entity which is associated with the event
     */
    public CloseStaffEvent(Model parentModel, String name,
                           double time, Entity entity) {
        super(parentModel, name, time, entity);


        this.currentModel = (Mensa) parentModel;
        this.entity = entity;

        if (this.entity.getClass() == Checkout.class) {
            isCheckout = true;
        } else if (this.entity.getClass() == FoodDistribution.class) {
            isFoodDistribution = true;
        }
    }


    /**
     * This eventRoutine() describes what happens when a Staff Member
     * (Food Distribution or Checkout) wants to close.
     */
    protected void eventRoutine() {

        if (isCheckout) {
            currentCO = (Checkout) entity;
            if (currentModel.checkEventList() || checkClosedQueue(currentCO)) {
                if (currentModel.idleCOQueue.indexOf(currentCO) >= 0) {
                    currentModel.idleCOQueue.remove(currentCO);
                }
                currentModel.closedStaffQueue.enqueue(currentCO);
            } else {
                int i = currentModel.getEventListSize();
                Event e = currentModel.getEventAt(i - 1);
                double newTime = e.getScheduledTime() + 1.0;

                currentModel.schedule(new CloseStaffEvent(currentModel,
                        "Closed Staff Event", newTime, currentCO));
            }
        } else if (isFoodDistribution) {
            currentFD = (FoodDistribution) entity;
            if (currentModel.checkEventList() || checkClosedQueue(currentFD)) {
                if (currentModel.idleFDQueue.indexOf(currentFD) >= 0) {
                    currentModel.idleFDQueue.remove(currentFD);
                }
                currentModel.closedStaffQueue.enqueue(currentFD);
            } else {
                int i = currentModel.getEventListSize();
                Event e = currentModel.getEventAt(i - 1);
                double newTime = e.getScheduledTime() + 1.0;

                currentModel.schedule(new CloseStaffEvent(currentModel,
                        "Closed Staff Event", newTime, currentFD));
            }
        }
    }

    /**
     * This Method checks if the staff can close or if it is the last
     * active staff which needs to stay open until the last student leaves the
     * mensa.
     * @param e
     *      Entity : The Food Distribution or Checkout which want to leave
     * @return
     *      boolean : Returns a boolean if it is the last or not
     */
    private boolean checkClosedQueue(Entity e) {

        if (e.getClass() == FoodDistribution.class) {
            int countFD = 0;
            for (int i = 0; i < currentModel.closedStaffQueue.size(); i++) {
                Object current = currentModel.closedStaffQueue.get(i);
                if (current.getClass() == FoodDistribution.class) {
                    countFD += 1;
                }
            }
            if (countFD < currentModel.NUM_FD - 1) {
                return true;
            }
        } else {
            int countCO = 0;
            for (int i = 0; i < currentModel.closedStaffQueue.size(); i++) {
                Object current = currentModel.closedStaffQueue.get(i);
                if (current.getClass() == Checkout.class) {
                    countCO += 1;
                }
            }

            if (countCO < currentModel.NUM_CO - 1) {
                return true;
            }
        }
    return false;
    }
}

