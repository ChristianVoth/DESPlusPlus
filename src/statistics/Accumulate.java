package statistics;

import Core.Model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Accumulate extends Statistic {

    private HashMap<Double, Double> accumulateMap;
    private Reportable r;
    private double mean;
    private double timeOfChange;
    private double standardDeviation;

    public Accumulate(Model parentModel, String name) {
        super(parentModel, name);

    }


    public void update(double val){
        accumulateMap.put(val,timeOfChange);
    }

    @Override
    public double getMax() {
        return 0;
    }

    @Override
    public double getMin() {
        return 0;
    }


    public double getMean(){
        double sum = 0;

        if(accumulateMap == null){
            System.out.println("List is empty.");
        } else {
            if(r.getObservations() == 1) {
                return r.getObservations();
            } else {
                for (Map.Entry val: accumulateMap.entrySet()) {

                }

                mean = sum / accumulateMap.size();
            }
        }
        return mean;
    }

    public double getStdDev(){
      /*  double stdDev = 0;
        if(accumulateMap == null){
            System.out.println("Can't get StdDev. The list is empty.");
        }else{
            for(double val: accumulateMap){
                stdDev += Math.pow(val - getMean(),2);
            }
            standardDeviation = Math.sqrt(stdDev/ accumulateMap.size());
        }

        return standardDeviation;
    }*/ return 0; }

    public void reset() {
        r.reset();
        this.mean = 0d;
        this.standardDeviation = 0d;
    }



    public String getReport(){
        return "Maximum: " +getMax() + "Minimum: " + getMin() + "Num. of Observations: " + r.getObservations()
                + "Last reset Time: " + r.lastResetTime() + "Mean: " + getMean() +" Standard Deviation: " + getStdDev();
    }
}
