package regRes;

import models.Authentication;

public class LoginResponse extends Response {

    private Authentication auth = null;

    /**
     * Used to get access to the Authentication object in the response
     * @return Authentication Object
     */
    public Authentication getAuth() {
        return auth;
    }

    /**
     * Used to set Authentication Object
     * @param auth
     */
    public void setAuth(Authentication auth) {
        this.auth = auth;
    }

    public String getAuthToken(){
      return auth.getToken();
    }
}
