package statistics;

import Core.Model;

public abstract class Reportable {
    private Model model;
    private int observation;

    abstract String getReport();


    public void reset(){
        observation = 0;
    }

    public int getObservations(){
        return observation;
    }

    public int incObservations(){
        return observation++;
    }

    public double lastResetTime(){
        return model.currentTime();
    }
}
