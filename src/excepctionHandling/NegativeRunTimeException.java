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
 * NegativeRunTimeException gets thrown when an Event can't be scheduled
 *
 */
public class NegativeRunTimeException extends DESPluPlusException {
    private static final long serialVersionUID = 1L;

    /**
     *Constructor that creates a new NegativeRunTimeException
     * @param message: detailed message of the Exception
     */
    public NegativeRunTimeException(ErrorMessage message) {
        super(message);
    }
}
