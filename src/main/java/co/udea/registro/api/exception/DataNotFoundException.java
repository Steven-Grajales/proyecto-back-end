package co.udea.registro.api.exception;

public class DataNotFoundException extends GeneralRuntimeException {
    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String message) {
        super(message);
    }

    public DataNotFoundException(String message, String translationKey) {
        super(message, translationKey);
    }
}
