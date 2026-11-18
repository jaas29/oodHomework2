/** Holds the user's inputs. This is the "request" passed down the chain. */
public class UserRegistration {
    private final String username;
    private final String password;
    private final String email;
    private final String phoneNumber; // optional, may be empty

    public UserRegistration(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public String getPhoneNumber() { return phoneNumber; }
}
