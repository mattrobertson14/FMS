package regRes;

import models.User;

public class RegisterRequest extends Request {

    private User user = null;

    public RegisterRequest(User user){
        this.user = user;
    }

    /**
     * @return request's User Object
     */
    public User getUser(){
        return user;
    }
}
