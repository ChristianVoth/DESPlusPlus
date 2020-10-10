package excepctionHandling;

public class NullEventException extends DESPluPlusException{
    private static final long serialVersionUID = 1L;

    public NullEventException(ErrorMessage errMessage) {
        super(errMessage);
    }
}
