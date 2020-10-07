package core;

import excepctionHandling.ErrorMessage;

public class NegativeRunTimeException extends DESPlusPlusException {
    public NegativeRunTimeException(ErrorMessage message) {
        super(message);
    }
}
