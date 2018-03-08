package regRes;

import models.Event;

public class EventResponse extends Response {

  private String descendant;
  private String eventID;
  private String personID;
  private String latitude;
  private String longitude;
  private String country;
  private String city;
  private String eventType;
  private String year;
  private Event[] data = null;

  /**
   * makes new EventResponse with a single Event object
   * @param event
   */
  public EventResponse(Event event){
    if (event != null){
      this.descendant = event.getDescendant();
      this.eventID = event.getEventID();
      this.personID = event.getPersonID();
      this.latitude = event.getLatitude();
      this.longitude = event.getLongitude();
      this.country = event.getCountry();
      this.city = event.getCity();
      this.eventType = event.getEventType();
      this.year = event.getYear();
    } else {
      setMessage("Invalid eventID parameter");
    }
  }

  /**
   * Makes a new EventResponse with all the event objects in DB
   * @param events
   */
  public EventResponse(Event[] data){
      this.data = data;
  }

  public EventResponse(){}

}
