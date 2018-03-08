package regRes;

import models.Person;

public class PersonResponse extends Response {

  private String descendant = null;
  private String personID = null;
  private String firstName = null;
  private String lastName = null;
  private String gender = null;
  private String father = null;
  private String mother = null;
  private String spouse = null;
  private Person[] data = null;

  /**
   * Makes new PersonResponse with a single person object
   * @param person
   */
  public PersonResponse(Person person) {
    if (person != null){
      descendant = person.getDescendant();
      personID = person.getId();
      firstName = person.getFirstName();
      lastName = person.getLastName();
      gender = person.getGender();
      father = person.getFather();
      mother = person.getMother();
      spouse = person.getSpouse();
    } else {
      setMessage("Person was not found in the DB");
    }
  }

  /**
   * Makes a new PersonResponse with all the person objects in DB
   * @param persons
   */
  public PersonResponse(Person[] data){
      this.data = data;
  }
}
