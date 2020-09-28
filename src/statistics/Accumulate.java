package statistics;

public class Accumulate extends Statistic {

    private Reportable r;
    private double mean;
    private double stdDev;

    public Accumulate(double min, double max, double mean, double stdDev) {
        super(min, max);
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

    public String getReport(){
        return "Maximum: " +getMax() + "Minimum: " + getMin() + "Num. of Observations: " + r.getObservations()
                + "Last reset Time: " + r.lastResetTime() + "Mean: " + getMean() +" Standard Deviation: " + getStdDev();
    }
}
