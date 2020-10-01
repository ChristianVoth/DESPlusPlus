package statistics;

import Core.Model;

public class ExponentialDistribution extends Distribution {

    private double mean;
    private double sample;

    public ExponentialDistribution(Model parentModel,String name, long seed, double mean)
    {
        super(parentModel,name, seed);
        this.mean = mean;
    }

    public double sample() {
        return sample = Math.log(1 - nextRandomDouble()) / (-mean);

    }

    public double getMean(){
        return this.mean;

    }

    // if wenn kein Seed angegeben
    public String getReport(){
        return "Distribution Parameters: " + mean + "Seed for Generator: " + getSeed()
                + "Number of Observations: " + getObservations() + "Time at last reset: " + getLastReset();
    }


}
