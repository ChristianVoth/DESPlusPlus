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

/**
 *
 */
public class DESPluPlusException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 2L;

    /**
     *
     */
    private ErrorMessage errorMessage;

    /**
     *
     * @param errMessage
     */
    public DESPluPlusException(ErrorMessage errMessage) {
        super("NegativeSimTimeException: " + errMessage.getMessageDescription()
                + "\n " + "Location: "
                + errMessage.getLocation() + " \n" + "Reason: "
                + errMessage.getReason() + "\n" + "Prevention: "
                + errMessage.getPrevention());
        this.errorMessage = errMessage;
    }

    /**
     *
     * @param errMessage
     * @param throwable
     */
    public DESPluPlusException(ErrorMessage errMessage, Throwable throwable) {
        super("NegativeSimTimeException : " + errMessage.getMessageDescription()
                + "\n " + "Location: " + errMessage.getLocation() + " \n"
                + "Reason: " + errMessage.getReason() + "\n" + "Prevention: "
                + errMessage.getPrevention(), throwable);
        this.errorMessage = errMessage;
    }

    /**
     *
     */
    public ErrorMessage getErrorMessage() {
        return this.errorMessage;
    }
}
