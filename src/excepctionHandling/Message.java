package excepctionHandling;

import core.Model;

public class Message {

    private String modelName;

    private String messageDiscription;

    private double messageTime;

    public Message(Model origin, String description, double time){

        if(origin == null){
            modelName = "----";
        }
        else {
            modelName = origin.getName();
        }
        if (description == null)
            messageDiscription = "----";
        else
            messageDiscription = description;

        messageTime = time;
    }

    public String getMessageDiscription(){
        return messageDiscription;
    }

    public String getModelName(){
        return modelName;
    }

    public double getMessageSentTime(){
        return messageTime;
    }

    public String toString(){

        return messageDiscription;
    }
}
