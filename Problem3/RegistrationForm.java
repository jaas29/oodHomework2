import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Java Swing UI. Collects input, sends it through the validator chain,
 * and shows the error next to the field that failed.
 */
public class RegistrationForm extends JFrame {
    private final JTextField usernameField = new JTextField(20);
    private final JPasswordField passwordField = new JPasswordField(20);
    private final JTextField emailField = new JTextField(20);
    private final JTextField phoneField = new JTextField(20);
    private final Map<String, JLabel> errorLabels = new HashMap<>();
    private final JLabel statusLabel = new JLabel(" ");
    private final Validator chain;

    public RegistrationForm(Validator chain) {
        super("User Registration");
        this.chain = chain;

        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));
        addRow(form, 0, "Username:", usernameField, "username");
        addRow(form, 1, "Password:", passwordField, "password");
        addRow(form, 2, "Email:", emailField, "email");
        addRow(form, 3, "Phone (optional):", phoneField, "phone");

        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> onRegister());

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setBorder(BorderFactory.createEmptyBorder(0, 12, 12, 12));
        bottom.add(registerButton, BorderLayout.WEST);
        bottom.add(statusLabel, BorderLayout.CENTER);

        add(form, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
    }

    /** One row = label | input | red error label (the error sits next to its field). */
    private void addRow(JPanel panel, int row, String text, JComponent input, String key) {
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(4, 4, 4, 4);
        c.anchor = GridBagConstraints.WEST;
        c.gridy = row;

        c.gridx = 0;
        panel.add(new JLabel(text), c);
        c.gridx = 1;
        panel.add(input, c);

        JLabel error = new JLabel(" ");
        error.setForeground(Color.RED);
        error.setPreferredSize(new Dimension(330, 18));
        errorLabels.put(key, error);
        c.gridx = 2;
        panel.add(error, c);
    }

    /** Register button handler: start the chain at its first validator. */
    private void onRegister() {
        for (JLabel label : errorLabels.values()) {
            label.setText(" ");
        }
        statusLabel.setText(" ");

        UserRegistration user = new UserRegistration(
                usernameField.getText(),
                new String(passwordField.getPassword()),
                emailField.getText(),
                phoneField.getText());

        try {
            chain.validate(user);
            statusLabel.setForeground(new Color(0, 128, 0));
            statusLabel.setText("  Registration successful!");
            JOptionPane.showMessageDialog(this, "Registration successful!");
        } catch (ValidationException ex) {
            errorLabels.get(ex.getField()).setText(ex.getMessage());
            statusLabel.setForeground(Color.RED);
            statusLabel.setText("  Please fix the highlighted field.");
            System.out.println("Validation failed: " + ex.getMessage());
        }
    }
}
