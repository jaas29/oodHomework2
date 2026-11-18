/** Concrete handler: email must look like username@domain.com. */
public class EmailValidator implements Validator {
    private static final String EMAIL_REGEX = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$";
    private Validator nextValidator;

    @Override
    public void setNextValidator(Validator nextValidator) {
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration request) throws ValidationException {
        String email = request.getEmail();
        if (email == null || !email.trim().matches(EMAIL_REGEX)) {
            throw new ValidationException("email", "Invalid email (e.g. username@domain.com).");
        }
        System.out.println("Email validated.");
        if (nextValidator != null) {
            nextValidator.validate(request);
        }
    }
}
