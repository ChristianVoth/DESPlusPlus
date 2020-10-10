/**
 * Project: DES++
 * $Header: $
 * Author: Christian Voth, Lennart Eikens, Lars Batterham, Steffen Kleinhaus
 * Last Change:
 *      by: $Author:
 *      date: $Date:
 * Copyright (c): DES++, 2020
 */

package statistics;

import core.LogHandler;
import core.Model;
import java.util.ArrayList;

/**
 * Class resembles standard FIFO-Queue, using java.util.Arraylist.
 * @param <Entity> : all entities be part of the queueing system
 */
public class Queue<Entity> extends Reportable {

    /**
     * Reference to the Logger.
     */
    LogHandler myLogger = new LogHandler();

    /**
     * List containing the queued entities.
     */
    ArrayList<Entity> list = new ArrayList<>();

    /**
     *
     * @param parentModel : model this queue belongs to
     * @param name : name of this queue
     */
    public Queue(Model parentModel, String name) {
        super(parentModel, name);
    }

    /**
     * Tally object collecting data without time-weighing.
     */
    private Tally queueLength = new Tally(getModel(),
            this.getName() + "-Tally");

    /**
     * Accumulate object collecting time-weighed data.
     */
    private Accumulate waitingTime = new Accumulate(getModel(),
            this.getName() + "-Accumulate");

    /**
     * Used when adding a entity to the Queue. Throws NullPointerException
     * when entity is invalid. Updates the tally object as well as the
     * accumulate object with the updated queue size.
     * @param e : is the passed on entity
     */
    public void enqueue(Entity e) {
        try{
            list.add(e);
            queueLength.update(list.size());
            waitingTime.update(list.size());
            waitingTime.incTotalOfQueueEntries();
        } catch (NullPointerException ext ){
            myLogger.logger.severe("You tried to enqueue an Entity with a Value of null: "
                    + getName() + " Exception: " + ext);
        }

    }

    /**
     * Used when removing the first entity from the queue.
     * Updates the tally and accumulate object with the updated
     * queue size.
     */
    public void dequeue() {

        if (list.isEmpty()) {
            return;
        }

            list.remove(0);
            queueLength.update(list.size());
            waitingTime.update(list.size());

    }

    /**
     * Used to remove a specific entity from the queue.
     * Updates the corresponding tally and accumulate objects.
     * @param e : entity which is to be removed
     */
    public void remove(core.Entity e) {

        int indexOfE = list.indexOf(e);

        try {
            list.remove(indexOfE);
            queueLength.update(list.size());
            waitingTime.update(list.size());
        } catch (NullPointerException exception) {
            myLogger.logger.severe("You tried to remove a Entity with the Value of Null: " + getName()
                    + "Exception: " + exception);
        }

    }

    /**
     * Used to get a reference to the first entity of the queue.
     * @return first entity of queue
     */
    public Entity getFirst() {

       return list.get(0);
    }


    /**
     *
     * @param i : index of entity to be returned
     * @return entity at given index
     */
    public Entity get(int i) {
        return list.get(i);
    }

    /**
     *
     * @return queue length
     */
    public int size() {

        return list.size();
    }

    /**
     *
     * @return true if queue is empty
     */
    public boolean isEmpty() {

        return list.isEmpty();
    }

    /**
     *
     * @param entity : check index for given entity
     * @return index of entity
     */
    public int indexOf(Entity entity) {
        return list.indexOf(entity);
    }

    /**
     *
     * @return max queue length
     */
    public int getMaxQueueLength() {

        return (int) queueLength.getMax();
    }

    /**
     *
     * @return mean wait time
     */
    public double getMeanWaitTime() {

        return waitingTime.getMean();
    }

    /**
     *
     * @return current queue length
     */
    public int getCurrentQueueLength() {

        return list.size();
    }

    /**
     * Adds default entry to accumulate object.
     */
    public void initQueue() {
        waitingTime.initQueue();
    }

    /**
     *
     * @return QueueReport containing a separate report for
     * the queue length and waiting times
     */
    public QueueReport getQueueReport() {
        return new QueueReport(queueLength.getQueueReport(),
                waitingTime.getQueueReport(), this);
    }

    @Override
    public Report getReport() {
        return null;
    }


}
