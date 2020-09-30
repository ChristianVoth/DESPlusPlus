package statistics;

import java.util.ArrayList;


public class Queue<Entity>{

    ArrayList<Entity> list = new ArrayList<>();

    private Entity entity;
    private int maxQueue = 0;
    private Tally tally;
    private Accumulate accumulate;
    private Reportable reportable;

    public void enqueue(Entity e){

        list.add(e);
        tally.update(list.size());
        accumulate.update(list.size());

    }

    public Entity dequeue(){
        tally.update(list.size());
        accumulate.update(list.size());
        return list.remove(0);

    }

    public void remove(Core.Entity e){

        int indexOfE = list.indexOf(e);

        list.remove(indexOfE);
        tally.update(list.size());
        accumulate.update(list.size());
    }

    public Entity getFirst() {

       return list.get(0);
    }

    public void showList() {
        int count = 1;
        for (Entity e : list) {

            System.out.println(count + ": " + e);
            count++;
        }
    }


    public int size(){

        return list.size();
    }

    public boolean isEmpty(){

        return list.isEmpty();
    }

    public int getMaxQueueLength() {

        if (maxQueue < list.size()) {
            maxQueue = list.size();
        }

        return maxQueue;
    }

    public double getMeanWaitTime(){


        return accumulate.getMean();
    }

    public int getCurrentQueueLength() {

        return list.size();
    }

    public double getMeanQueueLength(){

        return tally.getMean();
    }

    public String getReport(){
        return "Max Queue Length: " + getMaxQueueLength() + " Current Queue Length: " + getCurrentQueueLength()
                + "Mean Queue Length: " + getMeanQueueLength() + "Mean Wait Time: " + getMeanWaitTime();
    }


}
