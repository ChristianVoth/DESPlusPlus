package mensaComponents;

public class MeanReport {

    double studentFDQueue_meanLength;
    double studentFDQueue_meanWaitingTime;

    double studentCOQueue_meanLength;
    double studentCOQueue_meanWaitingTime;

/*
    double studentFDQueue_25PercentileWaitingTime;
    double studentFDQueue_25PercentileQueueLength;

    double studentCOQueue_25PercentileWaitingTime;
    double studentCOQueue_25PercentileQueueLength;

    double studentCOQueue_75PercentileWaitingTime;
    double studentCOQueue_75PercentileQueueLength;

    double studentFDQueue_75PercentileWaitingTime;
    double studentFDQueue_75PercentileQueueLength;
*/
    MeanReport(double studentFDQueue_meanLength, double studentFDQueue_meanWaitingTime,
               double studentCOQueue_meanLength, double studentCOQueue_meanWaitingTime){
        this.studentFDQueue_meanLength = studentFDQueue_meanLength;
        this.studentFDQueue_meanWaitingTime = studentFDQueue_meanWaitingTime;
        this.studentCOQueue_meanLength = studentCOQueue_meanLength;
        this.studentCOQueue_meanWaitingTime = studentCOQueue_meanWaitingTime;
    }
}
