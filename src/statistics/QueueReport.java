package statistics;

public class QueueReport{

    public QueueLengthReport queueLengthReport;
    public WaitingTimeReport waitingTimeReport;
    public Queue queue;

    QueueReport(QueueLengthReport queueLengthReport, WaitingTimeReport waitingTimeReport, Queue queue){

        this.queueLengthReport = queueLengthReport;
        this.waitingTimeReport = waitingTimeReport;
        this.queue = queue;
    }

    public QueueReport() {

    }
}
