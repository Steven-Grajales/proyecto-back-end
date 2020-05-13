package co.udea.registro.api.exception;

public class MissDataException extends GeneralRuntimeException {
    private static final long serialVersionUID = 1L;

    public MissDataException(String message) {
        super(message);
    }

    public MissDataException(String message, String translationKey) {
        super(message, translationKey);
    }
}
