package dao;

import models.Authentication;
import models.User;
import java.sql.*;
import java.util.*;

public class AuthenticationDao {

    /**
     * This will try to initialize a new session with the username and password it is passed
     * @param username
     * @param password
     * @return true if username/password combination is in DB
     * @return false if username/password combination is isn't in DB
     */
    public Authentication newSession(String username, String password) throws DatabaseException{
      UserDao usr = new UserDao();
      User u = usr.getUser(username);
      if (u == null){
        return null;
      }
      Authentication auth;
      Connection conn = null;
      try{
        conn = Database.openConnection();
        int id = authenticateUser(u, username, password);
        if (id == -1){
          return null;
        }
        auth = new Authentication();
        Statement stmt = conn.createStatement();
        String uuid = UUID.randomUUID().toString();
        String query = "INSERT INTO AuthTokens (token, user_id, username) VALUES (\""+uuid+"\", "+id+",\""+username+"\""+");";
        int rs = stmt.executeUpdate(query);
        if (rs == 1){
          auth.setToken(uuid);
          auth.setUserId(Integer.toString(id));
          auth.setPersonId(u.getPersonId());
          return auth;
        }
      }
      catch (Exception e){
        e.printStackTrace();
      }
      finally {
        Database.closeConnection(conn, true);
      }
      return null;
    }

    public int authenticateUser(User user, String username, String password){
      if (user == null){
        return -1;
      }
      if (!user.getPassword().equals(password)){
        return -1;
      }
      return Integer.parseInt(user.getId());
    }

    /**
     * This will return the session information
     * @param authToken
     * @return Authentication Object if exists / null if not
     */
    public Authentication getAuthentication(String authToken) throws DatabaseException {
      if (authToken == null){
        return null;
      }
      Connection conn = null;
      try {
        conn = Database.openConnection();
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM AuthTokens WHERE token=\'"+authToken+"\';";
        ResultSet rs = stmt.executeQuery(query);

        Authentication auth = null;
        while (rs.next()){
          auth = new Authentication();
          auth.setToken(authToken);
          auth.setUserId(rs.getString("user_id"));
          auth.setUserName(rs.getString("username"));
        }
        return auth;
      }
      catch(SQLException e){
        throw new DatabaseException(e.getMessage(), e);
      }
      finally {
        Database.closeConnection(conn, true);
      }
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
