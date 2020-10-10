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
 * The class ErrorMessage is used to Log custom Messages when an Error occurred
 */

public class ErrorMessage extends Message {

    /**
     * A variable that stores the reason of a ErrorMessage
     */
    private String reason;

    /**
     * A variable that stores the prevention of a ErrorMessage
     */

    private String prevention;

    /**
     * A variable that stores the location of a ErrorMessage
     */

    private String location;

    /**
     *
     * @param origin : The model origin in which the ErrorMessage occurred
     * @param description : The title of the ErrorMessage
     * @param location : The location in which the ErrorMessage occurred
     * @param reason : The reason why an error message occurred
     * @param prevention : The prevention of the errorMessage
     * @param time: The current model Time
     */
    public ErrorMessage(Model origin, String description, String location,
                        String reason, String prevention, double time) {

        super(origin, description, time);

        this.location = location;
        this.prevention = prevention;
        this.reason = reason;
    }


    /**
     *
     * @return location of the ErrorMessage
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @return prevention of the ErrorMessage
     */
    public String getPrevention() {
        return prevention;
    }

    /**
     *
     * @return reason of the ErrorMessage
     */
    public String getReason() {
        return reason;
    }
}
