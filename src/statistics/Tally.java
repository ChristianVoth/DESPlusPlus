package statistics;

import core.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tally extends Statistic {

    private double median;
    private double firstQuantil;
    private List<Double> tally = new ArrayList<>();
    private double thirdQuantil;

    public Tally(Model parentModel, String name) {
        super(parentModel, name);
    }
    private Sorting sorting = new Sorting();

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
        double stdDev;
        double intermediateResult = 0;
        for (double val : tally){
            intermediateResult += (Math.pow(val - getMean(), 2));
        }

        stdDev = Math.sqrt(intermediateResult / tally.size());

        return Math.round(stdDev * 10000d) / 10000d;
    }

    public double getMedian() {
        sorting.sortList(tally);

        if(tally.size() % 2 != 0) {
            median = tally.get(tally.size() / 2);
        } else {
            median = (tally.get((tally.size() / 2)) + tally.get(tally.size() / 2 - 1)) * 0.5d;
        }

        return  median;
    }

    public double getFirstQuantil(){
        double npFirstQuantil = tally.size()*0.25d;
        sorting.sortList(tally);

        if(tally.size() % 2 != 0) {
            firstQuantil = tally.get((int) npFirstQuantil);
        } else {
            firstQuantil = (tally.get((int) npFirstQuantil) + tally.get((int) npFirstQuantil - 1)) * 0.5d;
        }
        return firstQuantil;
    }

    public double getThridQuantil(){
        double npThirdQuantil = tally.size()*0.75d;
        sorting.sortList(tally);

        if(tally.size() % 2 != 0) {
            thirdQuantil = tally.get((int) npThirdQuantil);
        } else {
            thirdQuantil = (tally.get((int) npThirdQuantil) + tally.get((int) npThirdQuantil - 1)) * 0.5d;
        }
        return thirdQuantil;
    }



    @Override
    public String getReport() {
        return "Number of Observations: " + getObservations() + " Min: " + getMin() + " Max: " + getMax()
                + " Mean: " + getMean() + " Standard Deviation: " + getStdDev()
                + " since last Reset at: " + getLastReset() + " Median: " + getMedian();
    }
}
