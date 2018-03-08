package regRes;

public class EventRequest extends Request {

    private String id = null;
    private String authToken = null;

    /**
     * Creates a new EventRequest with eventID
     * @param id ID of person or "all" for all eventRequest
     */
    public EventRequest(String id){
        this.id = id;
    }

    public EventRequest(){}

    public void setAuthToken(String authToken){
      this.authToken = authToken;
    }

    public String getAuthToken(){
      return authToken;
    }

    /**
     * returns the id of the requested event
     * @return id
     */
    public String getId() { return id; }
}
