import statistics.Reportable;

public abstract class Model {


    private EventListImpl eventListImpl;

    private double currentTime;

    private double stopTime;

    private boolean running;

    public Model(String name) {

    }

    abstract void init();



    public void schedule(Event e){

            eventListImpl.insert(e);

    }

    public void cancel(Event e){
        eventListImpl.remove(e);
    }

    public void run() {
        Event currentEvent;
        init();
        while (running) {
            while (!eventListImpl.isEmpty() || currentTime >= stopTime) {

                currentEvent = eventListImpl.getFirst();
                currentEvent.eventRoutine();
                currentTime = currentEvent.getTime();
                eventListImpl.removeFirst();
            }
        }
        //report
        //finish
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

    public void registerReportable(Reportable r){

    }
}
