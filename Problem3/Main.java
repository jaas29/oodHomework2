import javax.swing.SwingUtilities;

/**
 * CLIENT. Builds the chain:
 *   Username -> Password -> Email -> Phone
 * and opens the Swing form. Run with "--test" for console test cases (no window).
 */
public class Main {

    /** Creates the validators and links them. Returns the head of the chain. */
    public static Validator buildChain() {
        Validator username = new UsernameValidator();
        Validator password = new PasswordValidator();
        Validator email = new EmailValidator();
        Validator phone = new PhoneNumberValidator();

        username.setNextValidator(password);
        password.setNextValidator(email);
        email.setNextValidator(phone);
        return username;
    }

    public static void main(String[] args) {
        Validator chain = buildChain();
        if (args.length > 0 && args[0].equals("--test")) {
            runConsoleTests(chain);
            return;
        }
        SwingUtilities.invokeLater(() -> new RegistrationForm(chain).setVisible(true));
    }

    /** Same chain, no UI: shows a pass and each kind of failure. */
    private static void runConsoleTests(Validator chain) {
        UserRegistration[] cases = {
            new UserRegistration("testuser", "Password1", "user@example.com", "1234567890"),
            new UserRegistration("testuser", "Password1", "user@example.com", ""),
            new UserRegistration("abc", "Password1", "user@example.com", ""),
            new UserRegistration("testuser", "password1", "user@example.com", ""),
            new UserRegistration("testuser", "Password1", "user.example.com", ""),
            new UserRegistration("testuser", "Password1", "user@example.com", "12345abcde"),
        };
        for (int i = 0; i < cases.length; i++) {
            System.out.println("--- Test " + (i + 1) + " ---");
            try {
                chain.validate(cases[i]);
                System.out.println("Registration passed all validations.");
            } catch (ValidationException e) {
                System.out.println("Validation failed [" + e.getField() + "]: " + e.getMessage());
            }
        }
    }
}
