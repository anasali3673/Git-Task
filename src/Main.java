public class Main {

    // Method to validate user credentials
    public boolean validateUser(String username, String password) {
        // Check if username and password are not null or empty
        if (username == null || username.isEmpty()) {
            System.out.println("Username cannot be null or empty.");
            return false;
        }
        if (password == null || password.isEmpty()) {
            System.out.println("Password cannot be null or empty.");
            return false;
        }

        // Example: Check username and password format
        if (!isValidUsername(username)) {
            System.out.println("Invalid username format.");
            return false;
        }
        if (!isValidPassword(password)) {
            System.out.println("Invalid password format.");
            return false;
        }

        // Example: Check against stored credentials (dummy check here)
        if (!checkCredentials(username, password)) {
            System.out.println("Username or password is incorrect.");
            return false;
        }

        // If all checks pass
        System.out.println("User validation successful.");
        return true;
    }

    private boolean isValidUsername(String username) {
        // Example criteria: Alphanumeric and length between 3-15
        return username.matches("^[a-zA-Z0-9]{3,15}$");
    }

    private boolean isValidPassword(String password) {
        // Example criteria: At least 8 characters, including one number and one special character
        return password.matches("^(?=.*[0-9])(?=.*[!@#$%^&*])[A-Za-z\\d!@#$%^&*]{8,}$");
    }

    private boolean checkCredentials(String username, String password) {
        // Placeholder for credential check (replace with actual logic)
        // For demonstration, let's say the valid credentials are:
        return "validUser".equals(username) && "Password1!".equals(password);
    }

    public static void main(String[] args) {
        // Create an instance of Main to use the validateUser method
        Main userValidator = new Main();

        // Test cases
        String[][] testCases = {
                {"validUser", "Password1!"},
                {"invalidUser", "wrongPassword"},
                {"", "Password1!"},
                {"validUser", ""},
                {"invalidUser@", "Password1!"},
                {"validUser", "short"},
                {"user", "Valid1!"}
        };

        // Validate each test case
        for (String[] testCase : testCases) {
            String username = testCase[0];
            String password = testCase[1];
            System.out.println("Validating user: " + username);
            boolean isValid = userValidator.validateUser(username, password);
            System.out.println("Validation result: " + isValid + "\n");
        }
    }
}
