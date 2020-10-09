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
 *
 * @param <Entity>
 */
public class Queue<Entity> extends Reportable {

    /**
     *
     */
    LogHandler myLogger = new LogHandler();

    /**
     *
     */
    ArrayList<Entity> list = new ArrayList<>();

    /**
     *
     * @param parentModel
     * @param name
     */
    public Queue(Model parentModel, String name) {
        super(parentModel, name);
    }

    /**
     *
     */
    private Tally queueLength = new Tally(getModel(),
            this.getName() + "-Tally");

    /**
     *
     */
    private Accumulate waitingTime = new Accumulate(getModel(),
            this.getName() + "-Accumulate");

    /**
     *
     * @param e
     */
    public void enqueue(Entity e) {
        if (e == null) {
            myLogger.logger.severe("You tried to enqueue "
                    + "an Entitiy with the value of null");
            throw new NullPointerException();
        }

        list.add(e);
        queueLength.update(list.size());
        waitingTime.update(list.size());
        waitingTime.incTotalOfQueueEntries();
    }

    /**
     *
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
     *
     * @param e
     */
    public void remove(core.Entity e) {

        int indexOfE = list.indexOf(e);

        try {
            list.remove(indexOfE);
            queueLength.update(list.size());
            waitingTime.update(list.size());
        } catch (NullPointerException exception) {
            myLogger.logger.severe("The Value of Entitiy e was null: "
                    + e + " " + exception);
        }

    }

    /**
     *
     * @return
     */
    public Entity getFirst() {

       return list.get(0);
    }

    /**
     *
     * @param e
     */
    public void setFirst(Entity e) {
        list.add(0, e);
        queueLength.update(list.size());
        waitingTime.update(list.size());
    }

    /**
     *
     * @param i
     * @return
     */
    public Entity get(int i) {
        return list.get(i);
    }

    /**
     *
     * @return
     */
    public int size() {

        return list.size();
    }

    /**
     *
     * @return
     */
    public boolean isEmpty() {

        return list.isEmpty();
    }

    /**
     *
     * @param entity
     * @return
     */
    public int indexOf(Entity entity) {
        return list.indexOf(entity);
    }

    /**
     *
     * @return
     */
    public int getMaxQueueLength() {

        return (int) queueLength.getMax();
    }

    /**
     *
     * @return
     */
    public double getMeanWaitTime() {

        return waitingTime.getMean();
    }

    /**
     *
     * @return
     */
    public int getCurrentQueueLength() {

        return list.size();
    }

    /**
     *
     * @return
     */
    public double getMeanQueueLength() {
        return queueLength.getMean();
    }

    /**
     *
     * @return
     */
    public double getMinimumWaitTime() {
        return waitingTime.getMinimumWaitTime();
    }

    /**
     *
     * @return
     */
    public double getMaximumWaitTime() {
        return waitingTime.getMaximumWaitTime();
    }

    /**
     *
     * @return
     */
    public QueueReport getReport() {
        return new QueueReport(queueLength.getReport(),
                waitingTime.getReport(), this);
    }


}
