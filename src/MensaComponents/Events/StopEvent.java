package MensaComponents.Events;

import Core.Entity;
import Core.Event;
import Core.Model;
import MensaComponents.Mensa;

public class StopEvent extends Event {
    private Mensa currentModel;
    public StopEvent(Model parentModel, String name, double time, Entity entity) {
        super(parentModel, name, time, entity);
        this.currentModel = (Mensa)parentModel;
    }

    @Override
    protected void eventRoutine() {
        currentModel.isOpen = false;

       /* for (int i = 0 ; i < currentModel.studentQueue.size() + currentModel.studentCOQUeue.size(); i++) {
            currentModel.schedule(new StudentArrivalEvent(currentModel, "Lappen" + i, currentModel.currentTime(), null));
            currentModel.schedule(new StudentGotFoodEvent(currentModel, "Torpedo" + i, currentModel.currentTime() + 0.1, null, null));
        }*/
        //for (int i = 0 ; i < currentModel.studentCOQUeue.size(); i++)
          //  currentModel.schedule(new StudentGotFoodEvent(currentModel, "Torpedo" + i, currentModel.currentTime(), null, null));

    }
}
