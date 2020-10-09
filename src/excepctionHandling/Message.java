/**
 * Project: DES++
 * $Header: $
 * Author: Christian Voth, Lennart Eikens, Lars Batterham, Steffen Kleinhaus
 * Last Change:
 *      by: $Author:
 *      date: $Date:
 * Copyright (c): DES++, 2020
 */

package excepctionHandling;

import core.Model;

/**
 *
 */
public class Message {

    /**
     *
     */
    private String modelName;

    /**
     *
     */
    private String messageDescription;

    /**
     *
     */
    private double messageTime;

    /**
     *
     * @param origin
     * @param description
     * @param time
     */
    public Message(Model origin, String description, double time) {

        if (origin == null) {
            modelName = "----";
        } else {
            modelName = origin.getName();
        }
        if (description == null) {
            messageDescription = "----";
        } else {
            messageDescription = description;

            messageTime = time;
        }
    }

    /**
     *
     */
    public Message() {

    }

    /**
     *
     */
    public String getMessageDescription() {
        return messageDescription;
    }

    /**
     *
     */
    public String getModelName() {
        return modelName;
    }

    /**
     *
     */
    public double getMessageSentTime() {
        return messageTime;
    }

    /**
     *
     */
    public String toString() {

        return messageDescription;
    }
}
