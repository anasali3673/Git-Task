import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Main {

    private Set<String> registeredUsernames = new HashSet<>();

    public boolean validateUser(String username, String password, String email) {
        if (username == null || username.isEmpty()) {
            log("Registration failed: Username cannot be null or empty.");
            return false;
        }
        if (password == null || password.isEmpty()) {
            log("Registration failed: Password cannot be null or empty.");
            return false;
        }
        if (email == null || email.isEmpty()) {
            log("Registration failed: Email cannot be null or empty.");
            return false;
        }

        if (registeredUsernames.contains(username)) {
            log("Registration failed: Username '" + username + "' is already taken.");
            return false;
        }

        if (!isValidUsername(username)) {
            log("Registration failed: Invalid username format.");
            return false;
        }
        if (!isValidPassword(password)) {
            log("Registration failed: Invalid password format.");
            return false;
        }
        if (!isValidEmail(email)) {
            log("Registration failed: Invalid email format.");
            return false;
        }

        registeredUsernames.add(username);
        log("User registration successful: " + username);
        return true;
    }

    private boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z0-9]{3,15}$");
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$");
    }

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(emailRegex, email);
    }

    private void log(String message) {
        System.out.println(message);
    }

    public static void main(String[] args) {
        Main userValidator = new Main();

        // Test cases
        String[][] testCases = {
                {"validUser", "Password1!", "validUser@example.com"},
                {"validUser", "Password1!", "validUser@example.com"},
                {"invalidUser", "wrongPassword", "invalidUser@example.com"},
                {"", "Password1!", "emptyUser@example.com"},
                {"validUser", "", "validUser@example.com"},
                {"duplicateUser", "Password1!", "duplicateUser@example.com"},
                {"duplicateUser", "Password1!", "duplicateUser@example.com"},
                {"validUser@", "Password1!", "validUser@example.com"},
                {"user", "Valid1!", "user@example.com"}
        };

        for (String[] testCase : testCases) {
            String username = testCase[0];
            String password = testCase[1];
            String email = testCase[2];
            System.out.println("Validating user: " + username);
            boolean isValid = userValidator.validateUser(username, password, email);
            System.out.println("Validation result: " + isValid + "\n");
        }
    }
}
