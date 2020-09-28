package Core;

import Core.Event;
import Core.EventListImpl;
import MensaComponents.Mensa;
import statistics.Reportable;

public abstract class Model {


    private EventListImpl eventListImpl = new EventListImpl();


    private double currentTime;

    private double stopTime;

    private boolean running = true;

    public boolean isOpen = true;



    public Model(String name) {

    }

    public abstract void init();



    public void schedule(Event e){

            eventListImpl.insert(e);

    }



    public void cancel(Event e){
        eventListImpl.remove(e);
    }

    public void run() {
        Event currentEvent;
        init();

            while (running && !eventListImpl.isEmpty()) {
                System.out.println(currentTime);
                eventListImpl.showList();


                currentEvent = eventListImpl.getFirst();
                currentTime = currentEvent.getTime();
                eventListImpl.removeFirst();






                currentEvent.eventRoutine();

                if (currentTime >= stopTime)
                    isOpen = false;
              //  System.out.println(currentTime);


            }
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
    public double getStopTime() {
        return stopTime;
    }


    public void report(){

    }

    public void registerReportable(Reportable r){

    }
}
