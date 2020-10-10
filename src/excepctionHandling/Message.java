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
 * Message is the base class for the ErrorMessages Class
 */
public class Message {

    /**
     * A variable that stores the modelName
     */
    private String modelName;

    /**
     * A variable that stores the messageDescription
     */
    private String messageDescription;

    /**
     *A variable that stores the Time at which the Message occurred
     */
    private double messageTime;

    /**
     *
     * @param origin : core.Model : The model this entity belongs to
     * @param description : java.lang.String: The description of the message
     * @param time : java.lang.Double: The current Time of the message
     */
    public Message(Model origin, String description, double time){

        if(origin == null){
            modelName = "----";
        }
        else {
            modelName = origin.getName();
        }
        if (description == null)
            messageDescription = "----";
        else
            messageDescription = description;

        messageTime = time;
    }

    /**
     * standard Message constructor
     */
    public Message() {

    }

    /**
     *
     * @returnthe messageDescription
     */
    public String getMessageDescription(){
        return messageDescription;
    }

    /**
     *
     * @return the messageName
     */
    public String getModelName(){
        return modelName;
    }

    /**
     *
     * @return the messageTime
     */
    public double getMessageSentTime(){
        return messageTime;
    }


    public String toString(){

        return messageDescription;
    }
}
