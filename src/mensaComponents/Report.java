package mensaComponents;

public class Report {

    double studentFDQueue_meanLength;
    double studentFDQueue_meanWaitingTime;

    double studentCOQueue_meanLength;
    double studentCOQueue_meanWaitingTime;

    Report(double studentFDQueue_meanLength, double studentFDQueue_meanWaitingTime,
           double studentCOQueue_meanLength, double studentCOQueue_meanWaitingTime){
        this.studentFDQueue_meanLength = studentFDQueue_meanLength;
        this.studentFDQueue_meanWaitingTime = studentFDQueue_meanWaitingTime;
        this.studentCOQueue_meanLength = studentCOQueue_meanLength;
        this.studentCOQueue_meanWaitingTime = studentCOQueue_meanWaitingTime;
    }
}
