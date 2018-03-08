package regRes;


import models.Authentication;

public class RegisterResponse extends Response {

  private Authentication auth = null;
  private String personId = null;

  public RegisterResponse(){}

  public RegisterResponse(Authentication auth, String personId){
    this.auth = auth;
    this.personId = personId;
  }

  /**
   * Used to get access to the Authentication object in the response
   * @return Authentication Object
   */
  public Authentication getAuthentication() {
    return auth;
  }

  /**
   * Used to set User Object
   * @param auth
   */
  public void setAuthentication(Authentication auth) {
    this.auth = auth;
  }

  public String getAuthToken() {
    return auth.getToken();
  }

  public String getPersonId() {
    return personId;
  }
}
