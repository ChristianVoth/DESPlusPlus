package statistics;

public class WaitingTimeReport extends QueueReport {

    public double meanWaitingTime;
    public Quantiles quantiles;
    public double minimumWaitingTime;
    public double maximumWaitingTime;

    public WaitingTimeReport(double meanWaitingTime, Quantiles quantiles, double minimumWaitingTime, double maximumWaitingTime){
        this.meanWaitingTime = meanWaitingTime;
        this.quantiles = quantiles;
        this.minimumWaitingTime = minimumWaitingTime;
        this.maximumWaitingTime = maximumWaitingTime;
    }

}
