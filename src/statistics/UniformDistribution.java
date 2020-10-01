package statistics;

import Core.Model;

public class UniformDistribution extends Distribution{
    private double max;
    private double min;
    private double sample;

    public UniformDistribution(Model parentModel, String name, long seed, double min, double max)
    {
        super(parentModel, name, seed);
        this.min = min;
        this.max = max;
    }

    public double sample() {
        return sample = min + ((max-min) * nextRandomDouble());

    }


    public double getMin(){
        return this.min;
    }

    public double getMax (){
        return this.max;
    }



    public String getReport(){
        return "Distribution Parameters: Min: " + getMin() + ", Max: " + getMax()  + "Seed for Generator: " + getSeed()
                + "Number of Observations: " + getObservations() + "Time at last reset: " + getLastReset();
    }

}
