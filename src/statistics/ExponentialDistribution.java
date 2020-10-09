package statistics;

import core.Model;

public class ExponentialDistribution extends Distribution {

    private double mean;
    private double sample;

    public ExponentialDistribution(Model parentModel,String name, long seed, double mean)
    {
        super(parentModel,name, seed);
        this.mean = mean;
    }

    public double sample() {
        return sample = -Math.log(nextRandomDouble()) * mean;
    }

    public double getMean(){
        return this.mean;
    }

    // if wenn kein Seed angegeben
    public QueueReport getReport(){
        return null;
    }


}
