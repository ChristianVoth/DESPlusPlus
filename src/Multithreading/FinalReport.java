package Multithreading;

/**
 *
 */
public class FinalReport {

    /**
     * A variable to store the mean food distrubtion queue length
     */
    public double meanQueueLength1;

    /**
     * A variable to store the mean checkout queue length
     */
    public double meanQueueLength2;

    /**
     * A variable to store the median food distribution queue length
     */
    public double medianQueueLength1;

    /**
     * A variable to store the median checkout queue length
     */
    public double medianQueueLength2;

    /**
     * A variable to store the max food distribution queue length
     */
    public double maxQueueLength1;

    /**
     * A variable to store the max checkout queue length
     */
    public double maxQueueLength2;

    /**
     * A variable to store the mean waiting time for food distribution queue.
     */
    public double meanWaitingTime1;

    /**
     * A variable to store the mean waiting time for checkout queue.
     */
    public double meanWaitingTime2;

    /**
     * A variable to store the median waiting time for food distribution queue.
     */
    public double medianWaitingTime1;

    /**
     * A variable to store the median waiting time for checkout queue.
     */
    public double medianWaitingTime2;

    /**
     * A variable to store max waiting time for food distribution queue.
     */
    public double maxWaitingTime1;

    /**
     * A variable to store max waiting time for checkout queue.
     */
    public double maxWaitingTime2;

    /**
     * Final Report Constructor
     * @param meanQL1
     *      double : The mean food distribution queue length
     * @param meanQL2
     *      double : The mean checkout queue length
     * @param medQL1
     *      double : The median food distribution queue length
     * @param medQL2
     *      double : The median checkout queue length
     * @param maxQL1
     *      double : The max food distribution queue length
     * @param maxQL2
     *      double : The max checkout queue length
     * @param meanQW1
     *      double : The mean food distribution queue waiting time
     * @param meanQW2
     *      double : The mean checkout queue waiting time
     * @param medQW1
     *      double : The median food distribution queue waiting time
     * @param medQW2
     *      double : The median checkout queue waiting time
     * @param maxQW1
     *      double : The max food distribution queue waiting time
     * @param maxQW2
     *      double : The max checkout queue waiting time
     */
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
