public abstract class Event extends DynamicObject{

    private Entity entity;
    public double time;
    private String eventName;

    public Event(Model parentModel, String name, double time,Entity entity) {
        super(parentModel, name);
        this.entity = entity;
        this.time = time;
        eventName = name;
    }

    public double getTime() {

        return time;
    }

    public Entity getEntity() {

        return entity;
    }

    abstract void eventRoutine();

    @Override
    public int compareTo(Event e) {

        return Double.compare(this.time,e.time);
    }
}
