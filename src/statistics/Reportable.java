package statistics;

abstract class Reportable {
    private int observation;

    abstract String getReport();

    public void reset(){

    }

    public int getObservations(){

        return observation;
    }

    public int incObservations(){
        return observation;
    }

    public double lastResetTime(){
        return 0;
    }
}
