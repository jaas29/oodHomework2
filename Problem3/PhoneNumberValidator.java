/**
 * Concrete handler (optional field): if a phone number is given,
 * it must be exactly 10 digits and only numbers. An empty phone is allowed.
 */
public class PhoneNumberValidator implements Validator {
    private Validator nextValidator;

    @Override
    public void setNextValidator(Validator nextValidator) {
        this.nextValidator = nextValidator;
    }

    @Override
    public void validate(UserRegistration request) throws ValidationException {
        String phone = request.getPhoneNumber();
        if (phone == null || phone.trim().isEmpty()) {
            System.out.println("Phone number skipped (optional).");
        } else if (!phone.trim().matches("\\d{10}")) {
            throw new ValidationException("phone", "Phone must be exactly 10 digits, numbers only.");
        } else {
            System.out.println("Phone number validated.");
        }
        if (nextValidator != null) {
            nextValidator.validate(request);
        }
    }
}
