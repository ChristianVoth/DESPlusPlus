package excepctionHandling;


/**
 * NegativeRunTimeException
 *
 */
public class NegativeRunTimeException extends DESPluPlusException {
    private static final long serialVersionUID = 1L;

    public NegativeRunTimeException(ErrorMessage message) {
        super(message);
    }
}
