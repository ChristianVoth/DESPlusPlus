/**
 * Project: DES++
 * $Header: $
 * Author: Christian Voth, Lennart Eikens, Lars Batterham, Steffen Kleinhaus
 * Last Change:
 *      by: $Author:
 *      date: $Date:
 * Copyright (c): DES++, 2020
 */

package statisticsTest;

import core.Entity;
import core.Model;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import statistics.ListEntry;
import statistics.Queue;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
class QueueTest {

    /**
     *
     */
   Model model = new Model("TestModel") {
       @Override
       public void init() {

       }
   };

    /**
     *
     */
   Queue testQueue = new Queue(model, "QueueTest");


    @Test
    void dequeueSize() {
     for (int i = 0; i < 15; i++) {
      testQueue.enqueue(i);
     }

     testQueue.dequeue();

     assertEquals(14, testQueue.size());
    }

 @Test
 void dequeueGetFirst() {
  for (int i = 1; i < 15; i += 2) {
   testQueue.enqueue(i);
  }

  testQueue.dequeue();

  assertEquals(3, testQueue.getFirst());
 }

    @Test
    void removeSize() {
     Entity e = new Entity();
     Entity r = new Entity();

     testQueue.enqueue(e);
     testQueue.enqueue(r);

     testQueue.remove(e);

     assertEquals(1, testQueue.size());

    }

 @Test
 void removeGetFrist() {
  Entity e = new Entity();
  Entity r = new Entity();

  testQueue.enqueue(e);
  testQueue.enqueue(r);

  int listIndex = testQueue.indexOf(e);

  testQueue.remove(e);

  assertEquals(r, testQueue.getFirst());

 }

    @Test
    void getFirstNoRemove() {
     for (int i = 0; i < 6; i++) {

      testQueue.enqueue(i);

     }
     assertEquals(0, testQueue.getFirst());
    }

 @Test
 void getFirstWithRemove() {
  for (int i = 0; i < 6; i++) {

   testQueue.enqueue(i);
  }

  testQueue.dequeue();
  assertEquals(1, testQueue.getFirst());
 }

    @Test
    void size() {
     for (int i = 0; i < 10; i++) {
      testQueue.enqueue(i);
     }

     assertEquals(10, testQueue.size());
    }

    @Test
    void isEmptyTrue() {
      assertTrue(testQueue.isEmpty());
    }

    @Test
    void isEmptyFalse() {

     for (int i = 0; i < 5; i++) {
       testQueue.enqueue(i);
     }

     assertFalse(testQueue.isEmpty());


    }

    @Test
    void getMaxQueueLength() {

     for (int i = 0; i < 11; i++) {
      testQueue.enqueue(i);
     }

     assertEquals(11, testQueue.getMaxQueueLength());

    }

    @Disabled
    void getMeanWaitTime() {
     ListEntry le = new ListEntry(5, 3);
     ListEntry le1 = new ListEntry(4, 3);

     testQueue.enqueue(le);
     testQueue.enqueue(le1);

     assertEquals(5.5d, testQueue.getMeanWaitTime());

    }

    @Test
    void getCurrentQueueLength() {
     for (int i = 1; i < 10; i += 2) {
       testQueue.enqueue(i);
     }

     assertEquals(5d, testQueue.getCurrentQueueLength());
    }

    @Test
    void getMeanQueueLength() {
     for (int i = 1; i < 11; i++) {
       testQueue.enqueue(i);
     }

     assertEquals(5.5d, testQueue.getMeanQueueLength());
    }

    @Test
    void getReport() {
    }
}