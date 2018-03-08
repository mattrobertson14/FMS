package models;

public class Authentication {
    private String token;
    private String userId;
    private String personId;
    private String userName;

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

    public String getPersonId(){
      return personId;
    }

    public void setPersonId(String personId){
      this.personId = personId;
    }

    public String getUserName(){
      return userName;
    }

    public void setUserName(String userName){
      this.userName = userName;
    }
}
