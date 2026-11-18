/** Concrete handler: username must be non-empty and at least 5 characters. */
public class UsernameValidator implements Validator {
    private Validator nextValidator;

    @Override
    public void setNextValidator(Validator nextValidator) {
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration request) throws ValidationException {
        String username = request.getUsername();
        if (username == null || username.trim().isEmpty()) {
            throw new ValidationException("username", "Username cannot be empty.");
        }
        if (username.trim().length() < 5) {
            throw new ValidationException("username", "Username must be at least 5 characters.");
        }
        System.out.println("Username validated.");
        if (nextValidator != null) {
            nextValidator.validate(request); // pass along the chain
        }
    }
}
