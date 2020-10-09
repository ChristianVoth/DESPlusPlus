package statistics;

import core.BasicModelComponent;
import core.Model;

public abstract class Reportable extends BasicModelComponent {
    private int observations;
    private double lastReset;

    public Reportable(Model parentModel, String name) {
        super(parentModel, name);
    }


    public abstract QueueReport getReport();


    public void reset(){
        lastReset = getModel().currentTime();
        observations = 0;

    }

    public int getObservations(){

        return observations;
    }

    public int incObservations(){

        return observations++;
    }

    public double getLastReset(){

        return lastReset;
    }
}
