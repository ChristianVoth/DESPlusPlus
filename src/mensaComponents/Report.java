package mensaComponents;

public class Report{

    MeanReport meanReport;
    MedianReport medianReport;
    Percentile25Report percentile25Report;
    Percentile75Report percentile75Report;

    Report(MeanReport mean, MedianReport median, Percentile25Report percentile25, Percentile75Report percentile75){

        this.meanReport = mean;
        this.medianReport = median;
        this.percentile25Report = percentile25;
        this.percentile75Report = percentile75;
    }

    public Report() {

    }
}
