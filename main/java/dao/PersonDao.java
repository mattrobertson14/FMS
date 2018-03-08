package dao;

import models.Person;
import java.sql.*;
import java.util.*;

public class PersonDao {

    /**
     * This will attempt to add a new Person into the DB
     * @param person a Person object
     * @return true if Person was successfully added / false if not
     */
    public boolean newPerson(Person person) throws DatabaseException{
      if (person == null){
        return false;
      }
      Connection conn = null;
      try{
        conn = Database.openConnection();
        Statement stmt = conn.createStatement();
        String id = person.getId();
        String descendant = person.getDescendant();
        String firstName = person.getFirstName();
        String lastName = person.getLastName();
        String gender = person.getGender();
        String father = (person.getFather() == null)? "NULL" : ("\"" + person.getFather() + "\"");
        String mother = (person.getMother() == null)? "NULL" : ("\"" + person.getMother() + "\"");
        String spouse = (person.getSpouse() == null)? "NULL" : ("\"" + person.getSpouse() + "\"");
        String query = String.format("INSERT INTO Persons (uuid, descendant, first_name, last_name, gender, father, mother, spouse) VALUES (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", %s,%s,%s)",id, descendant, firstName, lastName, gender, father, mother, spouse);

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
     * This will attempt to add multiple persons into the database
     * @param persons an array of Person objects
     * @return true on success
     * @return false on failure
     */
    public boolean newPersons(Person[] persons){ return false; }

    /**
     * Returns person by their ID
     * @param personId a person uuid
     * @return Person Object if exists / null if not
     */
    public Person getPerson(String personId) throws DatabaseException{
      if (personId == null){
        return null;
      }
      Connection conn = null;
      try{
        conn = Database.openConnection();
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM Persons WHERE uuid=\'"+personId+"\';";
        ResultSet rs = stmt.executeQuery(query);

        Person person = null;
        while (rs.next()){
          person = new Person(
            rs.getString("uuid"),
            rs.getString("descendant"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("gender")
          );
          person.setFather(rs.getString("father"));
          person.setMother(rs.getString("mother"));
          person.setSpouse(rs.getString("spouse"));
        }
        return person;
      }
      catch(SQLException e){
        throw new DatabaseException(e.getMessage(), e);
      }
      finally {
        Database.closeConnection(conn, true);
      }
    }

    /**
     * This will get all persons from the database
     * @return an array of Person objects
     */
    public Person[] getAllPersons() throws DatabaseException{
      ArrayList<Person> persons = new ArrayList<Person>();
      Connection conn = null;
      try{
        conn = Database.openConnection();
        Statement stmt = conn.createStatement();
        String query = "SELECT * FROM Persons;";
        ResultSet rs = stmt.executeQuery(query);

        Person person = null;
        while (rs.next()){
          person = new Person(
            rs.getString("uuid"),
            rs.getString("descendant"),
            rs.getString("first_name"),
            rs.getString("last_name"),
            rs.getString("gender")
          );
          person.setFather(rs.getString("father"));
          person.setMother(rs.getString("mother"));
          person.setSpouse(rs.getString("spouse"));
          persons.add(person);
        }
        return persons.toArray(new Person[persons.size()]);
      }
      catch(SQLException e){
        throw new DatabaseException(e.getMessage(), e);
      }
      finally {
        Database.closeConnection(conn, true);
      }
    }

    /**
     * This will delete a person by id
     * @param personID a uuid of a person
     * @return true on success
     * @return false on failure
     */
    public boolean deletePerson(String personID) { return false; }

    /**
     * This will delete all persons in the database
     * @return true on success
     * @return false on failure
     */
    public boolean deleteAllPersons(){ return false; }

    public static void main(String[] args){
      PersonDao pd = new PersonDao();
      Person person = new Person();
      String uuid = UUID.randomUUID().toString();

      person.setId(uuid);
      person.setDescendant("matthew");
      person.setFirstName("Test");
      person.setLastName("Tester");
      person.setGender("m");


      try{
        System.out.println(pd.newPerson(person));
        System.out.println(pd.newPerson(person));
        Person p = pd.getPerson(uuid);
        if (p != null){
          System.out.println(p.getFirstName());
          System.out.println(p.getLastName());
          System.out.println(p.getFather());
        }
      }
      catch(DatabaseException e){
        e.printStackTrace();
      }
    }
}
