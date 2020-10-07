package excepctionHandling;

public class NegativeSimTimeException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private ErrorMessage errorMessage;

    public NegativeSimTimeException(ErrorMessage errMessage) {
        super("NegativeSimTimeExecption: " +errMessage.getMessageDiscription() + "\n " + "Location: "
                + errMessage.getLocation() + " \n" + "Reason: " + errMessage.getReason()
                + "\n" + "Prevention: " + errMessage.getPrevention());
        this.errorMessage = errMessage;
    }

    public NegativeSimTimeException(ErrorMessage errMessage, Throwable throwable) {
        super("NegativeSimTimeExecption: " +errMessage.getMessageDiscription() + "\n " + "Location: "
                + errMessage.getLocation() + " \n" + "Reason: " + errMessage.getReason()
                + "\n" + "Prevention: " + errMessage.getPrevention(),throwable);
        this.errorMessage = errMessage;
    }


    public ErrorMessage getErrorMessage() {
        return this.errorMessage;
    }

}