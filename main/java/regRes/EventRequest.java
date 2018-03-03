package regRes;

public class EventRequest extends Request {

    private String id = null;

    /**
     * Creates a new EventRequest with eventID
     * @param id ID of person or "all" for all eventRequest
     */
    public EventRequest(String id){
        this.id = id;
    }

    /**
     * returns the id of the requested event
     * @return id
     */
    public String getId() { return id; }
}
