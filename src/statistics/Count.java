package statistics;

import Core.Model;

public class Count  extends Statistic  {
    private double value;
    private Reportable r;
    private double max;
    private double min;

    public Count(Model parentModel, String name) {

        super(parentModel, name);
    }

    @Override
    public void update(double val){
        this.value += val;

        if (this.value < this.min) {
            this.min = this.value;
        }

        if (this.value > this.max) {
            this.max = this.value;

        }

    }

    @Override
    public double getMax() {
        return max;
    }

    @Override
    public double getMin() {
        return min;
    }

    @Override
    public double getMax() {
        return max;
    }

    @Override
    public double getMin() {
        return min;
    }

    public void reset(){
       r.reset();

       this.min = 0d;
       this.max = 0d;
       this.value = 0d;
    }

    public double getValue() {
        return this.value;
    }

    public String getReport(){
        return "Current Value: " + getValue() + " Minimum: " + getMin() + " Maximum: " + getMax() +
                " Number of Observation: " + r.getObservations();
    }

}
