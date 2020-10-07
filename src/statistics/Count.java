package statistics;

import core.Model;

import java.util.List;

public class Count extends Statistic {

    private double value = 0;


    public Count(Model parentModel, String name) {
        super(parentModel, name);
    }

    public void update(double val){
        value += val;
        super.update(value);
    }



    public double getValue(){
        return value;
    }

    public void reset(){
        super.reset();
        value = 0;
    }

    @Override
    public String getReport() {
        return "Count: Number of Observations: " + getObservations() + " Min: " + getMin() + " Max: " + getMax() + " since last Reset at: " + getLastReset();
    }
}
