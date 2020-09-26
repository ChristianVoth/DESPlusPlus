import statistics.Reportable;

public abstract class Model {


    private EventListImpl eventListImpl = new EventListImpl();


    private double currentTime;

    private double stopTime;

    private boolean running = true;



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

            while (running && !eventListImpl.isEmpty() && currentTime < stopTime) {
                eventListImpl.showList();
                currentEvent = eventListImpl.getFirst();
                currentTime = currentEvent.getTime();
                eventListImpl.removeFirst();
                currentEvent.eventRoutine();
              //  System.out.println(currentTime);


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
