package regRes;


import models.User;

public class RegisterResponse extends Response {

    private User user = null;

    /**
     * Used to get access to the User object in the response
     * @return User Object
     */
    public User getUser() {
        return user;
    }

    /**
     * Used to set User Object
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }
}
