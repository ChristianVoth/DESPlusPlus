package excepctionHandling;

/**
 * NegativeTimeException
 */

public class NegativeTimeException extends DESPluPlusException {
    private static final long serialVersionUID = 1L;

    public NegativeTimeException(ErrorMessage errMessage) {
        super(errMessage);
    }
}
