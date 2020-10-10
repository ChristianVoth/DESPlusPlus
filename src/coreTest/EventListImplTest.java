package coreTest;

import core.Entity;
import core.Event;
import core.EventListImpl;
import core.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventListImplTest {
    EventListImpl eventList = new EventListImpl();
    Entity ent = new Entity();
    Model model = new Model("TestModel") {
        @Override
        public void init() {

        }
    };

    Event e = new Event(model,"TestEvent",3,ent) {
        @Override
        protected void eventRoutine() {

        }
    };
    Event e1 = new Event(model,"TestEvent",3,ent) {
        @Override
        protected void eventRoutine() {

        }
    };
    Event e2 = new Event(model,"TestEvent",3,ent) {
        @Override
        protected void eventRoutine() {

        }
    };


    @BeforeEach
    void setUp() {
        eventList.insert(e);
        eventList.insert(e1);
        eventList.insert(e2);
    }

    @Test
    void insertWithSize() {
        Event event = new Event(model, "New TestEvent",4,ent) {
            @Override
            protected void eventRoutine() {

            }
        };

        eventList.insert(event);

        assertEquals(4, eventList.size());
    }

    @Test
    void getFirst() {

        assertEquals(e, eventList.getFirst());
    }

    @Test
    void removeFirstWithGetFirst() {
        eventList.removeFirst();

        assertEquals(e1,eventList.getFirst());
    }

    @Test
    void removeWithSize() {

        eventList.remove(e1);

        assertEquals(2,eventList.size());
    }

    @Test
    void size() {
        assertEquals(3,eventList.size());
    }

    @Test
    void isEmptyFalse() {
        assertFalse(eventList.isEmpty());
    }

    @Test
    void isEmptyTrue() {
        for (int i = 0; i < eventList.size(); i++) {
            eventList.removeFirst();
        }
        assertFalse(eventList.isEmpty());
    }
}