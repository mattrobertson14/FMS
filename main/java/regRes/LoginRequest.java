package regRes;

public class LoginRequest extends Request {

    private String username;
    private String password;

    /**
     * Creates a new LoginRequest with the associated username and password
     * @param username
     * @param password
     */
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * returns the username that is requesting the login
     * @return String username
     */
    public String getUsername() {
        return username;
    }

    /**
     * returns the password for the requesting user
     * @return String password
     */
    public String getPassword() {
        return password;
    }
}
