/*package mensaComponents.events;

import core.Entity;
import core.Event;
import core.Model;
import mensaComponents.Mensa;

public class StopEvent extends Event {
    private Mensa currentModel;
    public StopEvent(Model parentModel, String name, double time, Entity entity) {
        super(parentModel, name, time, entity);
        this.currentModel = (Mensa)parentModel;
    }

    @Override
    protected void eventRoutine() {
        currentModel.getIsOpen() = false;

        for (int i = 0 ; i < currentModel.studentQueue.size() + currentModel.studentCOQUeue.size(); i++) {
            currentModel.schedule(new StudentArrivalEvent(currentModel, "Lappen" + i, currentModel.currentTime(), null));
            currentModel.schedule(new StudentGotFoodEvent(currentModel, "Torpedo" + i, currentModel.currentTime() + 0.1, null, null));
        }
        //for (int i = 0 ; i < currentModel.studentCOQUeue.size(); i++)
          //  currentModel.schedule(new StudentGotFoodEvent(currentModel, "Torpedo" + i, currentModel.currentTime(), null, null));

    }
}
*/
