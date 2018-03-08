package models;

public class Event {
  private String descendant;
  private String eventID;
  private String personID;
  private String latitude;
  private String longitude;
  private String country;
  private String city;
  private String eventType;
  private String year;

  public Event(String descendant, String eventID, String personID, String latitude, String longitude, String country, String city, String eventType, String year){
    this.descendant = descendant;
    this.eventID = eventID;
    this.personID = personID;
    this.latitude = latitude;
    this.longitude = longitude;
    this.country = country;
    this.city = city;
    this.eventType = eventType;
    this.year = year;
  }

  public String getDescendant(){
    return descendant;
  }

  public void setDescendant(String descendant){
    this.descendant = descendant;
  }

  /**
   * Unique identifier for this event (non-empty string)
   * @return String representation of event's id
   */
  public String getEventID() {
    return eventID;
  }

  /**
   * @param id type String
   */
  public void setEventID(String eventID) {
    this.eventID = eventID;
  }

  /**
   * ID of person to which this event belongs
   * @return String representation of person's id
   */
  public String getPersonID() {
    return personID;
  }

  /**
   * @param person type String
   */
  public void setPersonID(String personID) {
    this.personID = personID;
  }

  /**
   * Latitude of event's location
   * @return String representation of latitude
   */
  public String getLatitude() {
    return latitude;
  }

  /**
   * @param latitude type String
   */
  public void setLatitude(String latitude) {
    this.latitude = latitude;
  }

  /**
   * Longitude of event's location
   * @return String representation of longitude
   */
  public String getLongitude() {
    return longitude;
  }

  /**
   * @param longitude type String
   */
  public void setLongitude(String longitude) {
    this.longitude = longitude;
  }

  /**
   * Country in which event occurred
   * @return String representation of country
   */
  public String getCountry() {
    return country;
  }

  /**
   * @param country type String
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * City in which event occurred
   * @return String representation of city
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city type String
   */
  public void setCity(String city) {
    this.city = city;
  }

  /**
   * Type of event (birth, baptism, christening, marriage, death, etc.)
   * @return String representation of event type
   */
  public String getEventType() {
    return eventType;
  }

  /**
   * @param eventType type String
   */
  public void setEventType(String eventType) {
    this.eventType = eventType;
  }

  /**
   * Year in which event occurred
   * @return String representation of year
   */
  public String getYear() {
    return year;
  }

  /**
   * @param year type String
   */
  public void setYear(String year) {
    this.year = year;
  }
}
