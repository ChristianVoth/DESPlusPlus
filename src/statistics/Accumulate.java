package statistics;

import core.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




public class Accumulate extends Statistic{


    private Sorting sorting = new Sorting();
    private List<ListEntry> accumulate = new ArrayList<>();
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
        sorting.sortListEntry(accumulate);


        if(accumulate.size() % 2 != 0) {
            median = accumulate.get(accumulate.size() / 2).value;
        } else {
            median = (accumulate.get((accumulate.size() / 2)).value + accumulate.get(accumulate.size() / 2 - 1).value) * 0.5d;
        }

        return  median;
    }

    public double getFirstQuantil(){
        double npFirstQuantil = accumulate.size()*0.25d;
        sorting.sortListEntry(accumulate);

        if(accumulate.size() % 2 != 0) {
            firstQuantil = accumulate.get((int) npFirstQuantil).value;
        } else {
            firstQuantil = (accumulate.get((int) npFirstQuantil).value + accumulate.get((int) npFirstQuantil - 1).value) * 0.5d;
        }
        return firstQuantil;
    }

    public double getThridQuantil(){
        double npThirdQuantil = accumulate.size()*0.75d;
        sorting.sortListEntry(accumulate);

        if(accumulate.size() % 2 != 0) {
            thirdQuantil = accumulate.get((int) npThirdQuantil).value;
        } else {
            thirdQuantil = (accumulate.get((int) npThirdQuantil).value + accumulate.get((int) npThirdQuantil - 1).value) * 0.5d;
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
