/** Concrete handler: 8+ chars, at least one uppercase, one lowercase, one digit. */
public class PasswordValidator implements Validator {
    private Validator nextValidator;

    @Override
    public void setNextValidator(Validator nextValidator) {
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration request) throws ValidationException {
        String password = request.getPassword();
        if (password == null || password.length() < 8) {
            throw new ValidationException("password", "Password must be at least 8 characters.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new ValidationException("password", "Password needs an uppercase letter.");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new ValidationException("password", "Password needs a lowercase letter.");
        }
        if (!password.matches(".*[0-9].*")) {
            throw new ValidationException("password", "Password needs a digit.");
        }
        System.out.println("Password validated.");
        if (nextValidator != null) {
            nextValidator.validate(request);
        }
    }
}
