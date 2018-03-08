package service;


import regRes.ClearResponse;
import dao.Database;
import dao.DatabaseException;

public class ClearService {

  /**
   * The Handler will call this to try and clear all the data in the DB
   * @return a ClearResponse
   */
  public ClearResponse clear(){
    ClearResponse response = new ClearResponse();
    try {
      Database.clear();

      response.success = true;
      response.message = "Clear succeeded.";
    }
    catch (DatabaseException e) {
      response.success = false;
      response.message = e.getMessage();
      e.printStackTrace();
    }

    return response;
  }
}
