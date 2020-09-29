package statistics;

import Core.Model;

public class Accumulate extends Statistic {

    private Reportable r;
    private double mean;
    private double stdDev;

    public Accumulate(Model parentModel, String name, double mean, double stdDev) {
        super(parentModel, name);

        this.mean = 0d;
        this.stdDev = 0d;
    }


    public void update(double val){

    }



   public double getMean(){
        return this.mean;
    }

    public double getStdDev(){
        return this.stdDev;
    }

    public void reset() {
        r.reset();
        this.mean = 0d;
        this.stdDev = 0d;
    }

    public String getReport(){
        return "Maximum: " +getMax() + "Minimum: " + getMin() + "Num. of Observations: " + r.getObservations()
                + "Last reset Time: " + r.lastResetTime() + "Mean: " + getMean() +" Standard Deviation: " + getStdDev();
    }
}
