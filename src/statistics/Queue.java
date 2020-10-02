package statistics;

import core.Model;

import java.util.ArrayList;


public class Queue<Entity> extends Reportable{

    ArrayList<Entity> list = new ArrayList<>();
    private int maxQueue = 0;

    public Queue(Model parentModel, String name) {
        super(parentModel, name);
    }

    private Tally queueLength = new Tally(getModel(), this.getName() + "-Tally");
    private Accumulate waitingTime = new Accumulate(getModel(), this.getName() + "-Accumulate");

    public void enqueue(Entity e){


        list.add(e);
        queueLength.update(list.size());
        waitingTime.update(list.size());
    }

    public void dequeue(){

        if(list.isEmpty()) {
            return;
        }

            list.remove(0);
            queueLength.update(list.size());
            waitingTime.update(list.size());

    }

    public void remove(core.Entity e){

        int indexOfE = list.indexOf(e);

        list.remove(indexOfE);
        queueLength.update(list.size());
        waitingTime.update(list.size());
    }

    public Entity getFirst() {

       return list.get(0);
    }


    public int size(){

        return list.size();
    }

    public boolean isEmpty(){

        return list.isEmpty();
    }

    public int getMaxQueueLength() {

        return (int) queueLength.getMax();
    }

    public double getMeanWaitTime(){



        return waitingTime.getMean();
    }

    public int getCurrentQueueLength() {

        return list.size();
    }

    public double getMeanQueueLength(){

        return queueLength.getMean();
    }

    public String getReport(){
        return "Max Queue Length: " + getMaxQueueLength() + " Current Queue Length: " + getCurrentQueueLength()
                + " Mean Queue Length: " + getMeanQueueLength() + " Mean Wait Time: " + getMeanWaitTime() + "\n";
    }


}
