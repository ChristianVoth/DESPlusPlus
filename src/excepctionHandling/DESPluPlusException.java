package excepctionHandling;

public class DESPluPlusException extends RuntimeException {
    private static final long serialVersionUID = 2L;
    private ErrorMessage errorMessage;

    public DESPluPlusException(ErrorMessage errMessage) {
        super("DESPluPlusException: " +errMessage.getMessageDescription() + "\n " + "Location: "
                + errMessage.getLocation() + " \n" + "Reason: " + errMessage.getReason()
                + "\n" + "Prevention: " + errMessage.getPrevention());
        this.errorMessage = errMessage;
    }

    public DESPluPlusException(ErrorMessage errMessage, Throwable throwable) {
        super("DESPluPlusException : " +errMessage.getMessageDescription() + "\n " + "Location: "
                + errMessage.getLocation() + " \n" + "Reason: " + errMessage.getReason()
                + "\n" + "Prevention: " + errMessage.getPrevention(),throwable);
        this.errorMessage = errMessage;
    }


    public ErrorMessage getErrorMessage() {
        return this.errorMessage;
    }

}