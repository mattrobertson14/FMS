package service;

import regRes.PersonRequest;
import regRes.PersonResponse;
import dao.PersonDao;
import models.Person;

public class PersonService {

  /**
   * The Handler will call this to try and get either one person or all persons
   * @param request
   * @return a PersonResponse
   */
  public PersonResponse person(PersonRequest request){
    PersonDao dao = new PersonDao();
    PersonResponse response = null;
    boolean success = false;
    try{
      if (request.getId() != null){
        Person person = dao.getPerson(request.getId());
        response = new PersonResponse(person);
      } else {
        Person[] persons = dao.getAllPersons();
        response = new PersonResponse(persons);
      }
    }
    catch(Exception e){
      System.out.println("Error: " + e.getMessage());
      e.printStackTrace();
    }
    return response;
  }
}
