package dao;

import models.Authentication;
import models.User;

public class AuthenticationDao {

  Database db = new Database();

    /**
     * This will try to initialize a new session with the username and password it is passed
     * @param username
     * @param password
     * @return true if username/password combination is in DB
     * @return false if username/password combination is isn't in DB
     */
    public Authentication newSession(String username, String password) throws Database.DatabaseException{
      UserDao usr = new UserDao();
      User u = usr.getUser(username);
      if (u == null){
        return null;
      }
      Authentication auth;
      try{
        db.openConnection();
        auth = db.authenticateUser(username, password);
        return auth;
      }
      catch (Exception e){
        e.printStackTrace();
      }
      finally {
        db.closeConnection(true);
      }
      return null;
    }

    /**
     * This will return the session information
     * @param authToken
     * @return Authentication Object if exists / null if not
     */
    public Authentication getAuthentication(String authToken){
        return null;
    }

    /**
     * This will delete a certain authToken
     * @param authToken An authentication token
     * @return true on success
     * @return false on failure
     */
    public boolean delete(String authToken){ return false; }

    /**
     * This will delete all authTokens for a user
     * @param userID A uuid of the user
     * @return true on success
     * @return false on failure
     */
    public boolean deleteAllForUser(String userID){ return false; }

    /**
     * This will delete all authTokens in the database
     * @return true on success
     * @return false on failure
     */
    public boolean deleteAll(){ return false; }
}
