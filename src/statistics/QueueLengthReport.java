package statistics;

public class QueueLengthReport extends QueueReport {

    public double meanQueueLength;
    public Quantiles quantiles;
    public double minimumQueueLength;
    public double maximumQueueLength;

    public QueueLengthReport(double meanQueueLength, Quantiles quantiles, double maximumQueueLength){
        this.meanQueueLength = meanQueueLength;
        this.quantiles = quantiles;
        this.minimumQueueLength = 0;
        this.maximumQueueLength = maximumQueueLength;
    }

}
