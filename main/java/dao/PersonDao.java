package dao;

import models.Person;

public class PersonDao {

    /**
     * This will attempt to add a new Person into the DB
     * @param person a Person object
     * @return true if Person was successfully added / false if not
     */
    public boolean newPerson(Person person){
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
    public Person getPerson(String personId){
        return null;
    }

    /**
     * This will get all persons from the database
     * @return an array of Person objects
     */
    public Person[] getAllPersons() { return null; }

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
}
