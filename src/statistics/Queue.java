package statistics;

import core.LogHandler;
import core.Model;

import java.util.ArrayList;


public class Queue<Entity> extends Reportable{
    LogHandler myLogger = new LogHandler();

    ArrayList<Entity> list = new ArrayList<>();


    public Queue(Model parentModel, String name) {
        super(parentModel, name);
    }

    private Tally queueLength = new Tally(getModel(), this.getName() + "-Tally");
    private Accumulate waitingTime = new Accumulate(getModel(), this.getName() + "-Accumulate");

    public void enqueue(Entity e){
        if(e == null){
            myLogger.logger.severe("You tried to enqueue an Entitiy with the value of null");
            throw new NullPointerException();
        }

        list.add(e);
        queueLength.update(list.size());
        waitingTime.update(list.size());
        waitingTime.incTotalOfQueueEntries();
        //System.out.println(this.getName() + waitingTime.getTimeOfChanges());

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

        try {
            list.remove(indexOfE);
            queueLength.update(list.size());
            waitingTime.update(list.size());
        } catch (NullPointerException exception){
            myLogger.logger.severe("The Value of Entitiy e was null: " + e + " " + exception);
        }

    }

    public Entity getFirst() {

       return list.get(0);
    }

    public void setFirst(Entity e) {
        list.add(0, e);
        queueLength.update(list.size());
        waitingTime.update(list.size());
    }

    public Entity get(int i){
        return list.get(i);
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

    public double getMinimumWaitTime() {return waitingTime.getMinimumWaitTime();}

    public double getMaximumWaitTime() {return waitingTime.getMaximumWaitTime();}


    public QueueReport getReport(){
        return new QueueReport(queueLength.getReport(), waitingTime.getReport(), this);
    }


}
