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
 *
 */
public class CloseStaffEvent extends Event {

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
     */
    private boolean isFoodDistribution;

    /**
     *
     */
    private Entity entity;

    /**
     *
     * @param parentModel
     * @param name
     * @param time
     * @param entity
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
     *
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
     *
     * @param e
     * @return
     */
    private boolean checkClosedQueue(Entity e) {

            System.out.println(e.getClass());
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
                    System.out.println(currentModel.closedStaffQueue.get(i));
                    Object current = currentModel.closedStaffQueue.get(i);
                    if (current.getClass() == Checkout.class) {
                        countCO += 1;
                    }
                }
                System.out.println(countCO);
                if (countCO < currentModel.NUM_CO - 1) {
                    return true;
                }
            }
            return false;
        }
    }

