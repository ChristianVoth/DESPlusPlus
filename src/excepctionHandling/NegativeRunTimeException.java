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
public class NegativeRunTimeException extends DESPluPlusException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    public NegativeRunTimeException(ErrorMessage message) {
        super(message);
    }
}

