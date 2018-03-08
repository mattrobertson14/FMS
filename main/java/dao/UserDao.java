package dao;

import java.util.*;
import java.sql.*;

import models.User;

public class UserDao {

  /**
   * This will attempt to add a new User into the DB
   * @param user a User object
   * @return true if User was successfully added / false if not
   */
  public boolean newUser(User user) throws DatabaseException{
    if (user == null){
      return false;
    }
    Connection conn = null;
    try {
      conn = Database.openConnection();
      Statement stmt = conn.createStatement();
      String query = String.format("INSERT INTO Users (username, password, email, person_id) VALUES (\"%s\", \"%s\", \"%s\", \"%s\");",user.getUserName(), user.getPassword(), user.getEmail(), user.getPersonId());

      int result = stmt.executeUpdate(query);
      if (result == 1){
        return true;
      } else {
        return false;
      }
    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
    finally {
      Database.closeConnection(conn, true);
    }
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
   * Returns user by their username
   * @param username
   * @return User Object if exists / null if not
   */
  public User getUser(String username) throws DatabaseException{
    Statement stmt;
    Connection conn = null;
    try {
      conn = Database.openConnection();
      stmt = conn.createStatement();

      String query = "SELECT * FROM Users WHERE username=\'" + username + "\';";
      User usr = null;
      ResultSet rs = stmt.executeQuery(query);
      if (!rs.isBeforeFirst()){
        return usr;
      }
      usr = new User();

      while(rs.next()){
        usr.setId(Integer.toString(rs.getInt("id")));
        usr.setUserName(rs.getString("username"));
        usr.setPassword(rs.getString("password"));
        usr.setEmail(rs.getString("email"));
        usr.setPersonId(rs.getString("person_id"));
      }
      return usr;
    } catch(Exception e){
      e.printStackTrace();
    } finally {
      Database.closeConnection(conn, true);
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

  public static void main(String[] args){
    UserDao ud = new UserDao();
    User user = new User("michaella", "p@ssw0rd", "mail@mail", null, "0000-0000-0000-0001");

    try {
      System.out.println(ud.newUser(user));
      System.out.println(ud.newUser(user));
    }
    catch (DatabaseException e){
      e.printStackTrace();
    }
  }
}
