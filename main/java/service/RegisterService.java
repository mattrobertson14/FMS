package service;

import regRes.RegisterRequest;
import regRes.RegisterResponse;
import dao.*;

public class RegisterService {

  /**
   * The Handler will call this to try and register a new user
   * @param request
   * @return a RegisterResponse
   */
  public RegisterResponse register(RegisterRequest request){
    AuthenticationDao authDao = new AuthenticationDao();
    UserDao userDao = new UserDao();
    PersonDao persDao = new PersonDao();
    boolean success = false;
    try {
      if(!userDao.newUser(request.getUser())){
        return null;
      }
      if (!persDao.newPerson(request.getPerson())){
        return null;
      }
      String username = request.getUserName();
      String password = request.getPassword();
      RegisterResponse response = new RegisterResponse(authDao.newSession(username, password), request.getUser().getPersonId());
      return response;
    }
    catch (Exception e){
      e.printStackTrace();
    }
    return null;
  }
}
