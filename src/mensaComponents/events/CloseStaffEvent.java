package mensaComponents.events;

import core.Entity;
import core.Event;
import core.Model;
import mensaComponents.Checkout;
import mensaComponents.FoodDistribution;
import mensaComponents.Mensa;


public class CloseStaffEvent extends Event {

    private Mensa currentModel;

    private Checkout currentCO;

    private FoodDistribution currentFD;

    private boolean isCheckout;

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
    }


    @Override
    protected void eventRoutine() {

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
    }
}
