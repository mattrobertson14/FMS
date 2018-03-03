package dao;

import models.Event;

public class EventDao {

    /**
     * This will attempt to add a new Event into the DB
     * @param event An Event object
     * @return true on success
     * @return false on failure
     */
    public boolean newEvent(Event event){
        return false;
    }

    /**
     * This will attempt to add an array of Events into the DB
     * @param events An array of Event objects
     * @return true on success
     * @return false on failure
     */
    public boolean newEvents(Event[] events){ return false; }

    /**
     * Returns event by their ID
     * @param eventId
     * @return Event Object if exists / null if not
     */
    public Event getEvent(String eventId){
        return null;
    }

    /**
     * This will return all events for a person
     * @param personId A uuid of a person
     * @return array of Events
     */
    public Event[] getEvents(String personId) { return null; }

    /**
     * This will return an array of all of the events
     * @return an array of Events
     */
    public Event[] getAllEvents() { return null; }

    /**
     * This will delete an event by id
     * @param id An event id
     * @return true on success
     * @return false on failure
     */
    public boolean deleteEvent(String id){ return false; }

    /**
     * This will delete all events for a person
     * @param personID A uuid of a person
     * @return true on success
     * @return false on failure
     */
    public boolean deleteAllEventsForPerson(String personID) { return false; }

    /**
     * This will delete all events in the database
     * @return true on success
     * @return false on failure
     */
    public boolean deleteAllEvents(){ return false; }
}

