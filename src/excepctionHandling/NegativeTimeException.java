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
 * NegativeTimeException gets thrown when your picked date lies in the past
 */

public class NegativeTimeException extends DESPluPlusException {
    private static final long serialVersionUID = 1L;

    /**
     *  Constructor that creates a new NegativeRunTimeException
     * @param errMessage: detailed message of the Exception
     */
    public NegativeTimeException(ErrorMessage errMessage) {
        super(errMessage);
    }
}
