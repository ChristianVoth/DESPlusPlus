package statistics;


import Core.Model;
import MensaComponents.Mensa;

import java.util.Collections;
import java.util.List;

public class Tally extends Statistic  {

    private List<Double> tallyList = null;
    private Reportable reportable;
    private double standardDeviation;
    private double mean;
    private Mensa model;
    private double timeSinceLastUpdate;


    public Tally(Model parentModel, String name) {
        super(parentModel, name);
        this.model = (Mensa)parentModel;
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

        public void updateTally() {
           /* if(tallyList == null) {
                update(0);
                timeSinceLastUpdate = model.currentTime();
            } else {

                }


                /*for (double val : tallyList) {
                    tallyList.remove(val);
                    val += (model.currentTime() - timeSinceLastUpdate);
                    update(val);
                }
                update(0);
                timeSinceLastUpdate = model.currentTime();
            }*/

                for (int i = 0; i < tallyList.size(); i++) {
                    tallyList.set(i, tallyList.get(i) + (model.currentTime() - timeSinceLastUpdate));
                }
        }

        public void insertIntoTally() {
            if (tallyList != null) {
                updateTally();
            }
            update(0);
            timeSinceLastUpdate = model.currentTime();
        }

        public double removeFromTally(){
               double toRemove = tallyList.get(0);
                updateTally();
                tallyList.remove(0);

                return toRemove;
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

    public boolean isEmpty(){
        if(tallyList.size() == 0) {
            return true;
        } else {
            return false;
        }
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
