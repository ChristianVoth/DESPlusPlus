
public abstract class DynamicObject extends BasicModelComponent implements Comparable<Event> {

    int priority;
    double currentTime;

    public DynamicObject(Model parentModel, String name) {
        super(parentModel, name);
    }

    public DynamicObject(String name) {
        super();
    }


    public int getPriority() {

        return priority;
    }

    public void setPriority(int p){

        priority = p;
    }

    public double currentTime(){

        return currentTime;
    }


    @Override
    public int compareTo(Event e) {
        return 0;
    }
}
