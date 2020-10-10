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
 * NullEventException get thrown when an Event or Entity with a null Value gets inserted into a list
 */
public class NullEventException extends DESPluPlusException{
    private static final long serialVersionUID = 1L;

    /**
     * Constructor that creates a new NullEventException
     * @param errMessage: detailed errorMessage of the Exception
     */
    public NullEventException(ErrorMessage errMessage) {
        super(errMessage);
    }
}
