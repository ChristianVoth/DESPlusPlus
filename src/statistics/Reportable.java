package statistics;

import Core.Model;

public abstract class Reportable {
    private Model model;
    private int observation;
    private double timeAtReset;
    private Count count;



    public abstract String getReport();


    public void reset(){
        timeAtReset = model.currentTime();
        observation = 0;

    }

    public int getObservations(){

        return observation;
    }

    public int incObservations(){

        return observation++;
    }

    public double lastResetTime(){

        return timeAtReset;
    }
}
