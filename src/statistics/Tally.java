package statistics;

import core.Model;

import java.util.ArrayList;
import java.util.List;

public class Tally extends Statistic {

    private List<Double> tally = new ArrayList<>();
    public Tally(Model parentModel, String name) {
        super(parentModel, name);
    }

    public void update(double val){
        tally.add(val);
        super.update(val);
    }

    public double getMean(){
        double sum = 0;
        for(double val: tally){
            sum +=  val;
        }
        return sum / tally.size();
    }

    public double getStdDev(){
        double intermediateResult = 0;
        for (double val : tally){
            intermediateResult += (Math.pow(val - getMean(), 2));
        }
        return Math.sqrt(intermediateResult / tally.size());
    }

    @Override
    public String getReport() {
        return "Number of Observations: " + getObservations() + " Min: " + getMin() + ", Max: " + getMax()
                + ", Mean: " + getMean() + ", Standard Deviation: " + getStdDev()
                + " since last Reset at: " + getLastReset();
    }
}
