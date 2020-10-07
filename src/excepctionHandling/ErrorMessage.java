package excepctionHandling;

import core.Model;

public class ErrorMessage extends Message {

    private String reason;

    private String prevention;

    private String location;

    public ErrorMessage(Model origin, String description, String location,
                        String reason, String prevention, double time) {

        super(origin, description, time);

        this.location = location;
        this.prevention = prevention;
        this.reason = reason;
    }

    public String getLocation() {
        return location;
    }

    public String getPrevention() {
        return prevention;
    }

    public String getReason() {
        return reason;
    }
}
