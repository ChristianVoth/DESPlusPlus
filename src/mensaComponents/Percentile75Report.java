package mensaComponents;

public class Percentile75Report {


    double studentFDQueue_75WaitingTime;
    double studentFDQueue_75QueueLength;

    double studentCOQueue_75WaitingTime;
    double studentCOQueue_75QueueLength;

    Percentile75Report(double studentFDQueue_75QueueLength, double studentFDQueue_75WaitingTime,
                       double studentCOQueue_75QueueLength, double studentCOQueue_75WaitingTime){
        this.studentFDQueue_75QueueLength = studentFDQueue_75QueueLength;
        this.studentFDQueue_75WaitingTime = studentFDQueue_75WaitingTime;
        this.studentCOQueue_75QueueLength = studentCOQueue_75QueueLength;
        this.studentCOQueue_75WaitingTime = studentCOQueue_75WaitingTime;
    }
}