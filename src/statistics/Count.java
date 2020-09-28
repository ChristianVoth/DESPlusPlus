package statistics;

public class Count  extends Statistic  {
    private double value;
    private Reportable r;
    private double max;
    private double min;

    public Count(double value, double max, double min) {
        super(min, max);
        this.value = 0d;
    }

    public void update(double val){
        if(val < 0 ){
            this.value -= val;
        }
        this.value += val;

        if (this.value < this.min) {
            this.min = this.value;
        }

        if (this.value > this.max) {
            this.max = this.value;

        }
    }

    public double getMax(){return this.max;}

    public double getMin(){return this.min;}

    public double getValue(){
        return this.value;
    }

    public String getReport(){
        return "Current Value: " + getValue() + " Minimum: " + getMin() + " Maximum: " + getMax() +
                " Number of Observation: " + r.getObservations();
    }

}
