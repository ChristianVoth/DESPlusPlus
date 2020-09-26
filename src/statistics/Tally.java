package statistics;


import java.util.List;

public class Tally extends Statistic {
    private List<Double> tallyList;
    private Reportable r;

    public void update(double val){
        tallyList.add(val);
        r.incObservations();
    }

    public double getMean(){
        double sum = 0;
        for (double val: tallyList) {
            sum += val;
        }
        return sum / tallyList.size();
    }

    public double getStdDev(){
        double sum = 0;
        double stdDev = 0;

        for(double val: tallyList){
            sum += val;
        }

        for(double val: tallyList){
            stdDev += Math.pow(val - getMean(),2);
        }
        return Math.sqrt( stdDev/ tallyList.size());
    }

    public String getReport(){
        return "Maximum: " +getMax() + "Minimum: " + getMin() + "Num. of Observations: " + r.getObservations()
                + "Last reset Time: " + r.lastResetTime() + "Mean: " + getMean() +" Standard Deviation: " + getStdDev();
    }
}
