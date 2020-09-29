package statistics;

public class UniformDistribution extends Distribution{
    private Reportable r;
    private double max;
    private double min;

    public UniformDistribution(long seed) {
        super(seed);
    }

    public double sample() {
        return 0;
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
