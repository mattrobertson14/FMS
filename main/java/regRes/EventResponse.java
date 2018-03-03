package regRes;

import models.Event;

public class EventResponse extends Response {

    private Event event = null;
    private Event[] events = null;

    /**
     * makes new EventResponse with a single Event object
     * @param event
     */
    public EventResponse(Event event){
        this.event = event;
    }

    /**
     * Makes a new EventResponse with all the event objects in DB
     * @param events
     */
    public EventResponse(Event[] events){
        this.events = events;
    }
}
