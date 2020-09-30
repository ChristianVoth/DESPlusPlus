package statistics;


import Core.Model;

import java.util.Collections;
import java.util.List;

public class Tally extends Statistic {

    private List<Double> tallyList = null;
    private Reportable reportable;
    private double standardDeviation;
    private double mean;


    public Tally(Model parentModel, String name) {
        super(parentModel, name);

    }


    public void update(double val){
        tallyList.add(val);
        reportable.incObservations();
    }

    @Override
    public double getMax() {

        return Collections.max(tallyList);
    }

    @Override
    public double getMin() {

        return Collections.min(tallyList);
    }

    public double getMean(){
        double sum = 0;
        if(tallyList == null) {
            System.out.println("List is empty.");
        } else {
            if(reportable.getObservations() == 1) {
                return reportable.getObservations();
            } else {
                for (double val: tallyList) {
                    sum += val;
                }
                mean = sum / tallyList.size();
            }
        }
        return mean;
    }

    public double getStdDev() {
        double stdDev = 0;
        if(tallyList == null) {
            System.out.println("Can't get StdDev. The list is empty.");
        } else {
            for(double val: tallyList) {
                stdDev += Math.pow(val - getMean(),2);
            }
            standardDeviation =  Math.sqrt( stdDev / tallyList.size());
        }
        return standardDeviation;
    }

    public void reset() {
        reportable.reset();
        this.mean = 0d;
        this.standardDeviation = 0d;
    }

    public String getReport(){
        return "Maximum: " +getMax() + "Minimum: " + getMin() + "Num. of Observations: " + reportable.getObservations()
                + "Last reset Time: " + reportable.lastResetTime() + "Mean: " + getMean() +" Standard Deviation: " + getStdDev();
    }
}
