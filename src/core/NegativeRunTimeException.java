package core;

import expectionHandling.ErrorMessage;

public class NegativeRunTimeException extends DESPlusPlusException {
    public NegativeRunTimeException(ErrorMessage message) {
        super(message);
    }
}
