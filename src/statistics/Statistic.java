package statistics;

abstract class Statistic  {
    private Reportable r;
    private double min;
    private double max;

    public Statistic(double min, double max) {
        this.min = min;
        this.max = max;
    }

    public void update(double val){  }

    public double getMax(){
        return this.max;
    }

    public double getMin(){
        return this.min;
    }


}
