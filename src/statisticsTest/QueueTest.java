package statisticsTest;

import core.Entity;
import core.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import statistics.Queue;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Model model = new Model("TestModel") {
        @Override
        public void init() {

        }
    };

    Queue testQueue = new Queue(model, "TestQueue");
    Entity e = new Entity();
    Entity e1 = new Entity();
    Entity e2 = new Entity();
    Entity eNull = null;



    @BeforeEach
    void setUp() {

        testQueue.enqueue(e);
        testQueue.enqueue(e1);
        testQueue.enqueue(e2);

    }


    @Test
    void enqueueWithSize() {
        Entity e3 = new Entity();
        testQueue.enqueue(e3);
        assertEquals(4, testQueue.size());

    }

    @Test
    void dequeueWithSize() {
        testQueue.dequeue();

        assertEquals(2,testQueue.size());

    }

    @Test
    void removeWithGetFirst() {
        testQueue.remove(e);

        assertEquals(e1, testQueue.getFirst());
    }

    @Test
    void getFirst() {

        assertEquals(e, testQueue.getFirst());
    }

    @Test
    void get() {
        assertEquals(e2, testQueue.get(2));
    }

    @Test
    void size() {

        assertEquals(3, testQueue.size());
    }

    @Test
    void isEmptyFalse() {

        assertFalse(testQueue.isEmpty());
    }

    @Test
    void isEmptyTrue() {

        testQueue.dequeue();
        testQueue.dequeue();
        testQueue.dequeue();

        assertTrue(testQueue.isEmpty());
    }

    @Test
    void indexOf() {

        assertEquals(2, testQueue.indexOf(e2));
    }

    @Test
    void getMaxQueueLength() {

        assertEquals(3, testQueue.getMaxQueueLength());
    }

    @Test
    void getMeanWaitTime() {
        testQueue.initQueue();

        assertEquals(0,testQueue.getMeanWaitTime());
    }

    @Test
    void getCurrentQueueLength() {

        assertEquals(3, testQueue.getCurrentQueueLength());
    }


}