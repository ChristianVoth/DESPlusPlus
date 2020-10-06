package mensaComponents;

public class Report {

    MeanReport meanReport;
    MedianReport medianReport;
    Report(MeanReport mean, MedianReport median){

        this.meanReport = mean;
        this.medianReport = median;
    }
}
