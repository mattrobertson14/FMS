package regRes;

import models.Person;

public class PersonResponse extends Response {

    private Person person = null;
    private Person[] persons = null;

    /**
     * Makes new PersonResponse with a single person object
     * @param person
     */
    public PersonResponse(Person person) {
        this.person = person;
    }

    /**
     * Makes a new PersonResponse with all the person objects in DB
     * @param persons
     */
    public PersonResponse(Person[] persons){
        this.persons = persons;
    }
}
