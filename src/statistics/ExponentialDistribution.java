package statistics;

public class ExponentialDistribution extends Distribution {

    public double mean;
    private double sample;

    public ExponentialDistribution(long seed, double mean)
    {
        super(seed);
        this.mean = mean;

    }

    public double sample() {
        return sample = Math.log(1 - nextRandomDouble()) / (-mean);

    }

     double getMean(){
        return this.mean;

    }

    public String getReport(){

        return "";
    }


}
