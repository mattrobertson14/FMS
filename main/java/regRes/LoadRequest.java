package regRes;


import models.Event;
import models.Person;
import models.User;

public class LoadRequest extends Request {

    private User[] users = null;
    private Person[] persons = null;
    private Event[] events = null;

    /**
     * Creates a new LoadRequest with needed parameters
     * @param users
     * @param persons
     * @param events
     */
    public LoadRequest(User[] users, Person[] persons, Event[] events) {
        this.users = users;
        this.persons = persons;
        this.events = events;
    }

    /**
     * @return users array
     */
    public User[] getUsers() {
        return users;
    }

    /**
     * @return persons array
     */
    public Person[] getPersons() {
        return persons;
    }

    /**
     * @return events array
     */
    public Event[] getEvents() {
        return events;
    }
}
