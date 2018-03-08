package regRes;

import models.User;
import models.Person;

import java.util.*;

public class RegisterRequest extends Request {

  private User user = null;
  private Person person = null;

  public RegisterRequest(String username, String password, String email, String firstName, String lastName, String gender){
    String uuid = UUID.randomUUID().toString();
    user = new User(username, password, email, null, uuid);
    person = new Person(uuid, username, firstName, lastName, gender);
  }

  /**
   * @return request's User Object
   */
  public User getUser(){
    return user;
  }

  public Person getPerson(){
    return person;
  }

  public String getUserName(){
    return user.getUserName();
  }

  public String getPassword(){
    return user.getPassword();
  }
}
