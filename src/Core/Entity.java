package Core;

import Core.DynamicObject;

public class Entity extends DynamicObject {

    private String entityName;

    public Entity(String name) {
        super(name);
        this.entityName = name;

    }



    @Override
    public int compareTo(Event e) {
        return super.compareTo(e);
    }
}


