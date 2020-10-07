package statistics;

import core.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class Accumulate extends Statistic{


    private Sorting sorting = new Sorting();
    private List<ListEntry> accumulate = new ArrayList<>();

    private List<Double> timeOfChanges = new ArrayList<>();

    private double median;
    private double firstQuantil;
    private double thirdQuantil;

    public Accumulate(Model parentModel, String name) {
        super(parentModel, name);
    }

    public void update(double val){
        ListEntry entry = new ListEntry(val, getModel().currentTime());
        accumulate.add(entry);
        super.update(val);
    }

    public double getMean(){
            double timeWeightedSum = 0;
            double sumWeights = 0;

            for(int i = 0; i < accumulate.size() - 1; i++){
               timeWeightedSum += accumulate.get(i).value * (accumulate.get(i+1).timeOfChange - accumulate.get(i).timeOfChange);

            }
            for (int i = 0; i < accumulate.size() - 1; i++){
                sumWeights += accumulate.get(i + 1).timeOfChange - accumulate.get(i).timeOfChange;
            }
            if (sumWeights == 0)
                return 0;
            return timeWeightedSum / sumWeights;
        }

    public double getStdDev(){

        double intermediateResult = 0;

        for (int i = 0; i < accumulate.size(); i++){
        intermediateResult += (Math.pow(accumulate.get(i).value - getMean(), 2));
        }
        return Math.sqrt(intermediateResult / accumulate.size());
    }

    public double getMedian() {

        for(int i = 0; i < accumulate.size() - 1; i++){

            double timeDifference = accumulate.get(i).value * (accumulate.get(i+1).timeOfChange - accumulate.get(i).timeOfChange);
            timeOfChanges.add(timeDifference);

        }

        sorting.sortList(timeOfChanges);

        System.out.println(timeOfChanges);


        if(timeOfChanges.size() % 2 != 0) {
            median = timeOfChanges.get(timeOfChanges.size() / 2);
        } else {
            median = (timeOfChanges.get((timeOfChanges.size() / 2)) + timeOfChanges.get(timeOfChanges.size() / 2 - 1)) * 0.5d;
        }

        return  median;
    }

    public double getFirstQuantil(){
        double npFirstQuantil = timeOfChanges.size()*0.25d;
        sorting.sortList(timeOfChanges);

        if(timeOfChanges.size() % 2 != 0) {
            firstQuantil = timeOfChanges.get((int) npFirstQuantil);
        } else {
            firstQuantil = (timeOfChanges.get((int) npFirstQuantil) + timeOfChanges.get((int) npFirstQuantil - 1)) * 0.5d;
        }
        return firstQuantil;
    }

    public double getThridQuantil(){
        double npThirdQuantil = timeOfChanges.size()*0.75d;
        sorting.sortList(timeOfChanges);

        if(timeOfChanges.size() % 2 != 0) {
            thirdQuantil = timeOfChanges.get((int) npThirdQuantil);
        } else {
            thirdQuantil = (timeOfChanges.get((int) npThirdQuantil) + timeOfChanges.get((int) npThirdQuantil - 1)) * 0.5d;
        }
        return thirdQuantil;
    }



    @Override
    public String getReport() {
        return "Number of Observations: " + getObservations() + " Min: " + getMin() + ", Max: " + getMax()
                + ", Weighted Mean: " + getMean() + ", Weighted Standard Deviation: " + getStdDev()
                + " since last Reset at: " + getLastReset();
    }
}
