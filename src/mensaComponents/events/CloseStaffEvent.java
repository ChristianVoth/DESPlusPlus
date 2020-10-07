package mensaComponents.events;

import core.*;
import mensaComponents.Checkout;
import mensaComponents.FoodDistribution;
import mensaComponents.Mensa;

import java.util.List;


public class CloseStaffEvent extends Event {

    private Mensa currentModel;

    private Checkout currentCO;

    private FoodDistribution currentFD;

    private boolean isCheckout;

    private Entity entity;

    public CloseStaffEvent(Model parentModel, String name, double time, Entity entity) {
        super(parentModel, name, time, entity);
        if (entity.getClass() == Checkout.class) {
            this.currentCO = (Checkout) entity;
            isCheckout = true;
        } else {
            this.currentFD = (FoodDistribution) entity;
            isCheckout = false;
        }
        this.currentModel = (Mensa) parentModel;
        this.entity = entity;
    }


    @Override
    protected void eventRoutine() {

        if (currentModel.checkEventList() == true) {
            if (isCheckout) {
                if (currentModel.idleCOQueue.indexOf(currentCO) >= 0) {
                    currentModel.idleCOQueue.remove(currentCO);
                }
                currentModel.closedStaffQueue.enqueue(currentCO);
            } else {
                if (currentModel.idleFDQueue.indexOf(currentFD) >= 0) {
                    currentModel.idleFDQueue.remove(currentFD);
                }
                currentModel.closedStaffQueue.enqueue(currentFD);
            }

        } else {
            if (checkClosedQueue(entity)) {
                if (isCheckout) {
                    if (currentModel.idleCOQueue.indexOf(currentCO) >= 0) {
                        currentModel.idleCOQueue.remove(currentCO);
                    }
                    currentModel.closedStaffQueue.enqueue(currentCO);
                } else {
                    if (currentModel.idleFDQueue.indexOf(currentFD) >= 0) {
                        currentModel.idleFDQueue.remove(currentFD);
                    }
                    currentModel.closedStaffQueue.enqueue(currentFD);
                }
            } else {

                int i = currentModel.getEventListSize();
                Event e = currentModel.getEventAt(i - 1);
                double newTime = e.getScheduledTime() + 1.0;

                currentModel.schedule(new CloseStaffEvent(currentModel, "Closed Staff Event", newTime ,entity));
            }

        }
    }
        private boolean checkClosedQueue (Entity e){

            if (e.getClass() == FoodDistribution.class) {
                int countFD = 0;
                for (int i = 0; i < currentModel.closedStaffQueue.size(); i++) {
                    Object current = currentModel.closedStaffQueue.get(i);
                    if (current.getClass() == FoodDistribution.class)
                        countFD += 1;
                }
                if (countFD < currentModel.NUM_FD - 1)
                    return true;
            } else {
                int countCO = 0;
                for (int i = 0; i < currentModel.closedStaffQueue.size(); i++) {
                    Object current = currentModel.closedStaffQueue.get(i);
                    if (current.getClass() == FoodDistribution.class)
                        countCO += 1;
                }
                if (countCO < currentModel.NUM_CO - 1) ;
                return true;
            }
            return false;
        }
    }

