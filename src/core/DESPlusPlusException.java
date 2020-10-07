package core;

import excepctionHandling.ErrorMessage;

public class DESPlusPlusException extends RuntimeException {

private ErrorMessage errorMessage;

    public DESPlusPlusException(ErrorMessage message) {
        super("DESPlusPlusException\n"
                + "Description: " + message.getMessageDiscription() + "\n"
                + "Location:    " + message.getLocation() + "\n"
                + "Reason:      " + message.getReason() + "\n"
                + "Prevention:  " + message.getPrevention());
        errorMessage = message;
    }

    public ErrorMessage getErrorMessage() {
        return errorMessage;
    }
}

