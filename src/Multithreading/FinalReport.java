package Multithreading;

public class FinalReport {

    public double meanQueueLength1;
    public double meanQueueLength2;

    public double medianQueueLength1;
    public double medianQueueLength2;

    public double maxQueueLength1;
    public double maxQueueLength2;

    public double meanWaitingTime1;
    public double meanWaitingTime2;

    public double medianWaitingTime1;
    public double medianWaitingTime2;

    public double maxWaitingTime1;
    public double maxWaitingTime2;

    public FinalReport(double meanQL1, double meanQL2, double medQL1, double medQL2,
                       double maxQL1, double maxQL2, double meanQW1, double meanQW2,
                       double medQW1, double medQW2, double maxQW1, double maxQW2) {

        this.meanQueueLength1 = meanQL1;
        this.meanQueueLength2 = meanQL2;

        this.medianQueueLength1 = medQL1;
        this.medianQueueLength2 = medQL2;

        this.maxQueueLength1 = maxQL1;
        this.maxQueueLength2 = maxQL2;

        this.meanWaitingTime1 = meanQW1;
        this.meanWaitingTime2 = meanQW2;

        this.medianWaitingTime1 = medQW1;
        this.medianWaitingTime2 = medQW2;

        this.maxWaitingTime1 = maxQW1;
        this.maxWaitingTime2 = maxQW2;
    }


}
