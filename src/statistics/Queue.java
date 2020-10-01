package statistics;

import Core.Model;
import MensaComponents.Mensa;
import MensaComponents.Student;

import java.util.ArrayList;
import java.util.List;


public class Queue<Entity>{

    ArrayList<Entity> list = new ArrayList<>();
    List<Double> currentWaitingTimeList = new ArrayList<Double>();


    private Entity entity;
    private Mensa model;
    private int maxQueue = 0;
    private Reportable reportable;
    private double timeSinceLastUpdate = 0;

    public void enqueue(Entity e){

        list.add(e);
    }

    public Entity dequeue(){

        return list.remove(0) ;
    }

    public void remove(Core.Entity e){

        int indexOfE = list.indexOf(e);

        list.remove(indexOfE);
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


        return 0;
    }

    public int getCurrentQueueLength() {

        return list.size();
    }

    public double getMeanQueueLength(){

        return 0;
    }

    public String getReport(){
        return "Max Queue Length: " + getMaxQueueLength() + " Current Queue Length: " + getCurrentQueueLength()
                + "Mean Queue Length: " + getMeanQueueLength() + "Mean Wait Time: " + getMeanWaitTime();
    }


}
