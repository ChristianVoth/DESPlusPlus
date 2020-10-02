package mensaComponents;

import core.Entity;

public class Student extends Entity {
    public Student(String name) {
        super(name);
    }

    public Student(String name, int priority) {
        super(name, priority);
    }
}
