package statistics;

import core.Model;

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



    public QueueReport getReport(){
        return null;
    }

}
