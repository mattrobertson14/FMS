package dao;

import java.sql.*;
import java.io.*;
import java.util.*;
import org.sqlite.JDBC;
import models.Authentication;

public class Database {
  static {
    try {
      final String driver = "org.sqlite.JDBC";
      Class.forName(driver);
    }
    catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  public class DatabaseException extends Exception {
    String message;
    Exception e;

    DatabaseException(String message, Exception e){
      super(message);
      this.message = message;
      this.e = e;
    }
  }

  private Connection conn;

  public void openConnection() throws DatabaseException {
    try {
      final String CONNECTION_URL = "jdbc:sqlite:../family_map.db";

      conn = DriverManager.getConnection(CONNECTION_URL);

      conn.setAutoCommit(false);
    }
    catch (SQLException e) {
      throw new DatabaseException("openConnection failed", e);
    }
  }

  public HashMap<String,String> getUserByName(String name) throws SQLException{
    Statement stmt = null;
    try {
      stmt = conn.createStatement();
      String query = "SELECT * FROM Users WHERE username=\'" + name + "\';";
      HashMap<String,String> result = new HashMap<String, String>();

      ResultSet rs = stmt.executeQuery(query);
      while(rs.next()){
        result.put("id", Integer.toString(rs.getInt("id")));
        result.put("username", rs.getString("username"));
        result.put("password", rs.getString("password"));
        result.put("email", rs.getString("email"));
        result.put("person_id", rs.getString("person_id"));
      }
      return result;
    } catch(SQLException e){
      e.printStackTrace();
    } finally {
      if (stmt != null) { stmt.close(); }
    }
    return null;
  }

  public Authentication authenticateUser(String username, String password) throws SQLException{
    HashMap<String, String> map = getUserByName(username);
    if (map.isEmpty()){
      return null;
    }
    if (!map.get("password").equals(password)){
      return null;
    }
    Authentication auth = new Authentication();
    Statement stmt = null;
    try {
      stmt = conn.createStatement();
      String uuid = UUID.randomUUID().toString();
      String query = "INSERT INTO AuthTokens (token, user_id) VALUES (\""+uuid+"\", "+map.get("id")+");";
      int rs = stmt.executeUpdate(query);
      if (rs == 1){
        auth.setToken(uuid);
        auth.setUserId(map.get("id"));
        return auth;
      }
    } catch (SQLException e){
      e.printStackTrace();
    }
    return null;
  }

  public void closeConnection(boolean commit) throws DatabaseException {
    try {
      if (commit){
        conn.commit();
      } else {
        conn.rollback();
      }

      conn.close();
      conn = null;
    }
    catch(SQLException e) {
      throw new DatabaseException("closeConnection failed", e);
    }
  }
}
