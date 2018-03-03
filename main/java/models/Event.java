package models;

public class Event {
    private String id;
    private String person;
    private String latitude;
    private String longitude;
    private String country;
    private String city;
    private String eventType;
    private String year;

    /**
     * Unique identifier for this event (non-empty string)
     * @return String representation of event's id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id type String
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * ID of person to which this event belongs
     * @return String representation of person's id
     */
    public String getPerson() {
        return person;
    }

    /**
     * @param person type String
     */
    public void setPerson(String person) {
        this.person = person;
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
