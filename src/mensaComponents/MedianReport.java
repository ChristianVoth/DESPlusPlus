package mensaComponents;

public class MedianReport {

    double studentFDQueue_medianWaitingTime;
    double studentFDQueue_medianQueueLength;

    double studentCOQueue_medianWaitingTime;
    double studentCOQueue_medianQueueLength;

    MedianReport(double studentFDQueue_medianQueueLength, double studentFDQueue_medianWaitingTime,
                double studentCOQueue_medianQueueLength, double studentCOQueue_medianWaitingTime){
        this.studentFDQueue_medianQueueLength = studentFDQueue_medianQueueLength;
        this.studentFDQueue_medianWaitingTime = studentFDQueue_medianWaitingTime;
        this.studentCOQueue_medianQueueLength = studentCOQueue_medianQueueLength;
        this.studentCOQueue_medianWaitingTime = studentCOQueue_medianWaitingTime;
    }
}
