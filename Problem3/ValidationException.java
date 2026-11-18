/**
 * Thrown by a validator when its rule fails. It remembers WHICH field failed
 * so the UI can put the message next to that field.
 */
public class ValidationException extends Exception {
    private final String field;

    public ValidationException(String field, String message) {
        super(message);
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
