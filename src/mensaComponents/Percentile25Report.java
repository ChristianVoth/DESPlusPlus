package mensaComponents;

public class Percentile25Report {


    double studentFDQueue_25WaitingTime;
    double studentFDQueue_25QueueLength;

    double studentCOQueue_25WaitingTime;
    double studentCOQueue_25QueueLength;

    Percentile25Report(double studentFDQueue_25QueueLength, double studentFDQueue_25WaitingTime,
                 double studentCOQueue_25QueueLength, double studentCOQueue_25WaitingTime){
        this.studentFDQueue_25QueueLength = studentFDQueue_25QueueLength;
        this.studentFDQueue_25WaitingTime = studentFDQueue_25WaitingTime;
        this.studentCOQueue_25QueueLength = studentCOQueue_25QueueLength;
        this.studentCOQueue_25WaitingTime = studentCOQueue_25WaitingTime;
    }
}