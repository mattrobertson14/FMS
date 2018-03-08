package dao;

import models.Event;
import java.sql.*;
import java.util.*;

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
  public Event getEvent(String eventId) throws DatabaseException {
    if (eventId == null){
      return null;
    }
    Connection conn = null;
    try {
      conn = Database.openConnection();
      Statement stmt = conn.createStatement();
      String query = "SELECT * FROM Events WHERE uuid=\'"+eventId+"\';";
      ResultSet rs = stmt.executeQuery(query);

      Event event = null;
      while (rs.next()){
        event = new Event(
          rs.getString("descendant"),
          rs.getString("uuid"),
          rs.getString("person_id"),
          rs.getString("latitude"),
          rs.getString("longitude"),
          rs.getString("country"),
          rs.getString("city"),
          rs.getString("event_type"),
          rs.getString("event_year")
        );
      }
      return event;
    }
    catch(SQLException e){
      throw new DatabaseException(e.getMessage(), e);
    }
    finally {
      Database.closeConnection(conn, true);
    }
  }

  /**
   * This will return all events for a person
   * @param personId A uuid of a person
   * @return array of Events
   */
  public Event[] getEvents(String personId) {
    return null;
  }

  /**
   * This will return an array of all of the events
   * @return an array of Events
   */
  public Event[] getAllEvents() throws DatabaseException {
    ArrayList<Event> events = new ArrayList<Event>();
    Connection conn = null;
    try {
      conn = Database.openConnection();
      Statement stmt = conn.createStatement();
      String query = "SELECT * FROM Events;";
      ResultSet rs = stmt.executeQuery(query);

      Event event = null;
      while (rs.next()){
        event = new Event(
          rs.getString("descendant"),
          rs.getString("uuid"),
          rs.getString("person_id"),
          rs.getString("latitude"),
          rs.getString("longitude"),
          rs.getString("country"),
          rs.getString("city"),
          rs.getString("event_type"),
          rs.getString("event_year")
        );
        events.add(event);
      }
      return events.toArray(new Event[events.size()]);
    }
    catch(SQLException e){
      throw new DatabaseException(e.getMessage(), e);
    }
    finally {
      Database.closeConnection(conn, true);
    }
  }

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
