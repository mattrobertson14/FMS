package regRes;

public class PersonRequest {
    private String id = null;

    /**
     * Creates a new PersonRequest with personID
     * @param id ID of person or "all" for all personRequest
     */
    public PersonRequest(String id) {
        this.id = id;
    }

    public PersonRequest(){}

    /**
     * returns the id of the requested person
     * @return id
     */
    public String getId(){
        return id;
    }
}
