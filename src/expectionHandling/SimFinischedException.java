package expectionHandling;

public class SimFinischedException extends NegativeSimTimeException {
    private static final long serialVersionID = 1L;
    public SimFinischedException(ErrorMessage errMessage) {
        super(errMessage);
    }

}
