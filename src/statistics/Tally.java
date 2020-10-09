package statistics;


import core.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Tally extends Statistic {

    private List<Double> tally = new ArrayList<>();


    public Tally(Model parentModel, String name) {
        super(parentModel, name);

    }

    private Sorting sorting = new Sorting();

    public void update(double val){
        tally.add(val);
        super.update(val);
    }

    public double getMaxQueueLength(){
        sorting.sortList(tally);
        return tally.get(tally.size() - 1);
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

        return stdDev;
    }
    /*

    public double getMedian() {
        sorting.sortList(tally);

        if(tally.size() % 2 != 0) {
            median = tally.get(tally.size() / 2);
        } else {
            median = (tally.get((tally.size() / 2)) + tally.get(tally.size() / 2 - 1)) * 0.5d;
        }

        return  median;
    }


    public double getFirstQuantile(){
        double npFirstQuantile = tally.size()*0.25d;
        Collections.sort(tally);

        if(tally.size() % 2 != 0) {
            firstQuantile = tally.get((int) npFirstQuantile);
        } else {
            firstQuantile = (tally.get((int) npFirstQuantile) + tally.get((int) npFirstQuantile - 1)) * 0.5d;
        }
        return firstQuantile;
    }

    public double getThirdQuantile(){
        double npThirdQuantile = tally.size()*0.75d;
        Collections.sort(tally);

        if(tally.size() % 2 != 0) {
            firstQuantile = tally.get((int) npThirdQuantile);
        } else {
            firstQuantile = (tally.get((int) npThirdQuantile) + tally.get((int) npThirdQuantile - 1)) * 0.5d;
        }
        return firstQuantile;
    }
    */
    public Quantiles getQuantiles(){
        Collections.sort(tally);
        int npFirstQuantile = (int) (tally.size()*0.25d);
        int npThirdQuantile = (int) (tally.size()*0.75d);

        double median;
        double firstQuantile;
        double thirdQuantile;


        if(tally.size() % 2 != 0) {
            median = tally.get(tally.size() / 2);
            firstQuantile = tally.get(npFirstQuantile);
            thirdQuantile = tally.get(npThirdQuantile);
        } else {
            median = (tally.get(tally.size() / 2) + tally.get(tally.size() / 2 - 1)) * 0.5d;
            firstQuantile = (tally.get(npFirstQuantile) + tally.get(npFirstQuantile - 1)) * 0.5d;
            thirdQuantile = (tally.get(npThirdQuantile) + tally.get(npThirdQuantile - 1)) * 0.5d;

        }

        return new Quantiles(median, firstQuantile, thirdQuantile);


    }

    public List getTally(){
        return tally;
    }



    @Override
    public QueueLengthReport getReport() {
        return new QueueLengthReport(getMean(), getQuantiles(), getMaxQueueLength());

    }
}
