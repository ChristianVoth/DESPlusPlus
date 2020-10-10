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
 *DESPlusPlus is a custom Exception for the DESPLusPLus Framework
 */

public class DESPluPlusException extends RuntimeException {
    private static final long serialVersionUID = 2L;
    private ErrorMessage errorMessage;

    /**
     *
     * @param errMessage: ErrorMessage Object to get the description, location,
     *                    reason and prevention of an occurred ErrorMessage
     */
    public DESPluPlusException(ErrorMessage errMessage) {
        super("DESPluPlusException: " +errMessage.getMessageDescription() + "\n " + "Location: "
                + errMessage.getLocation() + " \n" + "Reason: " + errMessage.getReason()
                + "\n" + "Prevention: " + errMessage.getPrevention());
        this.errorMessage = errMessage;
    }

    /**
     *
     * @param errMessage: ErrorMessage Object to get the description, location,
     *      *                    reason and prevention of an occurred ErrorMessage
     * @param throwable: throws an Exception
     */
    public DESPluPlusException(ErrorMessage errMessage, Throwable throwable) {
        super("DESPluPlusException : " +errMessage.getMessageDescription() + "\n " + "Location: "
                + errMessage.getLocation() + " \n" + "Reason: " + errMessage.getReason()
                + "\n" + "Prevention: " + errMessage.getPrevention(),throwable);
        this.errorMessage = errMessage;
    }

    /**
     *
     * @return errorMessage
     */
    public ErrorMessage getErrorMessage() {
        return this.errorMessage;
    }

}