/** CHAIN OF RESPONSIBILITY - handler interface. */
public interface Validator {
    /** Links this validator to the next one in the chain. */
    void setNextValidator(Validator nextValidator);

    /** Checks one rule; if it passes, forwards the request to the next validator. */
    void validate(UserRegistration request) throws ValidationException;
}
