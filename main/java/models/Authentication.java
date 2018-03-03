package models;

public class Authentication {
    private String token;
    private String userId;

    /**
     * Token will be a uuid
     * @return String representation of token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token type String
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * This will be a uuid
     * @return String representation of the User's Id the token is associated with
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId type String
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
