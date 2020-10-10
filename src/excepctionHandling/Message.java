package excepctionHandling;

import core.Model;

/**
 * Message
 */
public class Message {

    private String modelName;

    private String messageDescription;

    private double messageTime;

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

    public Message() {

    }

    public String getMessageDescription(){
        return messageDescription;
    }

    public String getModelName(){
        return modelName;
    }

    public double getMessageSentTime(){
        return messageTime;
    }

    public String toString(){

        return messageDescription;
    }
}
