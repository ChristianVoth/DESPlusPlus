package Core;



public abstract class Event extends DynamicObject {

    private Entity entity;
    private String eventName;

    public Event(Model parentModel, String name, double time, Entity entity) {
        super(parentModel, name);
        this.entity = entity;
        this.scheduledTime = time;
        this.eventName = name;
        this.numberOfEntities = 1;
    }

    public double getTime() {

        return scheduledTime;
    }

    public Entity getEntity() {

        return entity;
    }

    protected abstract void eventRoutine();

    @Override
    public int compareTo(Event e) {

        return Double.compare(this.scheduledTime,e.scheduledTime);
    }
}
