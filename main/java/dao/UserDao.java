package dao;

import java.util.*;

import models.User;

public class UserDao {

  Database db = new Database();

  /**
   * This will attempt to add a new User into the DB
   * @param user a User object
   * @return true if User was successfully added / false if not
   */
  public boolean newUser(User user){
      return false;
  }

  /**
   * This will attempt to add multiple users into the database
   * @param users an array of User objects
   * @return true on success
   * @return false on failure
   */
  public boolean newUsers(User[] users) { return false; }

  /**
   * Returns user by their ID
   * @param userId
   * @return User Object if exists / null if not
   */
  public User getUser(String userId) throws Database.DatabaseException{
    try {
      db.openConnection();
      HashMap<String, String> map = db.getUserByName(userId);

      if (map.isEmpty()){
        return null;
      }
      User usr = new User();
      usr.setId(map.get("id"));
      usr.setUserName(map.get("username"));
      usr.setPassword(map.get("password"));
      usr.setEmail(map.get("email"));
      return usr;
    } catch(Exception e){
      e.printStackTrace();
    } finally {
      db.closeConnection(true);
    }
    return null;
  }

  /**
   * This will get all users in the database
   * @return an array of User objects
   */
  public User[] getAllUsers() { return null; }

  /**
   * This will delete a user by id
   * @param userID uuid of a user
   * @return true on success
   * @return false on failure
   */
  public boolean deleteUser(String userID) { return false; }

  /**
   * This will delete all users in the DB
   * @return true on success
   * @return false on failure
   */
  public boolean deleteAllUsers() { return false; }
}
