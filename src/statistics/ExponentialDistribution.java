package statistics;

import Core.Model;

public class ExponentialDistribution extends Distribution {

    public double mean;
    private double sample;

    public ExponentialDistribution(Model parentModel,String name, long seed, double mean)
    {
        super(parentModel,seed, name);
        this.mean = mean;
    }

    public double sample() {
        return sample = Math.log(1 - nextRandomDouble()) / (-mean);

    }

    public double getMean(){
        return this.mean;

    }


    public String getReport(){
        return "";
    }


}
