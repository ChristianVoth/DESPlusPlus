public abstract class Model {

    private EventListImpl eventListImpl;

    private double currentTime;

    private double stopTime;

    private boolean running;

    public Model(String name) {

    }

    abstract void init();

    public void schedule(Event e){
        while (running) {
            eventListImpl.insert(e);
        }

    }

    public void cancel(Event e){

    }

    public void run() {

        init();
    }

    public void setStopTime(double time){

        stopTime = time;

    }

    public void stop() {

        running = false;

    }

    public double currentTime(){

        return currentTime;

    }

    public void report(){

    }
    /* public void registerReportable(Reportable r){

    }*/
}
