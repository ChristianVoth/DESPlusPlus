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
public class ErrorMessage extends Message {

    /**
     *
     */
    private String reason;

    /**
     *
     */
    private String prevention;

    /**
     *
     */
    private String location;

    /**
     *
     * @param origin
     * @param ddescription
     * @param llocation
     * @param rreason
     * @param pprevention
     * @param time
     */
    public ErrorMessage(Model origin, String ddescription, String llocation,
                        String rreason, String pprevention, double time) {

        super(origin, ddescription, time);

        this.location = llocation;
        this.prevention = pprevention;
        this.reason = rreason;
    }

    /**
     *
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     */
    public String getPrevention() {
        return prevention;
    }

    /**
     *
     */
    public String getReason() {
        return reason;
    }
}
