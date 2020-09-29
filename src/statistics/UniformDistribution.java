package statistics;

public class UniformDistribution extends Distribution{
    private Reportable r;
    private double max;
    private double min;
    private double sample;

    public UniformDistribution(long seed, double min, double max)
    {
        super(seed);
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
        return "Num. of observation: "
                + r.getObservations() + " Maximum: " + getMax() + " Minumum: " + getMin()
                + " Time of last reset: " + r.lastResetTime() + " Seed: " + getSeed();
    }

}
