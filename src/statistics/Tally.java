package statistics;


import java.util.List;

public class Tally extends Statistic {
    private List<Double> tallyList = null;
    private Reportable r;
    private double stdDev = 0;

    public Tally(double min, double max) {
        super(min, max);

    }

    public void update(double val){
        tallyList.add(val);
        r.incObservations();

    }

    public double getMean(){
        double sum = 0;
        if(tallyList == null){
            System.out.println("List is empty.");
        } else{
            if(r.getObservations() == 1){
                return r.getObservations();
            } else{
                for (double val: tallyList) {
                    sum += val;
                }
                return sum / tallyList.size();
            }
        }
        return -1;
    }

    public double getStdDev(){
        if(tallyList == null){
            System.out.println("Can't get StdDev. The list is empty.");
        }else{
            for(double val: tallyList){
                stdDev += Math.pow(val - getMean(),2);
            }
            return Math.sqrt( stdDev/ tallyList.size());
        }
        return -1;
    }

    public String getReport(){
        return "Maximum: " +getMax() + "Minimum: " + getMin() + "Num. of Observations: " + r.getObservations()
                + "Last reset Time: " + r.lastResetTime() + "Mean: " + getMean() +" Standard Deviation: " + getStdDev();
    }
}
