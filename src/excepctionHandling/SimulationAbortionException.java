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
 * SimulationAbortionException gets thrown when a simulation gets abort because of an Error
 *
 */
public class SimulationAbortionException extends DESPluPlusException {
    private static final long serialVersionUID = 1L;

    /**
     * Constructor that creates an new SimulationAbortionException
     * @param errorMessage: detailed errorMessage of the Exception
     */
    public SimulationAbortionException(ErrorMessage errorMessage){
        super(errorMessage);
    }

}
