package excepctionHandling;

public class SimulationAbortionException extends DESPluPlusException {
    private static final long serialVersionUID = 1L;


    public SimulationAbortionException(ErrorMessage errorMessage){
        super(errorMessage);
    }

}
