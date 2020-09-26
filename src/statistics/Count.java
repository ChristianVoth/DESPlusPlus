package statistics;

public class Count  extends Statistic  {
    private double value;
    private Reportable r;

    public void update(double val){
        if(val < 0 ){
            value -= val;
        }
        value += val;
    }

    public double getValue(){
        return this.value;
    }

    public String getReport(){
        return "Current Value: " + getValue() + " Minimum: " + getMin() + " Maximum: " + getMax() +
                " Number of Observation: " +r.getObservations();
    }

}
