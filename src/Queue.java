import java.util.ArrayList;


public class Queue<Entity> {

    ArrayList<Entity> list = new ArrayList<>();

    public void enqueue(Entity e){

        list.add(e);

    }

    public Entity dequeue(){

       return list.remove(0);
    }

    public void remove(Entity e){

        int indexOfE = list.indexOf(e);

        list.remove(indexOfE);

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

    public int getMaxQueueLength(){
        return 0;
    }

    public double getMeanWaitTime(){
        return 9;
    }

    public int getCurrentQueueLength(){
        return 9;
    }

    public double getMeanQueueLength(){
        return 0;
    }

    public String getReport(){
        return "";
    }
}
