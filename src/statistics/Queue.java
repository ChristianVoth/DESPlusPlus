package statistics;

import core.Model;

import java.util.ArrayList;


public class Queue<Entity> extends Reportable{

    ArrayList<Entity> list = new ArrayList<>();


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

    public Entity get(int i){
        return  list.get(i);
    }


    public int size(){

        return list.size();
    }

    public boolean isEmpty(){

        return list.isEmpty();
    }
    public int indexOf(Entity entity) {
        return list.indexOf(entity);
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

    public double getMedianQueueLength(){
        return queueLength.getMedian();
    }

    public double getMedianWaitingTime(){
        return waitingTime.getMedian();
    }

    public double get25QueueLength() { return queueLength.getFirstQuantil();}

    public double get25WaitingTime() { return waitingTime.getFirstQuantil();}

    public double get75QueueLength() { return queueLength.getThridQuantil();}

    public double get75WaitingTime() { return waitingTime.getThridQuantil();}

    public String getReport(){
        return getName() + "Max Queue Length: " + getMaxQueueLength() + " Current Queue Length: " + getCurrentQueueLength()
                + " Mean Queue Length: " + getMeanQueueLength() + " Mean Wait Time: " + getMeanWaitTime() +
                " Median Queue Length: " + getMedianQueueLength() + " Median Wait Time: " + getMedianWaitingTime() + "\n";
    }


}
