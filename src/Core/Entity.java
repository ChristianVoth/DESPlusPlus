package Core;

import Core.DynamicObject;

public class Entity extends DynamicObject {

    public Entity(String name) {
        super(name);
    }

    @Override
    public int compareTo(Event e) {
        return super.compareTo(e);
    }
}
