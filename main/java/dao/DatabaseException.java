package dao;

public class DatabaseException extends Exception {
  String message;
  Exception e;

  DatabaseException(String message, Exception e){
    super(message);
    this.message = message;
    this.e = e;
  }

  DatabaseException(String message){
    super(message);
  }
}
