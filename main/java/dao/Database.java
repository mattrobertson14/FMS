package dao;

import java.sql.*;
import java.io.*;
import java.util.HashMap;
import java.util.Arrays;
import org.sqlite.JDBC;

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

  public static Connection openConnection() throws DatabaseException {
    Connection conn = null;
    try {
      final String CONNECTION_URL = "jdbc:sqlite:../family_map.db";

      conn = DriverManager.getConnection(CONNECTION_URL);

      conn.setAutoCommit(false);

      return conn;
    }
    catch (SQLException e) {
      throw new DatabaseException("openConnection failed", e);
    }
  }

  public static void closeConnection(Connection conn, boolean commit) throws DatabaseException {
    try {
      if (conn == null){ throw new SQLException(); }
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

  public static void clear() throws DatabaseException{
    Connection conn = null;
    boolean success = false;
    try {
      conn = openConnection();
      Statement stmt = conn.createStatement();
      String deleteUsers = "DELETE FROM Users;";
      String deletePersons = "DELETE FROM Persons;";
      String deleteEvents = "DELETE FROM Events;";
      String deleteAuthTokens = "DELETE FROM AuthTokens;";

      stmt.addBatch(deleteUsers);
      stmt.addBatch(deletePersons);
      stmt.addBatch(deleteEvents);
      stmt.addBatch(deleteAuthTokens);

      if (Arrays.asList(stmt.executeBatch()).contains(-1)){
        throw new DatabaseException("Problem Deleting a table, nothing deleted");
      }
      success = true;
    }
    catch(SQLException e){
      throw new DatabaseException("Clear Failed because of: " + e.getMessage(), e);
    }
    finally {
      if (success){
        closeConnection(conn, true);
      } else {
        closeConnection(conn, false);
      }
    }
  }
}
