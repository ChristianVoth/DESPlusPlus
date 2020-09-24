package statistics;

abstract class Statistic  {
    private Reportable reportable;

    public void update(double val){

    }

    public double getMin(){
        return 0;
    }

    public double getMax(){
        return 0;
    }
}
