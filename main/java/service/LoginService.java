package service;

import regRes.LoginRequest;
import regRes.LoginResponse;
import dao.AuthenticationDao;
import models.Authentication;

public class LoginService {

    /**
     * The Handler will call this to try and login a user
     * @param request a LoginRequest from the LoginHandler
     * @return a LoginResponse
     */
    public LoginResponse login(LoginRequest request){
      AuthenticationDao ad = new AuthenticationDao();
      try{
        Authentication auth = ad.newSession(request.getUsername(), request.getPassword());
        if (auth == null){
          return null;
        }
        LoginResponse lr = new LoginResponse();
        lr.setAuth(auth);
        return lr;
      }
      catch (Exception e){
        e.printStackTrace();
      }


      //LoginResponse lr = new LoginResponse();
      return null;
    }
}
